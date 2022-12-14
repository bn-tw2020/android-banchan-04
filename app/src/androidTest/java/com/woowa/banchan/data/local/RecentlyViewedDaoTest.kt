package com.woowa.banchan.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.woowa.banchan.data.local.dao.RecentlyViewedDao
import com.woowa.banchan.data.local.database.AppDatabase
import com.woowa.banchan.data.local.entity.RecentlyViewedEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi // 실험적 OptIn api 이용 선언
@RunWith(AndroidJUnit4::class) // 우리가 JVM이 아닌 Android Emulator에서 Unit Test를 한다는 것을 알림
@SmallTest // Optional. 작은 범위의 리소스 제약으로 테스트할 것이기 때문에 Small 임을 알림
// Network, Real DB 이용 여부, Time limit 등의 차이에 따라 Medium, Large 선언
class RecentlyViewedDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: RecentlyViewedDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder( // Real DB가 아닌 RAM 상에서만 테스트 용으로 DB를 유지
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries() // 테스트 코드에서는 단일 스레드에서 실행되기를 명시
            .build()

        dao = database.recentlyViewedDao()
    }

    @Test
    fun `최근_본_상품이_정상_등록된다`() = runTest {
        val item = RecentlyViewedEntity(id = 0L, "", "소고기", "", "", "0원", "0원", 100L)
        dao.insertRecentlyViewed(item)

        val allRecentlyViewed = dao.findAllByViewedAtDesc().first()
        assertThat(allRecentlyViewed).contains(item) // Success
    }

    @Test
    fun `최근_본_상품이_정상_조회된다`() = runTest {
        val item1 = RecentlyViewedEntity(id = 0L, "", "소고기", "", "", "0원", "0원", 100L)
        dao.insertRecentlyViewed(item1)
        val item2 = RecentlyViewedEntity(id = 1L, "", "돼지고기", "", "", "0원", "0원", 100L)

        val allRecentlyViewed = dao.findAllByViewedAtDesc().first()
        assertThat(allRecentlyViewed).contains(item1) // Success
        assertThat(allRecentlyViewed).contains(item2) // Fail
    }

    @Test
    fun `최근_본_상품이_가장_최근_순으로_정상_조회된다`() = runTest {
        val itemList = listOf(
            RecentlyViewedEntity(0L, "", "소", "", "", "0원", "0원", viewedAt = 0L),
            RecentlyViewedEntity(2L, "", "기", "", "", "0원", "0원", viewedAt = 1L),
            RecentlyViewedEntity(1L, "", "고", "", "", "0원", "0원", viewedAt = 3L),
            RecentlyViewedEntity(3L, "", "소", "", "", "0원", "0원", viewedAt = 9L),
            RecentlyViewedEntity(4L, "", "고", "", "", "0원", "0원", viewedAt = 5L),
            RecentlyViewedEntity(8L, "", "기", "", "", "0원", "0원", viewedAt = 100L),
            RecentlyViewedEntity(6L, "", "소", "", "", "0원", "0원", viewedAt = 7L),
            RecentlyViewedEntity(7L, "", "고", "", "", "0원", "0원", viewedAt = 11L),
            RecentlyViewedEntity(5L, "", "기", "", "", "0원", "0원", viewedAt = 4L)
        )
        itemList.forEach {
            dao.insertRecentlyViewed(it)
        }

        val top7RecentlyViewed = dao.findAllByViewedAtDesc().first()
        assertThat(top7RecentlyViewed).isInOrder { first, second -> // Success
            ((second as RecentlyViewedEntity).viewedAt - (first as RecentlyViewedEntity).viewedAt).toInt()
        }
        assertThat(top7RecentlyViewed).isInOrder { first, second -> // Fail
            ((first as RecentlyViewedEntity).viewedAt - (second as RecentlyViewedEntity).viewedAt).toInt()
        }
    }

    @Test
    fun `최근_본_상품이_정상_업데이트된다`() = runTest {
        val item = RecentlyViewedEntity(0L, "BEEF", "소고기", "", "", "0원", "0원", 100L)
        dao.insertOrUpdate(item)

        var allRecentlyViewed = dao.findAllByViewedAtDesc().first()

        val updateItem = allRecentlyViewed[0].copy(viewedAt = 2500L)
        dao.insertOrUpdate(updateItem)

        allRecentlyViewed = dao.findAllByViewedAtDesc().first()
        assertThat(allRecentlyViewed).isEqualTo(listOf(updateItem))
    }

    @After
    fun teardown() {
        database.close()
    }
}

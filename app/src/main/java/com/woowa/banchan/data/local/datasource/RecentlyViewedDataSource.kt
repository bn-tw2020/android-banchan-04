package com.woowa.banchan.data.local.datasource

import com.woowa.banchan.data.local.entity.RecentlyViewedEntity
import kotlinx.coroutines.flow.Flow

interface RecentlyViewedDataSource {

    fun getAllRecentlyViewed(): Flow<List<RecentlyViewedEntity>>

    suspend fun modifyRecentlyViewed(recentlyViewed: RecentlyViewedEntity)
}

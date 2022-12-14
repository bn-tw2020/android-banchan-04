package com.woowa.banchan.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.woowa.banchan.data.local.entity.OrderEntity
import com.woowa.banchan.data.local.entity.OrderInfoView
import com.woowa.banchan.data.local.entity.OrderLineItemEntity
import com.woowa.banchan.data.local.entity.OrderLineItemView
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

//    @Query("SELECT * FROM OrderInfoView LIMIT :loadSize OFFSET :index * :loadSize")
//    suspend fun findAllWithPage(index: Int, loadSize: Int): List<OrderInfoView>
    @Query("SELECT * FROM OrderInfoView")
    fun findAllWithPage(): PagingSource<Int, OrderInfoView>

    @Query("SELECT count(*) as count FROM `order` WHERE status = :status")
    fun findOrderCountByStatus(status: String): Flow<Int>

    @Query("SELECT * FROM order_line_item, `order` WHERE order_id = :orderId AND `order`.id = order_line_item.order_id")
    fun findByOrderId(orderId: Long): Flow<List<OrderLineItemView>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrder(orderEntity: OrderEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrderLineItem(vararg orderLineItemEntity: OrderLineItemEntity)

    @Update
    suspend fun updateOrder(orderEntity: OrderEntity): Int
}

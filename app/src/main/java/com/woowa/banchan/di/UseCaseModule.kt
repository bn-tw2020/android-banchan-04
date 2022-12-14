package com.woowa.banchan.di

import com.woowa.banchan.domain.repository.BanchanRepository
import com.woowa.banchan.domain.repository.CartRepository
import com.woowa.banchan.domain.repository.OrderRepository
import com.woowa.banchan.domain.repository.RecentlyViewedRepository
import com.woowa.banchan.domain.usecase.cart.AddCartUseCase
import com.woowa.banchan.domain.usecase.cart.ExistCartUseCase
import com.woowa.banchan.domain.usecase.cart.GetCartUseCase
import com.woowa.banchan.domain.usecase.cart.GetCartWithHashUseCase
import com.woowa.banchan.domain.usecase.cart.ModifyCartUseCase
import com.woowa.banchan.domain.usecase.cart.RemoveCartUseCase
import com.woowa.banchan.domain.usecase.order.GetOrderInfoUseCase
import com.woowa.banchan.domain.usecase.order.GetOrderLineItemUseCase
import com.woowa.banchan.domain.usecase.order.ModifyOrderUseCase
import com.woowa.banchan.domain.usecase.product.GetDetailProductUseCase
import com.woowa.banchan.domain.usecase.product.GetPlanUseCase
import com.woowa.banchan.domain.usecase.product.GetProductsUseCase
import com.woowa.banchan.domain.usecase.recentlyviewed.GetAllRecentlyViewedUseCase
import com.woowa.banchan.domain.usecase.recentlyviewed.ModifyRecentlyViewedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetPlanUseCase(
        banchanRepository: BanchanRepository,
        getCartUseCase: GetCartUseCase
    ): GetPlanUseCase {
        return GetPlanUseCase(banchanRepository, getCartUseCase)
    }

    @Provides
    @Singleton
    fun providesGetDetailProductUseCase(repository: BanchanRepository): GetDetailProductUseCase {
        return GetDetailProductUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetProductsUseCase(
        repository: BanchanRepository,
        getCartUseCase: GetCartUseCase
    ): GetProductsUseCase {
        return GetProductsUseCase(repository, getCartUseCase)
    }

    @Provides
    @Singleton
    fun providesAddCartUseCase(
        repository: CartRepository,
        existCartUseCase: ExistCartUseCase,
        modifyCartUseCase: ModifyCartUseCase,
        getCartWithHashUseCase: GetCartWithHashUseCase
    ): AddCartUseCase {
        return AddCartUseCase(
            repository,
            existCartUseCase,
            modifyCartUseCase,
            getCartWithHashUseCase
        )
    }

    @Provides
    @Singleton
    fun providesGetCartUseCase(repository: CartRepository): GetCartUseCase {
        return GetCartUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesExistCartUseCase(repository: CartRepository): ExistCartUseCase {
        return ExistCartUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesModifyCartUseCase(repository: CartRepository): ModifyCartUseCase {
        return ModifyCartUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetCartWithHashUseCase(repository: CartRepository): GetCartWithHashUseCase {
        return GetCartWithHashUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesRemoveUseCase(repository: CartRepository): RemoveCartUseCase {
        return RemoveCartUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetAllRecentlyViewedUseCase(
        repository: RecentlyViewedRepository,
        getCartUseCase: GetCartUseCase
    ): GetAllRecentlyViewedUseCase {
        return GetAllRecentlyViewedUseCase(repository, getCartUseCase)
    }

    @Provides
    @Singleton
    fun providesModifyRecentlyViewedUseCase(repository: RecentlyViewedRepository): ModifyRecentlyViewedUseCase {
        return ModifyRecentlyViewedUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetOrderInfoUseCase(repository: OrderRepository): GetOrderInfoUseCase {
        return GetOrderInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetOrderListUseCase(repository: OrderRepository): GetOrderLineItemUseCase {
        return GetOrderLineItemUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesModifyOrderUseCase(repository: OrderRepository): ModifyOrderUseCase {
        return ModifyOrderUseCase(repository)
    }
}

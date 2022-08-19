package com.woowa.banchan.domain.usecase

import com.woowa.banchan.domain.entity.RecentlyViewed
import com.woowa.banchan.domain.repository.RecentlyViewedRepository
import javax.inject.Inject

class AddRecentlyViewedUseCase @Inject constructor(
    private val recentlyViewedRepository: RecentlyViewedRepository
) {

    suspend operator fun invoke(recentlyViewed: RecentlyViewed) {
        return recentlyViewedRepository.addRecentlyViewed(recentlyViewed)
    }
}
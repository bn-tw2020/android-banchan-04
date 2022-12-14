package com.woowa.banchan.ui.screen.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.woowa.banchan.domain.usecase.order.GetOrderInfoUseCase
import com.woowa.banchan.domain.usecase.order.GetStartOrderCountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val getOrderInfoUseCase: GetOrderInfoUseCase,
    private val getStartOrderCountUseCase: GetStartOrderCountUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(OrderUiState())
    val state = _state.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

//    val data =
//        Pager(PagingConfig(pageSize = 10)) { getOrderInfoUseCase() }.flow
//            .catch {
//            }
//            .cachedIn(viewModelScope)
    val data = getOrderInfoUseCase()

    init {
        getStartOrderCount()
    }

    private fun getStartOrderCount() {
        viewModelScope.launch {
            getStartOrderCountUseCase().onEach { result ->
                result.onSuccess {
                    if (it > 0)
                        _state.value = _state.value.copy(
                            active = true,
                            isLoading = false
                        )
                    else
                        _state.value = _state.value.copy(
                            active = false,
                            isLoading = false
                        )
                }.onFailure {
                    _eventFlow.emit(UiEvent.ShowToast(it.message))
                }
            }.launchIn(this)
        }
    }

    fun navigateToDetail(id: Long) {
        viewModelScope.launch {
            _eventFlow.emit(UiEvent.NavigateToOrderDetail(id))
        }
    }

    fun navigateToBack() {
        viewModelScope.launch {
            _eventFlow.emit(UiEvent.NavigateToBack)
        }
    }
}

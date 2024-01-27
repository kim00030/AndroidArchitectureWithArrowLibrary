package com.dan.androidarchitercturewitharrowframework.store.presentation.products_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.androidarchitercturewitharrowframework.store.domain.repository.ProductRepository
import com.dan.androidarchitercturewitharrowframework.store.presentation.util.sendEvent
import com.dan.androidarchitercturewitharrowframework.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProductsViewState())
    val state = _state.asStateFlow()

//    var composeState = mutableStateOf(ProductsViewState())
//        private set

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            //Loading state
            _state.update { productViewState ->
                productViewState.copy(isLoading = true)
            }

            //Getting products
            val result = productRepository.getProducts()
            //successful case
            result.onRight { products ->
                _state.update { productsViewState ->
                    productsViewState.copy(isLoading = false, products = products)
                }
            }
            //Error case
            result.onLeft { netWorkError ->
                _state.update { productsViewState ->
                    productsViewState.copy(isLoading = false, error = netWorkError.error.message)
                }
                //send to UI and let the UI shows Toast message
                sendEvent(event = Event.Toast(message = netWorkError.error.message))
            }
        }
    }
}
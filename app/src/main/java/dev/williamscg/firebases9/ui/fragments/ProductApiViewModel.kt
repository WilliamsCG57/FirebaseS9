package dev.williamscg.firebases9.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.williamscg.firebases9.model.ProductApiModel
import dev.williamscg.firebases9.repository.ProductApiRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductApiViewModel : ViewModel() {
    private val repository = ProductApiRepository()
    private val _isProductAdded = MutableLiveData<Boolean>()
    val isProductAdded: MutableLiveData<Boolean> get() = _isProductAdded

    fun createProduct(producto: ProductApiModel) {
        repository.createProduct(producto).enqueue(object : Callback<ProductApiModel> {
            override fun onResponse(
                call: Call<ProductApiModel>,
                response: Response<ProductApiModel>
            ) {
                if (response.isSuccessful) {
                    _isProductAdded.value = true
                } else {
                    _isProductAdded.value = false
                }
            }


            override fun onFailure(call: Call<ProductApiModel>, t: Throwable) {
                _isProductAdded.value = false
            }
        })
    }
}



package com.enestigli.cryptocrazy.presentation.CryptoList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enestigli.cryptocrazy.domain.model.CryptoListItem
import com.enestigli.cryptocrazy.domain.use_case.get_crypto_list.GetCryptoListUseCase
import com.enestigli.cryptocrazy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject


@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCryptoListUseCase: GetCryptoListUseCase

):ViewModel(){

    var cryptoList = mutableStateOf<List<CryptoListItem>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    private var initialCryptoList = listOf<CryptoListItem>()
    private var isSearchStarting = true


    init{
        loadCryptos()
    }

    fun searchCryptoList(query:String)
    {
        var listToSearch = if(isSearchStarting){
            cryptoList.value
        }else{
            initialCryptoList
        }


        viewModelScope.launch(Dispatchers.Default) {
            if(query.isEmpty()){
                cryptoList.value = initialCryptoList
                isSearchStarting = true
                return@launch
            }

            val results = listToSearch.filter {

                it.currency.contains(query.trim(),ignoreCase = true)
            }


            if(isSearchStarting){
                initialCryptoList = cryptoList.value
                isSearchStarting = false
            }

            cryptoList.value = results
        }
    }

    fun loadCryptos() {

        viewModelScope.launch {
            isLoading.value = true
            val result = getCryptoListUseCase.invoke()
            when(result){

                is Resource.Success -> {
                    val cryptoItems = result.data!!.mapIndexed{index,item ->

                        CryptoListItem(item.currency,item.price)

                    } as List<CryptoListItem> //Bu ? yerine de yazılabilir

                    errorMessage.value = ""
                    isLoading.value = false
                    cryptoList.value += cryptoItems /* ? */
                }

                is Resource.Error -> {

                    errorMessage.value = result.message!!
                    isLoading.value = false
                }

            }
        }

    }


}
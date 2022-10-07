package com.enestigli.cryptocrazy.presentation.CryptoListDetail

import androidx.lifecycle.ViewModel
import com.enestigli.cryptocrazy.domain.model.Crypto
import com.enestigli.cryptocrazy.domain.repository.ICryptoCrazyRepository
import com.enestigli.cryptocrazy.domain.use_case.get_crypto_details.GetCryptoDetailUseCase
import com.enestigli.cryptocrazy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val getCryptoDetailUseCase: GetCryptoDetailUseCase
): ViewModel(){


    suspend fun getCrypto():Resource<Crypto>{

        return getCryptoDetailUseCase.invoke()
    }


}
package com.enestigli.cryptocrazy.domain.use_case.get_crypto_details

import com.enestigli.cryptocrazy.domain.model.Crypto
import com.enestigli.cryptocrazy.domain.repository.ICryptoCrazyRepository
import com.enestigli.cryptocrazy.util.Resource
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class GetCryptoDetailUseCase @Inject constructor(
    private val repository: ICryptoCrazyRepository
) {


    operator fun invoke () : Resource<Crypto>{

        val response = try {

            runBlocking {
                repository.getCrypto()

            }

        }catch (e:Exception){

            return Resource.Error("GetCryptoDetailUseCase error")
        }
        return Resource.Success(response)
    }
}
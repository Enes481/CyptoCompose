package com.enestigli.cryptocrazy.domain.use_case.get_crypto_list

import com.enestigli.cryptocrazy.domain.model.CryptoList
import com.enestigli.cryptocrazy.domain.repository.ICryptoCrazyRepository
import com.enestigli.cryptocrazy.util.Resource
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class GetCryptoListUseCase @Inject constructor(
    private val repository: ICryptoCrazyRepository
){

    operator fun invoke() : Resource<CryptoList> {

       val response = try {

            runBlocking {

                repository.getCryptoList()

            }

        }
        catch (e:Exception){
            return Resource.Error("GetCryptoListUseCase error!")
        }


        return Resource.Success(response)


    }


}
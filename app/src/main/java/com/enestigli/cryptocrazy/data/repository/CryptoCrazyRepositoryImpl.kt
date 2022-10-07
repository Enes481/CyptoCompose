package com.enestigli.cryptocrazy.data.repository

import com.enestigli.cryptocrazy.data.remote.CryptoAPI
import com.enestigli.cryptocrazy.domain.model.Crypto
import com.enestigli.cryptocrazy.domain.model.CryptoList
import com.enestigli.cryptocrazy.domain.repository.ICryptoCrazyRepository
import com.enestigli.cryptocrazy.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class CryptoCrazyRepositoryImpl @Inject constructor(
    private val api:CryptoAPI
) : ICryptoCrazyRepository{



    override suspend fun getCryptoList(): CryptoList {

        return api.getCryptoList()
    }


    override suspend fun getCrypto(): Crypto {

        return api.getCryptoListDetail()

    }


}
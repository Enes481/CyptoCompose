package com.enestigli.cryptocrazy.data.remote

import com.enestigli.cryptocrazy.domain.model.Crypto
import com.enestigli.cryptocrazy.domain.model.CryptoList
import com.enestigli.cryptocrazy.util.Constants.URL
import com.enestigli.cryptocrazy.util.Constants.URL2
import retrofit2.http.GET

interface CryptoAPI {

    @GET(URL)
    suspend fun getCryptoList() : CryptoList

    @GET(URL2)
    suspend fun getCryptoListDetail() : Crypto





}
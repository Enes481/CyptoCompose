package com.enestigli.cryptocrazy.domain.repository

import com.enestigli.cryptocrazy.domain.model.Crypto
import com.enestigli.cryptocrazy.domain.model.CryptoList
import com.enestigli.cryptocrazy.util.Resource

interface ICryptoCrazyRepository {

    suspend fun getCryptoList():CryptoList

    suspend fun getCrypto():Crypto
}
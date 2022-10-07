package com.enestigli.cryptocrazy.di

import com.enestigli.cryptocrazy.data.remote.CryptoAPI
import com.enestigli.cryptocrazy.data.repository.CryptoCrazyRepositoryImpl
import com.enestigli.cryptocrazy.domain.repository.ICryptoCrazyRepository
import com.enestigli.cryptocrazy.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Singleton
    @Provides
    fun provideCryptoApi() : CryptoAPI{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CryptoAPI::class.java)

    }


    @Singleton
    @Provides
    fun provideCryptoRepository( api : CryptoAPI) : ICryptoCrazyRepository {
        return CryptoCrazyRepositoryImpl(api)
    }






}
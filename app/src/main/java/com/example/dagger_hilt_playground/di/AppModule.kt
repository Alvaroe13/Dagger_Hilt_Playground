package com.example.dagger_hilt_playground.di

import com.example.dagger_hilt_playground.service.Api
import com.example.dagger_hilt_playground.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLogInterceptor() : HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(logInterceptor : HttpLoggingInterceptor) : OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit =
         Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : Api =
         retrofit.create(Api::class.java)

}
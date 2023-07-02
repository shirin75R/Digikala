package com.example.digikala1.di

import com.example.digikala1.BuildConfig
import com.example.digikala1.util.Constants.API_KEY
import com.example.digikala1.util.Constants.BASE_URL
import com.example.digikala1.util.Constants.TIMEOUT_IN_SECOND
import com.example.digikala1.util.Constants.USER_LANGUAGE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    internal fun interceptor(): HttpLoggingInterceptor{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    @Provides
    @Singleton
    fun provideOkHttp():OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT_IN_SECOND,TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_IN_SECOND,TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_IN_SECOND,TimeUnit.SECONDS)
        .addInterceptor{chain ->
            val request =chain.request().newBuilder()
                .addHeader("x-api-key",API_KEY)
                .addHeader("lang", USER_LANGUAGE)
            chain.proceed(request.build())
        }
        .addInterceptor(interceptor())
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()



}
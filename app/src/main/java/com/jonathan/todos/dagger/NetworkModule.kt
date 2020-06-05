package com.jonathan.todos.dagger

import com.jonathan.todos.BuildConfig
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()
}


/**
 * Retrofit
 *    HttpLoggingInterceptor
 *    HttpClient
 *    GsonConverter()
 *    RxJava CallAdpater()
 */

/**
 * Main Thread (UI Thread) (10 milliseconds - 30)
 * IO -> pipe data main
 *    -> Thread (Memory leak)
 *    -> AsyncTask (Memory leak)
 *    -> RxJava (Verbose) <---> observedOnMain
 *    -> Coroutines ****
 */



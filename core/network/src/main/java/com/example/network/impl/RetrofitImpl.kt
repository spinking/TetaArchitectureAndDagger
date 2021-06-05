package com.example.network.impl

import com.example.common_utils.config.ConfigProvider
import com.example.network.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.security.GeneralSecurityException
import java.security.SecureRandom
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.net.ssl.HostnameVerifier

class RetrofitImpl @Inject constructor(private val configProvider: ConfigProvider) :
    RetrofitProvider {
    private var retrofitInstance: Retrofit? = null
    override val retrofit: Retrofit
        get() {
            return if (retrofitInstance != null) {
                retrofitInstance!!
            } else {
                retrofitInstance = initRetrofit()
                retrofitInstance!!
            }
        }

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(configProvider.baseServer)
            .addConverterFactory(MoshiConverterFactory.create(moshi()))
            .client(okHttpClient())
            .build()
    }

    private fun moshi(): Moshi {
        return Moshi.Builder().build()
    }

    private fun okHttpClient(): OkHttpClient {
        val trustManager = TrustManagerFactory.provideTrustManager()
        val builder = OkHttpClient.Builder()
            .sslSocketFactory(socketFactory(trustManager), trustManager)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(LoggingInterceptor())
            builder.hostnameVerifier(HostnameVerifier { _, _ -> true })
        }
        if (!BuildConfig.DEBUG) {
            builder.certificatePinner(CertificatePinner.DEFAULT)
        }
        return builder.build()
    }

    private fun socketFactory(trustManager: X509TrustManager): SSLSocketFactory {
        try {
            val protocol = "SSL"
            val sslContext = SSLContext.getInstance(protocol)
            sslContext.init(null, arrayOf<TrustManager>(trustManager), SecureRandom())
            return sslContext.socketFactory
        } catch (e: GeneralSecurityException) {
            throw AssertionError()
        }
    }
}

private const val CONNECT_TIMEOUT = 10L
private const val READ_TIMEOUT = 60L
private const val WRITE_TIMEOUT = 60L

package com.example.fragments.movie.network.utils

import com.example.fragments.BuildConfig
import com.example.fragments.movie.network.api.MovieApi
import com.example.fragments.movie.network.api.MovieDetailsApi
import com.example.fragments.movie.network.api.MoviePopularApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

open class CallBuilder() {
	private val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
	private fun retrofit() = Retrofit.Builder()
		.baseUrl(BuildConfig.BASE_URL_API)
		.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
		.addConverterFactory(MoshiConverterFactory.create(moshi))
		.build()

	protected fun buildDetailsCall(): MovieDetailsApi = retrofit().create(MovieDetailsApi::class.java)
	protected fun buildPopularCall(): MoviePopularApi = retrofit().create(MoviePopularApi::class.java)
	protected fun buildMoviesCall(): MovieApi = retrofit().create(MovieApi::class.java)
}

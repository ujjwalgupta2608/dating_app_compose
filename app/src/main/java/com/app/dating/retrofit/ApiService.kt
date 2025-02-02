package com.app.dating.retrofit

import com.app.dating.model.login.request.LoginRequest
import com.app.dating.model.login.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("user/auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}
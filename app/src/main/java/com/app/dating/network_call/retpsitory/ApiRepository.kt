package com.app.dating.network_call.retpsitory

import com.app.dating.model.login.request.LoginRequest
import com.app.dating.model.login.response.LoginResponse
import com.app.dating.retrofit.ApiService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(emailOrUsername: String, password: String): LoginResponse {
        return apiService.login(LoginRequest(emailOrUsername, password))
    }
}

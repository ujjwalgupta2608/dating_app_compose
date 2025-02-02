package com.app.dating.model.login.request

data class LoginRequest(
    var deviceToken: String="",
    var deviceType: String="",
    var email: String="",
    var password: String="",
    var userName: String=""
)
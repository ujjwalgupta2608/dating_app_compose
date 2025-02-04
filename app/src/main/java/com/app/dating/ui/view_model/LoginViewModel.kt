package com.app.dating.ui.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.dating.network_call.retpsitory.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

    // Form input states
    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    // Validation error states
    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _loginSuccess = MutableStateFlow<Boolean?>(null)
    val loginSuccess = _loginSuccess.asStateFlow()

    fun setUsername(value: String) {
        _username.value = value
    }

    fun setPassword(value: String) {
        _password.value = value
    }

    // Validate form
    private fun validateInput(): Boolean {
        return when {
            username.value.isEmpty() -> {
                _errorMessage.value = "Username/Email cannot be empty"
                false
            }
            password.value.isEmpty() -> {
                _errorMessage.value = "Password cannot be empty"
                false
            }
            password.value.length < 6 -> {
                _errorMessage.value = "Password must be at least 6 characters"
                false
            }
            else -> {
                _errorMessage.value = ""
                true
            }
        }
    }

    // API call
    fun login() {
        if (!validateInput()) return // Stop if validation fails

        _isLoading.value = true

        viewModelScope.launch {
            try {
                val response = repository.login(username.value, password.value)
                Log.d("LoginViewModel", "Response: $response") // Log the API response

                if (response.status == "200") {
                    _loginSuccess.value = true
                } else {
                    _errorMessage.value = response.message
                    _loginSuccess.value = false
                }
            } catch (e: Exception) {
                Log.e("LoginViewModel", "Login failed", e) // Log the exception
                _errorMessage.value = "Something went wrong: ${e.localizedMessage}"
                _loginSuccess.value = false
            } finally {
                _isLoading.value = false
            }
        }
    }

}


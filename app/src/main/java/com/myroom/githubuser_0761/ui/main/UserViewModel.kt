package com.myroom.githubuser_0761.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myroom.githubuser_0761.api.RetrofitUser
import com.myroom.githubuser_0761.data.model.User
import com.myroom.githubuser_0761.data.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {
    val listUsers = MutableLiveData<ArrayList<User>>()

    fun setSearchUsers(query: String) {
        RetrofitUser.apiInstance
                .getSearchUsers(query)
                .enqueue(object : Callback<UserResponse> {
                    override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                        if (response.isSuccessful) {
                            listUsers.postValue(response.body()?.items)
                        }
                    }

                    override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                        t.message?.let { Log.d("Failure", it) }
                    }
                })
    }

    fun getSearchUsers(): LiveData<ArrayList<User>> {
        return listUsers
    }
}
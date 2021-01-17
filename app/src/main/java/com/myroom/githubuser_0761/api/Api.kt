package com.myroom.githubuser_0761.api

import com.myroom.githubuser_0761.data.model.DetailUserResponse
import com.myroom.githubuser_0761.data.model.User
import com.myroom.githubuser_0761.data.model.UserResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 95dc341eaf8c7f143bb923cadf4087885a8765fe")
    fun getSearchUsers(
            @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 95dc341eaf8c7f143bb923cadf4087885a8765fe")
    fun getUserDetail(
            @Path("username") username : String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 95dc341eaf8c7f143bb923cadf4087885a8765fe")
    fun getFollowers(
            @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 95dc341eaf8c7f143bb923cadf4087885a8765fe")
    fun getFollowing(
            @Path("username") username: String
    ): Call<ArrayList<User>>
}
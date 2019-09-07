package com.example.retrofitandgson.api

import com.example.retrofitandgson.model.Post
import com.example.retrofitandgson.model.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users/1")
    fun getExistingUser(): Call<User?>

    @GET("user/424")
    fun getNonExistingUser(): Call<User?>

    @GET("users")
    fun getUserById(@Query("id") id: Int): Call<User?>

    @GET("users")
    fun getUsersById(@Query("id") vararg ids: Int): Call<List<User>>

    @GET("users?_sort=id")
    fun getUsersSortedById(@Query("_order") order: String): Call<List<User>>

    @GET("users?_sort=name")
    fun getUsersSortedByName(@Query("_order") order: String): Call<List<User>>

    @GET("users")
    fun getUsersWithRawParams(@QueryName vararg queryParams: String): Call<List<User>>

    @GET("users")
    fun getUsersWithParamsMap(@QueryMap queryParams: Map<String, String>): Call<List<User>>

    @GET
    fun getUsersWithRawUrl(@Url url: String): Call<List<User>>

    @GET("users/{id}/posts")
    fun getPostsByUserId(@Path("id") userId: Int): Call<List<Post>>

    @HEAD("users")
    fun headUsers(): Call<Void>

    @POST("users")
    fun postUser(@Body user: User): Call<User?>

    @POST("users")
    fun postUsers(@Body users: List<User>): Call<List<User>>

    @POST("users")
    @FormUrlEncoded
    fun postUserByFields(
        @Field("name") name: String,
        @Field("email") email: String
    ): Call<User?>

    @POST("users")
    @FormUrlEncoded
    fun postUserByFieldsMap(@FieldMap fields: Map<String, String>): Call<User?>

    @POST("users/1")
    fun postFirstUser(@Body user: User): Call<User?>

    @POST("users/1")
    @FormUrlEncoded
    fun postFirstUserByFields(
        @Field("name") name: String,
        @Field("email") email: String
    ): Call<User?>

    @PUT("users/{id}")
    fun putUser(@Path("id") id: Int, @Body user: User): Call<User?>

    @PATCH("users/{id}")
    fun patchUser(@Path("id") id: Int, @Body user: User): Call<User?>

    @DELETE("users")
    fun deleteUsers(): Call<Void>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id: Int): Call<Void>

    @OPTIONS("*")
    fun options(): Call<Void>
}
package com.example.retrofitandgson.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.retrofitandgson.R
import com.example.retrofitandgson.api.BASE_URL
import com.example.retrofitandgson.api.OrderInterceptor
import com.example.retrofitandgson.api.UrlLoggingInterceptor
import com.example.retrofitandgson.api.UserService
import com.example.retrofitandgson.model.Address
import com.example.retrofitandgson.model.Company
import com.example.retrofitandgson.model.Post
import com.example.retrofitandgson.model.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var code: TextView
    private lateinit var headers: TextView
    private lateinit var body: TextView

    private lateinit var service: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
        initService()

        f00()
    }

    private fun f00() {
        //getUsers()
        //getExistingUser()
        //getNonExistingUser()
        //getUsersById()
        //getUsersSortedById()
        //getUsersSortedByName()
        //getUsersWithRawQueryParams()
        //getUsersWithQueryMap()
        //getUsersWithRawUrlRelative()
        //getUsersWithRawUrlAbsolute()
        //headUsers()
        //getPostsByUserId()
        //postUser()
        //postUsers()
        //postUserByFields()
        //postUserWithFieldsMap()
        //postFirstUser()
        //postFirstUserByFields()
        //putExistingUser()
        //putNewUser()
        //patchExistingUser()
        //patchNewUser()
        //deleteUsers()
        //deleteUser()
    }

    private fun getUsers() {
        service
            .getUsers()
            .enqueue(UserListCallback(::applyUserList))
    }

    private fun getExistingUser() {
        service
            .getExistingUser()
            .enqueue(createUserCallback())
    }

    private fun getNonExistingUser() {
        service
            .getNonExistingUser()
            .enqueue(createUserCallback())
    }

    private fun getUserById() {
        val param = 2
        service
            .getUserById(param)
            .enqueue(UserCallback(::applyUser))
    }

    private fun getUsersById() {
        val params = intArrayOf(2, 3)
        service
            .getUsersById(*params)
            .enqueue(UserListCallback(::applyUserList))
    }

    private fun getUsersSortedById() {
        val param = "desc"
        service
            .getUsersSortedById(param)
            .enqueue(createUserListCallback())
    }

    private fun getUsersSortedByName() {
        val param = "asc"
        service
            .getUsersSortedByName(param)
            .enqueue(createUserListCallback())
    }

    private fun getUsersWithRawQueryParams() {
        val params = arrayOf("_sort=id", "_order=desc")
        service
            .getUsersWithRawParams(*params)
            .enqueue(createUserListCallback())
    }

    private fun getUsersWithQueryMap() {
        val params = mapOf(
            "_sort" to "id",
            "_order" to "desc"
        )
        service
            .getUsersWithParamsMap(params)
            .enqueue(createUserListCallback())
    }

    private fun getUsersWithRawUrlRelative() {
        val params = "users"
        service
            .getUsersWithRawUrl(params)
            .enqueue(createUserListCallback())
    }

    private fun getUsersWithRawUrlAbsolute() {
        val param = "https://my-json-server.typicode.com/nmati/fake-REST-server/users"
        service
            .getUsersWithRawUrl(param)
            .enqueue(createUserListCallback())
    }

    private fun getUsersHeadersOnly() {
        service
            .headUsers()
            .enqueue(createVoidCallback())
    }

    private fun getPostsByUserId() {
        val params = 2
        service
            .getPostsByUserId(params)
            .enqueue(createPostListCallback())
    }

    private fun postUser() {
        val address = Address("streett", "cityy", "zipp")
        val company = Company("#1", "The BEST")
        val user = User(4, "John Doe", "johndoe@gmail.com", address, company)
        service
            .postUser(user)
            .enqueue(createUserCallback())
    }

    private fun postUsers() {
        val name1 = "John Doe1"
        val email1 = "johndoe1@gmail.com"
        val name2 = "John Doe2"
        val email2 = "johndoe2@gmail.com"
        val user1 = User(name = name1, email = email1)
        val user2 = User(name = name2, email = email2)
        val params = listOf(user1, user2)
        service
            .postUsers(params)
            .enqueue(createUserListCallback())
    }

    private fun postUserByFields() {
        val name = "John Doe"
        val email = "johndoe@gmail.com"
        service
            .postUserByFields(name, email)
            .enqueue(createUserCallback())
    }

    private fun postUserWithFieldsMap() {
        val params = mapOf(
            "id" to "6",
            "name" to "John",
            "email" to "johndoe@gmail.com"
        )
        service
            .postUserByFieldsMap(params)
            .enqueue(createUserCallback())
    }

    private fun postFirstUser() {
        val address = Address("streett", "cityy", "zipp")
        val company = Company("#1", "The BEST")
        val user = User(
            name = "John Doe",
            email = "johndoe@gmail.com",
            address = address,
            company = company
        )
        service
            .postFirstUser(user)
            .enqueue(createUserCallback())
    }

    private fun postFirstUserByFields() {
        val name = "John Doe"
        val email = "johndoe@gmail.com"
        service
            .postFirstUserByFields(name, email)
            .enqueue(createUserCallback())

    }

    private fun putExistingUser() {
        val id = 2
        val name = "John Doe"
        val email = "johndoe@gmail.com"
        val user = User(name = name, email = email)
        service
            .putUser(id, user)
            .enqueue(createUserCallback())
    }

    private fun putNewUser() {
        val id = 344
        val name = "John Doe"
        val email = "johndoe@gmail.com"
        val user = User(name = name, email = email)
        service
            .putUser(id, user)
            .enqueue(createUserCallback())
    }

    private fun patchExistingUser() {
        val id = 2
        val name = "John Doe"
        val email = "johndoe@gmail.com"
        val user = User(name = name, email = email)
        service
            .patchUser(id, user)
            .enqueue(createUserCallback())
    }

    private fun patchNewUser() {
        val id = 344
        val name = "John Doe"
        val email = "johndoe@gmail.com"
        val user = User(name = name, email = email)
        service
            .patchUser(id, user)
            .enqueue(createUserCallback())
    }

    private fun deleteUser() {
        val param = 2
        service
            .deleteUser(param)
            .enqueue(createVoidCallback())
    }

    private fun deleteUsers() {
        service
            .deleteUsers()
            .enqueue(createVoidCallback())
    }


    // ##########################################################

    private fun createUserCallback() = UserCallback(::applyUser)

    private fun createUserListCallback() = UserListCallback(::applyUserList)

    private fun createVoidCallback() = VoidCallback(::applyVoid)

    private fun createPostListCallback() = PostListCallback(::applyPosts)

    private fun findViews() {
        code = findViewById(R.id.code)
        headers = findViewById(R.id.headers)
        body = findViewById(R.id.body)
    }

    private fun initService() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
            .addInterceptor(OrderInterceptor())
            .addInterceptor(loggingInterceptor)
            .addInterceptor(UrlLoggingInterceptor())
            .build()

        service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    private fun applyUser(code: Int, headers: Map<String, String>, body: User?) {
        this.code.setCode(code)
        this.headers.setHeaders(headers)
        this.body.setBody(body)
    }

    private fun applyUserList(code: Int, headers: Map<String, String>, body: List<User>) {
        this.code.setCode(code)
        this.headers.setHeaders(headers)
        this.body.setBody(body)
    }

    private fun applyVoid(code: Int, headers: Map<String, String>) {
        this.code.setCode(code)
        this.headers.setHeaders(headers)
    }

    private fun applyPosts(code: Int, headers: Map<String, String>, body: List<Post>) {
        this.code.setCode(code)
        this.headers.setHeaders(headers)
        this.body.setBody(body)
    }

    private fun TextView.setCode(code: Int) {
        @ColorRes val colorResId = when (code) {
            in 100 until 200 -> android.R.color.darker_gray
            in 200 until 300 -> android.R.color.holo_green_dark
            in 300 until 400 -> android.R.color.darker_gray
            in 400 until 500 -> android.R.color.holo_red_light
            in 500 until 600 -> android.R.color.holo_red_dark
            else -> return
        }
        text = code.toString()
        setBackgroundColor(color(colorResId))
    }

    private fun TextView.setHeaders(headers: Map<String, String>) {
        val sb = StringBuilder()
        for (entry in headers.entries) {
            sb.append(entry.key)
            sb.append(" : ")
            sb.append(entry.value)
            sb.append("\n\n")
        }
        text = sb.toString()
    }

    private fun TextView.setBody(obj: Any?) {
        text = obj.toString()
    }

    private fun TextView.setBody(objs: Iterable<Any>) {
        val sb = StringBuilder()
        for (item in objs) {
            sb.append(item.toString())
            sb.append("\n\n")
        }
        text = sb.toString()
    }

    @ColorInt
    private fun color(@ColorRes colorResId: Int): Int =
        ContextCompat.getColor(this, colorResId)

    private class UserListCallback(
        private val block: (code: Int, headers: Map<String, String>, body: List<User>) -> Unit
    ) : Callback<List<User>> {

        override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
            block(response.code(), response.headers().toMap(), response.body() ?: emptyList())
        }

        override fun onFailure(call: Call<List<User>>, t: Throwable) = Unit
    }

    private class UserCallback(
        private val block: (code: Int, headers: Map<String, String>, body: User?) -> Unit
    ) : Callback<User?> {

        override fun onResponse(call: Call<User?>, response: Response<User?>) {
            block(response.code(), response.headers().toMap(), response.body())
        }

        override fun onFailure(call: Call<User?>, t: Throwable) = Unit
    }

    private class VoidCallback(
        private val block: (code: Int, headers: Map<String, String>) -> Unit
    ) : Callback<Void> {

        override fun onResponse(call: Call<Void>, response: Response<Void>) {
            block(response.code(), response.headers().toMap())
        }

        override fun onFailure(call: Call<Void>, t: Throwable) = Unit
    }

    private class PostListCallback(
        private val block: (code: Int, headers: Map<String, String>, body: List<Post>) -> Unit
    ) : Callback<List<Post>> {

        override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
            block(response.code(), response.headers().toMap(), response.body() ?: emptyList())
        }

        override fun onFailure(call: Call<List<Post>>, t: Throwable) = Unit
    }
}

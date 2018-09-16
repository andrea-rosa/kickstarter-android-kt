package it.andrearosa.kickstarter.service

import io.reactivex.Observable
import it.andrearosa.kickstarter.dto.User
import retrofit2.http.GET

interface RestInterface {

    @GET("users")
    fun getUsers(): Observable<List<User>>

}
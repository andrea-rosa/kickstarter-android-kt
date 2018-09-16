package it.andrearosa.kickstarter.activities

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import it.andrearosa.kickstarter.R
import it.andrearosa.kickstarter.db.AppDatabase
import it.andrearosa.kickstarter.db.models.UserModel
import it.andrearosa.kickstarter.service.RestClient
import org.jetbrains.anko.doAsync
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var restClient: RestClient

    @Inject
    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        restClient.restInterface.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    it.map {
                        UserModel(it.id, it.name, it.username, it.email)
                    }.forEach {
                        doAsync {
                            appDatabase.userDao().insert(it)
                        }
                    }
                }
    }
}
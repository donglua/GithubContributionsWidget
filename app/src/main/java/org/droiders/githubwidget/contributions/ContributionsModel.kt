package org.droiders.githubwidget.contributions

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by donglua on 2016/12/28.
 */
class ContributionsModel : ContributionsContract.Model {

    private val okhttp: OkHttpClient

    init {
        okhttp = OkHttpClient.Builder().build()
    }

    override fun getUserContributions(userName: String): Call {
        val request = Request.Builder()
                .url("https://github.com/users/$userName/contributions")
                .get()
                .build()
        return okhttp.newCall(request)
    }

}
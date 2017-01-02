package org.droiders.githubwidget.contributions

import android.content.Context
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Model
 *
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

    override fun getUserName(context: Context): String {
        val sp = context.getSharedPreferences("github_contributions", Context.MODE_PRIVATE)
        val userName = sp.getString("username", "")
        return userName
    }

    override fun saveUserName(context: Context, userName: String) {
        val editor = context.getSharedPreferences("github_contributions", Context.MODE_PRIVATE).edit()
        editor.putString("username", userName)
        editor.commit()
    }
}
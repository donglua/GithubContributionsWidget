package org.droiders.githubwidget.contributions

import okhttp3.Call
import org.droiders.githubwidget.data.Contributions

/**
 * Created by donglua on 2016/12/27.
 */
interface ContributionsContract {

    interface Presenter {
        fun initUserContributions(userName: String): Unit
    }

    interface View {
        fun showAppWidget(list: List<Contributions>)
        fun showFailure(message: String?)

    }

    interface Model {
        fun getUserContributions(userName: String): Call
    }
}
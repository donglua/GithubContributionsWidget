package org.droiders.githubwidget.contributions

import okhttp3.Call
import okhttp3.Response
import org.droiders.githubwidget.data.DayContributions
import org.droiders.githubwidget.Utils
import java.io.IOException

/**
 * Created by donglua on 2016/12/27.
 */

class ContributionsPresenter(
        private val mView: ContributionsContract.View,
        private val mModel: ContributionsContract.Model
) : ContributionsContract.Presenter {

    override fun initUserContributions(userName: String) {
        mModel.getUserContributions(userName).enqueue(object : okhttp3.Callback {

            override fun onResponse(call: Call?, response: Response?) {
                if (response?.isSuccessful?:false) {
                    val svgString = response?.body()?.string()
                    val list = Utils.svgToContributionsList(svgString)
                    mView.showAppWidget(list)
                } else {
                    mView.showFailure(response?.message())
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                mView.showFailure(e?.message)
            }
        })
    }


}


package org.droiders.githubwidget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import org.droiders.githubwidget.contributions.ContributionsContract
import org.droiders.githubwidget.contributions.ContributionsModel
import org.droiders.githubwidget.contributions.ContributionsPresenter
import org.droiders.githubwidget.data.DayContributions

import org.droiders.githubwidget.databinding.ActivityWidgetConfigBinding

/**
 * Created by donglua on 2016/12/27.
 */

class WidgetConfigActivity : AppCompatActivity(), ContributionsContract.View {


    private lateinit var mPresenter: ContributionsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityWidgetConfigBinding>(this,
                R.layout.activity_widget_config)

        mPresenter = ContributionsPresenter(this, ContributionsModel())

        binding.buttonUpdate.setOnClickListener {
            val userName = binding.etUserName.text.toString()
            if (userName.isEmpty()) {
                showToast("User Name Can't Be Blank ~")
                return@setOnClickListener
            }
            mPresenter.initUserContributions(userName)
        }
    }

    override fun showAppWidget(list: List<DayContributions>) {
        // runOnUiThread { showToast("list size = " + list.size) }
//        if (position < mRowIDs.size()) {
//            // Set widget result
//            final Intent resultValue = new Intent();
//            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
//            resultValue.putExtra("rowId", mRowIDs.get(position));
//            setResult(RESULT_OK, resultValue);
//
//            // Request widget update
//            final AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
//            ChecksWidgetProvider.updateAppWidget(this, appWidgetManager, mAppWidgetId, mRowIDs);
//        }
        setResult(RESULT_OK)
        finish()
    }

    override fun showFailure(message: String?) {
        if (message != null) showToast(message)
    }
}

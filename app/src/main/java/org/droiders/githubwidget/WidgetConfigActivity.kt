package org.droiders.githubwidget

import android.appwidget.AppWidgetManager
import android.content.*
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.droiders.githubwidget.contributions.ContributionsContract
import org.droiders.githubwidget.contributions.ContributionsModel
import org.droiders.githubwidget.contributions.ContributionsPresenter
import org.droiders.githubwidget.data.DBHelper
import org.droiders.githubwidget.data.DBHelper.Companion.TABLE_NAME
import org.droiders.githubwidget.data.Contributions

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

    override fun showAppWidget(list: List<Contributions>) {

        val uri = Uri.parse("content://${applicationInfo.packageName}.provider/$TABLE_NAME")
        list.forEach {
            val values = ContentValues()
            values.put(DBHelper.COLUMN_COLOR, it.color)
            values.put(DBHelper.COLUMN_DATA_COUNT, it.dataCount)
            values.put(DBHelper.COLUMN_DATE, it.day)
            contentResolver.insert(uri, values)
        }

        updateWidgetList()

        setResult(RESULT_OK)
        finish()
    }


    private fun updateWidgetList() {
        val name = ComponentName(this, ContributionsAppWidgetProvider::class.java)
        val widgetIds = AppWidgetManager.getInstance(this).getAppWidgetIds(name)
        val updateWidgetListIntent = Intent(this, ContributionsAppWidgetProvider::class.java)
        updateWidgetListIntent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        updateWidgetListIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, widgetIds)
        sendBroadcast(updateWidgetListIntent)
    }

    override fun showFailure(message: String?) {
        runOnUiThread {
            if (message != null) showToast(message)
        }
    }
}

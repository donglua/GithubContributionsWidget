package org.droiders.githubwidget

import android.appwidget.AppWidgetProvider
import android.content.Intent
import android.content.Context
import android.widget.RemoteViews
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetManager.ACTION_APPWIDGET_UPDATE
import android.appwidget.AppWidgetManager.EXTRA_APPWIDGET_IDS
import android.content.ComponentName
import android.content.ContentValues
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import android.widget.RemoteViewsService
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.droiders.githubwidget.contributions.ContributionsContract
import org.droiders.githubwidget.contributions.ContributionsModel
import org.droiders.githubwidget.contributions.ContributionsPresenter
import org.droiders.githubwidget.data.Contributions
import org.droiders.githubwidget.data.DBHelper
import java.io.IOException


/**
 * AppWidget Provider
 *
 * Created by donglua on 2016/12/24.
 */

class ContributionsWidgetProvider : AppWidgetProvider() {

    val TAG = "ContributionsWidgetProvider"

    val mModel: ContributionsContract.Model
    var mPresenter: ContributionsContract.Presenter? = null

    init {
        mModel = ContributionsModel()
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive ${intent?.action}")

        if (context == null) return

        when(intent?.action) {
            ACTION_APPWIDGET_UPDATE -> {
                val userName = mModel.getUserName(context)
                if (!TextUtils.isEmpty(userName)) {
                    mPresenter = ContributionsPresenter(object : ContributionsContract.View {
                        override fun showFailure(message: String?) {
                            Log.e(TAG, message)
                        }

                        override fun showAppWidget(list: List<Contributions>) {
                            val uri = Uri.parse("content://${context.applicationInfo?.packageName}.provider/${DBHelper.TABLE_NAME}")
                            list.forEach {
                                val values = ContentValues()
                                values.put(DBHelper.COLUMN_COLOR, it.color)
                                values.put(DBHelper.COLUMN_DATA_COUNT, it.dataCount)
                                values.put(DBHelper.COLUMN_DATE, it.day)
                                context.contentResolver.insert(uri, values)
                            }
                            super@ContributionsWidgetProvider.onReceive(context, intent)
                        }
                    }, mModel)
                    mPresenter?.initUserContributions(userName)
                    return
                }
            }
        }

        super.onReceive(context, intent)
    }

    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {


        val rvWidget = RemoteViews(context?.packageName, R.layout.appwidget_contributions)
        val intent = Intent(context, GridRemoteViewsService::class.java)
        rvWidget.setRemoteAdapter(R.id.grid_view, intent)
        appWidgetManager?.updateAppWidget(appWidgetIds, rvWidget)

        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

}

class GridRemoteViewsService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory? {
        return GridRemoteViewsAdapter(this)
    }
}
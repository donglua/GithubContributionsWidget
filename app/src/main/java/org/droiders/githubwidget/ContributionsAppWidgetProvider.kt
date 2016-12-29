package org.droiders.githubwidget

import android.appwidget.AppWidgetProvider
import android.content.Intent
import android.content.Context
import android.widget.RemoteViews
import android.appwidget.AppWidgetManager
import android.util.Log
import android.widget.RemoteViewsService
import org.droiders.githubwidget.data.Contributions
import java.util.*


/**
 * Created by donglua on 2016/12/24.
 */

class ContributionsAppWidgetProvider : AppWidgetProvider() {

    val TAG = "ContributionsAppWidgetProvider"
    val girdCount = 26 * 7
    val list = ArrayList<Contributions> (girdCount)

    override fun onDisabled(context: Context?) {
        super.onDisabled(context)
        Log.d(TAG, "onDisabled")
    }

    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {

        Log.d(TAG, "onUpdate")

//
//        cursor?.run {
//            if (moveToFirst()) {
//                list.clear()
//                do {
//                    val color = getInt(getColumnIndex(DBHelper.COLUMN_COLOR))
//                    val dataCount = getInt(getColumnIndex(DBHelper.COLUMN_DATA_COUNT))
//                    val day = getString(getColumnIndex(DBHelper.COLUMN_DATE))
//                    val contributions = Contributions(day, dataCount, color)
//                    list.add(contributions)
//                } while (moveToNext())
//            }
//        }
//
//        if (cursor?.count ?: 0 > 0) {
            val rvWidget = RemoteViews(context?.packageName, R.layout.appwidget_contributions)

            appWidgetIds?.forEach {
                // Specify the service to provide data for the collection widget. Note that we need to
                // embed the appWidgetId via the data otherwise it will be ignored.
                val intent = Intent(context, GridRemoteViewsService::class.java)
                intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, it)
                rvWidget.setRemoteAdapter(R.id.grid_view, intent)
                appWidgetManager?.updateAppWidget(it, rvWidget)
            }

//            // Build the intent to call the service
//            val serviceIntent = Intent(context?.applicationContext, GridRemoteViewsService::class.java)
//            serviceIntent.putParcelableArrayListExtra(EXTRA_CONTRIBUTIONS,
//                    list.takeLast(girdCount) as ArrayList<Contributions>)
//            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds)

//        // tell the service which button was touched
//        serviceIntent.putExtra(widgetName, buttonCode);
            // tell the service the bounds of the widget    - could be null
//        serviceIntent.putExtra("bounds", sourceBounds);

            // Update the widgets via the service
//            context?.startService(serviceIntent)
//        }

        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    private fun updateAppWidget(ctx: Context?, manager: AppWidgetManager?, id: Int) {
        val rvWidget = RemoteViews(ctx?.packageName, R.layout.appwidget_contributions)

        // Specify the service to provide data for the collection widget. Note that we need to
        // embed the appWidgetId via the data otherwise it will be ignored.
        val intent = Intent(ctx, GridRemoteViewsService::class.java)

        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id)

        rvWidget.setRemoteAdapter(R.id.grid_view, intent)

        manager?.updateAppWidget(id, rvWidget)
    }

}

class GridRemoteViewsService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory? {
        return GridRemoteViewsAdapter(this)
    }
}
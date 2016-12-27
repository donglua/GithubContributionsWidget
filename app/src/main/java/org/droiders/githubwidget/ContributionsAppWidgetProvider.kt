package org.droiders.githubwidget

import android.app.Service
import android.appwidget.AppWidgetProvider
import android.content.Intent
import android.content.Context
import android.widget.RemoteViews
import android.content.ComponentName
import android.appwidget.AppWidgetManager
import android.widget.RemoteViewsService
import android.widget.Toast


/**
 * Created by donglua on 2016/12/24.
 */

class ContributionsAppWidgetProvider : AppWidgetProvider() {

    val TAG = "ContributionsAppWidgetProvider"

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "onReceive", Toast.LENGTH_SHORT).show()
        super.onReceive(context, intent)
    }
    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        Toast.makeText(context, "onUpdate", Toast.LENGTH_SHORT).show()
        appWidgetIds?.forEach {
            updateAppWidget(context, appWidgetManager, it)
        }

        // Build the intent to call the service
        val serviceIntent = Intent(context?.applicationContext, GridRemoteViewsService::class.java);
        serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds)

//        // tell the service which button was touched
//        serviceIntent.putExtra(widgetName, buttonCode);
        // tell the service the bounds of the widget    - could be null
//        serviceIntent.putExtra("bounds", sourceBounds);

        // Update the widgets via the service
        context?.startService(serviceIntent)

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
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        return GridRemoteViewsFactory(this, Utils.getTestList().takeLast(26 * 7))
    }
}
//
//class ContributionsService : Service() {
//    override fun onBind(p0: Intent?) = null
//
//    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
//
//        buildUpdate(this)
//
//        return Service.START_STICKY
//    }
//
//    fun buildUpdate(context: Context) {
//        updateAppWidget(context)
//    }
//
//    private fun updateAppWidget(context: Context) {
//
//        val views = RemoteViews(context.packageName, R.layout.appwidget_contributions)
//        val serviceIntent = Intent(context, GridRemoteViewsService::class.java)
//        views.setRemoteAdapter(R.id.grid_view, serviceIntent)
//        // Push update for this widget to the home screen
//        val thisWidget = ComponentName(this, ContributionsAppWidgetProvider::class.java)
//        val manager = AppWidgetManager.getInstance(context)
//        manager.updateAppWidget(thisWidget, views)
//    }
//
//}
//

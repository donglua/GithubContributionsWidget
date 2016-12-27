package org.droiders.githubwidget

import android.content.Context
import android.util.Log
import android.widget.RemoteViewsService.RemoteViewsFactory
import android.widget.RemoteViews

class GridRemoteViewsFactory(val context: Context, val contributions: List<DayContributions>) : RemoteViewsFactory {

    override fun getLoadingView(): RemoteViews? = RemoteViews(context.packageName, R.layout.item_contributions)

    override fun getViewAt(position: Int): RemoteViews {

        val rv = RemoteViews(context.packageName, R.layout.item_contributions)
        Log.d("GridRemoteViewsFactory", "getViewAt " + position)

        // 设置 第position位的“视图”的数据
        rv.setInt(R.id.view, "setBackgroundColor", contributions[position].color)

        // 设置 第position位的“视图”对应的响应事件
//        val fillInIntent = Intent()
//        fillInIntent.putExtra(GridWidgetProvider.COLLECTION_VIEW_EXTRA, position)
//        rv.setOnClickFillInIntent(R.id.itemLayout, fillInIntent)
        return rv
    }

    override fun getViewTypeCount() = 1

    override fun onCreate() {
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun onDataSetChanged() {
    }

    override fun hasStableIds() = true

    override fun getCount() = 26 * 7

    override fun onDestroy() {
    }

}
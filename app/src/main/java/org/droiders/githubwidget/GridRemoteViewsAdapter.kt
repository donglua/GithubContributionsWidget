package org.droiders.githubwidget

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.util.Log
import android.widget.RemoteViewsService.RemoteViewsFactory
import android.widget.RemoteViews
import android.widget.Toast
import org.droiders.githubwidget.data.Contributions
import org.droiders.githubwidget.data.DBHelper
import org.droiders.githubwidget.data.DBHelper.Companion.COLUMN_COLOR
import org.droiders.githubwidget.data.DBHelper.Companion.COLUMN_DATE
import org.droiders.githubwidget.data.DBHelper.Companion.TABLE_NAME

class GridRemoteViewsAdapter(val context: Context) : RemoteViewsFactory {

    val TAG = "GridRemoteViewsAdapter"
    var mCursor: Cursor? = null
    val uri: Uri

    init {
        uri = Uri.parse("content://${context.applicationInfo?.packageName}.provider/$TABLE_NAME")
    }

    override fun getLoadingView(): RemoteViews? = RemoteViews(context.packageName, R.layout.item_contributions)

    override fun getViewAt(position: Int): RemoteViews {

        val rv = RemoteViews(context.packageName, R.layout.item_contributions)
        Log.d("GridRemoteViewsAdapter", "getViewAt " + position)


        if (mCursor == null) populateCursor()

        mCursor?.run {
            if (moveToPosition(position)) {

                val color = getInt(getColumnIndex(COLUMN_COLOR))

                val date = getInt(getColumnIndex(COLUMN_DATE))
                Log.d(TAG, "date = $date")

                // 设置 第position位的“视图”的数据
                rv.setInt(R.id.view, "setBackgroundColor", color)

                // 设置 第position位的“视图”对应的响应事件
                //        val fillInIntent = Intent()
                //        fillInIntent.putExtra(GridWidgetProvider.COLLECTION_VIEW_EXTRA, position)
                //        rv.setOnClickFillInIntent(R.id.itemLayout, fillInIntent)
            }
        }

        return rv
    }

    override fun getViewTypeCount() = 1

    override fun onCreate() {
        mCursor = context.contentResolver?.query(uri, null, null, null, null)
        Log.d(TAG, "cursor.count = ${mCursor?.count}")

    }

    override fun getItemId(position: Int) = position.toLong()

    override fun onDataSetChanged() {

        mCursor?.close()

        populateCursor()
    }

    override fun hasStableIds() = true

    override fun getCount() = mCursor?.count ?: 0

    override fun onDestroy() {
        mCursor?.close()
    }

    fun populateCursor() {

        mCursor?.close()
        mCursor = null

        mCursor = context.contentResolver.query(
                uri,
                null,
                " 1=1 limit ${26 * 7} ",
                null,
                null)
    }
}
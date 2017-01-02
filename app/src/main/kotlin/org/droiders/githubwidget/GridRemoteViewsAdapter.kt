package org.droiders.githubwidget

import android.content.Context
import android.net.Uri
import android.widget.RemoteViews
import android.widget.RemoteViewsService.RemoteViewsFactory
import org.droiders.githubwidget.data.Contributions
import org.droiders.githubwidget.data.DBHelper.Companion.COLUMN_COLOR
import org.droiders.githubwidget.data.DBHelper.Companion.COLUMN_DATA_COUNT
import org.droiders.githubwidget.data.DBHelper.Companion.COLUMN_DATE
import org.droiders.githubwidget.data.DBHelper.Companion.TABLE_NAME
import java.util.*

class GridRemoteViewsAdapter(val context: Context) : RemoteViewsFactory {

    val TAG = "GridRemoteViewsAdapter"

    val uri: Uri
    val array = ArrayList<ArrayList<Contributions>>(7)

    init {
        uri = Uri.parse("content://${context.applicationInfo?.packageName}.provider/$TABLE_NAME")
    }

    override fun getLoadingView(): RemoteViews? = RemoteViews(context.packageName, R.layout.item_contributions)

    override fun getViewAt(position: Int): RemoteViews {

        val rv = RemoteViews(context.packageName, R.layout.item_contributions)

        if (array.isEmpty()) populateCursor()


        val row = position / 26
        val col = position % 26

        // Log.d("GridRemoteViewsAdapter", "getViewAt $position - $row, $col")

        if (col < array[row].size) {
            val contributions = array[row][col]

            rv.setInt(R.id.view, "setBackgroundColor", contributions.color)
        }

        return rv
    }

    override fun getViewTypeCount() = 1

    override fun onCreate() {
        populateCursor()
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun onDataSetChanged() {

        populateCursor()
    }

    override fun hasStableIds() = true

    override fun getCount() = 26 * 7

    override fun onDestroy() {
        array.clear()
    }

    fun populateCursor() {

        var total = 26 * 7
        val mCursor = context.contentResolver.query(
                uri,
                null,
                null,
                null,
                "$COLUMN_DATE DESC limit $total ")

        if (mCursor?.moveToFirst() as Boolean) {
            val date = mCursor?.getInt(mCursor.getColumnIndex(COLUMN_DATE))!!
            val year = date / 10000
            val month = date % 10000 / 100
            val day = date % 100
            val calendar = Calendar.getInstance()
            calendar.set(year, month - 1, day) // Month value is 0-based

            val week = calendar.get(Calendar.DAY_OF_WEEK)
            total -= (7 - week)

            if (mCursor.moveToPosition(total - 1)) {

                array.clear()

                (1..7).forEach {
                    array.add(ArrayList<Contributions>(26))
                }
                var currentWeek = 6

                do {
                    currentWeek %= 7

                    array[6 - currentWeek].add(Contributions(
                        "${mCursor?.getInt(mCursor.getColumnIndex(COLUMN_DATE))!!}",
                        mCursor?.getInt(mCursor.getColumnIndex(COLUMN_DATA_COUNT))!!,
                        mCursor?.getInt(mCursor.getColumnIndex(COLUMN_COLOR))!!
                    ))
                    currentWeek = currentWeek + 7 - 1

                } while (mCursor.moveToPrevious())
            }

            // array.forEach {
            //     it.forEach { print(" ${it.day} | ") }
            //     println()
            // }
        }

        mCursor.close()
    }
}
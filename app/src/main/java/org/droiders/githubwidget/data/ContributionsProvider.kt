package org.droiders.githubwidget.data

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CONFLICT_REPLACE
import android.net.Uri
import org.droiders.githubwidget.data.DBHelper.Companion.TABLE_NAME

/**
 * ContributionsProvider
 *
 * Created by donglua on 2016/12/28.
 */

class ContributionsProvider : ContentProvider() {

    var db: SQLiteDatabase? = null

    override fun onCreate(): Boolean {
        db = DBHelper(context).getDb()
        return true
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        return db?.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder)
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val row = db?.insertWithOnConflict(TABLE_NAME, null, values, CONFLICT_REPLACE)!!

        if (row > 0) context.contentResolver.notifyChange(uri, null)

        return uri
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val count = db?.delete(TABLE_NAME, selection, selectionArgs) ?:0

        if(count > 0) context.contentResolver.notifyChange(uri, null)

        return count
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        val count = db?.update(TABLE_NAME, values, selection, selectionArgs)!!

        if (count > 0) context.contentResolver.notifyChange(uri, null)

        return count
    }

}

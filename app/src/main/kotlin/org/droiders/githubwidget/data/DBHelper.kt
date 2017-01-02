package org.droiders.githubwidget.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "$TABLE_NAME.db", null, TABLE_VERSION) {

    companion object {
        const val TABLE_NAME = "Contributions"
        const val TABLE_VERSION = 1

        const val COLUMN_COLOR = "color"
        const val COLUMN_DATA_COUNT = "data_count"
        const val COLUMN_DATE = "date"
    }

    private var db: SQLiteDatabase? = null

    override fun onCreate(db: SQLiteDatabase) {
        val sql = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_DATE INTEGER PRIMARY KEY," +
                "$COLUMN_COLOR INTEGER," +
                "$COLUMN_DATA_COUNT INTEGER);"
        db.execSQL(sql)
    }

    fun getDb(): SQLiteDatabase? {
        if (null == db || db!!.isOpen.not())
            db = this.writableDatabase
        return db
    }

    @Synchronized override fun close() {
        db?.close()
        super.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // ignore
    }
}
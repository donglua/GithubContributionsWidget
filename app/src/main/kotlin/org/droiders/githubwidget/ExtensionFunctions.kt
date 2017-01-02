package org.droiders.githubwidget

import android.content.Context
import android.widget.Toast

/**
 * Created by donglua on 2016/12/28.
 */
fun Context.showToast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
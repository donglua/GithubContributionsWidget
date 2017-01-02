package org.droiders.githubwidget

import android.graphics.Color
import org.droiders.githubwidget.data.Contributions
import java.util.*
import java.util.regex.Pattern


/**
 * Created by donglua on 2016/12/24.
 */

object Converter {

    @JvmStatic fun svgToContributionsList(svg: String): List<Contributions> {
        val contributionsList = ArrayList<Contributions>(52 * 7)

        // "#eeeeee" data-count="0" data-date="2015-12-20"
        val matcher = Pattern.compile("\"(#[A-Za-z0-9]{6})\"" +
                " data-count=\"([\\d]+)\"" +
                " data-date=\"([\\d]{4}-[\\d]{2}-[\\d]{1,2})\"").matcher(svg)

        while (matcher.find()) {
            val color = Color.parseColor(matcher.group(1))
            val dataCount = Integer.parseInt(matcher.group(2))
            val day = matcher.group(3).replace("-", "")

            val contributions = Contributions(
                    day,
                    dataCount,
                    color)
            contributionsList.add(contributions)
        }

        return contributionsList
    }

}

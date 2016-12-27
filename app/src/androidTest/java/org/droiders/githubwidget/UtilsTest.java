package org.droiders.githubwidget;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


/**
 * Created by donglua on 2016/12/24.
 */
@RunWith(AndroidJUnit4.class)
public class UtilsTest {
    @Test
    public void convertSvgToColorArray() throws Exception {

        String svg = "<svg width=\"676\" height=\"104\" class=\"js-calendar-graph-svg\">\n" +
                "  <g transform=\"translate(16, 20)\">\n" +
                "      <g transform=\"translate(0, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"13\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"13\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"13\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"13\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"13\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"13\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2015-12-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"13\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-26\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(13, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"12\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"12\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"12\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"12\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-30\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"12\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2015-12-31\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"12\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"12\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-02\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(26, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"11\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"11\" y=\"12\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-01-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"11\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"11\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"11\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"11\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"11\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-09\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(39, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"10\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"10\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"10\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"10\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"10\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"10\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"10\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-16\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(52, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"9\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"9\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"9\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"9\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"9\" y=\"48\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-01-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"9\" y=\"60\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-01-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"9\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-23\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(65, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"8\" y=\"0\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-01-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"8\" y=\"12\" fill=\"#8cc665\" data-count=\"5\" data-date=\"2016-01-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"8\" y=\"24\" fill=\"#44a340\" data-count=\"7\" data-date=\"2016-01-26\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"8\" y=\"36\" fill=\"#1e6823\" data-count=\"21\" data-date=\"2016-01-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"8\" y=\"48\" fill=\"#8cc665\" data-count=\"4\" data-date=\"2016-01-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"8\" y=\"60\" fill=\"#8cc665\" data-count=\"4\" data-date=\"2016-01-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"8\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-30\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(78, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"7\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-01-31\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"7\" y=\"12\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-02-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"7\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-02\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"7\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"7\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"7\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-02-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"7\" y=\"72\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-02-06\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(91, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"6\" y=\"0\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-02-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"6\" y=\"12\" fill=\"#8cc665\" data-count=\"5\" data-date=\"2016-02-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"6\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-09\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"6\" y=\"36\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-02-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"6\" y=\"48\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-02-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"6\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"6\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-13\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(104, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"5\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"5\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"5\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-16\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"5\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"5\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"5\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"5\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-20\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(117, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"4\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"4\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"4\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"4\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"4\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"4\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-26\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"4\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-27\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(130, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"3\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"3\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-02-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"3\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"3\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-02\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"3\" y=\"48\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-03-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"3\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"3\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-05\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(143, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"2\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"2\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"2\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"2\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-09\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"2\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"2\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"2\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-12\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(156, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"1\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"1\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"1\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"1\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-16\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"1\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"1\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"1\" y=\"72\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-03-19\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(169, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"0\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"0\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"0\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"0\" y=\"36\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-03-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"0\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"0\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-03-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"0\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-26\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(182, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-1\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-1\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-1\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-1\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-03-30\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-1\" y=\"48\" fill=\"#44a340\" data-count=\"7\" data-date=\"2016-03-31\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-1\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-1\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-02\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(195, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-2\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-2\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-2\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-2\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-2\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-2\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-2\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-09\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(208, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-3\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-3\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-3\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-3\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-3\" y=\"48\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-04-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-3\" y=\"60\" fill=\"#44a340\" data-count=\"7\" data-date=\"2016-04-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-3\" y=\"72\" fill=\"#8cc665\" data-count=\"4\" data-date=\"2016-04-16\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(221, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-4\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-4\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-4\" y=\"24\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-04-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-4\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-4\" y=\"48\" fill=\"#44a340\" data-count=\"7\" data-date=\"2016-04-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-4\" y=\"60\" fill=\"#1e6823\" data-count=\"21\" data-date=\"2016-04-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-4\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-04-23\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(234, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-5\" y=\"0\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-04-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-5\" y=\"12\" fill=\"#8cc665\" data-count=\"5\" data-date=\"2016-04-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-5\" y=\"24\" fill=\"#44a340\" data-count=\"7\" data-date=\"2016-04-26\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-5\" y=\"36\" fill=\"#1e6823\" data-count=\"14\" data-date=\"2016-04-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-5\" y=\"48\" fill=\"#8cc665\" data-count=\"5\" data-date=\"2016-04-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-5\" y=\"60\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-04-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-5\" y=\"72\" fill=\"#1e6823\" data-count=\"14\" data-date=\"2016-04-30\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(247, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-6\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-6\" y=\"12\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-05-02\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-6\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-6\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-6\" y=\"48\" fill=\"#44a340\" data-count=\"9\" data-date=\"2016-05-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-6\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-6\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-07\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(260, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-7\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-7\" y=\"12\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-05-09\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-7\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-7\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-7\" y=\"48\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-05-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-7\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-7\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-14\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(273, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-8\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-8\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-16\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-8\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-8\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-8\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-8\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-05-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-8\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-21\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(286, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-9\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-9\" y=\"12\" fill=\"#8cc665\" data-count=\"5\" data-date=\"2016-05-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-9\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-9\" y=\"36\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-05-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-9\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-26\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-9\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-9\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-28\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(299, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-10\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-10\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-30\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-10\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-05-31\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-10\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-10\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-02\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-10\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-10\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-04\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(312, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-11\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-11\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-11\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-11\" y=\"36\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-06-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-11\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-09\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-11\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-11\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-11\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(325, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-12\" y=\"0\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-06-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-12\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-12\" y=\"24\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-06-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-12\" y=\"36\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-06-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-12\" y=\"48\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-06-16\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-12\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-06-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-12\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-18\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(338, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-13\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-13\" y=\"12\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-06-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-13\" y=\"24\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-06-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-13\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-13\" y=\"48\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-06-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-13\" y=\"60\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-06-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-13\" y=\"72\" fill=\"#44a340\" data-count=\"7\" data-date=\"2016-06-25\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(351, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-14\" y=\"0\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-06-26\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-14\" y=\"12\" fill=\"#44a340\" data-count=\"9\" data-date=\"2016-06-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-14\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-14\" y=\"36\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-06-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-14\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-06-30\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-14\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-14\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-02\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(364, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-15\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-15\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-15\" y=\"24\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-07-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-15\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-15\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-15\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-15\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-09\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(377, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-16\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-16\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-16\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-16\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-16\" y=\"48\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-07-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-16\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-07-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-16\" y=\"72\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-07-16\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(390, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-17\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-17\" y=\"12\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-07-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-17\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-17\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-17\" y=\"48\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-07-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-17\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-17\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-23\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(403, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-18\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-18\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-18\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-26\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-18\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-18\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-18\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-07-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-18\" y=\"72\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-07-30\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(416, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-19\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-07-31\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-19\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-19\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-02\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-19\" y=\"36\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-08-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-19\" y=\"48\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-08-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-19\" y=\"60\" fill=\"#8cc665\" data-count=\"4\" data-date=\"2016-08-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-19\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-06\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(429, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-20\" y=\"0\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-08-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-20\" y=\"12\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-08-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-20\" y=\"24\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-08-09\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-20\" y=\"36\" fill=\"#44a340\" data-count=\"7\" data-date=\"2016-08-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-20\" y=\"48\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-08-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-20\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-08-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-20\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-13\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(442, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-21\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-21\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-21\" y=\"24\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-08-16\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-21\" y=\"36\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-08-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-21\" y=\"48\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-08-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-21\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-08-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-21\" y=\"72\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-08-20\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(455, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-22\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-22\" y=\"12\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-08-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-22\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-22\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-22\" y=\"48\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-08-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-22\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-26\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-22\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-27\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(468, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-23\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-23\" y=\"12\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-08-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-23\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-30\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-23\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-08-31\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-23\" y=\"48\" fill=\"#8cc665\" data-count=\"5\" data-date=\"2016-09-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-23\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-02\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-23\" y=\"72\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-09-03\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(481, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-24\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-24\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-24\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-24\" y=\"36\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-09-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-24\" y=\"48\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-09-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-24\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-09-09\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-24\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-10\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(494, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-25\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-25\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-25\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-25\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-25\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-25\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-16\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-25\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-17\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(507, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-26\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-26\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-26\" y=\"24\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-09-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-26\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-26\" y=\"48\" fill=\"#1e6823\" data-count=\"11\" data-date=\"2016-09-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-26\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-26\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-24\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(520, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-27\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-27\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-26\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-27\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-27\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-27\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-27\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-09-30\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-27\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-01\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(533, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-28\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-02\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-28\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-28\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-28\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-28\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-28\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-28\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-08\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(546, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-29\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-09\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-29\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-29\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-29\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-29\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-29\" y=\"60\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-10-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-29\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-15\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(559, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-30\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-16\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-30\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-30\" y=\"24\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-10-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-30\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-30\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-30\" y=\"60\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-10-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-30\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-22\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(572, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-31\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-31\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-31\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-31\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-26\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-31\" y=\"48\" fill=\"#8cc665\" data-count=\"5\" data-date=\"2016-10-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-31\" y=\"60\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-10-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-31\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-29\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(585, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-32\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-10-30\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-32\" y=\"12\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-10-31\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-32\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-32\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-02\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-32\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-03\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-32\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-32\" y=\"72\" fill=\"#8cc665\" data-count=\"4\" data-date=\"2016-11-05\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(598, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-33\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-33\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-33\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-33\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-09\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-33\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-10\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-33\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-33\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-12\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(611, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-34\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-34\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-34\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-34\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-16\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-34\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-17\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-34\" y=\"60\" fill=\"#44a340\" data-count=\"8\" data-date=\"2016-11-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-34\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-19\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(624, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-35\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-35\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-35\" y=\"24\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-11-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-35\" y=\"36\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-11-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-35\" y=\"48\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-11-24\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-35\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-25\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-35\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-26\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(637, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-36\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-27\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-36\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-28\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-36\" y=\"24\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-29\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-36\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-11-30\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-36\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-01\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-36\" y=\"60\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-12-02\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-36\" y=\"72\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-12-03\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(650, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-37\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-04\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-37\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-05\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-37\" y=\"24\" fill=\"#8cc665\" data-count=\"4\" data-date=\"2016-12-06\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-37\" y=\"36\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-12-07\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-37\" y=\"48\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-08\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-37\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-09\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-37\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-10\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(663, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-38\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-11\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-38\" y=\"12\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-12-12\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-38\" y=\"24\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-12-13\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-38\" y=\"36\" fill=\"#d6e685\" data-count=\"2\" data-date=\"2016-12-14\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-38\" y=\"48\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-12-15\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-38\" y=\"60\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-16\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-38\" y=\"72\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-17\"/>\n" +
                "      </g>\n" +
                "      <g transform=\"translate(676, 0)\">\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-39\" y=\"0\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-18\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-39\" y=\"12\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-19\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-39\" y=\"24\" fill=\"#d6e685\" data-count=\"1\" data-date=\"2016-12-20\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-39\" y=\"36\" fill=\"#eeeeee\" data-count=\"0\" data-date=\"2016-12-21\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-39\" y=\"48\" fill=\"#1e6823\" data-count=\"35\" data-date=\"2016-12-22\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-39\" y=\"60\" fill=\"#1e6823\" data-count=\"13\" data-date=\"2016-12-23\"/>\n" +
                "          <rect class=\"day\" width=\"10\" height=\"10\" x=\"-39\" y=\"72\" fill=\"#d6e685\" data-count=\"3\" data-date=\"2016-12-24\"/>\n" +
                "      </g>\n" +
                "      <text x=\"37\" y=\"-10\" class=\"month\">Jan</text>\n" +
                "      <text x=\"97\" y=\"-10\" class=\"month\">Feb</text>\n" +
                "      <text x=\"145\" y=\"-10\" class=\"month\">Mar</text>\n" +
                "      <text x=\"193\" y=\"-10\" class=\"month\">Apr</text>\n" +
                "      <text x=\"241\" y=\"-10\" class=\"month\">May</text>\n" +
                "      <text x=\"301\" y=\"-10\" class=\"month\">Jun</text>\n" +
                "      <text x=\"349\" y=\"-10\" class=\"month\">Jul</text>\n" +
                "      <text x=\"409\" y=\"-10\" class=\"month\">Aug</text>\n" +
                "      <text x=\"457\" y=\"-10\" class=\"month\">Sep</text>\n" +
                "      <text x=\"505\" y=\"-10\" class=\"month\">Oct</text>\n" +
                "      <text x=\"565\" y=\"-10\" class=\"month\">Nov</text>\n" +
                "      <text x=\"613\" y=\"-10\" class=\"month\">Dec</text>\n" +
                "    <text text-anchor=\"start\" class=\"wday\" dx=\"-14\" dy=\"8\" style=\"display: none;\">Sun</text>\n" +
                "    <text text-anchor=\"start\" class=\"wday\" dx=\"-14\" dy=\"20\">Mon</text>\n" +
                "    <text text-anchor=\"start\" class=\"wday\" dx=\"-14\" dy=\"32\" style=\"display: none;\">Tue</text>\n" +
                "    <text text-anchor=\"start\" class=\"wday\" dx=\"-14\" dy=\"44\">Wed</text>\n" +
                "    <text text-anchor=\"start\" class=\"wday\" dx=\"-14\" dy=\"57\" style=\"display: none;\">Thu</text>\n" +
                "    <text text-anchor=\"start\" class=\"wday\" dx=\"-14\" dy=\"69\">Fri</text>\n" +
                "    <text text-anchor=\"start\" class=\"wday\" dx=\"-14\" dy=\"81\" style=\"display: none;\">Sat</text>\n" +
                "  </g>\n" +
                "</svg>\n";

        List<DayContributions> array = Utils.svgToContributionsList(svg);

        Assert.assertEquals(array.get(0).getDay(), "2015-12-20");
    }

}
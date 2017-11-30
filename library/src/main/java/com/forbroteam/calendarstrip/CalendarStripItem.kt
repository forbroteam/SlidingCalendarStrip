package com.forbroteam.calendarstrip

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by bogatenkov on 10/11/17.
 */

data class CalendarStripItem(private val displayMode: SwipeableCalendarStrip.DisplayMode,
                             private val calendar: Calendar) {

    fun getName(): String {
        return when (displayMode) {
            SwipeableCalendarStrip.DisplayMode.DAYS -> SimpleDateFormat("EEE").format(calendar.time)
            SwipeableCalendarStrip.DisplayMode.MONTHS -> {
                if (calendar.get(Calendar.MONTH) == 0) {
                    SimpleDateFormat("MMM yyyy").format(calendar.time)
                } else {
                    SimpleDateFormat("MMM").format(calendar.time)
                }
            }
            SwipeableCalendarStrip.DisplayMode.DAYS_MONTHS -> SimpleDateFormat("dd MMM")
                    .format(calendar.time)
            SwipeableCalendarStrip.DisplayMode.MONTHS_YEARS -> SimpleDateFormat("MMM yy")
                    .format(calendar.time)
        }
    }

    fun getValue(): String {
        calendar?.let {
            return SimpleDateFormat("dd/MM/yyyy").format(it.time)
        }
    }

    fun getType() = displayMode.toString()

    fun getDate() = calendar.time
}
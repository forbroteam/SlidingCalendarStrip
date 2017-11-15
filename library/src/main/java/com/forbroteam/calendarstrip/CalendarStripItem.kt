package com.forbroteam.calendarstrip

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by bogatenkov on 10/11/17.
 */

data class CalendarStripItem(private val displayMode: SwipeableCalendarStrip.DisplayMode,
                               private val date: Date) {

    fun getName(): String {
        return when (displayMode) {
            SwipeableCalendarStrip.DisplayMode.DAYS -> SimpleDateFormat("EEE").format(date)
            SwipeableCalendarStrip.DisplayMode.MONTHS -> SimpleDateFormat("MMM").format(date)
            SwipeableCalendarStrip.DisplayMode.DAYS_MONTHS -> SimpleDateFormat("dd MMM").format(date)
            SwipeableCalendarStrip.DisplayMode.MONTHS_YEARS -> SimpleDateFormat("MMM yy").format(date)
        }
    }

    fun getValue(): String {
        date?.let {
            return SimpleDateFormat("dd/MM/yyyy").format(it)
        }
    }

    fun getType() = displayMode.toString()
}
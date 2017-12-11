package com.forbroteam.calendarstrip

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by bogatenkov on 10/11/17.
 */

data class CalendarStripItem(private val displayMode: SwipeableCalendarStrip.DisplayMode,
                             private val calendar: Calendar) {

    fun getName(): String {
        when (displayMode) {
            SwipeableCalendarStrip.DisplayMode.DAYS ->
                return SimpleDateFormat("EEE").format(calendar.time)
            SwipeableCalendarStrip.DisplayMode.MONTHS -> {
                var monthName = SimpleDateFormat("MMM").format(calendar.time)
                if (monthName.length > 5) {
                    monthName = monthName.substring(0, 5)
                }
                if (calendar.get(Calendar.MONTH) == 0) {
                    monthName = monthName.plus(" ${SimpleDateFormat("yyyy")
                            .format(calendar.time)}")
                }

                return monthName
            }
            SwipeableCalendarStrip.DisplayMode.DAYS_MONTHS -> return SimpleDateFormat("dd MMM")
                    .format(calendar.time)
            SwipeableCalendarStrip.DisplayMode.MONTHS_YEARS -> return SimpleDateFormat("MMM yy")
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
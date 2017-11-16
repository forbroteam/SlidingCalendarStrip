package com.forbroteam.calendarstrip.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.forbroteam.calendarstrip.SwipeableCalendarStrip
import com.forbroteam.calendarstrip.SwipeableCalendarStripListener

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sample)
        val calendarStrip = SwipeableCalendarStrip.Builder(this,
                R.id.cv_calendar_strip).build()
        calendarStrip.itemSelectionListener = object : SwipeableCalendarStripListener {
            override fun onCalendarStripItemSelected(value: String, type: String) {
                Toast.makeText(baseContext,
                        "Type: $type; Value: $value", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

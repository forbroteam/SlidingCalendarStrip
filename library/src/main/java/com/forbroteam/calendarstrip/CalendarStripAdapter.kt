package com.forbroteam.calendarstrip

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*


/**
 * Created by bogatenkov on 06/11/17.
 */

class CalendarStripAdapter(private val context: Context, val items: LinkedList<CalendarStripItem>,
                             private val typeface: Typeface?, private val itemTextColor: Int,
                             private val itemTextSize: Int) : PagerAdapter() {

    lateinit var clickListener: SwipeableCalendarStrip.ItemClickListener

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        var view = LayoutInflater.from(context).inflate(R.layout.pager_item, null)
        val tv = view.findViewById<TextView>(R.id.tv)

        typeface?.let {
            tv.typeface = it
        }
        if (itemTextColor > 0) {
            tv.setTextColor(ContextCompat.getColor(context, itemTextColor))
        }
        if (itemTextSize > 0) {
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, itemTextSize.toFloat())
        }
        val textItem = items[position]
        tv.text = textItem.getName()
        tv.tag = position
        tv.setOnClickListener { v ->
            clickListener?.onItemClicked(v.tag as Int)
        }

        container?.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun setPrimaryItem(container: ViewGroup?, position: Int, `object`: Any?) {
        super.setPrimaryItem(container, position, `object`)
    }
}
package com.forbroteam.calendarstrip

import android.content.Context
import android.content.res.TypedArray
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import java.util.*

/**
 * Created by bogatenkov on 06/11/17.
 */

class SwipeableCalendarStripView : LinearLayout, ViewPager.OnPageChangeListener,
        SwipeableCalendarStrip.ItemClickListener {

    lateinit var calendarStrip: SwipeableCalendarStrip
    private lateinit var viewPager: ViewPager
    private lateinit var calendarStripAdapter: CalendarStripAdapter

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttributes(context, attrs)
        init()
        initViewPager()
    }

    private fun initAttributes(context: Context, attrs: AttributeSet?) {
        attrs?.let {
            var array: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.SwipeableCalendarStrip)
            array.recycle()
        }
    }

    private fun init() {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.swipeable_calendar_strip, this, true)
    }

    private fun initViewPager() {
        viewPager = findViewById(R.id.vp)
        viewPager.setPageTransformer(false, CalendarStripPageTransformer())
        viewPager.clipChildren = false
        viewPager.clipToPadding = false
        viewPager.setFadingEdgeLength(0)
        viewPager.overScrollMode = View.OVER_SCROLL_NEVER
        viewPager.offscreenPageLimit = 7
        viewPager.addOnPageChangeListener(this)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var height = 0
        var offsetCoef = when (calendarStrip.itemTextSize) {
            in 18..24 -> 1.25
            in 25..29 -> 1.3
            in 30..35 -> 1.4
            in 36..40 -> 1.5
            in 41..100 -> 1.6
            else -> 1.2
        }
        for (i in 0 until viewPager.childCount) {
            val child = viewPager.getChildAt(i)
            child.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
            val h = child.measuredHeight
            if (h > height) height = h
        }

        val heightMeasureSpecNew = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)

        super.onMeasure(widthMeasureSpec, heightMeasureSpecNew)
        val w = measuredWidth

        viewPager.pageMargin = ((-w / offsetCoef).toInt())
    }

    fun prepareCalendarStrip(items: LinkedList<CalendarStripItem>) {
        initAdapter(items)
    }

    private fun initAdapter(items: LinkedList<CalendarStripItem>) {
        calendarStripAdapter = CalendarStripAdapter(context, items,
                calendarStrip.typeface, calendarStrip.itemTextColor,
                calendarStrip.itemTextSize)
        calendarStripAdapter.clickListener = this
        viewPager.adapter = calendarStripAdapter
        viewPager.setCurrentItem(calendarStripAdapter.count, false)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        calendarStrip.itemSelectionListener?.let {
            it.onCalendarStripItemSelected(calendarStripAdapter.items[position].getValue(),
                    calendarStripAdapter.items[position].getType())
        }
    }

    override fun onItemClicked(position: Int) {
        viewPager?.setCurrentItem(position, false)
    }
}
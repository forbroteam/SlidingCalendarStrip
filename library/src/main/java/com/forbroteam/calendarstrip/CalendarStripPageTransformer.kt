package com.forbroteam.calendarstrip

import android.support.v4.view.ViewPager
import android.view.View


/**
 * Created by bogatenkov on 07/11/17.
 */

class CalendarStripPageTransformer : ViewPager.PageTransformer {

    private val MIN_ALPHA = 0.3
    private val MAX_ALPHA = 0.07
    private val ALPHA_COEFFICIENT = 0.75f

    override fun transformPage(view: View, position: Float) {
        view.setLayerType(View.LAYER_TYPE_NONE, null)
        when {
            (position in -MAX_ALPHA..MAX_ALPHA) -> view.alpha = 1f
            (position in -MIN_ALPHA..-MAX_ALPHA) -> view.alpha = ALPHA_COEFFICIENT + position
            (position in MAX_ALPHA..MIN_ALPHA) -> view.alpha = ALPHA_COEFFICIENT - position
            else -> view.alpha = MIN_ALPHA.toFloat()
        }
    }
}
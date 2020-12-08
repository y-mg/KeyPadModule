package com.ymg.keypadmodule.pin.indicator

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import com.ymg.keypadmodule.R



/**
 * @author y-mg
 *
 * 이것은 PinKeyPad 와 함께 사용되는 indicator 입니다.
 * This is the indicator used with PinKeyPad.
 */
class PinIndicatorView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var dotLength: Int = 0
    private var fillDot: Int = 0
    private var emptyDot: Int = 0

    private var previousKeyPadValueLength: Int = 0



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.PinIndicatorStyle, defStyleAttr, defStyleAttr)

        // 점의 자릿수를 설정한다.
        // Sets the number of digits of a dot.
        val dotLength =
            typedArray.getInt(R.styleable.PinIndicatorStyle_piDotLength, 6)

        // 점의 지름을 설정한다.
        // Sets the diameter of a dot.
        val dotDiameter =
            typedArray.getDimension(
                R.styleable.PinIndicatorStyle_piDotDiameter,
                context.resources.getDimension(R.dimen.pin_indicator_default_dot_diameter)
            ).toInt()

        // 점과 점 사이의 공간을 설정한다.
        // Sets the space between the dot and the dot.
        val dotSpace =
            typedArray.getDimension(
                R.styleable.PinIndicatorStyle_piDotSpace,
                context.resources.getDimension(R.dimen.pin_indicator_default_dot_space)
            ).toInt()

        // 채워진 점의 아이콘을 설정한다.
        // Sets the icon for the filled dot.
        val fillDot =
            typedArray.getResourceId(
                R.styleable.PinIndicatorStyle_piFillDot,
                R.drawable.dot_pin_on
            )

        // 비워진 점의 아이콘을 설정한다.
        // Sets the icon of an empty dot.
        val emptyDot =
            typedArray.getResourceId(
                R.styleable.PinIndicatorStyle_piEmptyDot,
                R.drawable.dot_pin_off
            )

        typedArray.recycle()


        setInit(
            dotLength,
            dotDiameter,
            dotSpace,
            fillDot,
            emptyDot
        )
    }



    /**
     * Setting Init
     */
    private fun setInit(
        dotLength: Int,
        dotDiameter: Int,
        dotSpace: Int,
        fillDot: Int,
        emptyDot: Int
    ) {
        // Setting Dot Length
        setDotLength(dotLength)

        // Setting Fill Dot
        setFillDot(fillDot)

        // Setting Empty Dot
        setEmptyDot(emptyDot)

        // Setting Dot
        setDot(
            dotLength,
            dotDiameter,
            dotSpace,
            emptyDot
        )
    }



    /**
     * Setting Dot Length
     */
    private fun setDotLength(dotLength: Int) {
        this.dotLength = dotLength
    }



    /**
     * Setting Fill Dot
     */
    private fun setFillDot(fillDot: Int) {
        this.fillDot = fillDot
    }



    /**
     * Setting Empty Dot
     */
    private fun setEmptyDot(emptyDot: Int) {
        this.emptyDot = emptyDot
    }



    /**
     * Setting Dot
     */
    private fun setDot(
        dotLength: Int,
        dotDiameter: Int,
        dotSpace: Int,
        emptyDotDrawable: Int
    ) {
        ViewCompat.setLayoutDirection(this, ViewCompat.LAYOUT_DIRECTION_LTR)

        for (i in 0 until dotLength) {
            val dot = View(context)
            dot.setBackgroundResource(emptyDotDrawable)

            val layoutParams = LayoutParams(dotDiameter, dotDiameter)
            layoutParams.setMargins(dotSpace, 0, dotSpace, 0)
            dot.layoutParams = layoutParams

            addView(dot)
        }
    }



    /**
     * Setting Update Dot
     */
    internal fun setUpdateDot(keyPadValueLength: Int) {
        when {
            keyPadValueLength > 0 -> {
                when {
                    keyPadValueLength > previousKeyPadValueLength -> {
                        val dot = getChildAt(keyPadValueLength - 1)
                        dot.setBackgroundResource(fillDot)
                    }

                    else -> {
                        val dot = getChildAt(keyPadValueLength)
                        dot.setBackgroundResource(emptyDot)
                    }
                }

                previousKeyPadValueLength = keyPadValueLength
            }

            else -> {
                for (i in 0 until childCount) {
                    val dot = getChildAt(i)
                    dot.setBackgroundResource(emptyDot)
                }

                previousKeyPadValueLength = 0
            }
        }
    }



    /**
     * Return Dot Length
     */
    internal fun getDotLength(): Int {
        return dotLength
    }
}
package com.ymg.keypadmodule.pin.indicator

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import com.ymg.keypadmodule.R

class PinIndicatorView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    // Dot 길이, Fill Dot 아이콘, Empty Dot 아이콘
    private var indicatorDotLength: Int = 0
    private var indicatorFillDotDrawable: Int = 0
    private var indicatorEmptyDotDrawable: Int = 0

    // 이전에 입력된 키 패드 입력값 길이
    private var previousKeyPadTextLength: Int = 0



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.PinIndicatorStyle, defStyleAttr, defStyleAttr)

        // Dot 길이
        val dotLength =
            typedArray.getInt(R.styleable.PinIndicatorStyle_piDotLength, 6)



        // Dot 지름
        val dotDiameter =
            typedArray.getDimension(
                R.styleable.PinIndicatorStyle_piDotDiameter,
                context.resources.getDimension(R.dimen.pin_indicator_default_dot_diameter)
            ).toInt()

        // Dot 사이 공간
        val dotSpace =
            typedArray.getDimension(
                R.styleable.PinIndicatorStyle_piDotSpace,
                context.resources.getDimension(R.dimen.pin_indicator_default_dot_space)
            ).toInt()



        // Dot Fill 아이콘
        val fillDotDrawable =
            typedArray.getResourceId(
                R.styleable.PinIndicatorStyle_piFillDotDrawable,
                R.drawable.dot_pin_on
            )

        // Dot Empty 아이콘
        val emptyDotDrawable =
            typedArray.getResourceId(
                R.styleable.PinIndicatorStyle_piEmptyDotDrawable,
                R.drawable.dot_pin_off
            )



        typedArray.recycle()

        // 설정
        setInit(
            dotLength,
            dotDiameter,
            dotSpace,
            fillDotDrawable,
            emptyDotDrawable
        )
    }



    /**
     * 설정
     */
    private fun setInit(
        dotLength: Int,
        dotDiameter: Int,
        dotSpace: Int,
        fillDotDrawable: Int,
        emptyDotDrawable: Int
    ) {
        // Dot 길이 설정
        setDotLength(dotLength)

        // Dot Fill 설정
        setFillDotDrawable(fillDotDrawable)

        // Dot Empty 설정
        setEmptyDotDrawable(emptyDotDrawable)

        // Dot 설정
        setDot(
            dotLength,
            dotDiameter,
            dotSpace,
            emptyDotDrawable
        )
    }



    /**
     * Dot 길이 설정
     */
    private fun setDotLength(dotLength: Int) {
        indicatorDotLength = dotLength
    }



    /**
     * Dot Fill 설정
     */
    private fun setFillDotDrawable(fillDotDrawable: Int) {
        indicatorFillDotDrawable = fillDotDrawable
    }



    /**
     * Dot Empty 설정
     */
    private fun setEmptyDotDrawable(emptyDotDrawable: Int) {
        indicatorEmptyDotDrawable = emptyDotDrawable
    }



    /**
     * Dot 설정
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
     * Dot 업데이트
     */
    fun setUpdateDot(keyPadTextLength: Int) {
        when {
            // 키 패드 입력값이 있을 경우
            keyPadTextLength > 0 -> {
                when {
                    keyPadTextLength > previousKeyPadTextLength -> {
                        val dot = getChildAt(keyPadTextLength - 1)
                        dot.setBackgroundResource(indicatorFillDotDrawable)
                    }

                    else -> {
                        val dot = getChildAt(keyPadTextLength)
                        dot.setBackgroundResource(indicatorEmptyDotDrawable)
                    }
                }

                previousKeyPadTextLength = keyPadTextLength
            }

            // 키 패드 입력값이 없을 경우
            else -> {
                for (i in 0 until childCount) {
                    val dot = getChildAt(i)
                    dot.setBackgroundResource(indicatorEmptyDotDrawable)
                }

                previousKeyPadTextLength = 0
            }
        }
    }



    /**
     * Dot 길이 가져오기
     */
    fun getIndicatorDotLength(): Int {
        return indicatorDotLength
    }
}
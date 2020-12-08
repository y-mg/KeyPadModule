package com.ymg.keypadmodule.pin.vertical

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.ymg.keypadmodule.R
import com.ymg.keypadmodule.databinding.ViewPinKeyPadVerticalBinding
import com.ymg.keypadmodule.pin.indicator.PinIndicatorView
import java.util.*
import kotlin.collections.ArrayList



/**
 * @author y-mg
 *
 * 이것은 PinIndicator 와 함께 사용되는 PinKeyPad(Vertical) 입니다.
 * This is the PinKeyPad(Vertical) used with PinIndicator.
 */
class PinKeyPadVerticalView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    companion object {
        const val TOTAL_DEFAULT_BUTTON_COUNT = 10
        const val TOTAL_DIVIDER_COUNT = 11
    }

    private lateinit var viewBinding: ViewPinKeyPadVerticalBinding

    private val defaultButtonList: MutableList<MaterialButton> = ArrayList(TOTAL_DEFAULT_BUTTON_COUNT)
    private val dividerList: MutableList<View> = ArrayList(TOTAL_DIVIDER_COUNT)

    private val defaultButtonValueArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    private var value = ""
    private var maxLength: Int = 0

    private var pinKeyPadVerticalListener: PinKeyPadVerticalListener? = null

    private var pinIndicatorView: PinIndicatorView? = null



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.PinKeyPadVerticalStyle, defStyleAttr, defStyleAttr)

        // 기본 버튼의 글자 크기를 설정한다.
        // Sets the letter size of the default button.
        val defaultButtonTextSize =
            typedArray.getInt(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonTextSize,
                24
            )

        // 기본 버튼의 글자 색상을 설정한다.
        // Sets the text color of the default button.
        val defaultButtonTextColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonTextColor,
                R.color.black_000000
            )

        // 기본 버튼의 배경색을 설정한다.
        // Sets the background color of the default button.
        val defaultButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 기본 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the default button.
        val defaultButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonRippleColor,
                R.color.transparent_00000000
            )

        // 기본 버튼의 코너를 설정한다.
        // Set the corner of the default button.
        val defaultButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_corner_radius)
            ).toInt()

        // 기본 버튼의 테두리 두께를 설정한다.
        // Set the border thickness of the default button.
        val defaultButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_stroke_width)
            ).toInt()

        // 기본 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the default button.
        val defaultButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 아이콘을 설정한다.
        // Set the icon for the delete button.
        val deleteButtonIcon =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonIcon,
                R.drawable.btn_keyboard_del_black
            )

        // 삭제 버튼의 아이콘 크기를 설정한다.
        // Sets the size of the icon for the delete button.
        val deleteButtonIconSize =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonIconSize,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_icon_size)
            ).toInt()

        // 삭제 버튼의 배경색을 설정한다.
        // Sets the background color of the delete button.
        val deleteButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the delete button.
        val deleteButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonRippleColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 코너를 설정한다.
        // Set the corner of the delete button.
        val deleteButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_corner_radius)
            ).toInt()

        // 삭제 버튼의 테두리 두께를 설정한다.
        // Sets the border thickness of the delete button.
        val deleteButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_stroke_width)
            ).toInt()

        // 삭제 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the delete button.
        val deleteButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 클리어 버튼 사용 여부를 설정한다.
        // Set whether or not to use the clear button.
        val clearButtonEnabled =
            typedArray.getBoolean(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonEnabled,
                false
            )

        // 클리어 버튼의 텍스트를 설정한다.
        // Sets the text of the clear button.
        val clearButtonText =
            typedArray.getString(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonText
            )

        // 클리어 버튼의 글자 크기를 설정한다.
        // Sets the letter size of the clear button.
        val clearButtonTextSize =
            typedArray.getInt(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonTextSize,
                24
            )

        // 클리어 버튼의 글자 색상을 설정한다.
        // the character color of the clear button.
        val clearButtonTextColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonTextColor,
                R.color.black_000000
            )

        // 클리어 버튼의 배경색을 설정한다.
        // Set the background color of the clear button.
        val clearButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 클리어 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the clear button.
        val clearButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonRippleColor,
                R.color.transparent_00000000
            )

        // 클리어 버튼의 테두리를 설정한다.
        // Set the border of the clear button.
        val clearButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_corner_radius)
            ).toInt()

        // 버튼의 테두리 두께를 설정한다.
        // Set the border thickness of the clear button.
        val clearButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_stroke_width)
            ).toInt()

        // 클리어 버튼의 테두리 색상을 설정한다.
        // the border color of the clear button.
        val clearButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 구분선의 색상을 설정한다.
        // Sets the color of the dividing line.
        val dividerColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDividerColor,
                R.color.transparent_00000000
            )

        // 세로 구분선의 폭을 설정한다.
        // the width of the vertical divider.
        val dividerWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDividerWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_divider_width)
            ).toInt()

        // 가로 구분선의 높이를 설정한다.
        // Sets the height of the horizontal divider
        val dividerHeight =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDividerHeight,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_divider_height)
            ).toInt()

        // 배경색을 설정한다.
        // Set background color.
        val rootBackgroundDrawable =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvRootBackgroundDrawable,
                R.color.white_ffffff
            )

        typedArray.recycle()


        setInit(
            defaultButtonTextSize,
            defaultButtonTextColor,
            defaultButtonBackgroundColor,
            defaultButtonRippleColor,
            defaultButtonCornerRadius,
            defaultButtonStrokeWidth,
            defaultButtonStrokeColor,
            deleteButtonIcon,
            deleteButtonIconSize,
            deleteButtonBackgroundColor,
            deleteButtonRippleColor,
            deleteButtonCornerRadius,
            deleteButtonStrokeWidth,
            deleteButtonStrokeColor,
            clearButtonEnabled,
            clearButtonText,
            clearButtonTextSize,
            clearButtonTextColor,
            clearButtonBackgroundColor,
            clearButtonRippleColor,
            clearButtonCornerRadius,
            clearButtonStrokeWidth,
            clearButtonStrokeColor,
            dividerColor,
            dividerWidth,
            dividerHeight,
            rootBackgroundDrawable
        )
    }



    /**
     * Setting Init
     */
    private fun setInit(
        defaultButtonTextSize: Int,
        defaultButtonTextColor: Int,
        defaultButtonBackgroundColor: Int,
        defaultButtonRippleColor: Int,
        defaultButtonCornerRadius: Int,
        defaultButtonStrokeWidth: Int,
        defaultButtonStrokeColor: Int,
        deleteButtonIcon: Int,
        deleteButtonIconSize: Int,
        deleteButtonBackgroundColor: Int,
        deleteButtonRippleColor: Int,
        deleteButtonCornerRadius: Int,
        deleteButtonStrokeWidth: Int,
        deleteButtonStrokeColor: Int,
        clearButtonEnabled: Boolean,
        clearButtonText: String?,
        clearButtonTextSize: Int,
        clearButtonTextColor: Int,
        clearButtonBackgroundColor: Int,
        clearButtonRippleColor: Int,
        clearButtonCornerRadius: Int,
        clearButtonStrokeWidth: Int,
        clearButtonStrokeColor: Int,
        dividerColor: Int,
        dividerWidth: Int,
        dividerHeight: Int,
        rootBackgroundDrawable: Int
    ) {
        viewBinding = ViewPinKeyPadVerticalBinding.inflate(LayoutInflater.from(context), this)

        // Setting Default Button List
        defaultButtonList.apply {
            add(viewBinding.btn0)
            add(viewBinding.btn1)
            add(viewBinding.btn2)
            add(viewBinding.btn3)
            add(viewBinding.btn4)
            add(viewBinding.btn5)
            add(viewBinding.btn6)
            add(viewBinding.btn7)
            add(viewBinding.btn8)
            add(viewBinding.btn9)
        }

        // Setting Divider List
        dividerList.apply {
            add(viewBinding.divider1)
            add(viewBinding.divider2)
            add(viewBinding.divider3)
            add(viewBinding.divider4)
            add(viewBinding.divider5)
            add(viewBinding.divider6)
            add(viewBinding.divider7)
            add(viewBinding.divider8)
            add(viewBinding.divider9)
            add(viewBinding.divider10)
            add(viewBinding.divider11)
        }

        // Setting Default Button Shuffle
        setDefaultButtonShuffle()

        // Setting Default Button
        setDefaultButton(
            defaultButtonTextSize,
            defaultButtonTextColor,
            defaultButtonBackgroundColor,
            defaultButtonRippleColor,
            defaultButtonCornerRadius,
            defaultButtonStrokeWidth,
            defaultButtonStrokeColor
        )

        // Setting Delete Button
        setDeleteButton(
            deleteButtonIcon,
            deleteButtonIconSize,
            deleteButtonBackgroundColor,
            deleteButtonRippleColor,
            deleteButtonCornerRadius,
            deleteButtonStrokeWidth,
            deleteButtonStrokeColor
        )

        // Setting Clear Button
        setClearButton(
            clearButtonEnabled,
            clearButtonText,
            clearButtonTextSize,
            clearButtonTextColor,
            clearButtonBackgroundColor,
            clearButtonRippleColor,
            clearButtonCornerRadius,
            clearButtonStrokeWidth,
            clearButtonStrokeColor
        )

        // Setting Divider
        setDivider(dividerColor, dividerWidth, dividerHeight)

        // Setting Background
        setRootBackground(rootBackgroundDrawable)

        // Setting Button Event
        bindView()
    }



    /**
     * Setting Default Button Shuffle
     */
    private fun setDefaultButtonShuffle() {
        val keyPad: IntArray = getDefaultButtonSwap(defaultButtonValueArray)
        keyPad.let {
            viewBinding.apply {
                btn0.text = it[0].toString()
                btn1.text = it[1].toString()
                btn2.text = it[2].toString()
                btn3.text = it[3].toString()
                btn4.text = it[4].toString()
                btn5.text = it[5].toString()
                btn6.text = it[6].toString()
                btn7.text = it[7].toString()
                btn8.text = it[8].toString()
                btn9.text = it[9].toString()
            }
        }
    }

    private fun getDefaultButtonSwap(intArray: IntArray): IntArray {
        val length = intArray.size
        val random = Random()
        random.nextInt()

        for (i in 0 until length) {
            val change = i + random.nextInt(length - i)
            setDefaultButtonSwap(
                intArray,
                i,
                change
            )
        }

        return intArray
    }

    private fun setDefaultButtonSwap(intArray: IntArray, index: Int, change: Int) {
        val temp = intArray[index]

        intArray[index] = intArray[change]
        intArray[change] = temp
    }



    /**
     * Setting Default Button
     */
    private fun setDefaultButton(
        defaultButtonTextSize: Int,
        defaultButtonTextColor: Int,
        defaultButtonBackgroundColor: Int,
        defaultButtonRippleColor: Int,
        defaultButtonCornerRadius: Int,
        defaultButtonStrokeWidth: Int,
        defaultButtonStrokeColor: Int
    ) {
        defaultButtonList.forEach {
            it.textSize = defaultButtonTextSize.toFloat()
            it.setTextColor(ContextCompat.getColor(context, defaultButtonTextColor))
            it.setBackgroundColor(ContextCompat.getColor(context, defaultButtonBackgroundColor))
            it.setRippleColorResource(defaultButtonRippleColor)
            it.cornerRadius = defaultButtonCornerRadius
            it.strokeWidth = defaultButtonStrokeWidth
            it.setStrokeColorResource(defaultButtonStrokeColor)
        }
    }



    /**
     * Setting Delete Button
     */
    private fun setDeleteButton(
        deleteButtonIcon: Int,
        deleteButtonIconSize: Int,
        deleteButtonBackgroundColor: Int,
        deleteButtonRippleColor: Int,
        deleteButtonCornerRadius: Int,
        deleteButtonStrokeWidth: Int,
        deleteButtonStrokeColor: Int
    ) {
        viewBinding.btnDelete.apply {
            setIconResource(deleteButtonIcon)
            iconSize = deleteButtonIconSize
            setBackgroundColor(ContextCompat.getColor(context, deleteButtonBackgroundColor))
            setRippleColorResource(deleteButtonRippleColor)
            cornerRadius = deleteButtonCornerRadius
            strokeWidth = deleteButtonStrokeWidth
            setStrokeColorResource(deleteButtonStrokeColor)
        }
    }



    /**
     * Setting Clear Button
     */
    @SuppressLint("SetTextI18n")
    private fun setClearButton(
        clearButtonEnabled: Boolean,
        clearButtonText: String?,
        clearButtonTextSize: Int,
        clearButtonTextColor: Int,
        clearButtonBackgroundColor: Int,
        clearButtonRippleColor: Int,
        clearButtonCornerRadius: Int,
        clearButtonStrokeWidth: Int,
        clearButtonStrokeColor: Int
    ) {
        viewBinding.btnClear.apply {
            if (clearButtonEnabled) {
                clearButtonText?.let {
                    text = it
                } ?: let {
                    text = "CLEAR"
                }

                textSize = clearButtonTextSize.toFloat()
                setTextColor(ContextCompat.getColor(context, clearButtonTextColor))
            }

            setBackgroundColor(ContextCompat.getColor(context, clearButtonBackgroundColor))
            setRippleColorResource(clearButtonRippleColor)
            cornerRadius = clearButtonCornerRadius
            strokeWidth = clearButtonStrokeWidth
            setStrokeColorResource(clearButtonStrokeColor)
        }
    }



    /**
     * Setting Divider
     */
    private fun setDivider(
        dividerColor: Int,
        dividerWidth: Int,
        dividerHeight: Int
    ) {
        for (i in 0 until dividerList.size) {
            dividerList[i].setBackgroundColor(ContextCompat.getColor(context, dividerColor))

            when (i) {
                0, 1, 3, 4, 6, 7, 9, 10 -> {
                    dividerList[i].layoutParams.width = dividerWidth
                }

                2, 5, 8 -> {
                    dividerList[i].layoutParams.height = dividerHeight
                }
            }
        }
    }



    /**
     * Setting Background
     */
    private fun setRootBackground(rootBackgroundDrawable: Int) {
        viewBinding.rootLayout.apply {
            setBackgroundResource(rootBackgroundDrawable)
        }
    }



    /**
     * Setting Button Event
     */
    private fun bindView() {
        // Default Button
        defaultButtonList.forEach { btn ->
            val enterValue = btn.text.toString()
            btn.setOnClickListener {
                pinKeyPadVerticalListener?.pinKeyPadVerticalChanged(setAddKeyPadText(enterValue.toInt()))
            }
        }

        // Delete Button
        viewBinding.btnDelete.apply {
            setOnClickListener {
                pinKeyPadVerticalListener?.pinKeyPadVerticalChanged(setDeleteKeyPadText())
            }

            setOnLongClickListener {
                setClear()
                true
            }
        }

        // Clear Button
        viewBinding.btnClear.apply {
            setOnClickListener {
                setClear()
            }
        }
    }



    /**
     * Setting Add KeyPad Text
     */
    private fun setAddKeyPadText(enterValue: Int): String {
        if (value.length < maxLength) {
            value += enterValue
            pinIndicatorView?.setUpdateDot(value.length)
        }

        return value
    }



    /**
     * Setting Delete KeyPad Text
     */
    private fun setDeleteKeyPadText(): String {
        value = when (value.length) {
            1 -> {
                ""
            }

            else -> {
                value.dropLast(1)
            }
        }

        pinIndicatorView?.setUpdateDot(value.length)

        return value
    }



    /**
     * - 입력값을 초기화한다.
     * - Initialize the input value.
     */
    fun setClear() {
        value = ""
        pinKeyPadVerticalListener?.pinKeyPadVerticalChanged(value)
        pinIndicatorView?.setUpdateDot(value.length)
    }



    /**
     * - 입력값을 가져온다.
     * - Gets the input value.
     */
    fun getValue(): String {
        return value
    }



    /**
     * - PinIndicatorView 를 연결한다.
     * - Attach to PinIndicatorView
     */
    fun setAttachPinIndicatorView(pinIndicatorView: PinIndicatorView) {
        this.pinIndicatorView = pinIndicatorView
        this.pinIndicatorView?.let {
            maxLength = it.getDotLength()
        }
    }





    /**
     * KeyPad Listener
     */
    interface PinKeyPadVerticalListener {
        fun pinKeyPadVerticalChanged(value: String)
    }

    fun setPinKeyPadVerticalListener(pinKeyPadVerticalListener: PinKeyPadVerticalListener) {
        this.pinKeyPadVerticalListener = pinKeyPadVerticalListener
    }
}
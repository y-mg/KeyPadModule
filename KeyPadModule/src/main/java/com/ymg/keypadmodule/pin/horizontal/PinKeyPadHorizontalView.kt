package com.ymg.keypadmodule.pin.horizontal

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.ymg.keypadmodule.R
import com.ymg.keypadmodule.databinding.ViewPinKeyPadHorizontalBinding
import com.ymg.keypadmodule.pin.indicator.PinIndicatorView
import java.util.*
import kotlin.collections.ArrayList



/**
 * @author y-mg
 *
 * 이것은 PinIndicator 와 함께 사용되는 PinKeyPad(Horizontal) 입니다.
 * This is the PinKeyPad(Horizontal) used with PinIndicator.
 */
class PinKeyPadHorizontalView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    companion object {
        const val TOTAL_DEFAULT_BUTTON_COUNT = 12
        const val TOTAL_EMPTY_BUTTON_COUNT = 2
        const val TOTAL_DIVIDER_COUNT = 13
    }

    private lateinit var viewBinding: ViewPinKeyPadHorizontalBinding

    private val defaultButtonList: MutableList<MaterialButton> = ArrayList(TOTAL_DEFAULT_BUTTON_COUNT)
    private val emptyButtonList: MutableList<MaterialButton> = ArrayList(TOTAL_EMPTY_BUTTON_COUNT)
    private val dividerList: MutableList<View> = ArrayList(TOTAL_DIVIDER_COUNT)

    private val defaultButtonValueArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

    private var value = ""
    private var maxLength: Int = 0

    private var pinKeyPadHorizontalListener: PinKeyPadHorizontalListener? = null

    private var pinIndicatorView: PinIndicatorView? = null



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.PinKeyPadHorizontalStyle, defStyleAttr, defStyleAttr)

        // 기본 버튼의 글자 크기를 설정한다.
        // Sets the letter size of the default button.
        val defaultButtonTextSize =
            typedArray.getInt(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonTextSize,
                24
            )

        // 기본 버튼의 글자 색상을 설정한다.
        // Sets the text color of the default button.
        val defaultButtonTextColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonTextColor,
                R.color.black_000000
            )

        // 기본 버튼의 배경색을 설정한다.
        // Sets the background color of the default button.
        val defaultButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 기본 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the default button.
        val defaultButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonRippleColor,
                R.color.transparent_00000000
            )

        // 기본 버튼의 코너를 설정한다.
        // Set the corner of the default button.
        val defaultButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_corner_radius)
            ).toInt()

        // 기본 버튼의 테두리 두께를 설정한다.
        // Set the border thickness of the default button.
        val defaultButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_stroke_width)
            ).toInt()

        // 기본 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the default button.
        val defaultButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 아이콘을 설정한다.
        // Set the icon for the delete button.
        val deleteButtonIcon =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonIcon,
                R.drawable.btn_keyboard_del_black
            )

        // 삭제 버튼의 아이콘 크기를 설정한다.
        // Sets the size of the icon for the delete button.
        val deleteButtonIconSize =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonIconSize,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_icon_size)
            ).toInt()

        // 삭제 버튼의 배경색을 설정한다.
        // Sets the background color of the delete button.
        val deleteButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the delete button.
        val deleteButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonRippleColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 코너를 설정한다.
        // Set the corner of the delete button.
        val deleteButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_corner_radius)
            ).toInt()

        // 삭제 버튼의 테두리 두께를 설정한다.
        // Sets the border thickness of the delete button.
        val deleteButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_stroke_width)
            ).toInt()

        // 삭제 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the delete button.
        val deleteButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 빈 버튼의 아이콘을 설정한다.
        // the icon for the empty button.
        val emptyButtonIcon =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonIcon,
                R.drawable.btn_empty
            )

        // 빈 버튼의 아이콘 크기를 설정한다.
        // the size of the icon for the empty button.
        val emptyButtonIconSize =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonIconSize,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_icon_size)
            ).toInt()

        // 빈 버튼의 배경색을 설정한다.
        // Sets the background color of the empty button.
        val emptyButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 빈 버튼의 코너를 설정한다.
        // Set the corner of the empty button.
        val emptyButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_corner_radius)
            ).toInt()

        // 빈 버튼의 테두리 두께를 설정한다.
        // Sets the border thickness of the empty button.
        val emptyButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_stroke_width)
            ).toInt()

        // 빈 버튼의 테두리 색상을 설정한다.
        // the border color of the empty button.
        val emptyButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 클리어 버튼의 텍스트를 설정한다.
        // Sets the text of the clear button.
        val clearButtonText =
            typedArray.getString(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonText
            )

        // 클리어 버튼의 글자 크기를 설정한다.
        // Sets the letter size of the clear button.
        val clearButtonTextSize =
            typedArray.getInt(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonTextSize,
                24
            )

        // 클리어 버튼의 글자 색상을 설정한다.
        // the character color of the clear button.
        val clearButtonTextColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonTextColor,
                R.color.black_000000
            )

        // 클리어 버튼의 배경색을 설정한다.
        // Set the background color of the clear button.
        val clearButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 클리어 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the clear button.
        val clearButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonRippleColor,
                R.color.transparent_00000000
            )

        // 클리어 버튼의 테두리를 설정한다.
        // Set the border of the clear button.
        val clearButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_corner_radius)
            ).toInt()

        // 버튼의 테두리 두께를 설정한다.
        // Set the border thickness of the clear button.
        val clearButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_stroke_width)
            ).toInt()

        // 클리어 버튼의 테두리 색상을 설정한다.
        // the border color of the clear button.
        val clearButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 구분선의 색상을 설정한다.
        // Sets the color of the dividing line.
        val dividerColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDividerColor,
                R.color.transparent_00000000
            )

        // 세로 구분선의 폭을 설정한다.
        // the width of the vertical divider.
        val dividerWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDividerWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_divider_width)
            ).toInt()

        // 가로 구분선의 높이를 설정한다.
        // Sets the height of the horizontal divider
        val dividerHeight =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDividerHeight,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_divider_height)
            ).toInt()

        // 배경색을 설정한다.
        // Set background color.
        val rootBackgroundDrawable =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphRootBackgroundDrawable,
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
            clearButtonText,
            clearButtonTextSize,
            clearButtonTextColor,
            clearButtonBackgroundColor,
            clearButtonRippleColor,
            clearButtonCornerRadius,
            clearButtonStrokeWidth,
            clearButtonStrokeColor,
            emptyButtonIcon,
            emptyButtonIconSize,
            emptyButtonBackgroundColor,
            emptyButtonCornerRadius,
            emptyButtonStrokeWidth,
            emptyButtonStrokeColor,
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
        clearButtonText: String?,
        clearButtonTextSize: Int,
        clearButtonTextColor: Int,
        clearButtonBackgroundColor: Int,
        clearButtonRippleColor: Int,
        clearButtonCornerRadius: Int,
        clearButtonStrokeWidth: Int,
        clearButtonStrokeColor: Int,
        emptyButtonIcon: Int,
        emptyButtonIconSize: Int,
        emptyButtonBackgroundColor: Int,
        emptyButtonCornerRadius: Int,
        emptyButtonStrokeWidth: Int,
        emptyButtonStrokeColor: Int,
        dividerColor: Int,
        dividerWidth: Int,
        dividerHeight: Int,
        rootBackgroundDrawable: Int
    ) {
        viewBinding = ViewPinKeyPadHorizontalBinding.inflate(LayoutInflater.from(context), this)

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
            add(viewBinding.btn10)
            add(viewBinding.btn11)
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
            add(viewBinding.divider12)
            add(viewBinding.divider13)
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
            clearButtonText,
            clearButtonTextSize,
            clearButtonTextColor,
            clearButtonBackgroundColor,
            clearButtonRippleColor,
            clearButtonCornerRadius,
            clearButtonStrokeWidth,
            clearButtonStrokeColor
        )

        // Setting Empty Button
        setEmptyButton(
            emptyButtonIcon,
            emptyButtonIconSize,
            emptyButtonBackgroundColor,
            emptyButtonCornerRadius,
            emptyButtonStrokeWidth,
            emptyButtonStrokeColor
        )

        // Setting Divider
        setDivider(dividerColor, dividerWidth, dividerHeight)

        // Setting Background
        setRootBackground(rootBackgroundDrawable)

        // Setting Button Event
        setButtonEvent()
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
                btn10.text = it[10].toString()
                btn11.text = it[11].toString()
            }
        }

        defaultButtonList.forEach {
            val enterValue = it.text.toString()

            if (enterValue == "10" || enterValue == "11") {
                emptyButtonList.add(it)
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
            clearButtonText?.let {
                text = it
            } ?: let {
                text = "CLEAR"
            }

            textSize = clearButtonTextSize.toFloat()
            setTextColor(ContextCompat.getColor(context, clearButtonTextColor))
            setBackgroundColor(ContextCompat.getColor(context, clearButtonBackgroundColor))
            setRippleColorResource(clearButtonRippleColor)
            cornerRadius = clearButtonCornerRadius
            strokeWidth = clearButtonStrokeWidth
            setStrokeColorResource(clearButtonStrokeColor)
        }
    }



    /**
     * Setting Empty Button
     */
    private fun setEmptyButton(
        emptyButtonIcon: Int,
        emptyButtonIconSize: Int,
        emptyButtonBackgroundColor: Int,
        emptyButtonCornerRadius: Int,
        emptyButtonStrokeWidth: Int,
        emptyButtonStrokeColor: Int
    ) {
        emptyButtonList.forEach {
            it.text = ""
            it.isEnabled = false

            it.setIconResource(emptyButtonIcon)
            it.iconSize = emptyButtonIconSize
            it.setBackgroundColor(ContextCompat.getColor(context, emptyButtonBackgroundColor))
            it.cornerRadius = emptyButtonCornerRadius
            it.strokeWidth = emptyButtonStrokeWidth
            it.setStrokeColorResource(emptyButtonStrokeColor)
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
                0, 1, 2, 4, 5, 6, 8, 9, 10, 12 -> {
                    dividerList[i].layoutParams.width = dividerWidth
                }

                3, 7, 11 -> {
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
    private fun setButtonEvent() {
        // Default Button
        defaultButtonList.forEach { btn ->
            val enterValue = btn.text.toString()
            btn.setOnClickListener {
                pinKeyPadHorizontalListener?.pinKeyPadHorizontalChanged(setAddKeyPadText(enterValue.toInt()))
            }
        }

        // Delete Button
        viewBinding.btnDelete.apply {
            setOnClickListener {
                pinKeyPadHorizontalListener?.pinKeyPadHorizontalChanged(setDeleteKeyPadText())
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
        pinKeyPadHorizontalListener?.pinKeyPadHorizontalChanged(value)
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
    interface PinKeyPadHorizontalListener {
        fun pinKeyPadHorizontalChanged(value: String)
    }

    fun setPinKeyPadHorizontalListener(pinKeyPadHorizontalListener: PinKeyPadHorizontalListener) {
        this.pinKeyPadHorizontalListener = pinKeyPadHorizontalListener
    }
}
package com.ymg.keypadmodule.number

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.ymg.keypadmodule.R
import com.ymg.keypadmodule.databinding.ViewNumberKeyPadBinding



/**
 * @author y-mg
 *
 * 이것은 숫자 입력 키 패드입니다.
 * This is the number input key pad.
 */
class NumberKeyPadView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    companion object {
        const val TOTAL_DEFAULT_BUTTON_COUNT = 10
        const val TOTAL_DIVIDER_COUNT = 11
    }

    private lateinit var viewBinding: ViewNumberKeyPadBinding

    private val defaultButtonList: MutableList<MaterialButton> = ArrayList(TOTAL_DEFAULT_BUTTON_COUNT)
    private val dividerList: MutableList<View> = ArrayList(TOTAL_DIVIDER_COUNT)

    private var checkFormat = true
    private var maxLength: Int = 0

    private var value = ""

    private var numberKeyPadListener: NumberKeyPadListener? = null



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.NumberKeyPadStyle, defStyleAttr, defStyleAttr)

        // Format 을 체크한다.(true: Integer, false: Number)
        // Check the format.(true: Integer, false: Number)
        val checkFormat =
            typedArray.getBoolean(R.styleable.NumberKeyPadStyle_nkpCheckFormat, true)

        // 입력할 수 있는 자릿수를 설정한다.
        // Sets the number of digits that can be entered.
        val maxLength =
            typedArray.getInt(R.styleable.NumberKeyPadStyle_nkpMaxLength, 20)

        // 기본 버튼의 글자 크기를 설정한다.
        // Sets the letter size of the default button.
        val defaultButtonTextSize =
            typedArray.getInt(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonTextSize,
                24
            )

        // 기본 버튼의 글자 색상을 설정한다.
        // Sets the text color of the default button.
        val defaultButtonTextColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonTextColor,
                R.color.black_000000
            )

        // 기본 버튼의 배경색을 설정한다.
        // Sets the background color of the default button.
        val defaultButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 기본 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the default button.
        val defaultButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonRippleColor,
                R.color.transparent_00000000
            )

        // 기본 버튼의 코너를 설정한다.
        // Set the corner of the default button.
        val defaultButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonCornerRadius,
                context.resources.getDimension(R.dimen.number_key_pad_default_corner_radius)
            ).toInt()

        // 기본 버튼의 테두리 두께를 설정한다.
        // Set the border thickness of the default button.
        val defaultButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonStrokeWidth,
                context.resources.getDimension(R.dimen.number_key_pad_default_stroke_width)
            ).toInt()

        // 기본 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the default button.
        val defaultButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 아이콘을 설정한다.
        // Set the icon for the delete button.
        val deleteButtonIcon =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonIcon,
                R.drawable.btn_keyboard_del_black
            )

        // 삭제 버튼의 아이콘 크기를 설정한다.
        // Sets the size of the icon for the delete button.
        val deleteButtonIconSize =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonIconSize,
                context.resources.getDimension(R.dimen.number_key_pad_default_icon_size)
            ).toInt()

        // 삭제 버튼의 배경색을 설정한다.
        // Sets the background color of the delete button.
        val deleteButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the delete button.
        val deleteButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonRippleColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 코너를 설정한다.
        // Set the corner of the delete button.
        val deleteButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonCornerRadius,
                context.resources.getDimension(R.dimen.number_key_pad_default_corner_radius)
            ).toInt()

        // 삭제 버튼의 테두리 두께를 설정한다.
        // Sets the border thickness of the delete button.
        val deleteButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonStrokeWidth,
                context.resources.getDimension(R.dimen.number_key_pad_default_stroke_width)
            ).toInt()

        // 삭제 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the delete button.
        val deleteButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 클리어 버튼의 적용 여부를 설정한다.
        // Sets whether the clear button is applied.
        val clearButtonEnabled =
            typedArray.getBoolean(
                R.styleable.NumberKeyPadStyle_nkpClearButtonEnabled,
                false
            )

        // 클리어 버튼의 텍스트를 설정한다.
        // Sets the text of the clear button.
        val clearButtonText =
            typedArray.getString(
                R.styleable.NumberKeyPadStyle_nkpClearButtonText
            )

        // 클리어 버튼의 글자 크기를 설정한다.
        // Sets the letter size of the clear button.
        val clearButtonTextSize =
            typedArray.getInt(
                R.styleable.NumberKeyPadStyle_nkpClearButtonTextSize,
                24
            )

        // 클리어 버튼의 글자 색상을 설정한다.
        // Sets the character color of the clear button.
        val clearButtonTextColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpClearButtonTextColor,
                R.color.black_000000
            )

        // 클리어 버튼의 배경색을 설정한다.
        // Set the background color of the clear button.
        val clearButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpClearButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 클리어 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the clear button.
        val clearButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpClearButtonRippleColor,
                R.color.transparent_00000000
            )

        // 클리어 버튼의 테두리를 설정한다.
        // Set the border of the clear button.
        val clearButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpClearButtonCornerRadius,
                context.resources.getDimension(R.dimen.number_key_pad_default_corner_radius)
            ).toInt()

        // 클리어 버튼의 테두리 두께를 설정한다.
        // Set the border thickness of the clear button.
        val clearButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpClearButtonStrokeWidth,
                context.resources.getDimension(R.dimen.number_key_pad_default_stroke_width)
            ).toInt()

        // 클리어 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the clear button.
        val clearButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpClearButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 구분선의 색상을 설정한다.
        // Sets the color of the dividing line.
        val dividerColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDividerColor,
                R.color.transparent_00000000
            )

        // 세로 구분선의 폭을 설정한다.
        // the width of the vertical divider.
        val dividerWidth =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDividerWidth,
                context.resources.getDimension(R.dimen.number_key_pad_default_divider_width)
            ).toInt()

        // 가로 구분선의 높이를 설정한다.
        // Sets the height of the horizontal divider.
        val dividerHeight =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDividerHeight,
                context.resources.getDimension(R.dimen.number_key_pad_default_divider_height)
            ).toInt()

        // 배경색을 설정한다.
        // Set background color.
        val rootBackgroundDrawable =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpRootBackgroundDrawable,
                R.color.white_ffffff
            )

        typedArray.recycle()


        setInit(
            checkFormat,
            maxLength,
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
        checkFormat: Boolean,
        maxLength: Int,
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
        viewBinding = ViewNumberKeyPadBinding.inflate(LayoutInflater.from(context), this)

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

        // Setting Check Format
        setCheckFormat(checkFormat)

        // Setting Max Length
        setMaxLength(maxLength)

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
        setButtonEvent()
    }



    /**
     * Setting Check Format
     */
    private fun setCheckFormat(checkFormat: Boolean) {
        this.checkFormat = checkFormat
    }



    /**
     * - 입력할 수 있는 자릿수를 설정한다.
     * - Sets the number of digits that can be entered.
     *
     * @param maxLength -> Number of digits to be able to enter
     */
    fun setMaxLength(maxLength: Int) {
        this.maxLength = maxLength
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
    private fun setButtonEvent() {
        // Default Button
        defaultButtonList.forEach { btn ->
            val enterValue = btn.text.toString()
            btn.setOnClickListener {
                numberKeyPadListener?.numberKeyPadChanged(setAddKeyPadText(enterValue.toInt()))
            }
        }

        // Delete Button
        viewBinding.btnDelete.apply {
            setOnClickListener {
                numberKeyPadListener?.numberKeyPadChanged(setDeleteKeyPadText())
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
        }

        if (checkFormat) {
            when {
                value.startsWith("00") -> {
                    value = "0"
                }

                value.matches("^0[1-9]".toRegex()) -> {
                    value = value.replace("0", "")
                }
            }
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

        return value
    }



    /**
     * - 입력값을 초기화한다.
     * - Initialize the input value.
     */
    fun setClear() {
        value = ""
        numberKeyPadListener?.numberKeyPadChanged(value)
    }



    /**
     * - 입력값을 설정한다.
     * - Set the input value.
     *
     * @param value -> Input Value
     */
    fun setValue(value: String) {
        this.value = value
    }



    /**
     * - 입력값을 가져온다.
     * - Gets the input value.
     */
    fun getValue(): String {
        return value
    }





    /**
     * KeyPad Listener
     */
    interface NumberKeyPadListener {
        fun numberKeyPadChanged(value: String)
    }

    fun setNumberKeyPadListener(numberKeyPadListener: NumberKeyPadListener) {
        this.numberKeyPadListener = numberKeyPadListener
    }
}
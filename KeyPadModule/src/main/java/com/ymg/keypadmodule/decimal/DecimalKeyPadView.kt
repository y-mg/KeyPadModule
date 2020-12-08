package com.ymg.keypadmodule.decimal

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.ymg.keypadmodule.R
import com.ymg.keypadmodule.databinding.ViewDecimalKeyPadBinding



/**
 * @author y-mg
 *
 * 이것은 소수 입력 키 패드입니다.
 * This is the decimal input key pad.
 */
class DecimalKeyPadView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    companion object {
        const val TOTAL_DEFAULT_BUTTON_COUNT = 10
        const val TOTAL_DIVIDER_COUNT = 11
    }

    private lateinit var viewBinding: ViewDecimalKeyPadBinding

    private val defaultButtonList: MutableList<MaterialButton> =
        ArrayList(TOTAL_DEFAULT_BUTTON_COUNT)
    private val dividerList: MutableList<View> = ArrayList(TOTAL_DIVIDER_COUNT)

    private var maxLength: Int = 0
    private var decimalCut: Int = 0

    private var value = ""

    private var decimalKeyPadListener: DecimalKeyPadListener? = null



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.DecimalKeyPadStyle,
                defStyleAttr,
                defStyleAttr
            )

        // 입력할 수 있는 자릿수를 설정한다.
        // Sets the number of digits that can be entered.
        val maxLength =
            typedArray.getInt(R.styleable.DecimalKeyPadStyle_dkpMaxLength, 20)

        // 소수점 이하 자릿수를 설정한다.
        // Sets the decimal place.
        val decimalCut =
            typedArray.getInt(R.styleable.DecimalKeyPadStyle_dkpDecimalCut, 8)

        // 기본 버튼의 글자 크기를 설정한다.
        // Sets the letter size of the default button.
        val defaultButtonTextSize =
            typedArray.getInt(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonTextSize,
                24
            )

        // 기본 버튼의 글자 색상을 설정한다.
        // Sets the text color of the default button.
        val defaultButtonTextColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonTextColor,
                R.color.black_000000
            )

        // 기본 버튼의 배경색을 설정한다.
        // Sets the background color of the default button.
        val defaultButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 기본 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the default button.
        val defaultButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonRippleColor,
                R.color.transparent_00000000
            )

        // 기본 버튼의 코너를 설정한다.
        // Set the corner of the default button.
        val defaultButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonCornerRadius,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_corner_radius)
            ).toInt()

        // 기본 버튼의 테두리 두께를 설정한다.
        // Set the border thickness of the default button.
        val defaultButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonStrokeWidth,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_stroke_width)
            ).toInt()

        // 기본 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the default button.
        val defaultButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 아이콘을 설정한다.
        // Set the icon for the delete button.
        val deleteButtonIcon =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonIcon,
                R.drawable.btn_keyboard_del_black
            )

        // 삭제 버튼의 아이콘 크기를 설정한다.
        // Sets the size of the icon for the delete button.
        val deleteButtonIconSize =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonIconSize,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_icon_size)
            ).toInt()

        // 삭제 버튼의 배경색을 설정한다.
        // Sets the background color of the delete button.
        val deleteButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the delete button.
        val deleteButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonRippleColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼의 코너를 설정한다.
        // Set the corner of the delete button.
        val deleteButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonCornerRadius,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_corner_radius)
            ).toInt()

        // 삭제 버튼의 테두리 두께를 설정한다.
        // Sets the border thickness of the delete button.
        val deleteButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonStrokeWidth,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_stroke_width)
            ).toInt()

        // 삭제 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the delete button.
        val deleteButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 점 버튼의 글자 크기를 설정한다.
        // Sets the letter size of the dot button.
        val dotButtonTextSize =
            typedArray.getInt(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonTextSize,
                24
            )

        // 점 버튼의 글자 색상을 설정한다.
        // Sets the character color of the dot button.
        val dotButtonTextColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonTextColor,
                R.color.black_000000
            )

        // 점 버튼의 배경색을 설정한다.
        // Set the background color of the dot button.
        val dotButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 점 버튼의 효과 색상을 설정한다.
        // Sets the effect color of the dot button.
        val dotButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonRippleColor,
                R.color.transparent_00000000
            )

        // 점 버튼의 테두리를 설정한다.
        // Set the border of the dot button.
        val dotButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonCornerRadius,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_corner_radius)
            ).toInt()

        // 점 버튼의 테두리 두께를 설정한다.
        // Set the border thickness of the dot button.
        val dotButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonStrokeWidth,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_stroke_width)
            ).toInt()

        // 점 버튼의 테두리 색상을 설정한다.
        // Sets the border color of the dot button.
        val dotButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonStrokeColor,
                R.color.transparent_00000000
            )

        // 구분선의 색상을 설정한다.
        // Sets the color of the dividing line.
        val dividerColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDividerColor,
                R.color.transparent_00000000
            )

        // 세로 구분선의 폭을 설정한다.
        // the width of the vertical divider.
        val dividerWidth =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDividerWidth,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_divider_width)
            ).toInt()

        // 가로 구분선의 높이를 설정한다.
        // Sets the height of the horizontal divider.
        val dividerHeight =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDividerHeight,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_divider_height)
            ).toInt()

        // 배경색을 설정한다.
        // Set background color.
        val rootBackgroundDrawable =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpRootBackgroundDrawable,
                R.color.white_ffffff
            )

        typedArray.recycle()


        setInit(
            maxLength,
            decimalCut,
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
            dotButtonTextSize,
            dotButtonTextColor,
            dotButtonBackgroundColor,
            dotButtonRippleColor,
            dotButtonCornerRadius,
            dotButtonStrokeWidth,
            dotButtonStrokeColor,
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
        maxLength: Int,
        decimalCut: Int,
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
        dotButtonTextSize: Int,
        dotButtonTextColor: Int,
        dotButtonBackgroundColor: Int,
        dotButtonRippleColor: Int,
        dotButtonCornerRadius: Int,
        dotButtonStrokeWidth: Int,
        dotButtonStrokeColor: Int,
        dividerColor: Int,
        dividerWidth: Int,
        dividerHeight: Int,
        rootBackgroundDrawable: Int
    ) {
        viewBinding = ViewDecimalKeyPadBinding.inflate(LayoutInflater.from(context), this)

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

        // Setting Max Length
        setMaxLength(maxLength)

        // Setting Decimal Place
        setDecimalCut(decimalCut)

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

        // Setting Dot Button
        setDotButton(
            dotButtonTextSize,
            dotButtonTextColor,
            dotButtonBackgroundColor,
            dotButtonRippleColor,
            dotButtonCornerRadius,
            dotButtonStrokeWidth,
            dotButtonStrokeColor
        )

        // Setting Divider
        setDivider(dividerColor, dividerWidth, dividerHeight)

        // Setting Background
        setRootBackground(rootBackgroundDrawable)

        // Setting Button Event
        setButtonEvent()
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
     * - 소수점 이하 자릿수를 설정한다.
     * - Sets the decimal place.
     *
     * @param decimalCut -> Decimal Digit
     */
    fun setDecimalCut(decimalCut: Int) {
        this.decimalCut = decimalCut
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
     * Setting Dot Button
     */
    private fun setDotButton(
        dotButtonTextSize: Int,
        dotButtonTextColor: Int,
        dotButtonBackgroundColor: Int,
        dotButtonRippleColor: Int,
        dotButtonCornerRadius: Int,
        dotButtonStrokeWidth: Int,
        dotButtonStrokeColor: Int
    ) {
        viewBinding.btnDot.apply {
            textSize = dotButtonTextSize.toFloat()
            setTextColor(ContextCompat.getColor(context, dotButtonTextColor))
            setBackgroundColor(ContextCompat.getColor(context, dotButtonBackgroundColor))
            setRippleColorResource(dotButtonRippleColor)
            cornerRadius = dotButtonCornerRadius
            strokeWidth = dotButtonStrokeWidth
            setStrokeColorResource(dotButtonStrokeColor)
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
                decimalKeyPadListener?.decimalKeyPadChanged(setAddKeyPadText(enterValue))
            }
        }

        // Delete Button
        viewBinding.btnDelete.apply {
            setOnClickListener {
                decimalKeyPadListener?.decimalKeyPadChanged(setDeleteKeyPadText())
            }

            setOnLongClickListener {
                setClear()
                true
            }
        }

        // Dot Button
        viewBinding.btnDot.apply {
            setOnClickListener {
                val enterValue = viewBinding.btnDot.text.toString()
                decimalKeyPadListener?.decimalKeyPadChanged(setAddKeyPadText(enterValue))
            }
        }
    }



    /**
     * Setting Add KeyPad Text
     */
    private fun setAddKeyPadText(enterValue: String): String {
        when {
            value.isEmpty() && enterValue == "." -> {
                return ""
            }

            enterValue == "." && value.contains(".") -> {
                return value
            }

            enterValue == "." && decimalCut <= 0 -> {
                return value
            }
        }

        if (value.length <= maxLength) {
            value += if (value.contains(".")) {
                val enterDecimalValueLength =
                    value.substring(value.lastIndexOf(".")).replace(".", "").length

                when {
                    enterDecimalValueLength >= decimalCut -> {
                        return value
                    }

                    else -> {
                        enterValue
                    }
                }
            } else {
                enterValue
            }
        }

        when {
            value.startsWith("00") -> {
                value = "0"
            }

            value.matches("^0[1-9]".toRegex()) -> {
                value = value.replace("0", "")
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
        decimalKeyPadListener?.decimalKeyPadChanged(value)
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
    interface DecimalKeyPadListener {
        fun decimalKeyPadChanged(value: String)
    }

    fun setDecimalKeyPadListener(decimalKeyPadListener: DecimalKeyPadListener) {
        this.decimalKeyPadListener = decimalKeyPadListener
    }
}
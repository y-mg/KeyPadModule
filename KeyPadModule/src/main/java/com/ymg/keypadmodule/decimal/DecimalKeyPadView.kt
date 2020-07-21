package com.ymg.keypadmodule.decimal

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.ymg.keypadmodule.R


class DecimalKeyPadView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    companion object {
        // 기본 버튼 총 수
        const val TOTAL_DEFAULT_BUTTON_COUNT = 10

        // 구분선 총 수
        const val TOTAL_DIVIDER_COUNT = 11
    }

    // 기본 버튼 리스트, 구분선 리스트
    private val defaultButtonList: MutableList<MaterialButton> =
        ArrayList(TOTAL_DEFAULT_BUTTON_COUNT)
    private val dividerList: MutableList<View> = ArrayList(TOTAL_DIVIDER_COUNT)

    // 입력값, 입력 가능한 최대 글자 수, 입력 가능한 소수점 컷 자리 수
    private var keyPadTextValue = ""
    private var keyPadTextMaxLength: Int = 0
    private var keyPadTextDecimalCut: Int = 0

    // 삭제 버튼, 점 버튼, Root Layout
    private var btnDelete: MaterialButton? = null
    private var btnDot: MaterialButton? = null
    private var rootLayout: LinearLayout? = null

    // 키 패드 리스너
    private var decimalKeyPadListener: DecimalKeyPadListener? = null



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.DecimalKeyPadStyle,
                defStyleAttr,
                defStyleAttr
            )

        // 입력 가능한 최대 글자 수
        val textMaxLength =
            typedArray.getInt(R.styleable.DecimalKeyPadStyle_dkpTextMaxLength, 20)

        // 입력 가능한 소수점 컷 자리 수
        val textDecimalCut =
            typedArray.getInt(R.styleable.DecimalKeyPadStyle_dkpTextDecimalCut, 8)



        // 기본 버튼 글자 크기
        val defaultButtonTextSize =
            typedArray.getInt(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonTextSize,
                24
            )

        // 기본 버튼 글자 색상
        val defaultButtonTextColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonTextColor,
                R.color.black_000000
            )

        // 기본 버튼 배경 색상
        val defaultButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 기본 버튼 리플 색상
        val defaultButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonRippleColor,
                R.color.transparent_00000000
            )

        // 기본 버튼 코너
        val defaultButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonCornerRadius,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_corner_radius)
            ).toInt()

        // 기본 버튼 테두리 두께
        val defaultButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonStrokeWidth,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_stroke_width)
            ).toInt()

        // 기본 버튼 테두리 색상
        val defaultButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDefaultButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 삭제 버튼 아이콘
        val deleteButtonIcon =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonIcon,
                R.drawable.btn_keyboard_del_black
            )

        // 삭제 버튼 크기
        val deleteButtonIconSize =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonIconSize,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_icon_size)
            ).toInt()

        // 삭제 버튼 배경 색상
        val deleteButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼 리플 색상
        val deleteButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonRippleColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼 코너
        val deleteButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonCornerRadius,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_corner_radius)
            ).toInt()

        // 삭제 버튼 테두리 두께
        val deleteButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonStrokeWidth,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_stroke_width)
            ).toInt()

        // 삭제 버튼 테두리 색상
        val deleteButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDeleteButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 점 버튼 글자 크기
        val dotButtonTextSize =
            typedArray.getInt(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonTextSize,
                24
            )

        // 점 버튼 글자 색상
        val dotButtonTextColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonTextColor,
                R.color.black_000000
            )

        // 점 버튼 배경 색상
        val dotButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 점 버튼 리플 색상
        val dotButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonRippleColor,
                R.color.transparent_00000000
            )

        // 점 버튼 코너
        val dotButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonCornerRadius,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_corner_radius)
            ).toInt()

        // 점 버튼 테두리 두께
        val dotButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonStrokeWidth,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_stroke_width)
            ).toInt()

        // 점 버튼 테두리 색상
        val dotButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDotButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 구분선 색상
        val dividerColor =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpDividerColor,
                R.color.transparent_00000000
            )

        // 세로 구분선 폭
        val dividerWidth =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDividerWidth,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_divider_width)
            ).toInt()

        // 가로 구분선 높이
        val dividerHeight =
            typedArray.getDimension(
                R.styleable.DecimalKeyPadStyle_dkpDividerHeight,
                context.resources.getDimension(R.dimen.decimal_key_pad_default_divider_height)
            ).toInt()



        // 배경
        val rootBackgroundDrawable =
            typedArray.getResourceId(
                R.styleable.DecimalKeyPadStyle_dkpRootBackgroundDrawable,
                R.color.white_ffffff
            )



        typedArray.recycle()

        // 설정
        setInit(
            textMaxLength,
            textDecimalCut,
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
     * 설정
     */
    private fun setInit(
        textMaxLength: Int,
        textDecimalCut: Int,
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
        val container = View.inflate(context, R.layout.view_decimal_key_pad, this)
        btnDot = container.findViewById(R.id.btnDot)
        btnDelete = container.findViewById(R.id.btnDelete)
        rootLayout = container.findViewById(R.id.rootLayout)

        // 기본 버튼
        defaultButtonList.apply {
            add(container.findViewById(R.id.btn0))
            add(container.findViewById(R.id.btn1))
            add(container.findViewById(R.id.btn2))
            add(container.findViewById(R.id.btn3))
            add(container.findViewById(R.id.btn4))
            add(container.findViewById(R.id.btn5))
            add(container.findViewById(R.id.btn6))
            add(container.findViewById(R.id.btn7))
            add(container.findViewById(R.id.btn8))
            add(container.findViewById(R.id.btn9))
        }

        // 구분선
        dividerList.apply {
            add(container.findViewById(R.id.divider1))
            add(container.findViewById(R.id.divider2))
            add(container.findViewById(R.id.divider3))
            add(container.findViewById(R.id.divider4))
            add(container.findViewById(R.id.divider5))
            add(container.findViewById(R.id.divider6))
            add(container.findViewById(R.id.divider7))
            add(container.findViewById(R.id.divider8))
            add(container.findViewById(R.id.divider9))
            add(container.findViewById(R.id.divider10))
            add(container.findViewById(R.id.divider11))
        }


        // 키 패드 최대 글자 수 설정
        setTextMaxLength(textMaxLength)

        // 소수점 컷 자리 수 설정
        setTextDecimalCut(textDecimalCut)

        // 버튼 설정
        setDefaultButton(
            defaultButtonTextSize,
            defaultButtonTextColor,
            defaultButtonBackgroundColor,
            defaultButtonRippleColor,
            defaultButtonCornerRadius,
            defaultButtonStrokeWidth,
            defaultButtonStrokeColor
        )

        // 삭제 버튼 설정
        setDeleteButton(
            deleteButtonIcon,
            deleteButtonIconSize,
            deleteButtonBackgroundColor,
            deleteButtonRippleColor,
            deleteButtonCornerRadius,
            deleteButtonStrokeWidth,
            deleteButtonStrokeColor
        )

        // 점 버튼 설정
        setDotButton(
            dotButtonTextSize,
            dotButtonTextColor,
            dotButtonBackgroundColor,
            dotButtonRippleColor,
            dotButtonCornerRadius,
            dotButtonStrokeWidth,
            dotButtonStrokeColor
        )

        // 구분선 설정
        setDivider(dividerColor, dividerWidth, dividerHeight)

        // 배경 설정
        setRootBackground(rootBackgroundDrawable)

        // BindView
        bindView()
    }



    /**
     * 키 패드 최대 글자 수 설정
     */
    fun setTextMaxLength(textMaxLength: Int) {
        keyPadTextMaxLength = textMaxLength
    }



    /**
     * 소수점 컷 자리 수 설정
     */
    fun setTextDecimalCut(textDecimalCut: Int) {
        keyPadTextDecimalCut = textDecimalCut
    }



    /**
     * 버튼 설정
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
     * 삭제 버튼 설정
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
        btnDelete?.apply {
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
     * 점 버튼 설정
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
        btnDot?.apply {
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
    * 구분선 설정
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
     * 배경 설정
     */
    private fun setRootBackground(rootBackgroundDrawable: Int) {
        rootLayout?.apply {
            setBackgroundResource(rootBackgroundDrawable)
        }
    }



    /**
     * BindView
     */
    private fun bindView() {
        // 버튼
        defaultButtonList.forEach { btn ->
            val enterValue = btn.text.toString()
            btn.setOnClickListener {
                decimalKeyPadListener?.decimalKeyPadChanged(setAddKeyPadText(enterValue))
            }
        }

        // 삭제 버튼
        btnDelete?.setOnClickListener {
            decimalKeyPadListener?.decimalKeyPadChanged(setDeleteKeyPadText())
        }

        // 삭제 버튼 크게 클릭
        btnDelete?.setOnLongClickListener {
            setClearKeyPadText()
            true
        }

        // 점 버튼
        btnDot?.setOnClickListener {
            val enterValue = btnDot?.text.toString()
            decimalKeyPadListener?.decimalKeyPadChanged(setAddKeyPadText(enterValue))
        }
    }



    /**
     * 입력값 Add
     */
    private fun setAddKeyPadText(enterValue: String): String {
        when {
            // 입력값이 .으로 시작하면 초기화
            keyPadTextValue.isEmpty() && enterValue == "." -> {
                return ""
            }

            // 이미 입력값에 . 이 존재하는데 . 을 입력한 경우
            enterValue == "." && keyPadTextValue.contains(".") -> {
                return keyPadTextValue
            }

            // 입력 가능한 소수점 컷 자리수가 0 인 경우
            enterValue == "." && keyPadTextDecimalCut <= 0 -> {
                return keyPadTextValue
            }
        }

        // 입력값 최대 글자 수보다 작으면
        if (keyPadTextValue.length <= keyPadTextMaxLength) {
            keyPadTextValue += if (keyPadTextValue.contains(".")) {
                // 입력된 소수값 길이
                val enterDecimalValueLength =
                    keyPadTextValue.substring(keyPadTextValue.lastIndexOf(".")).replace(".", "").length

                when {
                    // 입력된 소수값이 소수점 컷 자리 수 보다 크거나 같으면 더이상 안받음
                    enterDecimalValueLength >= keyPadTextDecimalCut -> {
                        return keyPadTextValue
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
            // 입력값이 00 으로 시작하면 0 으로 치환
            keyPadTextValue.startsWith("00") -> {
                keyPadTextValue = "0"
            }

            // 키패드 입력값이 01, 02... 패턴식으로 시작하면 0 제거
            keyPadTextValue.matches("^0[1-9]".toRegex()) -> {
                keyPadTextValue = keyPadTextValue.replace("0", "")
            }
        }

        return keyPadTextValue
    }



    /**
     * 입력값 Delete
     */
    private fun setDeleteKeyPadText(): String {
        keyPadTextValue = when (keyPadTextValue.length) {
            // 입력값이 1개 남았을 경우 빈값으로 초기화
            1 -> {
                ""
            }

            // 입력값 마지막 자리 삭제
            else -> {
                keyPadTextValue.dropLast(1)
            }
        }

        return keyPadTextValue
    }



    /**
     * 입력값 초기화
     */
    fun setClearKeyPadText() {
        keyPadTextValue = ""
        decimalKeyPadListener?.decimalKeyPadChanged(keyPadTextValue)
    }



    /**
     * 입력값 설정
     */
    fun setKeyPadText(text: String) {
        keyPadTextValue = text
    }



    /**
     * 입력값 가져오기
     */
    fun getKeyPadText(): String {
        return keyPadTextValue
    }





    /**
     * 키 패드 리스너
     */
    interface DecimalKeyPadListener {
        fun decimalKeyPadChanged(keyPadValue: String)
    }

    fun setDecimalKeyPadListener(decimalKeyPadListener: DecimalKeyPadListener) {
        this.decimalKeyPadListener = decimalKeyPadListener
    }
}
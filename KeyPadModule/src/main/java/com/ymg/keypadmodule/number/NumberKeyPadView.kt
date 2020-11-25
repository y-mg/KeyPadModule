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


class NumberKeyPadView @JvmOverloads
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

    private lateinit var viewBinding: ViewNumberKeyPadBinding

    // 기본 버튼 리스트, 구분선 리스트
    private val defaultButtonList: MutableList<MaterialButton> = ArrayList(TOTAL_DEFAULT_BUTTON_COUNT)
    private val dividerList: MutableList<View> = ArrayList(TOTAL_DIVIDER_COUNT)

    // 입력값 포맷 체크 여부, 입력값, 입력 가능한 최대 글자 수
    private var keyPadTextCheckFormat = true
    private var keyPadTextValue = ""
    private var keyPadTextMaxLength: Int = 0

    // 키 패드 리스너
    private var numberKeyPadListener: NumberKeyPadListener? = null



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.NumberKeyPadStyle, defStyleAttr, defStyleAttr)

        // 입력값 포맷 체크 여부
        val textCheckFormat =
            typedArray.getBoolean(R.styleable.NumberKeyPadStyle_nkpTextCheckFormat, true)

        // 입력 가능한 최대 글자 수
        val textMaxLength =
            typedArray.getInt(R.styleable.NumberKeyPadStyle_nkpTextMaxLength, 20)



        // 기본 버튼 글자 크기
        val defaultButtonTextSize =
            typedArray.getInt(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonTextSize,
                24
            )

        // 기본 버튼 글자 색상
        val defaultButtonTextColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonTextColor,
                R.color.black_000000
            )

        // 기본 버튼 배경 색상
        val defaultButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 기본 버튼 리플 색상
        val defaultButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonRippleColor,
                R.color.transparent_00000000
            )

        // 기본 버튼 코너
        val defaultButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonCornerRadius,
                context.resources.getDimension(R.dimen.number_key_pad_default_corner_radius)
            ).toInt()

        // 기본 버튼 테두리 두께
        val defaultButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonStrokeWidth,
                context.resources.getDimension(R.dimen.number_key_pad_default_stroke_width)
            ).toInt()

        // 기본 버튼 테두리 색상
        val defaultButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDefaultButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 삭제 버튼 아이콘
        val deleteButtonIcon =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonIcon,
                R.drawable.btn_keyboard_del_black
            )

        // 삭제 버튼 크기
        val deleteButtonIconSize =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonIconSize,
                context.resources.getDimension(R.dimen.number_key_pad_default_icon_size)
            ).toInt()

        // 삭제 버튼 배경 색상
        val deleteButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼 리플 색상
        val deleteButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonRippleColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼 코너
        val deleteButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonCornerRadius,
                context.resources.getDimension(R.dimen.number_key_pad_default_corner_radius)
            ).toInt()

        // 삭제 버튼 테두리 두께
        val deleteButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonStrokeWidth,
                context.resources.getDimension(R.dimen.number_key_pad_default_stroke_width)
            ).toInt()

        // 삭제 버튼 테두리 색상
        val deleteButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDeleteButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 전체삭제 버튼 적용 여부
        val clearButtonEnabled =
            typedArray.getBoolean(
                R.styleable.NumberKeyPadStyle_nkpClearButtonEnabled,
                false
            )

        // 전체삭제 버튼 텍스트
        val clearButtonText =
            typedArray.getString(
                R.styleable.NumberKeyPadStyle_nkpClearButtonText
            )

        // 전체삭제 버튼 글자 크기
        val clearButtonTextSize =
            typedArray.getInt(
                R.styleable.NumberKeyPadStyle_nkpClearButtonTextSize,
                24
            )

        // 전체삭제 버튼 글자 색상
        val clearButtonTextColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpClearButtonTextColor,
                R.color.black_000000
            )

        // 전체삭제 버튼 배경 색상
        val clearButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpClearButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 전체삭제 버튼 리플 색상
        val clearButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpClearButtonRippleColor,
                R.color.transparent_00000000
            )

        // 전체삭제 버튼 코너
        val clearButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpClearButtonCornerRadius,
                context.resources.getDimension(R.dimen.number_key_pad_default_corner_radius)
            ).toInt()

        // 전체삭제 버튼 테두리 두께
        val clearButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpClearButtonStrokeWidth,
                context.resources.getDimension(R.dimen.number_key_pad_default_stroke_width)
            ).toInt()

        // 전체삭제 버튼 테두리 색상
        val clearButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpClearButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 구분선 색상
        val dividerColor =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpDividerColor,
                R.color.transparent_00000000
            )

        // 세로 구분선 폭
        val dividerWidth =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDividerWidth,
                context.resources.getDimension(R.dimen.number_key_pad_default_divider_width)
            ).toInt()

        // 가로 구분선 높이
        val dividerHeight =
            typedArray.getDimension(
                R.styleable.NumberKeyPadStyle_nkpDividerHeight,
                context.resources.getDimension(R.dimen.number_key_pad_default_divider_height)
            ).toInt()



        // 배경
        val rootBackgroundDrawable =
            typedArray.getResourceId(
                R.styleable.NumberKeyPadStyle_nkpRootBackgroundDrawable,
                R.color.white_ffffff
            )



        typedArray.recycle()

        // 설정
        setInit(
            textCheckFormat,
            textMaxLength,
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
     * 설정
     */
    private fun setInit(
        textCheckFormat: Boolean,
        textMaxLength: Int,
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

        // 기본 버튼
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

        // 구분선
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

        // 키 패드 값 포맷 체크 여부 설정
        setTextCheckFormat(textCheckFormat)

        // 키 패드 최대 글자 수 설정
        setTextMaxLength(textMaxLength)

        // 기본 버튼 설정
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

        // 전체삭제 버튼 설정
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

        // 구분선 설정
        setDivider(dividerColor, dividerWidth, dividerHeight)

        // 배경 설정
        setRootBackground(rootBackgroundDrawable)

        // BindView
        bindView()
    }



    /**
     * 키 패드 값 포맷 체크 여부 설정
     */
    private fun setTextCheckFormat(textCheckFormat: Boolean) {
        keyPadTextCheckFormat = textCheckFormat
    }



    /**
     * 키 패드 최대 글자 수 설정
     */
    fun setTextMaxLength(textMaxLength: Int) {
        keyPadTextMaxLength = textMaxLength
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
     * 전체삭제 버튼 설정
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
        viewBinding.rootLayout.apply {
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
                numberKeyPadListener?.numberKeyPadChanged(setAddKeyPadText(enterValue.toInt()))
            }
        }

        viewBinding.btnDelete.apply {
            // 삭제 버튼
            setOnClickListener {
                numberKeyPadListener?.numberKeyPadChanged(setDeleteKeyPadText())
            }

            // 삭제 버튼 크게 클릭
            setOnLongClickListener {
                setClearKeyPadText()
                true
            }

            // 전체삭제 버튼
            setOnClickListener {
                setClearKeyPadText()
            }
        }
    }



    /**
     * 입력값 Add
     */
    private fun setAddKeyPadText(enterValue: Int): String {
        // 입력값 최대 글자 수보다 작거나 같으면 add, 아니면 현재값 return
        if (keyPadTextValue.length < keyPadTextMaxLength) {
            keyPadTextValue += enterValue
        }

        // 입력값 포맷 체크 하는 경우
        if (keyPadTextCheckFormat) {
            when {
                // 입력값이 00 으로 시작하면 0 으로 치환
                keyPadTextValue.startsWith("00") -> {
                    keyPadTextValue = "0"
                }

                // 입력값이 01, 02... 패턴식으로 시작하면 0 제거
                keyPadTextValue.matches("^0[1-9]".toRegex()) -> {
                    keyPadTextValue = keyPadTextValue.replace("0", "")
                }
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
        numberKeyPadListener?.numberKeyPadChanged(keyPadTextValue)
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
    interface NumberKeyPadListener {
        fun numberKeyPadChanged(keyPadValue: String)
    }

    fun setNumberKeyPadListener(numberKeyPadListener: NumberKeyPadListener) {
        this.numberKeyPadListener = numberKeyPadListener
    }
}
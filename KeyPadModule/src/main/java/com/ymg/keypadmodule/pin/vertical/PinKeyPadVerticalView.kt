package com.ymg.keypadmodule.pin.vertical

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.ymg.keypadmodule.R
import com.ymg.keypadmodule.pin.indicator.PinIndicatorView
import kotlinx.android.synthetic.main.view_pin_key_pad_vertical.view.*
import java.util.*
import kotlin.collections.ArrayList


class PinKeyPadVerticalView @JvmOverloads
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
    private val defaultButtonList: MutableList<MaterialButton> = ArrayList(TOTAL_DEFAULT_BUTTON_COUNT)
    private val dividerList: MutableList<View> = ArrayList(TOTAL_DIVIDER_COUNT)

    // 입력값, 입력 가능한 최대 글자 수
    private var keyPadTextValue = ""
    private var keyPadTextMaxLength: Int = 0

    // 기본 버튼 값 Array
    private val defaultButtonValueArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 삭제 버튼, 전체삭제 버튼, Root Layout
    private var btnDelete: MaterialButton? = null
    private var btnClear: MaterialButton? = null
    private var rootLayout: LinearLayout? = null

    // 키 패드 리스너
    private var pinKeyPadVerticalListener: PinKeyPadVerticalListener? = null

    // Pin Indicator 리스너
    private var pinIndicatorView: PinIndicatorView? = null



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.PinKeyPadVerticalStyle, defStyleAttr, defStyleAttr)

        // 기본 버튼 글자 크기
        val defaultButtonTextSize =
            typedArray.getInt(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonTextSize,
                24
            )

        // 기본 버튼 글자 색상
        val defaultButtonTextColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonTextColor,
                R.color.black_000000
            )

        // 기본 버튼 배경 색상
        val defaultButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 기본 버튼 리플 색상
        val defaultButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonRippleColor,
                R.color.transparent_00000000
            )

        // 기본 버튼 코너
        val defaultButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_corner_radius)
            ).toInt()

        // 기본 버튼 테두리 두께
        val defaultButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_stroke_width)
            ).toInt()

        // 기본 버튼 테두리 색상
        val defaultButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDefaultButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 삭제 버튼 아이콘
        val deleteButtonIcon =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonIcon,
                R.drawable.btn_keyboard_del_black
            )

        // 삭제 버튼 크기
        val deleteButtonIconSize =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonIconSize,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_icon_size)
            ).toInt()

        // 삭제 버튼 배경 색상
        val deleteButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼 리플 색상
        val deleteButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonRippleColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼 코너
        val deleteButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_corner_radius)
            ).toInt()

        // 삭제 버튼 테두리 두께
        val deleteButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_stroke_width)
            ).toInt()

        // 삭제 버튼 테두리 색상
        val deleteButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDeleteButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 전체삭제 버튼 적용 여부
        val clearButtonEnabled =
            typedArray.getBoolean(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonEnabled,
                false
            )

        // 전체삭제 버튼 텍스트
        val clearButtonText =
            typedArray.getString(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonText
            )

        // 전체삭제 버튼 글자 크기
        val clearButtonTextSize =
            typedArray.getInt(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonTextSize,
                24
            )

        // 전체삭제 버튼 글자 색상
        val clearButtonTextColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonTextColor,
                R.color.black_000000
            )

        // 전체삭제 버튼 배경 색상
        val clearButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 전체삭제 버튼 리플 색상
        val clearButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonRippleColor,
                R.color.transparent_00000000
            )

        // 전체삭제 버튼 코너
        val clearButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_corner_radius)
            ).toInt()

        // 전체삭제 버튼 테두리 두께
        val clearButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_stroke_width)
            ).toInt()

        // 전체삭제 버튼 테두리 색상
        val clearButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvClearButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 구분선 색상
        val dividerColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvDividerColor,
                R.color.transparent_00000000
            )

        // 세로 구분선 폭
        val dividerWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDividerWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_divider_width)
            ).toInt()

        // 가로 구분선 높이
        val dividerHeight =
            typedArray.getDimension(
                R.styleable.PinKeyPadVerticalStyle_pkpvDividerHeight,
                context.resources.getDimension(R.dimen.pin_key_pad_vertical_default_divider_height)
            ).toInt()



        // 배경
        val rootBackgroundDrawable =
            typedArray.getResourceId(
                R.styleable.PinKeyPadVerticalStyle_pkpvRootBackgroundDrawable,
                R.color.white_ffffff
            )



        typedArray.recycle()

        // 설정
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
     * 설정
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
        val container = View.inflate(context, R.layout.view_pin_key_pad_vertical, this)
        btnDelete = container.findViewById(R.id.btnDelete)
        btnClear = container.findViewById(R.id.btnClear)
        rootLayout = container.findViewById(R.id.rootLayout)

        // 숫자 버튼
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


        // 기본 버튼 섞기 설정
        setDefaultButtonShuffle()

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
     * 섞기 여부 설정
     */
    private fun setDefaultButtonShuffle() {
        val keyPad: IntArray? = getDefaultButtonSwap(defaultButtonValueArray)
        keyPad?.let {
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

    private fun getDefaultButtonSwap(intArray: IntArray): IntArray? {
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
     * 기본 버튼 설정
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
        btnClear?.apply {
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
                pinKeyPadVerticalListener?.pinKeyPadVerticalChanged(setAddKeyPadText(enterValue.toInt()))
            }
        }

        // 삭제 버튼
        btnDelete?.setOnClickListener {
            pinKeyPadVerticalListener?.pinKeyPadVerticalChanged(setDeleteKeyPadText())
        }

        // 삭제 버튼 크게 클릭
        btnDelete?.setOnLongClickListener {
            setClearKeyPadText()
            true
        }

        // 전체삭제 버튼
        btnClear?.setOnClickListener {
            setClearKeyPadText()
        }
    }



    /**
     * 입력값 Add
     */
    private fun setAddKeyPadText(enterValue: Int): String {
        // 입력값 최대 글자 수보다 작거나 같으면 add, 아니면 현재값 return
        if (keyPadTextValue.length < keyPadTextMaxLength) {
            keyPadTextValue += enterValue
            pinIndicatorView?.setUpdateDot(keyPadTextValue.length)
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

        pinIndicatorView?.setUpdateDot(keyPadTextValue.length)

        return keyPadTextValue
    }



    /**
     * 입력값 초기화
     */
    fun setClearKeyPadText() {
        keyPadTextValue = ""
        pinKeyPadVerticalListener?.pinKeyPadVerticalChanged(keyPadTextValue)
        pinIndicatorView?.setUpdateDot(keyPadTextValue.length)
    }



    /**
     * 입력값 가져오기
     */
    fun getKeyPadText(): String {
        return keyPadTextValue
    }



    /**
     *  Pin Indicator 과 연결
     */
    fun setAttachPinIndicatorView(pinIndicatorView: PinIndicatorView) {
        this.pinIndicatorView = pinIndicatorView

        // 입력값 최대 자리 수 Pin Indicator Dot 길이 값과 동일하게 설정
        this.pinIndicatorView?.let {
            keyPadTextMaxLength = it.getIndicatorDotLength()
        }
    }





    /**
     * 키 패드 리스너
     */
    interface PinKeyPadVerticalListener {
        fun pinKeyPadVerticalChanged(keyPadValue: String)
    }

    fun setPinKeyPadVerticalListener(pinKeyPadVerticalListener: PinKeyPadVerticalListener) {
        this.pinKeyPadVerticalListener = pinKeyPadVerticalListener
    }
}
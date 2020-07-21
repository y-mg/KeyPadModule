package com.ymg.keypadmodule.pin.horizontal

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
import kotlinx.android.synthetic.main.view_pin_key_pad_horizontal.view.*
import java.util.*
import kotlin.collections.ArrayList



class PinKeyPadHorizontalView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    companion object {
        // 기본 버튼 총 수
        const val TOTAL_DEFAULT_BUTTON_COUNT = 12

        // 빈 버튼 총 수
        const val TOTAL_EMPTY_BUTTON_COUNT = 2

        // 구분선 총 수
        const val TOTAL_DIVIDER_COUNT = 13
    }

    // 기본 버튼 리스트, 빈 버튼 리스트, 구분선 리스트
    private val defaultButtonList: MutableList<MaterialButton> = ArrayList(TOTAL_DEFAULT_BUTTON_COUNT)
    private val emptyButtonList: MutableList<MaterialButton> = ArrayList(TOTAL_EMPTY_BUTTON_COUNT)
    private val dividerList: MutableList<View> = ArrayList(TOTAL_DIVIDER_COUNT)

    // 입력값, 입력 가능한 최대 글자 수
    private var keyPadTextValue = ""
    private var keyPadTextMaxLength: Int = 0

    // 기본 버튼 값 Array
    private val defaultButtonValueArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

    // 삭제 버튼, 전체삭제 버튼, Root Layout
    private var btnDelete: MaterialButton? = null
    private var btnClear: MaterialButton? = null
    private var rootLayout: LinearLayout? = null

    // 키 패드 리스너
    private var pinKeyPadHorizontalListener: PinKeyPadHorizontalListener? = null

    // Pin Indicator 리스너
    private var pinIndicatorView: PinIndicatorView? = null



    init {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.PinKeyPadHorizontalStyle, defStyleAttr, defStyleAttr)

        // 기본 버튼 글자 크기
        val defaultButtonTextSize =
            typedArray.getInt(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonTextSize,
                24
            )

        // 기본 버튼 글자 색상
        val defaultButtonTextColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonTextColor,
                R.color.black_000000
            )

        // 기본 버튼 배경 색상
        val defaultButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 기본 버튼 리플 색상
        val defaultButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonRippleColor,
                R.color.transparent_00000000
            )

        // 기본 버튼 코너
        val defaultButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_corner_radius)
            ).toInt()

        // 기본 버튼 테두리 두께
        val defaultButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_stroke_width)
            ).toInt()

        // 기본 버튼 테두리 색상
        val defaultButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDefaultButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 삭제 버튼 아이콘
        val deleteButtonIcon =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonIcon,
                R.drawable.btn_keyboard_del_black
            )

        // 삭제 버튼 크기
        val deleteButtonIconSize =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonIconSize,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_icon_size)
            ).toInt()

        // 삭제 버튼 배경 색상
        val deleteButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼 리플 색상
        val deleteButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonRippleColor,
                R.color.transparent_00000000
            )

        // 삭제 버튼 코너
        val deleteButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_corner_radius)
            ).toInt()

        // 삭제 버튼 테두리 두께
        val deleteButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_stroke_width)
            ).toInt()

        // 삭제 버튼 테두리 색상
        val deleteButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDeleteButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 빈 버튼 아이콘
        val emptyButtonIcon =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonIcon,
                R.drawable.btn_empty
            )

        // 빈 버튼 크기
        val emptyButtonIconSize =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonIconSize,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_icon_size)
            ).toInt()

        // 빈 버튼 배경 색상
        val emptyButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 빈 버튼 코너
        val emptyButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_corner_radius)
            ).toInt()

        // 빈 버튼 테두리 두께
        val emptyButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_stroke_width)
            ).toInt()

        // 빈 버튼 테두리 색상
        val emptyButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphEmptyButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 전체삭제 버튼 텍스트
        val clearButtonText =
            typedArray.getString(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonText
            )

        // 전체삭제 버튼 글자 크기
        val clearButtonTextSize =
            typedArray.getInt(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonTextSize,
                24
            )

        // 전체삭제 버튼 글자 색상
        val clearButtonTextColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonTextColor,
                R.color.black_000000
            )

        // 전체삭제 버튼 배경 색상
        val clearButtonBackgroundColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonBackgroundColor,
                R.color.transparent_00000000
            )

        // 전체삭제 버튼 리플 색상
        val clearButtonRippleColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonRippleColor,
                R.color.transparent_00000000
            )

        // 전체삭제 버튼 코너
        val clearButtonCornerRadius =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonCornerRadius,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_corner_radius)
            ).toInt()

        // 전체삭제 버튼 테두리 두께
        val clearButtonStrokeWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonStrokeWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_stroke_width)
            ).toInt()

        // 전체삭제 버튼 테두리 색상
        val clearButtonStrokeColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphClearButtonStrokeColor,
                R.color.transparent_00000000
            )



        // 구분선 색상
        val dividerColor =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphDividerColor,
                R.color.transparent_00000000
            )

        // 세로 구분선 폭
        val dividerWidth =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDividerWidth,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_divider_width)
            ).toInt()

        // 가로 구분선 높이
        val dividerHeight =
            typedArray.getDimension(
                R.styleable.PinKeyPadHorizontalStyle_pkphDividerHeight,
                context.resources.getDimension(R.dimen.pin_key_pad_horizontal_default_divider_height)
            ).toInt()



        // 배경
        val rootBackgroundDrawable =
            typedArray.getResourceId(
                R.styleable.PinKeyPadHorizontalStyle_pkphRootBackgroundDrawable,
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
        val container = View.inflate(context, R.layout.view_pin_key_pad_horizontal, this)
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
            add(container.findViewById(R.id.btn10))
            add(container.findViewById(R.id.btn11))
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
            add(container.findViewById(R.id.divider12))
            add(container.findViewById(R.id.divider13))
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
            clearButtonText,
            clearButtonTextSize,
            clearButtonTextColor,
            clearButtonBackgroundColor,
            clearButtonRippleColor,
            clearButtonCornerRadius,
            clearButtonStrokeWidth,
            clearButtonStrokeColor
        )

        // 빈 버튼 설정
        setEmptyButton(
            emptyButtonIcon,
            emptyButtonIconSize,
            emptyButtonBackgroundColor,
            emptyButtonCornerRadius,
            emptyButtonStrokeWidth,
            emptyButtonStrokeColor
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
            btn10.text = it[10].toString()
            btn11.text = it[11].toString()
        }

        // 섞기 후 값이 11 or 12를 가지고 있는 버튼을 빈 버튼 리스트에 추가
        defaultButtonList.forEach {
            val enterValue = it.text.toString()

            if (enterValue == "10" || enterValue == "11") {
                emptyButtonList.add(it)
            }
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
     * 빈 버튼 설정
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
            // 빈 버튼 비활성화
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
                pinKeyPadHorizontalListener?.pinKeyPadHorizontalChanged(setAddKeyPadText(enterValue.toInt()))
            }
        }

        // 삭제 버튼
        btnDelete?.setOnClickListener {
            pinKeyPadHorizontalListener?.pinKeyPadHorizontalChanged(setDeleteKeyPadText())
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
        pinKeyPadHorizontalListener?.pinKeyPadHorizontalChanged(keyPadTextValue)
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
    interface PinKeyPadHorizontalListener {
        fun pinKeyPadHorizontalChanged(keyPadValue: String)
    }

    fun setPinKeyPadHorizontalListener(pinKeyPadHorizontalListener: PinKeyPadHorizontalListener) {
        this.pinKeyPadHorizontalListener = pinKeyPadHorizontalListener
    }
}
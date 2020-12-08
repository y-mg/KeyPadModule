# KeyPadModule
<img width="250px" height="500px" src="/sample/number.gif" /> <img width="250px" height="500px" src="/sample/decimal.gif" />
<img width="250px" height="500px" src="/sample/vertical.gif" /> <img width="250px" height="500px" src="/sample/horizontal.gif" />
<br/>
<br/>



## 1. NumberKeyPadView

> 이것은 숫자 입력 키 패드입니다.<br/>
> This is the number input key pad.


### XML Attributes

```xml
<com.ymg.keypadmodule.number.NumberKeyPadView
    android:layout_width="match_parent"
    android:layout_height="400dp"
    app:nkpCheckFormat="false"
    app:nkpMaxLength="10"
    app:nkpDefaultButtonTextSize="12"
    app:nkpDefaultButtonTextColor="@color/red_ff0016"
    app:nkpDefaultButtonBackgroundColor="@color/blue_1161c5"
    app:nkpDefaultButtonRippleColor="@color/red_ff0016"
    app:nkpDefaultButtonCornerRadius="3dp"
    app:nkpDefaultButtonStrokeWidth="2dp"
    app:nkpDefaultButtonStrokeColor="@color/gray_ebebeb"
    app:nkpDeleteButtonIcon="@drawable/icon_back"
    app:nkpDeleteButtonIconSize="12dp"
    app:nkpDeleteButtonBackgroundColor="@color/blue_1161c5"
    app:nkpDeleteButtonRippleColor="@color/red_ff0016"
    app:nkpDeleteButtonCornerRadius="3dp"
    app:nkpDeleteButtonStrokeWidth="2dp"
    app:nkpDeleteButtonStrokeColor="@color/gray_ebebeb"
    app:nkpClearButtonEnabled="true"
    app:nkpClearButtonText="CLEAR"
    app:nkpClearButtonTextSize="12"
    app:nkpClearButtonTextColor="@color/red_ff0016"
    app:nkpClearButtonBackgroundColor="@color/blue_1161c5"
    app:nkpClearButtonRippleColor="@color/red_ff0016"
    app:nkpClearButtonCornerRadius="3dp"
    app:nkpClearButtonStrokeWidth="2dp"
    app:nkpClearButtonStrokeColor="@color/gray_ebebeb"
    app:nkpDividerColor="@color/red_ff0016"
    app:nkpDividerWidth="3dp"
    app:nkpDividerHeight="3dp"
    app:nkpRootBackgroundDrawable="@color/black_000000" />
```
- app:nkpCheckFormat
    - Format 을 체크한다.(true: Integer, false: Number)
    - Check the format.(true: Integer, false: Number)

- app:nkpMaxLength
    - 입력할 수 있는 자릿수를 설정한다.
    - Sets the number of digits that can be entered.

- app:nkpDefaultButtonTextSize
    - 기본 버튼의 글자 크기를 설정한다.
    - Sets the letter size of the default button.

- app:nkpDefaultButtonTextColor
    - 기본 버튼의 글자 색상을 설정한다.
    - Sets the text color of the default button.

- app:nkpDefaultButtonBackgroundColor
    - 기본 버튼의 배경색을 설정한다.
    - Sets the background color of the default button.

- app:nkpDefaultButtonRippleColor
    - 기본 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the default button.

- app:nkpDefaultButtonCornerRadius
    - 기본 버튼의 코너를 설정한다.
    - Set the corner of the default button.

- app:nkpDefaultButtonStrokeWidth
    - 기본 버튼의 테두리 두께를 설정한다.
    - Set the border thickness of the default button.

- app:nkpDefaultButtonStrokeColor
    - 기본 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the default button.

- app:nkpDeleteButtonIcon
    - 삭제 버튼의 아이콘을 설정한다.
    - Set the icon for the delete button.

- app:nkpDeleteButtonIconSize
    - 삭제 버튼의 아이콘 크기를 설정한다.
    - Sets the size of the icon for the delete button.

- app:nkpDeleteButtonBackgroundColor
    - 삭제 버튼의 배경색을 설정한다.
    - Sets the background color of the delete button.

- app:nkpDeleteButtonRippleColor
    - 삭제 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the delete button.

- app:nkpDeleteButtonCornerRadius
    - 삭제 버튼의 코너를 설정한다.
    - Set the corner of the delete button.

- app:nkpDeleteButtonStrokeWidth
    - 삭제 버튼의 테두리 두께를 설정한다.
    - Sets the border thickness of the delete button.

- app:nkpDeleteButtonStrokeColor
    - 삭제 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the delete button.

- app:nkpClearButtonEnabled
    - 클리어 버튼의 적용 여부를 설정한다.
    - Sets whether the clear button is applied.

- app:nkpClearButtonText
    - 클리어 버튼의 텍스트를 설정한다.
    - Sets the text of the clear button.

- app:nkpClearButtonTextSize
    - 클리어 버튼의 글자 크기를 설정한다.
    - Sets the letter size of the clear button.

- app:nkpClearButtonTextColor
    - 클리어 버튼의 글자 색상을 설정한다.
    - Sets the character color of the clear button.

- app:nkpClearButtonBackgroundColor
    - 클리어 버튼의 배경색을 설정한다.
    - Set the background color of the clear button.

- app:nkpClearButtonRippleColor
    - 클리어 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the clear button.

- app:nkpClearButtonCornerRadius
    - 클리어 버튼의 테두리를 설정한다.
    - Set the border of the clear button.

- app:nkpClearButtonStrokeWidth
    - 클리어 버튼의 테두리 두께를 설정한다.
    - Set the border thickness of the clear button.

- app:nkpClearButtonStrokeColor
    - 클리어 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the clear button.

- app:nkpDividerColor
    - 구분선의 색상을 설정한다.
    - Sets the color of the dividing line.

- app:nkpDividerWidth
    - 세로 구분선의 폭을 설정한다.
    - Sets the width of the vertical divider.

- app:nkpDividerHeight
    - 가로 구분선의 높이를 설정한다.
    - Sets the height of the horizontal divider.

- app:nkpRootBackgroundDrawable
    - 배경색을 설정한다.
    - Set background color.


### Kotlin Function

```kotlin
/**
 * - 입력할 수 있는 자릿수를 설정한다.
 * - Sets the number of digits that can be entered.
 *
 * @param maxLength -> Number of digits to be able to enter
 */
fun setMaxLength(maxLength: Int)

/**
 * - 입력값을 초기화한다.
 * - Initialize the input value.
 */
fun setClear()

/**
 * - 입력값을 설정한다.
 * - Set the input value.
 *
 * @param value -> Input Value
 */
fun setValue(value: String)

/**
 * - 입력값을 가져온다.
 * - Gets the input value.
 */
fun getValue()
```


### Directions For Use

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewBinding = ActivityNumberKeyPadBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)
    viewBinding.numberKeyPadView.setNumberKeyPadListener(numberKeyPadListener)
}

private var numberKeyPadListener = object : NumberKeyPadView.NumberKeyPadListener {
    override fun numberKeyPadChanged(value: String) {}
}
```
<br/>
<br/>



## 2. DecimalKeyPadView

> 이것은 소수 입력 키 패드입니다.<br/>
> This is the decimal input key pad.


### XML Attributes

```xml
<com.ymg.keypadmodule.decimal.DecimalKeyPadView
    android:layout_width="match_parent"
    android:layout_height="400dp"
    app:dkpMaxLength="20"
    app:dkpDecimalCut="6"
    app:dkpDefaultButtonTextSize="12"
    app:dkpDefaultButtonTextColor="@color/red_ff0016"
    app:dkpDefaultButtonBackgroundColor="@color/blue_1161c5"
    app:dkpDefaultButtonRippleColor="@color/red_ff0016"
    app:dkpDefaultButtonCornerRadius="3dp"
    app:dkpDefaultButtonStrokeWidth="2dp"
    app:dkpDefaultButtonStrokeColor="@color/gray_ebebeb"
    app:dkpDeleteButtonIcon="@drawable/icon_back"
    app:dkpDeleteButtonIconSize="12dp"
    app:dkpDeleteButtonBackgroundColor="@color/blue_1161c5"
    app:dkpDeleteButtonRippleColor="@color/red_ff0016"
    app:dkpDeleteButtonCornerRadius="3dp"
    app:dkpDeleteButtonStrokeWidth="2dp"
    app:dkpDeleteButtonStrokeColor="@color/gray_ebebeb"
    app:dkpDotButtonTextSize="12"
    app:dkpDotButtonTextColor="@color/red_ff0016"
    app:dkpDotButtonBackgroundColor="@color/blue_1161c5"
    app:dkpDotButtonRippleColor="@color/red_ff0016"
    app:dkpDotButtonCornerRadius="3dp"
    app:dkpDotButtonStrokeWidth="2dp"
    app:dkpDotButtonStrokeColor="@color/gray_ebebeb"
    app:dkpDividerColor="@color/red_ff0016"
    app:dkpDividerWidth="3dp"
    app:dkpDividerHeight="3dp"
    app:dkpRootBackgroundDrawable="@color/black_000000" />
```
- app:dkpMaxLength
    - 입력할 수 있는 자릿수를 설정한다.
    - Sets the number of digits that can be entered.

- app:dkpDecimalCut
    - 소수점 이하 자릿수를 설정한다.
    - Sets the decimal place.

- app:dkpDefaultButtonTextSize
    - 기본 버튼의 글자 크기를 설정한다.
    - Sets the letter size of the default button.

- app:dkpDefaultButtonTextColor
    - 기본 버튼의 글자 색상을 설정한다.
    - Sets the text color of the default button.

- app:dkpDefaultButtonBackgroundColor
    - 기본 버튼의 배경색을 설정한다.
    - Sets the background color of the default button.

- app:dkpDefaultButtonRippleColor
    - 기본 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the default button.

- app:dkpDefaultButtonCornerRadius
    - 기본 버튼의 코너를 설정한다.
    - Set the corner of the default button.

- app:dkpDefaultButtonStrokeWidth
    - 기본 버튼의 테두리 두께를 설정한다.
    - Set the border thickness of the default button.

- app:dkpDefaultButtonStrokeColor
    - 기본 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the default button.

- app:dkpDeleteButtonIcon
    - 삭제 버튼의 아이콘을 설정한다.
    - Set the icon for the delete button.

- app:dkpDeleteButtonIconSize
    - 삭제 버튼의 아이콘 크기를 설정한다.
    - Sets the size of the icon for the delete button.

- app:dkpDeleteButtonBackgroundColor
    - 삭제 버튼의 배경색을 설정한다.
    - Sets the background color of the delete button.

- app:dkpDeleteButtonRippleColor
    - 삭제 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the delete button.

- app:dkpDeleteButtonCornerRadius
    - 삭제 버튼의 코너를 설정한다.
    - Set the corner of the delete button.

- app:dkpDeleteButtonStrokeWidth
    - 삭제 버튼의 테두리 두께를 설정한다.
    - Sets the border thickness of the delete button.

- app:dkpDeleteButtonStrokeColor
    - 삭제 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the delete button.

- app:dkpDotButtonTextSize
    - 점 버튼의 글자 크기를 설정한다.
    - Sets the letter size of the dot button.

- app:dkpDotButtonTextColor
    - 점 버튼의 글자 색상을 설정한다.
    - Sets the character color of the dot button.

- app:dkpDotButtonBackgroundColor
    - 점 버튼의 배경색을 설정한다.
    - Set the background color of the dot button.

- app:dkpDotButtonRippleColor
    - 점 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the dot button.

- app:dkpDotButtonCornerRadius
    - 점 버튼의 테두리를 설정한다.
    - Set the border of the dot button.

- app:dkpDotButtonStrokeWidth
    - 점 버튼의 테두리 두께를 설정한다.
    - Set the border thickness of the dot button.

- app:dkpDotButtonStrokeColor
    - 점 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the dot button.

- app:dkpDividerColor
    - 구분선의 색상을 설정한다.
    - Sets the color of the dividing line.

- app:dkpDividerWidth
    - 세로 구분선의 폭을 설정한다.
    - Sets the width of the vertical divider.

- app:dkpDividerHeight
    - 가로 구분선의 높이를 설정한다.
    - Sets the height of the horizontal divider.

- app:dkpRootBackgroundDrawable
    - 배경색을 설정한다.
    - Set background color.


### Kotlin Function

```kotlin
/**
 * - 입력할 수 있는 자릿수를 설정한다.
 * - Sets the number of digits that can be entered.
 *
 * @param maxLength -> Number of digits to be able to enter
 */
fun setMaxLength(maxLength: Int)

/**
 * - 소수점 이하 자릿수를 설정한다.
 * - Sets the decimal place.
 *
 * @param decimalCut -> Decimal Digit
 */
fun setDecimalCut(decimalCut: Int)

/**
 * - 입력값을 초기화한다.
 * - Initialize the input value.
 */
fun setClear()

/**
 * - 입력값을 설정한다.
 * - Set the input value.
 *
 * @param value -> Input Value
 */
fun setValue(value: String)

/**
 * - 입력값을 가져온다.
 * - Gets the input value.
 */
fun getValue()
```


### Directions For Use

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewBinding = ActivityDecimalKeyPadBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)
    viewBinding.decimalKeyPadView.setDecimalKeyPadListener(decimalKeyPadListener)
}

private var decimalKeyPadListener = object : DecimalKeyPadView.DecimalKeyPadListener {
    override fun decimalKeyPadChanged(value: String) {}
}
```
<br/>
<br/>



## 3. PinIndicatorView

> 이것은 PinKeyPad 와 함께 사용되는 PinIndicator 입니다.<br/>
> This is the PinIndicator used with PinKeyPad.


### XML Attributes

```xml
<com.ymg.keypadmodule.pin.indicator.PinIndicatorView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:piDotLength="4"
    app:piDotDiameter="32dp"
    app:piDotSpace="3dp"
    app:piFillDot="@drawable/icon_pin_on"
    app:piEmptyDot="@drawable/icon_pin_off" />
```
- app:piDotLength
    - 점의 자릿수를 설정한다.
    - Sets the number of digits of a dot.

- app:piDotDiameter
    - 점의 지름을 설정한다.
    - Sets the diameter of a dot.

- app:piDotSpace
    - 점과 점 사이의 공간을 설정한다.
    - Sets the space between the dot and the dot.

- app:piFillDot
    - 채워진 점의 아이콘을 설정한다.
    - Sets the icon for the filled dot.

- app:piEmptyDot
    - 비워진 점의 아이콘을 설정한다.
    - Sets the icon of an empty dot.
<br/>
<br/>



## 4. PinKeyPadVerticalView


> 이것은 PinIndicator 와 함께 사용되는 PinKeyPad(Vertical) 입니다.<br/>
> This is the PinKeyPad(Vertical) used with PinIndicator.


### XML

```xml
<com.ymg.keypadmodule.pin.vertical.PinKeyPadVerticalView
    android:layout_width="match_parent"
    android:layout_height="300dp"
    app:pkphDefaultButtonTextSize="12"
    app:pkpvDefaultButtonTextColor="@color/red_ff0016"
    app:pkpvDefaultButtonBackgroundColor="@color/blue_1161c5"
    app:pkpvDefaultButtonRippleColor="@color/red_ff0016"
    app:pkpvDefaultButtonCornerRadius="3dp"
    app:pkpvDefaultButtonStrokeWidth="2dp"
    app:pkpvDefaultButtonStrokeColor="@color/gray_ebebeb"
    app:pkpvDeleteButtonIcon="@drawable/icon_back"
    app:pkpvDeleteButtonIconSize="12dp"
    app:pkpvDeleteButtonBackgroundColor="@color/blue_1161c5"
    app:pkpvDeleteButtonRippleColor="@color/red_ff0016"
    app:pkpvDeleteButtonCornerRadius="3dp"
    app:pkpvDeleteButtonStrokeWidth="2dp"
    app:pkpvDeleteButtonStrokeColor="@color/gray_ebebeb"
    app:pkpvClearButtonEnabled="true"
    app:pkpvClearButtonText="CLEAR"
    app:pkpvClearButtonTextSize="12"
    app:pkpvClearButtonTextColor="@color/red_ff0016"
    app:pkpvClearButtonBackgroundColor="@color/blue_1161c5"
    app:pkpvClearButtonRippleColor="@color/red_ff0016"
    app:pkpvClearButtonCornerRadius="3dp"
    app:pkpvClearButtonStrokeWidth="2dp"
    app:pkpvClearButtonStrokeColor="@color/gray_ebebeb"
    app:pkpvDividerColor="@color/red_ff0016"
    app:pkpvDividerWidth="3dp"
    app:pkpvDividerHeight="3dp"
    app:pkpvRootBackgroundDrawable="@color/black_000000" />
```
- app:pkpvDefaultButtonTextSize
    - 기본 버튼의 글자 크기를 설정한다.
    - Sets the letter size of the default button.

- app:pkpvDefaultButtonTextColor
    - 기본 버튼의 글자 색상을 설정한다.
    - Sets the text color of the default button.

- app:pkpvDefaultButtonBackgroundColor
    - 기본 버튼의 배경색을 설정한다.
    - Sets the background color of the default button.

- app:pkpvDefaultButtonRippleColor
    - 기본 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the default button.

- app:pkpvDefaultButtonCornerRadius
    - 기본 버튼의 코너를 설정한다.
    - Set the corner of the default button.

- app:pkpvDefaultButtonStrokeWidth
    - 기본 버튼의 테두리 두께를 설정한다.
    - Set the border thickness of the default button.

- app:pkpvDefaultButtonStrokeColor
    - 기본 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the default button.

- app:pkpvDeleteButtonIcon
    - 삭제 버튼의 아이콘을 설정한다.
    - Set the icon for the delete button.

- app:pkpvDeleteButtonIconSize
    - 삭제 버튼의 아이콘 크기를 설정한다.
    - Sets the size of the icon for the delete button.

- app:pkpvDeleteButtonBackgroundColor
    - 삭제 버튼의 배경색을 설정한다.
    - Sets the background color of the delete button.

- app:pkpvDeleteButtonRippleColor
    - 삭제 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the delete button.

- app:pkpvDeleteButtonCornerRadius
    - 삭제 버튼의 코너를 설정한다.
    - Set the corner of the delete button.

- app:pkpvDeleteButtonStrokeWidth
    - 삭제 버튼의 테두리 두께를 설정한다.
    - Sets the border thickness of the delete button.

- app:pkpvDeleteButtonStrokeColor
    - 삭제 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the delete button.

- app:pkpvClearButtonEnabled
    - 클리어 버튼 사용 여부를 설정한다.
    - Set whether or not to use the clear button.

- app:pkpvClearButtonText
    - 클리어 버튼의 텍스트를 설정한다.
    - Sets the text of the clear button.

- app:pkpvClearButtonTextSize
    - 클리어 버튼의 글자 크기를 설정한다.
    - Sets the letter size of the clear button.

- app:pkpvClearButtonTextColor
    - 클리어 버튼의 글자 색상을 설정한다.
    - Sets the character color of the clear button.

- app:pkpvClearButtonBackgroundColor
    - 클리어 버튼의 배경색을 설정한다.
    - Set the background color of the clear button.

- app:pkpvClearButtonRippleColor
    - 클리어 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the clear button.

- app:pkpvClearButtonCornerRadius
    - 클리어 버튼의 테두리를 설정한다.
    - Set the border of the clear button.

- app:pkpvClearButtonStrokeWidth
    - 클리어 버튼의 테두리 두께를 설정한다.
    - Set the border thickness of the clear button.

- app:pkpvClearButtonStrokeColor
    - 클리어 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the clear button.

- app:pkpvDividerColor
    - 구분선의 색상을 설정한다.
    - Sets the color of the dividing line.

- app:pkpvDividerWidth
    - 세로 구분선의 폭을 설정한다.
    - Sets the width of the vertical divider.

- app:pkpvDividerHeight
    - 가로 구분선의 높이를 설정한다.
    - Sets the height of the horizontal divider.

- app:pkpvRootBackgroundDrawable
    - 배경색을 설정한다.
    - Set background color.


### Kotlin Function

```kotlin
/**
 * - 입력값을 초기화한다.
 * - Initialize the input value.
 */
fun setClear()

/**
 * - 입력값을 가져온다.
 * - Gets the input value.
 */
fun getValue()
```


### Directions For Use

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewBinding = ActivityPinKeyPadVerticalBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    viewBinding.apply {
        pinKeyPadVerticalView.setAttachPinIndicatorView(pinIndicatorView)
        pinKeyPadVerticalView.setPinKeyPadVerticalListener(pinKeyPadVerticalListener)
    }
}

private var pinKeyPadVerticalListener = object : PinKeyPadVerticalView.PinKeyPadVerticalListener {
    override fun pinKeyPadVerticalChanged(value: String) {}
}
```
<br/>
<br/>



## 5. PinKeyPadHorizontalView

> 이것은 PinIndicator 와 함께 사용되는 PinKeyPad(Horizontal) 입니다.<br/>
> This is the PinKeyPad(Horizontal) used with PinIndicator.


### XML

```xml
<com.ymg.keypadmodule.pin.horizontal.PinKeyPadHorizontalView
    android:layout_width="match_parent"
    android:layout_height="300dp"
    app:pkphDefaultButtonTextSize="12"
    app:pkphDefaultButtonTextColor="@color/red_ff0016"
    app:pkphDefaultButtonBackgroundColor="@color/blue_1161c5"
    app:pkphDefaultButtonRippleColor="@color/red_ff0016"
    app:pkphDefaultButtonCornerRadius="3dp"
    app:pkphDefaultButtonStrokeWidth="2dp"
    app:pkphDefaultButtonStrokeColor="@color/gray_ebebeb"
    app:pkphDeleteButtonIcon="@drawable/icon_back"
    app:pkphDeleteButtonIconSize="12dp"
    app:pkphDeleteButtonBackgroundColor="@color/blue_1161c5"
    app:pkphDeleteButtonRippleColor="@color/red_ff0016"
    app:pkphDeleteButtonCornerRadius="3dp"
    app:pkphDeleteButtonStrokeWidth="2dp"
    app:pkphDeleteButtonStrokeColor="@color/gray_ebebeb"
    app:pkphClearButtonText="CLEAR"
    app:pkphClearButtonTextSize="12"
    app:pkphClearButtonTextColor="@color/red_ff0016"
    app:pkphClearButtonBackgroundColor="@color/blue_1161c5"
    app:pkphClearButtonRippleColor="@color/red_ff0016"
    app:pkphClearButtonCornerRadius="3dp"
    app:pkphClearButtonStrokeWidth="2dp"
    app:pkphClearButtonStrokeColor="@color/gray_ebebeb"
    app:pkphEmptyButtonIcon="@drawable/icon_close"
    app:pkphEmptyButtonIconSize="12dp"
    app:pkphEmptyButtonBackgroundColor="@color/gray_ebebeb"
    app:pkphEmptyButtonCornerRadius="0dp"
    app:pkphEmptyButtonStrokeWidth="0dp"
    app:pkphEmptyButtonStrokeColor="@color/transparent_00000000"
    app:pkphDividerColor="@color/red_ff0016"
    app:pkphDividerWidth="3dp"
    app:pkphDividerHeight="3dp"
    app:pkphRootBackgroundDrawable="@color/black_000000" />
```
- app:pkphDefaultButtonTextSize
    - 기본 버튼의 글자 크기를 설정한다.
    - Sets the letter size of the default button.

- app:pkphDefaultButtonTextColor
    - 기본 버튼의 글자 색상을 설정한다.
    - Sets the text color of the default button.

- app:pkphDefaultButtonBackgroundColor
    - 기본 버튼의 배경색을 설정한다.
    - Sets the background color of the default button.

- app:pkphDefaultButtonRippleColor
    - 기본 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the default button.

- app:pkphDefaultButtonCornerRadius
    - 기본 버튼의 코너를 설정한다.
    - Set the corner of the default button.

- app:pkphDefaultButtonStrokeWidth
    - 기본 버튼의 테두리 두께를 설정한다.
    - Set the border thickness of the default button.

- app:pkphDefaultButtonStrokeColor
    - 기본 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the default button.

- app:pkphDeleteButtonIcon
    - 삭제 버튼의 아이콘을 설정한다.
    - Set the icon for the delete button.

- app:pkphDeleteButtonIconSize
    - 삭제 버튼의 아이콘 크기를 설정한다.
    - Sets the size of the icon for the delete button.

- app:pkphDeleteButtonBackgroundColor
    - 삭제 버튼의 배경색을 설정한다.
    - Sets the background color of the delete button.

- app:pkphDeleteButtonRippleColor
    - 삭제 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the delete button.

- app:pkphDeleteButtonCornerRadius
    - 삭제 버튼의 코너를 설정한다.
    - Set the corner of the delete button.

- app:pkphDeleteButtonStrokeWidth
    - 삭제 버튼의 테두리 두께를 설정한다.
    - Sets the border thickness of the delete button.

- app:pkphDeleteButtonStrokeColor
    - 삭제 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the delete button.

- app:pkphEmptyButtonIcon
    - 빈 버튼의 아이콘을 설정한다.
    - Set the icon for the empty button.

- app:pkphEmptyButtonIconSize
    - 빈 버튼의 아이콘 크기를 설정한다.
    - Sets the size of the icon for the empty button.

- app:pkphEmptyButtonBackgroundColor
    - 빈 버튼의 배경색을 설정한다.
    - Sets the background color of the empty button.

- app:pkphEmptyButtonCornerRadius
    - 빈 버튼의 코너를 설정한다.
    - Set the corner of the empty button.

- app:pkphEmptyButtonStrokeWidth
    - 빈 버튼의 테두리 두께를 설정한다.
    - Sets the border thickness of the empty button.

- app:pkphEmptyButtonStrokeColor
    - 빈 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the empty button.

- app:pkphClearButtonText
    - 클리어 버튼의 텍스트를 설정한다.
    - Sets the text of the clear button.

- app:pkphClearButtonTextSize
    - 클리어 버튼의 글자 크기를 설정한다.
    - Sets the letter size of the clear button.

- app:pkphClearButtonTextColor
    - 클리어 버튼의 글자 색상을 설정한다.
    - Sets the character color of the clear button.

- app:pkphClearButtonBackgroundColor
    - 클리어 버튼의 배경색을 설정한다.
    - Set the background color of the clear button.

- app:pkphClearButtonRippleColor
    - 클리어 버튼의 효과 색상을 설정한다.
    - Sets the effect color of the clear button.

- app:pkphClearButtonCornerRadius
    - 클리어 버튼의 테두리를 설정한다.
    - Set the border of the clear button.

- app:pkphClearButtonStrokeWidth
    - 클리어 버튼의 테두리 두께를 설정한다.
    - Set the border thickness of the clear button.

- app:pkphClearButtonStrokeColor
    - 클리어 버튼의 테두리 색상을 설정한다.
    - Sets the border color of the clear button.

- app:pkphDividerColor
    - 구분선의 색상을 설정한다.
    - Sets the color of the dividing line.

- app:pkphDividerWidth
    - 세로 구분선의 폭을 설정한다.
    - Sets the width of the vertical divider.

- app:pkphDividerHeight
    - 가로 구분선의 높이를 설정한다.
    - Sets the height of the horizontal divider.

- app:pkphRootBackgroundDrawable
    - 배경색을 설정한다.
    - Set background color.


### Kotlin Function

```kotlin
/**
 * - 입력값을 초기화한다.
 * - Initialize the input value.
 */
fun setClear()

/**
 * - 입력값을 가져온다.
 * - Gets the input value.
 */
fun getValue()
```


### Directions For Use

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewBinding = ActivityPinKeyPadHorizontalBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    viewBinding.apply {
        pinKeyPadHorizontalView.setAttachPinIndicatorView(pinIndicatorView)
        pinKeyPadHorizontalView.setPinKeyPadHorizontalListener(pinKeyPadHorizontalListener)
    }
}

private var pinKeyPadHorizontalListener = object : PinKeyPadHorizontalView.PinKeyPadHorizontalListener {
    override fun pinKeyPadHorizontalChanged(value: String) {}
}
```
<br/>
<br/>



# KeyPadModule
<br/>



##1. NumberKeyPadView

```xml
<com.ymg.keypadmodule.number.NumberKeypadView
        android:id="@+id/numberKeyPadView"
        android:layout_width="match_parent"
        android:layout_height="400dp"
        app:nkpTextCheckFormat="false"
        app:nkpTextMaxLength="10"
        app:nkpDefaultButtonTextSize="12"
        app:nkpDefaultButtonTextColor="@color/red_ff0016"
        app:nkpDefaultButtonBackgroundColor="@color/white_ffffff"
        app:nkpDefaultButtonRippleColor="@color/red_ff0016"
        app:nkpDefaultButtonCornerRadius="3dp"
        app:nkpDefaultButtonStrokeWidth="2dp"
        app:nkpDefaultButtonStrokeColor="@color/gray_ebebeb"
        app:nkpDeleteButtonIcon="@drawable/icon_back"
        app:nkpDeleteButtonIconSize="12dp"
        app:nkpDeleteButtonBackgroundColor="@color/white_ffffff"
        app:nkpDeleteButtonRippleColor="@color/red_ff0016"
        app:nkpDeleteButtonCornerRadius="3dp"
        app:nkpDeleteButtonStrokeWidth="2dp"
        app:nkpDeleteButtonStrokeColor="@color/gray_ebebeb"
        app:nkpClearButtonEnabled="true"
        app:nkpClearButtonText="CLEAR"
        app:nkpClearButtonTextSize="12"
        app:nkpClearButtonTextColor="@color/red_ff0016"
        app:nkpClearButtonBackgroundColor="@color/white_ffffff"
        app:nkpClearButtonRippleColor="@color/red_ff0016"
        app:nkpClearButtonCornerRadius="3dp"
        app:nkpClearButtonStrokeWidth="2dp"
        app:nkpClearButtonStrokeColor="@color/gray_ebebeb"
        app:nkpDividerColor="@color/red_ff0016"
        app:nkpDividerWidth="3dp"
        app:nkpDividerHeight="3dp"
        app:nkpRootBackgroundDrawable="@color/black_000000"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
```
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>nkpTextCheckFormat</center> | <center>입력값 포맷 체크 여부</center> |
| <center>nkpTextMaxLength</center> | <center>입력할 수 있는 최대 자리 수</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>nkpDefaultButtonTextSize</center> | <center>기본 버튼 글자 크기</center> |
| <center>nkpDefaultButtonTextColor</center> |<center>기본 버튼 글자 색상</center> |
| <center>nkpDefaultButtonBackgroundColor</center> |<center>기본 버튼 배경 색상</center> |
| <center>nkpDefaultButtonRippleColor</center> | <center>기본 버튼 클릭 효과 색상</center> |
| <center>nkpDefaultButtonCornerRadius</center> | <center>기본 버튼 코너</center> |
| <center>nkpDefaultButtonStrokeWidth</center> | <center>기본 버튼 테두리 두께</center> |
| <center>nkpDefaultButtonStrokeColor</center> | <center>기본 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>nkpDeleteButtonIcon</center> | <center>삭제 버튼 아이콘</center> |
| <center>nkpDeleteButtonIconSize</center> | <center>삭제 버튼 아이콘 크기</center> |
| <center>nkpDeleteButtonBackgroundColor</center> |<center>삭제 버튼 배경 색상</center> |
| <center>nkpDeleteButtonRippleColor</center> | <center>삭제 버튼 클릭 효과 색상</center> |
| <center>nkpDeleteButtonCornerRadius</center> | <center>삭제 버튼 코너</center> |
| <center>nkpDeleteButtonStrokeWidth</center> | <center>삭제 버튼 테두리 두께</center> |
| <center>nkpDeleteButtonStrokeColor</center> | <center>삭제 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>nkpClearButtonEnabled</center> | <center>전체삭제 버튼 적용 여부</center> |
| <center>nkpClearButtonText</center> | <center>전체삭제 버튼 텍스트</center> |
| <center>nkpClearButtonTextSize</center> | <center>전체삭제 버튼 글자 크기</center> |
| <center>nkpClearButtonTextColor</center> |<center>전체삭제 버튼 글자 색상</center> |
| <center>nkpClearButtonBackgroundColor</center> |<center>전체삭제 버튼 배경 색상</center> |
| <center>nkpClearButtonRippleColor</center> | <center>전체삭제 버튼 클릭 효과 색상</center> |
| <center>nkpClearButtonCornerRadius</center> | <center>전체삭제 버튼 코너</center> |
| <center>nkpClearButtonStrokeWidth</center> | <center>전체삭제 버튼 테두리 두께</center> |
| <center>nkpClearButtonStrokeColor</center> | <center>전체삭제 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>nkpDividerColor</center> | <center>구분선 색상</center> |
| <center>nkpDividerWidth</center> | <center>세로 구분선 폭</center> |
| <center>nkpDividerHeight</center> | <center>가로 구분선 높이</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>nkpRootBackgroundDrawable</center> | <center>배경</center> |
<br/>
<br/>


```kotlin
class NumberKeyPadActivity: BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_keypad)
        numberKeyPadView.setKeyboardListener(numberKeyPadListener)
    }

    var numberKeyPadListener = object : NumberKeypadView.NumberKeyPadListener {
        override fun numberKeyPadChanged(keyPadValue: String) {
            // 키 패드 입력값 확인
            Log.e("DEBUG", "Value: $keyPadValue")
        }
    }
}
```
<br/>

|  <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>setTextMaxLength(length: Int)</center> | <center>입력할 수 있는 최대 자리 수 설정</center> |
| <center>setClearKeyPadText()</center> | <center>입력 값 초기화</center> |
| <center>setKeyPadText(text: String)</center> |<center>입력 값 설정</center> |
| <center>getKeyPadText()</center> | <center>입력 값 가져오기</center> |
<br/>
<br/>



##2. DecimalKeyPadView

```xml
<com.ymg.keypadmodule.decimal.DecimalKeyPadView
        android:id="@+id/decimalKeyPadView"
        android:layout_width="match_parent"
        android:layout_height="400dp"
        app:dkpTextMaxLength="20"
        app:dkpTextDecimalCut="6"
        app:dkpDefaultButtonTextSize="12"
        app:dkpDefaultButtonTextColor="@color/red_ff0016"
        app:dkpDefaultButtonBackgroundColor="@color/white_ffffff"
        app:dkpDefaultButtonRippleColor="@color/red_ff0016"
        app:dkpDefaultButtonCornerRadius="3dp"
        app:dkpDefaultButtonStrokeWidth="2dp"
        app:dkpDefaultButtonStrokeColor="@color/gray_ebebeb"
        app:dkpDeleteButtonIcon="@drawable/icon_back"
        app:dkpDeleteButtonIconSize="12dp"
        app:dkpDeleteButtonBackgroundColor="@color/white_ffffff"
        app:dkpDeleteButtonRippleColor="@color/red_ff0016"
        app:dkpDeleteButtonCornerRadius="3dp"
        app:dkpDeleteButtonStrokeWidth="2dp"
        app:dkpDeleteButtonStrokeColor="@color/gray_ebebeb"
        app:dkpDotButtonTextSize="12"
        app:dkpDotButtonTextColor="@color/red_ff0016"
        app:dkpDotButtonBackgroundColor="@color/white_ffffff"
        app:dkpDotButtonRippleColor="@color/red_ff0016"
        app:dkpotButtonCornerRadius="3dp"
        app:dkpDotButtonStrokeWidth="2dp"
        app:dkpDotButtonStrokeColor="@color/gray_ebebeb"
        app:dkpDividerColor="@color/red_ff0016"
        app:dkpDividerWidth="3dp"
        app:dkpDividerHeight="3dp"
        app:dkpRootBackgroundDrawable="@color/black_000000"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
```
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>dkpTextMaxLength</center> | <center>입력할 수 있는 최대 자리 수</center> |
| <center>dkpTextDecimalCut</center> | <center>입력할 수 있는 소수점 최대 자리 수</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>dkpDefaultButtonTextSize</center> | <center>기본 버튼 글자 크기</center> |
| <center>dkpDefaultButtonTextColor</center> |<center>기본 버튼 글자 색상</center> |
| <center>dkpDefaultButtonBackgroundColor</center> | <center>기본 버튼 배경 색상</center> |
| <center>dkpDefaultButtonRippleColor</center> | <center>기본 버튼 클릭 효과 색상</center> |
| <center>dkpDefaultButtonCornerRadius</center> | <center>기본 버튼 코너</center> |
| <center>dkpDefaultButtonStrokeWidth</center> | <center>기본 버튼 테두리 두께</center> |
| <center>dkpDefaultButtonStrokeColor</center> | <center>기본 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>dkpDeleteButtonIcon</center> | <center>삭제 버튼 아이콘</center> |
| <center>dkpDeleteButtonIconSize</center> | <center>삭제 버튼 아이콘 크기</center> |
| <center>dkpDeleteButtonBackgroundColor</center> | <center>삭제 버튼 배경 색상</center> |
| <center>dkpDeleteButtonRippleColor</center> | <center>삭제 버튼 클릭 효과 색상</center> |
| <center>dkpDeleteButtonCornerRadius</center> | <center>삭제 버튼 코너</center> |
| <center>dkpDeleteButtonStrokeWidth</center> | <center>삭제 버튼 테두리 두께</center> |
| <center>dkpDeleteButtonStrokeColor</center> | <center>삭제 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>dkpDotButtonTextSize</center> | <center>점 버튼 글자 크기</center> |
| <center>dkpDotButtonTextColor</center> |<center>점 버튼 글자 색상</center> |
| <center>dkpDotButtonBackgroundColor</center> | <center>점 버튼 배경 색상</center> |
| <center>dkpDotButtonRippleColor</center> | <center>점 버튼 클릭 효과 색상</center> |
| <center>dkpDotButtonCornerRadius</center> | <center>점 버튼 코너</center> |
| <center>dkpDotButtonStrokeWidth</center> | <center>점 버튼 테두리 두께</center> |
| <center>dkpDotButtonStrokeColor</center> | <center>점 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>dkpDividerColor</center> | <center>구분선 색상</center> |
| <center>dkpDividerWidth</center> | <center>세로 구분선 폭</center> |
| <center>dkpDividerHeight</center> | <center>가로 구분선 높이</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>dkpRootBackgroundDrawable</center> | <center>배경</center> |
<br/>
<br/>


```kotlin
class DecimalKeyPadActivity: BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decimal_keypad)
        decimalKeyPadView.setDecimalKeyPadListener(decimalKeyPadListener)
    }

    private var decimalKeyPadListener = object : DecimalKeyPadView.DecimalKeyPadListener {
        override fun decimalKeyPadChanged(keyPadValue: String) {
            // 키 패드 입력값 확인
            Log.e("DEBUG", "Value: $keyPadValue")
        }
    }
}
```
<br/>

|  <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>setTextMaxLength(length: Int)</center> | <center>입력할 수 있는 최대 자리 수 설정</center> |
| <center>setTextDecimalCut(length: Int)</center> | <center>입력할 수 있는 소수점 최대 자리 수 설정</center> |
| <center>setClearKeyPadText()</center> | <center>입력 값 초기화</center> |
| <center>setKeyPadText(text: String)</center> |<center>입력 값 설정</center> |
| <center>getKeyPadText()</center> | <center>입력 값 가져오기</center> |
<br/>
<br/>



##3. PinKeyPadVerticalView

```xml
    <com.ymg.keypadmodule.pin.indicator.PinIndicatorView
        android:id="@+id/pinIndicatorView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:piDotLength="4"
        app:piDotDiameter="32dp"
        app:piDotSpace="3dp"
        app:piFillDotDrawable="@drawable/icon_pin_on"
        app:piEmptyDotDrawable="@drawable/icon_pin_off"
        app:layout_constraintBottom_toTopOf="@+id/pinKeyPadVerticalView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <com.ymg.keypadmodule.pin.vertical.PinKeyPadVerticalView
        android:id="@+id/pinKeyPadVerticalView"
        android:layout_width="match_parent"
        android:layout_height="400dp"
        app:pkpvDefaultButtonTextSize="12"
        app:pkpvDefaultButtonTextColor="@color/red_ff0016"
        app:pkpvDefaultButtonBackgroundColor="@color/white_ffffff"
        app:pkpvDefaultButtonRippleColor="@color/red_ff0016"
        app:pkpvDefaultButtonCornerRadius="3dp"
        app:pkpvDefaultButtonStrokeWidth="2dp"
        app:pkpvDefaultButtonStrokeColor="@color/gray_ebebeb"
        app:pkpvDeleteButtonIcon="@drawable/icon_back"
        app:pkpvDeleteButtonIconSize="12dp"
        app:pkpvDeleteButtonBackgroundColor="@color/white_ffffff"
        app:pkpvDeleteButtonRippleColor="@color/red_ff0016"
        app:pkpvDeleteButtonCornerRadius="3dp"
        app:pkpvDeleteButtonStrokeWidth="2dp"
        app:pkpvDeleteButtonStrokeColor="@color/gray_ebebeb"
        app:pkpvClearButtonEnabled="true"
        app:pkpvClearButtonText="CLEAR"
        app:pkpvClearButtonTextSize="12"
        app:pkpvClearButtonTextColor="@color/red_ff0016"
        app:pkpvClearButtonBackgroundColor="@color/white_ffffff"
        app:pkpvClearButtonRippleColor="@color/red_ff0016"
        app:pkpvClearButtonCornerRadius="3dp"
        app:pkpvClearButtonStrokeWidth="2dp"
        app:pkpvClearButtonStrokeColor="@color/gray_ebebeb"
        app:pkpvDividerColor="@color/red_ff0016"
        app:pkpvDividerWidth="3dp"
        app:pkpvDividerHeight="3dp"
        app:pkpvRootBackgroundDrawable="@color/black_000000"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
```
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>piDotLength</center> | <center>Dot 길이</center> |
| <center>piDotDiameter</center> | <center>Dot 지름</center> |
| <center>piDotSpace</center> | <center>Dot 사이 공간</center> |
| <center>piFillDotDrawable</center> |<center>Dot Fill 아이콘</center> |
| <center>piEmptyDotDrawable</center> | <center>Dot Empty 아이콘</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkpvDefaultButtonTextSize</center> | <center>기본 버튼 글자 크기</center> |
| <center>pkpvDefaultButtonTextColor</center> |<center>기본 버튼 글자 색상</center> |
| <center>pkpvDefaultButtonBackgroundColor</center> | <center>기본 버튼 배경 색상</center> |
| <center>pkpvDefaultButtonRippleColor</center> | <center>기본 버튼 클릭 효과 색상</center> |
| <center>pkpvDefaultButtonCornerRadius</center> | <center>기본 버튼 코너</center> |
| <center>pkpvDefaultButtonStrokeWidth</center> | <center>기본 버튼 테두리 두께</center> |
| <center>pkpvDefaultButtonStrokeColor</center> | <center>기본 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkpvDeleteButtonIcon</center> | <center>삭제 버튼 아이콘</center> |
| <center>pkpvDeleteButtonIconSize</center> | <center>삭제 버튼 아이콘 크기</center> |
| <center>pkpvDeleteButtonBackgroundColor</center> | <center>삭제 버튼 배경 색상</center> |
| <center>pkpvDeleteButtonRippleColor</center> | <center>삭제 버튼 클릭 효과 색상</center> |
| <center>pkpvDeleteButtonCornerRadius</center> | <center>삭제 버튼 코너</center> |
| <center>pkpvDeleteButtonStrokeWidth</center> | <center>삭제 버튼 테두리 두께</center> |
| <center>pkpvDeleteButtonStrokeColor</center> | <center>삭제 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkpvClearButtonEnabled</center> | <center>전체삭제 버튼 적용 여부</center> |
| <center>pkpvClearButtonText</center> | <center>전체삭제 버튼 텍스트</center> |
| <center>pkpvClearButtonTextSize</center> | <center>기본 버튼 글자 크기</center> |
| <center>pkpvClearButtonTextColor</center> |<center>기본 버튼 글자 색상</center> |
| <center>pkpvClearButtonBackgroundColor</center> | <center>기본 버튼 배경 색상</center> |
| <center>pkpvClearButtonRippleColor</center> | <center>기본 버튼 클릭 효과 색상</center> |
| <center>pkpvClearButtonCornerRadius</center> | <center>기본 버튼 코너</center> |
| <center>pkpvClearButtonStrokeWidth</center> | <center>기본 버튼 테두리 두께</center> |
| <center>pkpvClearButtonStrokeColor</center> | <center>기본 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkpvDividerColor</center> | <center>구분선 색상</center> |
| <center>pkpvDividerWidth</center> | <center>세로 구분선 폭</center> |
| <center>pkpvDividerHeight</center> | <center>가로 구분선 높이</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkpvRootBackgroundDrawable</center> | <center>배경</center> |
<br/>
<br/>


```kotlin
class PinKeyPadVerticalActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_key_pad_vertical)
        pinKeyPadVerticalView.setAttachPinIndicatorView(pinIndicatorView)
        pinKeyPadVerticalView.setPinKeyPadVerticalListener(pinKeyPadVerticalListener)
    }

    private var pinKeyPadVerticalListener = object : PinKeyPadVerticalView.PinKeyPadVerticalListener {
        override fun pinKeyPadVerticalChanged(keyPadValue: String) {
            // 키 패드 입력값 확인
            Log.e("DEBUG", "Value: $keyPadValue")
        }
    }
}
```
<br/>

|  <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>setClearKeyPadText()</center> | <center>입력 값 초기화</center> |
| <center>getKeyPadText()</center> | <center>입력 값 가져오기</center> |
<br/>
<br/>



##4. PinKeyPadHorizontalView

```xml
    <com.ymg.keypadmodule.pin.indicator.PinIndicatorView
        android:id="@+id/pinIndicatorView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:piDotLength="4"
        app:piDotDiameter="32dp"
        app:piDotSpace="3dp"
        app:piFillDotDrawable="@drawable/icon_pin_on"
        app:piEmptyDotDrawable="@drawable/icon_pin_off"
        app:layout_constraintBottom_toTopOf="@+id/pinKeyPadHorizontalView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <com.ymg.keypadmodule.pin.horizontal.PinKeyPadHorizontalView
        android:id="@+id/pinKeyPadHorizontalView"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        app:pkphDefaultButtonTextSize="12"
        app:pkphDefaultButtonTextColor="@color/red_ff0016"
        app:pkphDefaultButtonBackgroundColor="@color/white_ffffff"
        app:pkphDefaultButtonRippleColor="@color/red_ff0016"
        app:pkphDefaultButtonCornerRadius="3dp"
        app:pkphDefaultButtonStrokeWidth="2dp"
        app:pkphDefaultButtonStrokeColor="@color/gray_ebebeb"
        app:pkphDeleteButtonIcon="@drawable/icon_back"
        app:pkphDeleteButtonIconSize="12dp"
        app:pkphDeleteButtonBackgroundColor="@color/white_ffffff"
        app:pkphDeleteButtonRippleColor="@color/red_ff0016"
        app:pkphDeleteButtonCornerRadius="3dp"
        app:pkphDeleteButtonStrokeWidth="2dp"
        app:pkphDeleteButtonStrokeColor="@color/gray_ebebeb"
        app:pkphClearButtonText="CLEAR"
        app:pkphClearButtonTextSize="12"
        app:pkphClearButtonTextColor="@color/red_ff0016"
        app:pkphClearButtonBackgroundColor="@color/white_ffffff"
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
        app:pkphRootBackgroundDrawable="@color/black_000000"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
```
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>piDotLength</center> | <center>Dot 길이</center> |
| <center>piDotDiameter</center> | <center>Dot 지름</center> |
| <center>piDotSpace</center> | <center>Dot 사이 공간</center> |
| <center>piFillDotDrawable</center> |<center>Dot Fill 아이콘</center> |
| <center>piEmptyDotDrawable</center> | <center>Dot Empty 아이콘</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkphDefaultButtonTextSize</center> | <center>기본 버튼 글자 크기</center> |
| <center>pkphDefaultButtonTextColor</center> |<center>기본 버튼 글자 색상</center> |
| <center>pkphDefaultButtonBackgroundColor</center> | <center>기본 버튼 배경 색상</center> |
| <center>pkphDefaultButtonRippleColor</center> | <center>기본 버튼 클릭 효과 색상</center> |
| <center>pkphDefaultButtonCornerRadius</center> | <center>기본 버튼 코너</center> |
| <center>pkphDefaultButtonStrokeWidth</center> | <center>기본 버튼 테두리 두께</center> |
| <center>pkphDefaultButtonStrokeColor</center> | <center>기본 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkphDeleteButtonIcon</center> | <center>삭제 버튼 아이콘</center> |
| <center>pkphDeleteButtonIconSize</center> | <center>삭제 버튼 아이콘 크기</center> |
| <center>pkphDeleteButtonBackgroundColor</center> | <center>삭제 버튼 배경 색상</center> |
| <center>pkphDeleteButtonRippleColor</center> | <center>삭제 버튼 클릭 효과 색상</center> |
| <center>pkphDeleteButtonCornerRadius</center> | <center>삭제 버튼 코너</center> |
| <center>pkphDeleteButtonStrokeWidth</center> | <center>삭제 버튼 테두리 두께</center> |
| <center>pkphDeleteButtonStrokeColor</center> | <center>삭제 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkphClearButtonEnabled</center> | <center>전체삭제 버튼 적용 여부</center> |
| <center>pkphClearButtonText</center> | <center>전체삭제 버튼 텍스트</center> |
| <center>pkphClearButtonTextSize</center> | <center>기본 버튼 글자 크기</center> |
| <center>pkphClearButtonTextColor</center> |<center>기본 버튼 글자 색상</center> |
| <center>pkphClearButtonBackgroundColor</center> | <center>기본 버튼 배경 색상</center> |
| <center>pkphClearButtonRippleColor</center> | <center>기본 버튼 클릭 효과 색상</center> |
| <center>pkphClearButtonCornerRadius</center> | <center>기본 버튼 코너</center> |
| <center>pkphClearButtonStrokeWidth</center> | <center>기본 버튼 테두리 두께</center> |
| <center>pkphClearButtonStrokeColor</center> | <center>기본 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkphEmptyButtonIcon</center> | <center>빈 버튼 아이콘</center> |
| <center>pkphEmptyButtonIconSize</center> | <center>빈 버튼 아이콘 크기</center> |
| <center>pkphEmptyButtonBackgroundColor</center> | <center>빈 버튼 배경 색상</center> |
| <center>pkphEmptyButtonCornerRadius</center> | <center>빈 버튼 코너</center> |
| <center>pkphEmptyButtonStrokeWidth</center> | <center>빈 버튼 테두리 두께</center> |
| <center>pkphEmptyButtonStrokeColor</center> | <center>빈 버튼 테두리 색상</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkphDividerColor</center> | <center>구분선 색상</center> |
| <center>pkphDividerWidth</center> | <center>세로 구분선 폭</center> |
| <center>pkphDividerHeight</center> | <center>가로 구분선 높이</center> |
<br/>

| <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>pkphRootBackgroundDrawable</center> | <center>배경</center> |
<br/>
<br/>


```kotlin
class PinKeyPadHorizontalActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_key_pad_horizontal)
        pinKeyPadHorizontalView.setAttachPinIndicatorView(pinIndicatorView)
        pinKeyPadHorizontalView.setPinKeyPadHorizontalListener(pinKeyPadHorizontalListener)
    }

    private var pinKeyPadHorizontalListener = object : PinKeyPadHorizontalView.PinKeyPadHorizontalListener {
        override fun pinKeyPadHorizontalChanged(keyPadValue: String) {
            // 키 패드 입력값 확인
            Log.e("DEBUG", "Value: $keyPadValue")
        }
    }
}
```
<br/>

|  <center>Option</center> | <center>Description</center> |
|:--------|:--------:|
| <center>setClearKeyPadText()</center> | <center>입력 값 초기화</center> |
| <center>getKeyPadText()</center> | <center>입력 값 가져오기</center> |
<br/>
<br/>
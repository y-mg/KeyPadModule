# PinKeyPadVerticalView

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
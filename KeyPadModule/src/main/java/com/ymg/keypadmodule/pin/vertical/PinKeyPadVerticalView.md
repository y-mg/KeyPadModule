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
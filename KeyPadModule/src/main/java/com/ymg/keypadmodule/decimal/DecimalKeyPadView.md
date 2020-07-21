# DecimalKeyPadView

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
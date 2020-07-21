# NumberKeyPadView

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
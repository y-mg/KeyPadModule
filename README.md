# KeyPadModule
<br/>
<br/>



## 1. NumberKeyPadView

### XML

| <span style="color:DodgerBlue">Option</span> | <span style="color:LimeGreen">Default</span> | <span style="color:Black">Description</span> |
|:----------|:----------|:----------|
| <span style="color:DodgerBlue">nkpTextCheckFormat</span> | <span style="color:LimeGreen">true</span> | <span style="color:Black">입력값 포맷 체크 여부</span> |
| <span style="color:DodgerBlue">nkpTextMaxLength</span> | <span style="color:LimeGreen">20</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDefaultButtonTextSize</span> | <span style="color:LimeGreen">24</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDefaultButtonTextColor</span> | <span style="color:LimeGreen">#000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDefaultButtonBackgroundColor</span> | <span style="color:LimeGreen">#00000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDefaultButtonRippleColor</span> | <span style="color:LimeGreen">#00000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDefaultButtonCornerRadius</span> | <span style="color:LimeGreen">0dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDefaultButtonStrokeWidth</span> | <span style="color:LimeGreen">0dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDefaultButtonStrokeColor</span> | <span style="color:LimeGreen">0dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDeleteButtonIcon</span> | <span style="color:LimeGreen">btn_keyboard_del_black.png</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDeleteButtonIconSize</span> | <span style="color:LimeGreen">24dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDeleteButtonBackgroundColor</span> | <span style="color:LimeGreen">#00000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDeleteButtonRippleColor</span> | <span style="color:LimeGreen">#00000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDeleteButtonCornerRadius</span> | <span style="color:LimeGreen">0dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDeleteButtonStrokeWidth</span> | <span style="color:LimeGreen">0dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDeleteButtonStrokeColor</span> | <span style="color:LimeGreen">#00000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpClearButtonEnabled</span> | <span style="color:LimeGreen">false</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpClearButtonText</span> | <span style="color:LimeGreen">CLEAR</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpClearButtonTextSize</span> | <span style="color:LimeGreen">24</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpClearButtonTextColor</span> | <span style="color:LimeGreen">#000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpClearButtonBackgroundColor</span> | <span style="color:LimeGreen">#00000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpClearButtonRippleColor</span> | <span style="color:LimeGreen">#00000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpClearButtonCornerRadius</span> | <span style="color:LimeGreen">0dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpClearButtonStrokeWidth</span> | <span style="color:LimeGreen">0dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpClearButtonStrokeColor</span> | <span style="color:LimeGreen">#00000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDividerColor</span> | <span style="color:LimeGreen">#00000000</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDividerWidth</span> | <span style="color:LimeGreen">0dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpDividerHeight</span> | <span style="color:LimeGreen">0dp</span> | <span style="color:Black">입력값</span> |
| <span style="color:DodgerBlue">nkpRootBackgroundDrawable</span> | <span style="color:LimeGreen">#ffffff</span> | <span style="color:Black">입력값</span> |

### Kotlin

| <center>Function</center> | Parameter | <center>Description</center> |
|:--------|:--------|:--------|
| setTextMaxLength(length: Int) | 설정할 최대 자리 수 | 입력할 수 있는 최대 자리 수 설정 |
| setClearKeyPadText() | Void | 입력 값 초기화 |
| setKeyPadText(text: String) | 입력 값 | 입력 값 설정 |
| getKeyPadText() | Void | 입력 값 가져오기 |
<br/>
<br/>



## 2. DecimalKeyPadView

### XML

| <center>Option</center> | <center>Default</center> | <center>Description</center> |
|:--------|:--------|:--------|
| dkpTextMaxLength | 입력할 수 있는 최대 자리 수 |
| dkpTextDecimalCut | 입력할 수 있는 소수점 최대 자리 수 |
| dkpDefaultButtonTextSize | 기본 버튼 글자 크기 |
| dkpDefaultButtonTextColor |기본 버튼 글자 색상 |
| dkpDefaultButtonBackgroundColor | 기본 버튼 배경 색상 |
| dkpDefaultButtonRippleColor | 기본 버튼 클릭 효과 색상 |
| dkpDefaultButtonCornerRadius | 기본 버튼 코너 |
| dkpDefaultButtonStrokeWidth | 기본 버튼 테두리 두께 |
| dkpDefaultButtonStrokeColor | 기본 버튼 테두리 색상 |
| dkpDeleteButtonIcon | 삭제 버튼 아이콘 |
| dkpDeleteButtonIconSize | 삭제 버튼 아이콘 크기 |
| dkpDeleteButtonBackgroundColor | 삭제 버튼 배경 색상 |
| dkpDeleteButtonRippleColor | 삭제 버튼 클릭 효과 색상 |
| dkpDeleteButtonCornerRadius | 삭제 버튼 코너 |
| dkpDeleteButtonStrokeWidth | 삭제 버튼 테두리 두께 |
| dkpDeleteButtonStrokeColor | 삭제 버튼 테두리 색상 |
| dkpDotButtonTextSize | 점 버튼 글자 크기 |
| dkpDotButtonTextColor |점 버튼 글자 색상 |
| dkpDotButtonBackgroundColor | 점 버튼 배경 색상 |
| dkpDotButtonRippleColor | 점 버튼 클릭 효과 색상 |
| dkpDotButtonCornerRadius | 점 버튼 코너 |
| dkpDotButtonStrokeWidth | 점 버튼 테두리 두께 |
| dkpDotButtonStrokeColor | 점 버튼 테두리 색상 |
| dkpDividerColor | 구분선 색상 |
| dkpDividerWidth | 세로 구분선 폭 |
| dkpDividerHeight | 가로 구분선 높이 |
| dkpRootBackgroundDrawable | 배경 |

### Kotlin

| <center>Option</center> | <center>Description</center> |
|:--------|:--------|
| setTextMaxLength(length: Int) | 입력할 수 있는 최대 자리 수 설정 |
| setTextDecimalCut(length: Int) | 입력할 수 있는 소수점 최대 자리 수 설정 |
| setClearKeyPadText() | 입력 값 초기화 |
| setKeyPadText(text: String) |입력 값 설정 |
| getKeyPadText() | 입력 값 가져오기 |
<br/>
<br/>



## 3. PinKeyPadVerticalView

### XML

| <center>Option</center> | <center>Description</center> |
|:--------|:--------|
| piDotLength | Dot 길이 |
| piDotDiameter | Dot 지름 |
| piDotSpace | Dot 사이 공간 |
| piFillDotDrawable |Dot Fill 아이콘 |
| piEmptyDotDrawable | Dot Empty 아이콘 |
| pkpvDefaultButtonTextSize | 기본 버튼 글자 크기 |
| pkpvDefaultButtonTextColor |기본 버튼 글자 색상 |
| pkpvDefaultButtonBackgroundColor | 기본 버튼 배경 색상 |
| pkpvDefaultButtonRippleColor | 기본 버튼 클릭 효과 색상 |
| pkpvDefaultButtonCornerRadius | 기본 버튼 코너 |
| pkpvDefaultButtonStrokeWidth | 기본 버튼 테두리 두께 |
| pkpvDefaultButtonStrokeColor | 기본 버튼 테두리 색상 |
| pkpvDeleteButtonIcon | 삭제 버튼 아이콘 |
| pkpvDeleteButtonIconSize | 삭제 버튼 아이콘 크기 |
| pkpvDeleteButtonBackgroundColor | 삭제 버튼 배경 색상 |
| pkpvDeleteButtonRippleColor | 삭제 버튼 클릭 효과 색상 |
| pkpvDeleteButtonCornerRadius | 삭제 버튼 코너 |
| pkpvDeleteButtonStrokeWidth | 삭제 버튼 테두리 두께 |
| pkpvDeleteButtonStrokeColor | 삭제 버튼 테두리 색상 |
| pkpvClearButtonEnabled | 전체삭제 버튼 적용 여부 |
| pkpvClearButtonText | 전체삭제 버튼 텍스트 |
| pkpvClearButtonTextSize | 기본 버튼 글자 크기 |
| pkpvClearButtonTextColor |기본 버튼 글자 색상 |
| pkpvClearButtonBackgroundColor | 기본 버튼 배경 색상 |
| pkpvClearButtonRippleColor | 기본 버튼 클릭 효과 색상 |
| pkpvClearButtonCornerRadius | 기본 버튼 코너 |
| pkpvClearButtonStrokeWidth | 기본 버튼 테두리 두께 |
| pkpvClearButtonStrokeColor | 기본 버튼 테두리 색상 |
| pkpvDividerColor | 구분선 색상 |
| pkpvDividerWidth | 세로 구분선 폭 |
| pkpvDividerHeight | 가로 구분선 높이 |
| pkpvRootBackgroundDrawable | 배경 |

### Kotlin

|  <center>Option</center> | <center>Description</center> |
|:--------|:--------|
| setClearKeyPadText() | 입력 값 초기화 |
| getKeyPadText() | 입력 값 가져오기 |
<br/>
<br/>



## 4. PinKeyPadHorizontalView

### XML

| <center>Option</center> | <center>Description</center> |
|:--------|:--------|
| piDotLength | Dot 길이 |
| piDotDiameter | Dot 지름 |
| piDotSpace | Dot 사이 공간 |
| piFillDotDrawable |Dot Fill 아이콘 |
| piEmptyDotDrawable | Dot Empty 아이콘 |
| pkphDefaultButtonTextSize | 기본 버튼 글자 크기 |
| pkphDefaultButtonTextColor |기본 버튼 글자 색상 |
| pkphDefaultButtonBackgroundColor | 기본 버튼 배경 색상 |
| pkphDefaultButtonRippleColor | 기본 버튼 클릭 효과 색상 |
| pkphDefaultButtonCornerRadius | 기본 버튼 코너 |
| pkphDefaultButtonStrokeWidth | 기본 버튼 테두리 두께 |
| pkphDefaultButtonStrokeColor | 기본 버튼 테두리 색상 |
| pkphDeleteButtonIcon | 삭제 버튼 아이콘 |
| pkphDeleteButtonIconSize | 삭제 버튼 아이콘 크기 |
| pkphDeleteButtonBackgroundColor | 삭제 버튼 배경 색상 |
| pkphDeleteButtonRippleColor | 삭제 버튼 클릭 효과 색상 |
| pkphDeleteButtonCornerRadius | 삭제 버튼 코너 |
| pkphDeleteButtonStrokeWidth | 삭제 버튼 테두리 두께 |
| pkphDeleteButtonStrokeColor | 삭제 버튼 테두리 색상 |
| pkphClearButtonEnabled | 전체삭제 버튼 적용 여부 |
| pkphClearButtonText | 전체삭제 버튼 텍스트 |
| pkphClearButtonTextSize | 기본 버튼 글자 크기 |
| pkphClearButtonTextColor |기본 버튼 글자 색상 |
| pkphClearButtonBackgroundColor | 기본 버튼 배경 색상 |
| pkphClearButtonRippleColor | 기본 버튼 클릭 효과 색상 |
| pkphClearButtonCornerRadius | 기본 버튼 코너 |
| pkphClearButtonStrokeWidth | 기본 버튼 테두리 두께 |
| pkphClearButtonStrokeColor | 기본 버튼 테두리 색상 |
| pkphEmptyButtonIcon | 빈 버튼 아이콘 |
| pkphEmptyButtonIconSize | 빈 버튼 아이콘 크기 |
| pkphEmptyButtonBackgroundColor | 빈 버튼 배경 색상 |
| pkphEmptyButtonCornerRadius | 빈 버튼 코너 |
| pkphEmptyButtonStrokeWidth | 빈 버튼 테두리 두께 |
| pkphEmptyButtonStrokeColor | 빈 버튼 테두리 색상 |
| pkphDividerColor | 구분선 색상 |
| pkphDividerWidth | 세로 구분선 폭 |
| pkphDividerHeight | 가로 구분선 높이 |
| pkphRootBackgroundDrawable | 배경 |

### Kotlin

|  <center>Option</center> | <center>Description</center> |
|:--------|:--------|
| setClearKeyPadText() | 입력 값 초기화 |
| getKeyPadText() | 입력 값 가져오기 |
<br/>
<br/>



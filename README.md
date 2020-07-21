# KeyPadModule
<br/>
<br/>



## 1. NumberKeyPadView

### XML

| <center>Option</center> | <center>Description</center> |
|:--------|:--------|
| nkpTextCheckFormat | 입력값 포맷 체크 여부 |
| nkpTextMaxLength | 입력할 수 있는 최대 자리 수 |
| nkpDefaultButtonTextSize | 기본 버튼 글자 크기 |
| nkpDefaultButtonTextColor | 기본 버튼 글자 색상 |
| nkpDefaultButtonBackgroundColor | 기본 버튼 배경 색상 |
| nkpDefaultButtonRippleColor | 기본 버튼 클릭 효과 색상 |
| nkpDefaultButtonCornerRadius | 기본 버튼 코너 |
| nkpDefaultButtonStrokeWidth | 기본 버튼 테두리 두께 |
| nkpDefaultButtonStrokeColor | 기본 버튼 테두리 색상 |
| nkpDeleteButtonIcon | 삭제 버튼 아이콘 |
| nkpDeleteButtonIconSize | 삭제 버튼 아이콘 크기 |
| nkpDeleteButtonBackgroundColor |삭제 버튼 배경 색상 |
| nkpDeleteButtonRippleColor | 삭제 버튼 클릭 효과 색상 |
| nkpDeleteButtonCornerRadius | 삭제 버튼 코너 |
| nkpDeleteButtonStrokeWidth | 삭제 버튼 테두리 두께 |
| nkpDeleteButtonStrokeColor | 삭제 버튼 테두리 색상 |
| nkpClearButtonEnabled | 전체삭제 버튼 적용 여부 |
| nkpClearButtonText | 전체삭제 버튼 텍스트 |
| nkpClearButtonTextSize | 전체삭제 버튼 글자 크기 |
| nkpClearButtonTextColor |전체삭제 버튼 글자 색상 |
| nkpClearButtonBackgroundColor |전체삭제 버튼 배경 색상 |
| nkpClearButtonRippleColor | 전체삭제 버튼 클릭 효과 색상 |
| nkpClearButtonCornerRadius | 전체삭제 버튼 코너 |
| nkpClearButtonStrokeWidth | 전체삭제 버튼 테두리 두께 |
| nkpClearButtonStrokeColor | 전체삭제 버튼 테두리 색상 |
| nkpDividerColor | 구분선 색상 |
| nkpDividerWidth | 세로 구분선 폭 |
| nkpDividerHeight | 가로 구분선 높이 |
| nkpRootBackgroundDrawable | 배경 |

### Kotlin

| <center>Option</center> | <center>Description</center> |
|:--------|:--------|
| setTextMaxLength(length: Int) | 입력할 수 있는 최대 자리 수 설정 |
| setClearKeyPadText() | 입력 값 초기화 |
| setKeyPadText(text: String) |입력 값 설정 |
| getKeyPadText() | 입력 값 가져오기 |
<br/>
<br/>



## 2. DecimalKeyPadView

### XML

| <center>Option</center> | <center>Description</center> |
|:--------|:--------|
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



# KeyPadModule
<br/>
<br/>



## 1. NumberKeyPadView

### XML

| Option | Default | Description |
|:----------|:----------|:----------|
| nkpTextCheckFormat | true | 입력값 포맷 체크 여부 |
| nkpTextMaxLength | 20 | 입력할 수 있는 최대 자리 수 |
| nkpDefaultButtonTextSize | 24 | 기본 버튼 글자 크기 |
| nkpDefaultButtonTextColor | #000000 | 기본 버튼 글자 색상 |
| nkpDefaultButtonBackgroundColor | #00000000 | 기본 버튼 배경 색상 |
| nkpDefaultButtonRippleColor | #00000000 | 기본 버튼 클릭 효과 색상 |
| nkpDefaultButtonCornerRadius | 0dp | 기본 버튼 코너 |
| nkpDefaultButtonStrokeWidth | 0dp | 기본 버튼 테두리 두께 |
| nkpDefaultButtonStrokeColor | 0dp | 기본 버튼 테두리 색상 |
| nkpDeleteButtonIcon | btn_keyboard_del_black.png | 삭제 버튼 아이콘 |
| nkpDeleteButtonIconSize | 24dp | 삭제 버튼 아이콘 크기 |
| nkpDeleteButtonBackgroundColor | #00000000 | 삭제 버튼 배경 색상 |
| nkpDeleteButtonRippleColor | #00000000 | 삭제 버튼 클릭 효과 색상 |
| nkpDeleteButtonCornerRadius | 0dp | 삭제 버튼 코너 |
| nkpDeleteButtonStrokeWidth | 0dp | 삭제 버튼 테두리 두께 |
| nkpDeleteButtonStrokeColor | #00000000 | 삭제 버튼 테두리 색상 |
| nkpClearButtonEnabled | false | 전체삭제 버튼 적용 여부 |
| nkpClearButtonText | CLEAR | 전체삭제 버튼 텍스트 |
| nkpClearButtonTextSize | 24 | 전체삭제 버튼 글자 크기 |
| nkpClearButtonTextColor | #000000 | 전체삭제 버튼 글자 색상 |
| nkpClearButtonBackgroundColor | #00000000 | 전체삭제 버튼 배경 색상 |
| nkpClearButtonRippleColor | #00000000 | 전체삭제 버튼 클릭 효과 색상 |
| nkpClearButtonCornerRadius | 0dp | 전체삭제 버튼 코너 |
| nkpClearButtonStrokeWidth | 0dp | 전체삭제 버튼 테두리 두께 |
| nkpClearButtonStrokeColor | #00000000 | 전체삭제 버튼 테두리 색상 |
| nkpDividerColor | #00000000 | 구분선 색상 |
| nkpDividerWidth | 0dp | 세로 구분선 폭 |
| nkpDividerHeight | 0dp | 가로 구분선 높이 |
| nkpRootBackgroundDrawable | #ffffff | 배경 |

### Kotlin

| Function | Parameter | Description |
|:----------|:----------|:----------|
| setTextMaxLength(length: Int) | 설정할 최대 자리 수 | 입력할 수 있는 최대 자리 수 설정 |
| setClearKeyPadText() | Void | 입력 값 초기화 |
| setKeyPadText(text: String) | 입력 값 | 입력 값 설정 |
| getKeyPadText() | Void | 입력 값 가져오기 |
<br/>
<br/>



## 2. DecimalKeyPadView

### XML

| Option | Default | Description |
|:----------|:----------|:----------|
| dkpTextMaxLength | 20 | 입력할 수 있는 최대 자리 수 |
| dkpTextDecimalCut | 8 | 입력할 수 있는 소수점 최대 자리 수 |
| dkpDefaultButtonTextSize | 24 | 기본 버튼 글자 크기 |
| dkpDefaultButtonTextColor | #000000 | 기본 버튼 글자 색상 |
| dkpDefaultButtonBackgroundColor | #00000000 | 기본 버튼 배경 색상 |
| dkpDefaultButtonRippleColor | #00000000 | 기본 버튼 클릭 효과 색상 |
| dkpDefaultButtonCornerRadius | 0dp | 기본 버튼 코너 |
| dkpDefaultButtonStrokeWidth | 0dp | 기본 버튼 테두리 두께 |
| dkpDefaultButtonStrokeColor | #00000000 | 기본 버튼 테두리 색상 |
| dkpDeleteButtonIcon | btn_keyboard_del_black.png | 삭제 버튼 아이콘 |
| dkpDeleteButtonIconSize | 24dp | 삭제 버튼 아이콘 크기 |
| dkpDeleteButtonBackgroundColor | #00000000 | 삭제 버튼 배경 색상 |
| dkpDeleteButtonRippleColor | #00000000 | 삭제 버튼 클릭 효과 색상 |
| dkpDeleteButtonCornerRadius | 0dp | 삭제 버튼 코너 |
| dkpDeleteButtonStrokeWidth | 0dp | 삭제 버튼 테두리 두께 |
| dkpDeleteButtonStrokeColor | #00000000 | 삭제 버튼 테두리 색상 |
| dkpDotButtonTextSize | 24 | 점 버튼 글자 크기 |
| dkpDotButtonTextColor | #000000 | 점 버튼 글자 색상 |
| dkpDotButtonBackgroundColor | #00000000 | 점 버튼 배경 색상 |
| dkpDotButtonRippleColor | #00000000 | 점 버튼 클릭 효과 색상 |
| dkpDotButtonCornerRadius | 0dp | 점 버튼 코너 |
| dkpDotButtonStrokeWidth | 0dp | 점 버튼 테두리 두께 |
| dkpDotButtonStrokeColor | #00000000 | 점 버튼 테두리 색상 |
| dkpDividerColor | #00000000 | 구분선 색상 |
| dkpDividerWidth | 0dp | 세로 구분선 폭 |
| dkpDividerHeight | 0dp | 가로 구분선 높이 |
| dkpRootBackgroundDrawable | #00000000 | 배경 |

### Kotlin

| Function | Parameter | Description |
|:----------|:----------|:----------|
| setTextMaxLength(length: Int) | 설정할 최대 자리 수 | 입력할 수 있는 최대 자리 수 설정 |
| setTextDecimalCut(length: Int) | 설정할 소수점 최대 자리 수 | 입력할 수 있는 소수점 최대 자리 수 설정 |
| setClearKeyPadText() | Void | 입력 값 초기화 |
| setKeyPadText(text: String) | 입력 값 | 입력 값 설정 |
| getKeyPadText() | Void | 입력 값 가져오기 |
<br/>
<br/>



## 3. PinIndicatorView

### XML

| Option | Default | Description |
|:----------|:----------|:----------|
| piDotLength | 6 | Dot 길이 |
| piDotDiameter | 16dp | Dot 지름 |
| piDotSpace | 8dp | Dot 사이 공간 |
| piFillDotDrawable | dot_pin_on.png | Dot Fill 아이콘 |
| piEmptyDotDrawable | dot_pin_off.png | Dot Empty 아이콘 |
<br/>
<br/>



## 4. PinKeyPadVerticalView

### XML

| Option | Default | Description |
|:----------|:----------|:----------|
| pkpvDefaultButtonTextSize | 24 | 기본 버튼 글자 크기 |
| pkpvDefaultButtonTextColor | #000000 | 기본 버튼 글자 색상 |
| pkpvDefaultButtonBackgroundColor | #00000000 | 기본 버튼 배경 색상 |
| pkpvDefaultButtonRippleColor | #00000000 | 기본 버튼 클릭 효과 색상 |
| pkpvDefaultButtonCornerRadius | 0dp | 기본 버튼 코너 |
| pkpvDefaultButtonStrokeWidth | 0dp | 기본 버튼 테두리 두께 |
| pkpvDefaultButtonStrokeColor | 0dp | 기본 버튼 테두리 색상 |
| pkpvDeleteButtonIcon | btn_keyboard_del_black.png | 삭제 버튼 아이콘 |
| pkpvDeleteButtonIconSize | 24dp | 삭제 버튼 아이콘 크기 |
| pkpvDeleteButtonBackgroundColor | #00000000 | 삭제 버튼 배경 색상 |
| pkpvDeleteButtonRippleColor | #00000000 | 삭제 버튼 클릭 효과 색상 |
| pkpvDeleteButtonCornerRadius | 0dp | 삭제 버튼 코너 |
| pkpvDeleteButtonStrokeWidth | 0dp | 삭제 버튼 테두리 두께 |
| pkpvDeleteButtonStrokeColor | #00000000 | 삭제 버튼 테두리 색상 |
| pkpvClearButtonEnabled | false | 전체삭제 버튼 적용 여부 |
| pkpvClearButtonText | CLEAR | 전체삭제 버튼 텍스트 |
| pkpvClearButtonTextSize | 24 | 기본 버튼 글자 크기 |
| pkpvClearButtonTextColor | #000000 | 기본 버튼 글자 색상 |
| pkpvClearButtonBackgroundColor | #00000000 | 기본 버튼 배경 색상 |
| pkpvClearButtonRippleColor | #00000000 | 기본 버튼 클릭 효과 색상 |
| pkpvClearButtonCornerRadius | 0dp | 기본 버튼 코너 |
| pkpvClearButtonStrokeWidth | 0dp | 기본 버튼 테두리 두께 |
| pkpvClearButtonStrokeColor | #00000000 | 기본 버튼 테두리 색상 |
| pkpvDividerColor | #00000000 | 구분선 색상 |
| pkpvDividerWidth | 0dp | 세로 구분선 폭 |
| pkpvDividerHeight | 0dp | 가로 구분선 높이 |
| pkpvRootBackgroundDrawable | #ffffff | 배경 |

### Kotlin

| Function | Parameter | Description |
|:----------|:----------|:----------|
| setClearKeyPadText() | Void | 입력 값 초기화 |
| getKeyPadText() | Void | 입력 값 가져오기 |
<br/>
<br/>



## 4. PinKeyPadHorizontalView

### XML

| Option | Default | Description |
|:----------|:----------|:----------|
| pkphDefaultButtonTextSize | 24 | 기본 버튼 글자 크기 |
| pkphDefaultButtonTextColor | #000000 | 기본 버튼 글자 색상 |
| pkphDefaultButtonBackgroundColor | #00000000 | 기본 버튼 배경 색상 |
| pkphDefaultButtonRippleColor | #00000000 | 기본 버튼 클릭 효과 색상 |
| pkphDefaultButtonCornerRadius | 0dp | 기본 버튼 코너 |
| pkphDefaultButtonStrokeWidth | 0dp | 기본 버튼 테두리 두께 |
| pkphDefaultButtonStrokeColor | #00000000 | 기본 버튼 테두리 색상 |
| pkphDeleteButtonIcon | btn_keyboard_del_black.png | 삭제 버튼 아이콘 |
| pkphDeleteButtonIconSize | 24dp | 삭제 버튼 아이콘 크기 |
| pkphDeleteButtonBackgroundColor | #00000000 | 삭제 버튼 배경 색상 |
| pkphDeleteButtonRippleColor | #00000000 | 삭제 버튼 클릭 효과 색상 |
| pkphDeleteButtonCornerRadius | 0dp | 삭제 버튼 코너 |
| pkphDeleteButtonStrokeWidth | 0dp | 삭제 버튼 테두리 두께 |
| pkphDeleteButtonStrokeColor | #00000000 | 삭제 버튼 테두리 색상 |
| pkphEmptyButtonIcon | btn_empty.png | 빈 버튼 아이콘 |
| pkphEmptyButtonIconSize | 24dp | 빈 버튼 아이콘 크기 |
| pkphEmptyButtonBackgroundColor | #00000000 | 빈 버튼 배경 색상 |
| pkphEmptyButtonCornerRadius | 0dp | 빈 버튼 코너 |
| pkphEmptyButtonStrokeWidth | 0dp | 빈 버튼 테두리 두께 |
| pkphEmptyButtonStrokeColor | #00000000 | 빈 버튼 테두리 색상 |
| pkphClearButtonText | CLEAR | 전체삭제 버튼 텍스트 |
| pkphClearButtonTextSize | 24 | 전체삭제 버튼 글자 크기 |
| pkphClearButtonTextColor | #000000 | 전체삭제 버튼 글자 색상 |
| pkphClearButtonBackgroundColor | #00000000 | 전체삭제 버튼 배경 색상 |
| pkphClearButtonRippleColor | #00000000 | 전체삭제 버튼 클릭 효과 색상 |
| pkphClearButtonCornerRadius | 0dp | 전체삭제 버튼 코너 |
| pkphClearButtonStrokeWidth | 0dp | 전체삭제 버튼 테두리 두께 |
| pkphClearButtonStrokeColor | #00000000 | 전체삭제 버튼 테두리 색상 |
| pkphDividerColor | #00000000 | 구분선 색상 |
| pkphDividerWidth | 0dp | 세로 구분선 폭 |
| pkphDividerHeight | 0dp | 가로 구분선 높이 |
| pkphRootBackgroundDrawable | #ffffff | 배경 |

### Kotlin

| Function | Parameter | Description |
|:----------|:----------|:----------|
| setClearKeyPadText() | Void | 입력 값 초기화 |
| getKeyPadText() | Void | 입력 값 가져오기 |
<br/>
<br/>



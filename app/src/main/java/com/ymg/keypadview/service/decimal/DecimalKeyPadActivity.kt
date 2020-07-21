package com.ymg.keypadview.service.decimal

import android.os.Bundle
import android.util.Log
import com.ymg.keypadmodule.decimal.DecimalKeyPadView
import com.ymg.keypadview.R
import com.ymg.keypadview.main.BasicActivity
import kotlinx.android.synthetic.main.activity_decimal_key_pad.*


class DecimalKeyPadActivity: BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decimal_key_pad)
        decimalKeyPadView.setDecimalKeyPadListener(decimalKeyPadListener)
    }

    private var decimalKeyPadListener = object : DecimalKeyPadView.DecimalKeyPadListener {
        override fun decimalKeyPadChanged(keyPadValue: String) {
            Log.e("DEBUG", "Value: $keyPadValue")
            textKeyPadValue.text = keyPadValue
        }
    }
}
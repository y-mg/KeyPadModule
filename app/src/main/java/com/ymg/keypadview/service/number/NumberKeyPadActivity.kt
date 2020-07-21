package com.ymg.keypadview.service.number

import android.os.Bundle
import android.util.Log
import com.ymg.keypadmodule.number.NumberKeyPadView
import com.ymg.keypadview.R
import com.ymg.keypadview.main.BasicActivity
import kotlinx.android.synthetic.main.activity_number_key_pad.*


class NumberKeyPadActivity: BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_key_pad)
        numberKeyPadView.setNumberKeyPadListener(numberKeyPadListener)
    }

    private var numberKeyPadListener = object : NumberKeyPadView.NumberKeyPadListener {
        override fun numberKeyPadChanged(keyPadValue: String) {
            Log.e("DEBUG", "Value: $keyPadValue")
            textKeyPadValue.text = keyPadValue
        }
    }
}



/*
class NumberKeyPadActivity: BasicActivity(), NumberKeypadView.NumberKeyPadListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_key_pad)

        numberKeyPadView.setKeyboardListener(this)
    }

    override fun numberKeyPadChanged(keyPadValue: String) {
        Log.e("DEBUG", "Value: $keyPadValue")
        textKeyPadValue.text = keyPadValue
    }
}*/
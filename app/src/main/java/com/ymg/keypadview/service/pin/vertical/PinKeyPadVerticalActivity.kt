package com.ymg.keypadview.service.pin.vertical

import android.os.Bundle
import android.util.Log
import com.ymg.keypadmodule.pin.vertical.PinKeyPadVerticalView
import com.ymg.keypadview.R
import com.ymg.keypadview.main.BasicActivity
import kotlinx.android.synthetic.main.activity_pin_key_pad_vertical.*

class PinKeyPadVerticalActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_key_pad_vertical)

        pinKeyPadVerticalView.setAttachPinIndicatorView(pinIndicatorView)
        pinKeyPadVerticalView.setPinKeyPadVerticalListener(pinKeyPadVerticalListener)
    }

    private var pinKeyPadVerticalListener = object : PinKeyPadVerticalView.PinKeyPadVerticalListener {
        override fun pinKeyPadVerticalChanged(keyPadValue: String) {
            Log.e("DEBUG", "Value: $keyPadValue")
        }
    }
}
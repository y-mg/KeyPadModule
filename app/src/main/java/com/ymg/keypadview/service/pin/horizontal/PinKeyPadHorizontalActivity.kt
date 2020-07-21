package com.ymg.keypadview.service.pin.horizontal

import android.os.Bundle
import android.util.Log
import com.ymg.keypadmodule.pin.horizontal.PinKeyPadHorizontalView
import com.ymg.keypadview.R
import com.ymg.keypadview.main.BasicActivity
import kotlinx.android.synthetic.main.activity_pin_key_pad_horizontal.*


class PinKeyPadHorizontalActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_key_pad_horizontal)

        pinKeyPadHorizontalView.setAttachPinIndicatorView(pinIndicatorView)
        pinKeyPadHorizontalView.setPinKeyPadHorizontalListener(pinKeyPadHorizontalListener)
    }

    private var pinKeyPadHorizontalListener = object : PinKeyPadHorizontalView.PinKeyPadHorizontalListener {
        override fun pinKeyPadHorizontalChanged(keyPadValue: String) {
            Log.e("DEBUG", "Value: $keyPadValue")
        }
    }
}
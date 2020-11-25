package com.ymg.keypadview.service.pin.vertical

import android.os.Bundle
import android.util.Log
import com.ymg.keypadmodule.pin.vertical.PinKeyPadVerticalView
import com.ymg.keypadview.databinding.ActivityPinKeyPadVerticalBinding
import com.ymg.keypadview.main.BasicActivity


class PinKeyPadVerticalActivity : BasicActivity() {

    private lateinit var viewBinding: ActivityPinKeyPadVerticalBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityPinKeyPadVerticalBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.apply {
            pinKeyPadVerticalView.setAttachPinIndicatorView(pinIndicatorView)
            pinKeyPadVerticalView.setPinKeyPadVerticalListener(pinKeyPadVerticalListener)
        }
    }

    private var pinKeyPadVerticalListener = object : PinKeyPadVerticalView.PinKeyPadVerticalListener {
        override fun pinKeyPadVerticalChanged(keyPadValue: String) {
            Log.e("DEBUG", "Value: $keyPadValue")
        }
    }
}
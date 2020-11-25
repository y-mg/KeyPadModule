package com.ymg.keypadview.service.pin.horizontal

import android.os.Bundle
import android.util.Log
import com.ymg.keypadmodule.pin.horizontal.PinKeyPadHorizontalView
import com.ymg.keypadview.databinding.ActivityPinKeyPadHorizontalBinding
import com.ymg.keypadview.main.BasicActivity


class PinKeyPadHorizontalActivity : BasicActivity() {

    private lateinit var viewBinding: ActivityPinKeyPadHorizontalBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityPinKeyPadHorizontalBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.apply {
            pinKeyPadHorizontalView.setAttachPinIndicatorView(pinIndicatorView)
            pinKeyPadHorizontalView.setPinKeyPadHorizontalListener(pinKeyPadHorizontalListener)
        }
    }

    private var pinKeyPadHorizontalListener = object : PinKeyPadHorizontalView.PinKeyPadHorizontalListener {
        override fun pinKeyPadHorizontalChanged(keyPadValue: String) {
            Log.e("DEBUG", "Value: $keyPadValue")
        }
    }
}
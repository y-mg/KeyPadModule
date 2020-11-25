package com.ymg.keypadview.service.decimal

import android.os.Bundle
import android.util.Log
import com.ymg.keypadmodule.decimal.DecimalKeyPadView
import com.ymg.keypadview.databinding.ActivityDecimalKeyPadBinding
import com.ymg.keypadview.main.BasicActivity



class DecimalKeyPadActivity: BasicActivity() {

    private lateinit var viewBinding: ActivityDecimalKeyPadBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDecimalKeyPadBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.decimalKeyPadView.setDecimalKeyPadListener(decimalKeyPadListener)
    }

    private var decimalKeyPadListener = object : DecimalKeyPadView.DecimalKeyPadListener {
        override fun decimalKeyPadChanged(keyPadValue: String) {
            Log.e("DEBUG", "Value: $keyPadValue")
            viewBinding.textKeyPadValue.text = keyPadValue
        }
    }
}
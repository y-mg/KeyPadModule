package com.ymg.keypadview.service.number

import android.os.Bundle
import android.util.Log
import com.ymg.keypadmodule.number.NumberKeyPadView
import com.ymg.keypadview.databinding.ActivityNumberKeyPadBinding
import com.ymg.keypadview.main.BasicActivity



class NumberKeyPadActivity: BasicActivity() {

    private lateinit var viewBinding: ActivityNumberKeyPadBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNumberKeyPadBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.numberKeyPadView.setNumberKeyPadListener(numberKeyPadListener)
    }

    private var numberKeyPadListener = object : NumberKeyPadView.NumberKeyPadListener {
        override fun numberKeyPadChanged(value: String) {
            Log.e("DEBUG", "Value: $value")
            viewBinding.textKeyPadValue.text = value
        }
    }
}
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
        override fun numberKeyPadChanged(keyPadValue: String) {
            Log.e("DEBUG", "Value: $keyPadValue")
            viewBinding.textKeyPadValue.text = keyPadValue
        }
    }
}



/*
class NumberKeyPadActivity: BasicActivity(), NumberKeypadView.NumberKeyPadListener {

    private lateinit var viewBinding: ActivityNumberKeyPadBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNumberKeyPadBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.numberKeyPadView.setKeyboardListener(this)
    }

    override fun numberKeyPadChanged(keyPadValue: String) {
        Log.e("DEBUG", "Value: $keyPadValue")
        viewBinding.textKeyPadValue.text = keyPadValue
    }
}*/
package com.ymg.keypadview.main

import android.content.Intent
import android.os.Bundle
import com.ymg.keypadview.R
import com.ymg.keypadview.service.decimal.DecimalKeyPadActivity
import com.ymg.keypadview.service.number.NumberKeyPadActivity
import com.ymg.keypadview.service.pin.horizontal.PinKeyPadHorizontalActivity
import com.ymg.keypadview.service.pin.vertical.PinKeyPadVerticalActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
    }

    private fun bindView() {
        // Number Key Pad
        btnNumberKeyPad.setOnClickListener {
            startActivity(
                Intent(this, NumberKeyPadActivity::class.java)
            )
        }

        // Decimal Key Pad
        btnDecimalKeyPad.setOnClickListener {
            startActivity(
                Intent(this, DecimalKeyPadActivity::class.java)
            )
        }

        // Pin Key Pad Vertical
        btnPinKeyPadVertical.setOnClickListener {
            startActivity(
                Intent(this, PinKeyPadVerticalActivity::class.java)
            )
        }

        // Pin Key Pad Horizontal
        btnPinKeyPadHorizontal.setOnClickListener {
            startActivity(
                Intent(this, PinKeyPadHorizontalActivity::class.java)
            )
        }
    }
}
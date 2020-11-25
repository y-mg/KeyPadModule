package com.ymg.keypadview.main

import android.content.Intent
import android.os.Bundle
import com.ymg.keypadview.databinding.ActivityMainBinding
import com.ymg.keypadview.service.decimal.DecimalKeyPadActivity
import com.ymg.keypadview.service.number.NumberKeyPadActivity
import com.ymg.keypadview.service.pin.horizontal.PinKeyPadHorizontalActivity
import com.ymg.keypadview.service.pin.vertical.PinKeyPadVerticalActivity


class MainActivity : BasicActivity() {

    private lateinit var viewBinding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        bindView()
    }

    private fun bindView() {
        viewBinding.apply {
            // Number Key Pad
            btnNumberKeyPad.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, NumberKeyPadActivity::class.java)
                )
            }

            // Decimal Key Pad
            btnDecimalKeyPad.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, DecimalKeyPadActivity::class.java)
                )
            }

            // Pin Key Pad Vertical
            btnPinKeyPadVertical.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, PinKeyPadVerticalActivity::class.java)
                )
            }

            // Pin Key Pad Horizontal
            btnPinKeyPadHorizontal.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, PinKeyPadHorizontalActivity::class.java)
                )
            }
        }
    }
}
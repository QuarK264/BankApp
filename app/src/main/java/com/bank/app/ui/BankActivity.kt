package com.bank.app.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.bank.app.R
import com.bank.app.core.base.BaseActivity
import com.bank.app.viewmodel.BankViewModel

class BankActivity : BaseActivity() {
    val viewModel: BankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bank)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return super.onSupportNavigateUp()
    }
}
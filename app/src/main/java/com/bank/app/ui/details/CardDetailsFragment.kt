package com.bank.app.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.bank.app.R
import com.bank.app.core.base.BaseFragment
import com.bank.app.core.extension.initializeToolbar
import com.bank.app.ui.details.model.User
import com.bank.app.viewmodel.BankViewModel
import com.bank.app.viewmodel.BankViewModelFactory
import com.bank.app.viewmodel.Status
import com.bank.app.viewmodel.UserResponse
import kotlinx.android.synthetic.main.fragment_card_details.*
import kotlinx.android.synthetic.main.layout_currency_card.view.*
import kotlinx.android.synthetic.main.layout_transaction_history.*
import kotlinx.android.synthetic.main.layout_user_details.*
import java.math.RoundingMode
import java.text.DecimalFormat

class CardDetailsFragment : BaseFragment() {

    private val viewModel by activityViewModels<BankViewModel> {
        BankViewModelFactory(requireActivity().application)
    }

    private val adapter by lazy { TransactionHistoryAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_card_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeToolbar(toolbar, getString(R.string.user_details_title), false)
        setupCurrencyCards()

        adapter.attachTo(transactionHistoryRecyclerView)

        viewModel.response.observe(viewLifecycleOwner) { processResponse(it) }

        viewModel.getUser()
    }

    private fun processResponse(userResponse: UserResponse) {
        when (userResponse.status) {
            Status.LOADING -> renderLoadingState()
            Status.SUCCESS -> renderDataState(userResponse.data)
            Status.ERROR -> renderErrorState(userResponse.error)
        }
    }

    private fun renderLoadingState() {

    }

    private fun renderDataState(data: User?) {
        if (data != null) {
            with(data) {
                cardNumberView.text = cardNumber
                userNameView.text = cardholderName
                cardValidDateView.text = valid
                cardImageView.setImageResource(
                    when (type) {
                        "mastercard" -> R.drawable.ic_mastercard
                        "visa" -> R.drawable.ic_visa
                        "unionpay" -> R.drawable.ic_union_pay
                        else -> 0
                    }
                )

                val standardBalance = standardBalance.setScale(2, RoundingMode.DOWN)
                val balance = balance.setScale(2, RoundingMode.DOWN)
                val decimalFormat = DecimalFormat()
                decimalFormat.maximumFractionDigits = 2
                decimalFormat.minimumFractionDigits = 0
                decimalFormat.isGroupingUsed = false
                standardCardBalanceView.text =
                    getString(R.string.standard_balance_pattern, decimalFormat.format(standardBalance))
                cardBalanceView.text =
                    getString(R.string.eur_balance_pattern, decimalFormat.format(balance))

                adapter.submitList(transactionHistory)
            }
        }
    }

    private fun renderErrorState(error: Throwable?) {
        if (error != null) {
            Log.e("dataError", error.toString())
        }
    }

    private fun setupCurrencyCards() {
        gbpCardView.currencySymbolView.text = getString(R.string.gbp_symbol)
        gbpCardView.currencyNameView.text = getString(R.string.gbp_name)
        eurCardView.currencySymbolView.text = getString(R.string.eur_symbol)
        eurCardView.currencyNameView.text = getString(R.string.eur_name)
        rubCardView.currencySymbolView.text = getString(R.string.rub_symbol)
        rubCardView.currencyNameView.text = getString(R.string.rub_name)
    }
}
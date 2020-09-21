package com.bank.app.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.bank.app.R
import com.bank.app.core.base.BaseFragment
import com.bank.app.core.extension.initializeToolbar
import com.bank.app.viewmodel.BankViewModel
import com.bank.app.viewmodel.BankViewModelFactory
import com.bank.app.viewmodel.Response
import com.bank.app.viewmodel.Status
import kotlinx.android.synthetic.main.fragment_card_details.*

class CardDetailsFragment : BaseFragment() {

    private val viewModel by activityViewModels<BankViewModel> {
        BankViewModelFactory(requireActivity().application)
    }

    private val adapter by lazy {  }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_card_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeToolbar(toolbar, getString(R.string.user_details_title), false)

        viewModel.response.observe(viewLifecycleOwner) { processResponse(it) }
    }

    private fun processResponse(response: Response) {
        when (response.status) {
            Status.LOADING -> renderLoadingState()
            Status.SUCCESS -> renderDataState()
            Status.ERROR -> renderErrorState()
        }
    }

    private fun renderLoadingState() {
        TODO("Not yet implemented")
    }

    private fun renderDataState() {
        TODO("Not yet implemented")
    }

    private fun renderErrorState() {
        TODO("Not yet implemented")
    }
}
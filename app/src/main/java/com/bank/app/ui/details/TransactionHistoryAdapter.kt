package com.bank.app.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bank.app.R
import com.bank.app.ui.details.model.Transaction
import kotlinx.android.synthetic.main.layout_transaction_item.view.*
import java.text.DecimalFormat

class TransactionHistoryAdapter : ListAdapter<Transaction, RecyclerView.ViewHolder>(ItemCallback) {

    fun attachTo(target: RecyclerView) {
        target.adapter = this
        val context = target.context
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        target.layoutManager = linearLayoutManager
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            inflater.inflate(R.layout.layout_transaction_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = holder.itemView
        val context = view.context
        val item = getItem(position)
        val decimalFormat = DecimalFormat()
        decimalFormat.maximumFractionDigits = 2
        decimalFormat.minimumFractionDigits = 0
        decimalFormat.isGroupingUsed = false

        with(view) {
            transactionNameView.text = item.title
            transactionDateView.text = item.date
            transactionAmountView.text = decimalFormat.format(item.amount)
            transactionStandardAmountView.text = decimalFormat.format(item.standardAmount)
        }
    }

    private class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private object ItemCallback : DiffUtil.ItemCallback<Transaction>() {
        override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean =
            oldItem.title == newItem.title && oldItem.amount == newItem.amount

        override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean =
            oldItem == newItem
    }
}
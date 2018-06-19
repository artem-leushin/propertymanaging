package com.panda.materialproperty.presentation.enterprises

import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.panda.materialproperty.BR
import com.panda.materialproperty.R
import com.panda.materialproperty.databinding.ItemEnterpriseBinding
import com.panda.materialproperty.databinding.ItemHeaderEnterpriseBinding
import com.panda.materialproperty.presentation.enterprises.EnterprisesContract.View.DisplayableItem

/**
 * Created by A.Olkinitskaya on 19.06.2018.
 */

class EnterprisesAdapter : ListAdapter<DisplayableItem, EnterprisesAdapter.ViewHolder>(
    ItemDiffCallback
) {

    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (!::inflater.isInitialized) inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            R.layout.item_header_enterprise -> ViewHolder(
                ItemHeaderEnterpriseBinding.inflate(inflater, parent, false)
            )

            R.layout.item_enterprise -> ViewHolder(
                ItemEnterpriseBinding.inflate(inflater, parent, false)
            )

            else -> throw IllegalStateException("unsupported viewtype for ViewHolder $viewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is DisplayableItem.HeaderRow -> R.layout.item_header_enterprise
        is DisplayableItem.EnterpriseRow -> R.layout.item_enterprise
        else -> {
            throw IllegalStateException("unsupported viewtype for position $position")
        }
    }

    inner class ViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DisplayableItem) {
            if (binding.setVariable(BR.itemState, data)) binding.executePendingBindings()
        }
    }

    companion object ItemDiffCallback :
        DiffUtil.ItemCallback<DisplayableItem>() {
        override fun areItemsTheSame(
            oldItem: DisplayableItem,
            newItem: DisplayableItem
        ): Boolean =
            if (oldItem is DisplayableItem.EnterpriseRow && newItem is DisplayableItem.EnterpriseRow)
                oldItem.id == newItem.id
            else
                true


        override fun areContentsTheSame(
            oldItem: DisplayableItem,
            newItem: DisplayableItem
        ): Boolean = oldItem == newItem
    }
}


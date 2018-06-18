package com.panda.materialproperty.presentation.enterprises

import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.panda.materialproperty.domain.entity.Enterprise

/**
 * Created by A.Olkinitskaya on 19.06.2018.
 */
class EnterprisesAdapter : ListAdapter<Enterprise, EnterprisesAdapter.ViewHolder>(
    ItemDiffCallback
) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented")
    }


    inner class ViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bind() {

        }

    }

    companion object ItemDiffCallback :
        DiffUtil.ItemCallback<Enterprise>() {
        override fun areItemsTheSame(
            oldItem: Enterprise,
            newItem: Enterprise
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Enterprise,
            newItem: Enterprise
        ): Boolean = oldItem == newItem
    }
}


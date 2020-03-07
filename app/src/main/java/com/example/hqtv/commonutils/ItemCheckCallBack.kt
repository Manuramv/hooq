package com.example.hqtv.commonutils

import androidx.recyclerview.widget.DiffUtil
import com.example.hqtv.models.Result
import com.example.hqtv.view.RowItemViewModel

/**
 * Created by manuramv on 2020-03-04.
 */
class ItemCheckCallBack : DiffUtil.ItemCallback<Result>(){
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id;
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return return oldItem == newItem
    }
}
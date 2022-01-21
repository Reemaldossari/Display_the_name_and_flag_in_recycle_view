package com.reemsd.display_the_name_and_flag_in_recycle_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.reemsd.display_the_name_and_flag_in_recycle_view.databinding.ListItemBinding

class CountryAdapter : androidx.recyclerview.widget.ListAdapter<Country, CountryAdapter.CountryViewHolder>(DiffCallback){

    class CountryViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindImage(flagPic: Country) {
            binding.country = flagPic
            binding.executePendingBindings()

        }


    }
    companion object DiffCallback: DiffUtil.ItemCallback<Country>(){
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.flag == newItem.flag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
         val flagPhoto = getItem(position)
        println(flagPhoto.flag)
        holder.bindImage(flagPhoto)
     }
}


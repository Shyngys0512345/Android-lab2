package kz.android.androidlab2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.android.androidlab2.databinding.CelebrityBinding
import kz.android.androidlab2.models.Celebrity

class CelebrityAdapter : ListAdapter<Celebrity, CelebrityAdapter.CelebrityViewHolder>(CelebrityDiffUtils()) {


    class CelebrityDiffUtils:DiffUtil.ItemCallback<Celebrity>(){
        override fun areItemsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
            return oldItem.name === newItem.name
        }

        override fun areContentsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
            return oldItem == newItem
        }

    }
    override fun onBindViewHolder(holder: CelebrityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebrityViewHolder {
        return CelebrityViewHolder(
            CelebrityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class CelebrityViewHolder(private val binding: CelebrityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(celebrity: Celebrity) {
            binding.name.text = celebrity.name
            binding.netWorth.text = "Net Worth: \$${celebrity.netWorth}"
            binding.gender.text = "Gender: ${celebrity.gender}"
            binding.nationality.text = "Nationality: ${celebrity.nationality}"
            binding.occupation.text = "Occupation: ${celebrity.occupation?.joinToString(", ")}"
            binding.height.text = "Height: ${celebrity.height}m"
            binding.birthday.text = "Birthday: ${celebrity.birthday}"
        }
    }


}
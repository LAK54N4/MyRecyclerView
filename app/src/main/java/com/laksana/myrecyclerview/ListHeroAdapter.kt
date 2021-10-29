package com.laksana.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laksana.myrecyclerview.databinding.ItemRowHeroBinding

class ListHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            with(binding) {
                imgItemPhoto.setImageResource(hero.photo)
                tvItemName.text = hero.name
                tvItemDescription.text = hero.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val name = listHero[position]
        val description = listHero[position]
        val photo = listHero[position]

        holder.bind(name)
        holder.bind(description)
        holder.bind(photo)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }

}
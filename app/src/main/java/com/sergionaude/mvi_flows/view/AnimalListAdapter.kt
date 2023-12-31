package com.sergionaude.mvi_flows.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sergionaude.mvi_flows.R
import com.sergionaude.mvi_flows.api.AnimalService
import com.sergionaude.mvi_flows.model.Animal
import kotlinx.android.synthetic.main.animal_item.view.*

class AnimalListAdapter(private val animals: ArrayList<Animal>) :
    RecyclerView.Adapter<AnimalListAdapter.DataViewHolder>() {

    fun newAnimals(newAnimals: List<Animal>) {
        animals.clear()
        animals.addAll(newAnimals)
        notifyDataSetChanged()
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(animal: Animal) {
            itemView.animalName.text = animal.name
            itemView.animalLocation.text = animal.location
            val url = AnimalService.BASE_URL + animal.image
            Glide.with(itemView.animalImage.context)
                .load(url)
                .into(itemView.animalImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.animal_item, parent, false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(animals[position])
    }

    override fun getItemCount() = animals.size
}
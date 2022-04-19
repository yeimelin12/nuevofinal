package com.example.myapplication2project.model

import android.content.Intent
import android.os.Message
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2project.R
import com.example.myapplication2project.databinding.TvShowListItemBinding
import com.example.myapplication2project.registro
import com.example.myapplication2project.viewmodel.episodateviewmodel
import com.squareup.picasso.Picasso

class tvShowListAdapter (val tvShows:List<tvshow>,val viewModel:episodateviewmodel): RecyclerView.Adapter<tvShowListAdapter.ViewHolder>() {

    public class ViewHolder(binding: TvShowListItemBinding): RecyclerView.ViewHolder(binding.root){
        val binding = binding


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(TvShowListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val tvShow = tvShows[position]

        Picasso.get().load(tvShow.image)
            .placeholder(R.drawable.cargando)
            .centerCrop()
            .resize(90*2,100*2)
            .into(holder.binding.poster)

        val tvshow = tvShows[position];
        holder.binding.tvshowname.text = tvshow.name
        holder.binding.date.text = tvshow.startDate
        holder.binding.status.text = tvshow.status
        holder.binding.root.setOnClickListener{
            viewModel.setSelectedItem(tvshow)

        }
        holder.binding.favo.setOnClickListener {


        }
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }
}
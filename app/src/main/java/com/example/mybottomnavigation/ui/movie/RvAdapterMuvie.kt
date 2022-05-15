package com.example.mybottomnavigation.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybottomnavigation.R
import com.example.mybottomnavigation.databinding.SingleItemMovieBinding


class RvAdapterMuvie constructor(var list: MutableList<Movie>): RecyclerView.Adapter<MovieViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var binding =
            SingleItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var movie= list[position]
        holder.binding.name.text = movie.name
        holder.binding.category.text = movie.category
        holder.binding.category2.text = movie.desc

        Glide.with(holder.binding.root.context)

            .load(movie.imageUrlMovie)
            //     .transform(CircleCrop())
            //    .fitCenter()
            //  .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .override(1000)
            .into(holder.binding.imageViewMovie)

        println(movie.imageUrlMovie + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@22")




//holder.binding.constLayout.setOnClickListener{
//    var intent:Intent = Intent(holder.binding.root.context, MainActivity ::class.java)
//    intent.putExtra("Herrro", hero)
//
//    holder.binding.root.context.startActivity(intent)
//}


    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun addList(list: List<Movie>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}



class MovieViewHolder (var binding: SingleItemMovieBinding ): RecyclerView.ViewHolder(binding.root){

}

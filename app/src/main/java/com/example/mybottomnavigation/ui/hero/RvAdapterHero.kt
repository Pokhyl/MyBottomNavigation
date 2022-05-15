package com.example.retrofittt

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybottomnavigation.R
import com.example.mybottomnavigation.databinding.SingleItemHeroBinding
import com.example.mybottomnavigation.ui.hero.Hero


class RvAdapter(var list: MutableList<Hero>): RecyclerView.Adapter<HeroViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        var binding =
            SingleItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        var hero = list[position]

        holder.binding.nameee.text= hero.name
        holder.binding.realnameee.text = hero.realname
        holder.binding.createdbyyy.text = hero.createdby
        holder.binding.firstappearanceee.text = hero.firstappearance
        holder.binding.teammm.text = hero.team
        holder.binding.publisherrr.text = hero.publisher
        holder.binding.biooo.text = hero.bio





//holder.binding.constLayout.setOnClickListener{
//    var intent:Intent = Intent(holder.binding.root.context, MainActivity ::class.java)
//    intent.putExtra("Herrro", hero)
//
//    holder.binding.root.context.startActivity(intent)
//}
        Glide.with(holder.binding.root.context)

            .load(hero.imageurl)
       //     .transform(CircleCrop())
       //    .fitCenter()
          //  .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(com.bumptech.glide.R.drawable.abc_ab_share_pack_mtrl_alpha)
          .override(1000)
            .into(holder.binding.imageView)

    }

    override fun getItemCount(): Int {
       return list.size
    }
    fun addList(list: List<Hero>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}

private fun Intent.putExtra(s: String, hero: Hero) {

}

class HeroViewHolder (var binding: SingleItemHeroBinding): RecyclerView.ViewHolder(binding.root){

}


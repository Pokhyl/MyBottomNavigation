package com.example.mybottomnavigation.ui.hero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybottomnavigation.databinding.FragmentHeroBinding
import com.example.retrofittt.RvAdapter

class HeroFragment : Fragment() {

    private lateinit var _binding: FragmentHeroBinding
  lateinit var  heroViewModel:HeroViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         heroViewModel =
          //  ViewModelProvider(this).get(HomeViewModel::class.java)
            ViewModelProvider(this, HeroViewModelFactory(HeroRepository(RetrofitServiceHero.getInstance()))).get(
                HeroViewModel::class.java)
        _binding = FragmentHeroBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        heroViewModel.getAllHeroes()
        heroViewModel.heroList.observe(viewLifecycleOwner) {
            var adapter = RvAdapter(mutableListOf())
            binding.rViewHero.adapter = adapter
            binding.rViewHero.layoutManager = LinearLayoutManager(context?.applicationContext)
        adapter.addList(it)

        }
        heroViewModel.progresBar.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
        }
    }

}
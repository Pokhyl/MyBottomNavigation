package com.example.mybottomnavigation.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybottomnavigation.MainActivity
import com.example.mybottomnavigation.MyComponent

import com.example.mybottomnavigation.databinding.FragmentMovieBinding
import com.example.mybottomnavigation.ui.hero.HeroViewModel
import com.example.mybottomnavigation.ui.hero.HeroViewModelFactory
import javax.inject.Inject

class MovieFragment : Fragment() {

    private lateinit var _binding: FragmentMovieBinding


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var myComponent: MyComponent
    lateinit var  movieViewModel: MovieViewModel

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        myComponent = (requireActivity() as MainActivity).myComponent
        myComponent.inject(this)
        movieViewModel = ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)

        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var adapter = RvAdapterMuvie(mutableListOf())
        binding.rViewMovie.adapter = adapter
        binding.rViewMovie.layoutManager = LinearLayoutManager(context?.applicationContext)


        movieViewModel.getAllMovies()
     movieViewModel.movieList.observe(viewLifecycleOwner, {
         println(it+"???????????????????????????????????????????????????" )
         adapter.addList(it)
     })
        return root
    }



}
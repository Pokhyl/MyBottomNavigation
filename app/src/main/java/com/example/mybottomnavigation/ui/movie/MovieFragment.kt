package com.example.mybottomnavigation.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.mybottomnavigation.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    private lateinit var _binding: FragmentMovieBinding


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val movieViewModel =
       //     ViewModelProvider(this).get(DashboardViewModel::class.java)
            ViewModelProvider(this, MovieViewModelFactory(MovieRepository(RetrofitServiceMovie.getInstance()))).get(

                MovieViewModel::class.java)

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
package com.example.mybottomnavigation.ui.quote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybottomnavigation.MainActivity
import com.example.mybottomnavigation.MyComponent
import com.example.mybottomnavigation.databinding.FragmentQuoteBinding
import com.example.mybottomnavigation.ui.movie.MovieViewModel
import com.example.mybottomnavigation.ui.movie.MovieViewModelFactory
import javax.inject.Inject

class QuoteFragment : Fragment() {

    private var binding: FragmentQuoteBinding? = null
    lateinit var myComponent: MyComponent
    lateinit var  quoteViewModel: QuoteViewModel

    @Inject
    lateinit var quoteViewModelFactory: QuoteViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        myComponent = (requireActivity() as MainActivity).myComponent
        myComponent.inject(this)
        quoteViewModel = ViewModelProvider(this, quoteViewModelFactory).get(QuoteViewModel::class.java)
        binding = FragmentQuoteBinding.inflate(inflater, container, false)
        var adapterQuote = RvAdapterQuote(mutableListOf())
        binding!!.rw.adapter = adapterQuote
        binding!!.rw.layoutManager = LinearLayoutManager(context?.applicationContext)

        var retrofitServiQuote = RetrofitServiceQuote.getInstance()
        var  quoteRepository = QuoteRepository(retrofitServiQuote)
        var  quoteViewModel = QuoteViewModelFactory(quoteRepository)
        val notificationsViewModel =
            ViewModelProvider(this,quoteViewModel ).get(QuoteViewModel::class.java)
//        ViewModelProvider(this, HeroViewModelFactory(HomeRepository(RetrofitServiceHero.getInstance()))).get(
//            HomeViewModel::class.java)

        val root: View = binding!!.root

        val textView: TextView = binding!!.error
        notificationsViewModel.errorMessage.observe(viewLifecycleOwner) {
            textView.text = it
        }
        notificationsViewModel.progresBar.observe(viewLifecycleOwner){
            binding!!.progressBar2.isVisible = it
        }
        notificationsViewModel.quoteList.observe(viewLifecycleOwner){
            println(it.results)
           adapterQuote.addList(it.results)
        }
        notificationsViewModel.getAllQuotes()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
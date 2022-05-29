package co.za.giantpanda.hilt_mvvm_binding_etc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.za.giantpanda.hilt_mvvm_binding_etc.databinding.FragmentMainBinding
import co.za.giantpanda.hilt_mvvm_binding_etc.db.RepositoriesData
import kotlinx.android.synthetic.main.fragment_main.recyclerView
import androidx.lifecycle.ViewModelProviders
import co.za.giantpanda.hilt_mvvm_binding_etc.adapter.RecyclerViewAdapter
import co.za.giantpanda.hilt_mvvm_binding_etc.db.AppViewModel
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

class MainFragment : Fragment() {

  lateinit var flipper: ViewFlipper
  private lateinit var prev_Button: Button
  private lateinit var next_Button: Button
  private lateinit var main : MainActivity
  private lateinit var recyclerViewAdapter : RecyclerViewAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_main, container, false)

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)


    flipper = view.findViewById(R.id.view_flipper)
    prev_Button = view.findViewById(R.id.prev_button)
    next_Button = view.findViewById(R.id.next_button)

    prev_Button.setOnClickListener {

      flipper.setInAnimation(
        requireContext(),
        R.anim.slide_right
      )
      flipper.setOutAnimation(
        requireContext(),
        R.anim.slide_left
      )
      flipper.showPrevious()
    }


    next_Button.setOnClickListener {
      flipper.setInAnimation(
        requireContext(),
        R.anim.slide_left
      )
      flipper.setOutAnimation(
        requireContext(),
        R.anim.slide_right
      )
      flipper.showNext()
    }
  }

  private fun initViewModel() {
    recyclerView.apply {
      layoutManager = LinearLayoutManager(requireContext())
      recyclerView.addItemDecoration(
        DividerItemDecoration(
          main.baseContext,
          (layoutManager as LinearLayoutManager).orientation))
      recyclerViewAdapter = RecyclerViewAdapter()
      adapter = recyclerViewAdapter
    }

    fun initMainViewModel(){

     val viewModel = ViewModelProvider(this)[AppViewModel::class.java]

//      val viewModel = ViewModelProviders.of(ApplicationContext())[AppViewModel::class.java]
      viewModel.getAllRepositoryList().observe(this, Observer<List<RepositoriesData>>{
        recyclerViewAdapter.setListData(it)
        recyclerViewAdapter.notifyDataSetChanged()
      })
      viewModel.makeApiCall()

      }
    }

  }


package com.example.myapplication2project.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication2project.R
import com.example.myapplication2project.databinding.FragmentTvshowlistBinding
import com.example.myapplication2project.model.tvShowListAdapter
import com.example.myapplication2project.viewmodel.episodateviewmodel
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [tvshowlist.newInstance] factory method to
 * create an instance of this fragment.
 */
class tvshowlist : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentTvshowlistBinding.inflate(inflater, container,false)
        binding.tvShowsList.layoutManager = LinearLayoutManager(requireContext())
        val viewModel= ViewModelProvider(requireActivity()).get(episodateviewmodel::class.java)
        viewModel.tvshowlist.observe(viewLifecycleOwner,{
           binding.tvShowsList.adapter = tvShowListAdapter(it,viewModel);

        })

        viewModel.selected.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.tvshowdetail)
        }


        viewModel.error.observe(viewLifecycleOwner,{
            Snackbar.make(binding.root, it,Snackbar.LENGTH_SHORT).show()
        })

        viewModel.loadTvShows()

        return binding.root;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment tvshowlist.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tvshowlist().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
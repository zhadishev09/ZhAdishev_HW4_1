package com.example.zhadishev_hw4_1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.zhadishev_hw4_1.R
import com.example.zhadishev_hw4_1.databinding.FragmentHomeBinding
import com.example.zhadishev_hw4_1.model.Task
import com.example.zhadishev_hw4_1.ui.home.Adapter.TaskAdapter
import com.example.zhadishev_hw4_1.ui.task.TaskFragment.Companion.RESULT_KEY
import com.example.zhadishev_hw4_1.ui.task.TaskFragment.Companion.TASK_KEY

class HomeFragment : Fragment() {

private var _binding: FragmentHomeBinding? = null
    private val adapter = TaskAdapter()

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {


    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding.root
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvItem.adapter=adapter
        setFragmentResultListener(RESULT_KEY ){ requestKey, bundle ->
            val data=bundle.getSerializable(TASK_KEY) as Task
            adapter.setData(data)
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
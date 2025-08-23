package com.example.calculator_of_trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.calculator_of_trip.databinding.FragmentStartCalculatorBinding
import kotlin.getValue


class StartFragment : Fragment() {

    private var _binding : FragmentStartCalculatorBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FuelCalculatorViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // chamar funcao reset do ViewModel

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_startCalculatorFragment_to_priceFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}







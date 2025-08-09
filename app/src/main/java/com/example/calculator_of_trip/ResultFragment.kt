package com.example.calculator_of_trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.calculator_of_trip.databinding.FragmentResultBinding
import kotlin.getValue

class ResultFragment : Fragment() {

    private var _binding : FragmentResultBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FuelCalculatorViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newCalculation()
        backButton()
        showResult()
        viewModel.spent()
    }

    private fun showResult() {
        viewModel.gasPrice.observe(viewLifecycleOwner) { price ->
            val formatted = price?.let {
                getString(R.string.format_gas_price, it)
            }
            binding.tvPriceValue.text = formatted
        }

        viewModel.distanceTraveled.observe(viewLifecycleOwner) { distance ->
            val formatted = distance?.let {
                getString(R.string.format_distance, it)
            }
            binding.tvDistanceValue.text = formatted
        }

        viewModel.carConsumption.observe(viewLifecycleOwner) { consumption ->
            val formatted = consumption?.let {
                getString(R.string.format_consumption, it)
            }
            binding.tvConsumptionValue.text = formatted
        }

        viewModel.totalAmount.observe(viewLifecycleOwner) { total ->
            if (total != null) {
                val formatted = total?.let {
                    getString(R.string.format_total, it)
                }
                binding.tvTitleResult.text = formatted
            }

        }
    }

    private fun newCalculation() {
        binding.buttonResult.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_startCalculatorFragment)

        }
    }

    private fun backButton(){
        binding.btnBackResult.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
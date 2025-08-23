package com.example.calculator_of_trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.calculator_of_trip.databinding.FragmentGasPriceBinding


class PriceFragment : Fragment() {

    private var _binding : FragmentGasPriceBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FuelCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGasPriceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setGasPrice()
        backButton()

    }
    private fun setGasPrice(){
        binding.btnPrice.setOnClickListener {
            val gasPricingInput = binding.tiePrice.text.toString().toFloatOrNull()

            if (gasPricingInput != null){
                viewModel.setGasPrice(gasPricingInput)
                findNavController().navigate(R.id.action_priceFragment_to_consumptionFragment)
            }
            else {
                Toast.makeText(requireContext(), "Enter a valid value Ex. 3.50" , Toast.LENGTH_SHORT).show()}

        }
    }

    private fun backButton() {
        binding.ivBackPrice.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.example.calculator_of_trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.calculator_of_trip.databinding.FragmentCarConsumptionBinding
import kotlin.getValue


class CarConsumptionFragment : Fragment() {

    private var _binding : FragmentCarConsumptionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FuelCalculatorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarConsumptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCarConsumption()
        backButton()
    }

    private fun setCarConsumption(){
        binding.btnConsumption.setOnClickListener {
            val carConsumptionInput = binding.tieConsumption.text.toString().toFloatOrNull()

            if (carConsumptionInput != null){
                viewModel.setCarConsumption(carConsumptionInput)
                findNavController().navigate(R.id.action_consumptionFragment_to_distanceFragment)
            }
            else {
                Toast.makeText(requireContext(), "Enter a valid value Ex. 15 km/l" , Toast.LENGTH_SHORT).show()}
        }
    }

    private fun backButton(){
        binding.btnBackConsumption.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
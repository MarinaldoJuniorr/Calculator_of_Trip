package com.example.calculator_of_trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.calculator_of_trip.databinding.FragmentDistanceBinding


class DistanceFragment : Fragment() {

    private var _binding : FragmentDistanceBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FuelCalculatorViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDistanceBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDistance()
        backButton()

    }

    private fun setDistance(){
        binding.btnDistance.setOnClickListener {
            val distanceInput = binding.tieDistance.text.toString().toFloatOrNull()

            if (distanceInput != null) {
                viewModel.setDistance(distanceInput)
                findNavController().navigate(R.id.action_distanceFragment_to_resultFragment)
            }
            else {
                Toast.makeText(requireContext(), "Digite um valor valido Ex. 150 km", Toast.LENGTH_SHORT).show()}
        }
    }

    private fun backButton(){
        binding.btnBackDistance.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}



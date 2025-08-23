package com.example.calculator_of_trip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class FuelCalculatorViewModel : ViewModel() {
    private val _gasPrice = MutableLiveData<Float?>()
    val gasPrice : LiveData<Float?> = _gasPrice

    fun setGasPrice (gasPriceInput: Float) {
        _gasPrice.value = gasPriceInput
    }

    private val _carConsumption = MutableLiveData<Float?>()
    val carConsumption : LiveData<Float?> = _carConsumption

    fun setCarConsumption (carConsumptionInput: Float) {
        _carConsumption.value = carConsumptionInput
    }

    private val _distance = MutableLiveData<Float?>()
    val distanceTraveled : LiveData<Float?> = _distance

    fun setDistance (distanceInput: Float) {
        _distance.value = distanceInput
    }

    private val _totalAmount = MutableLiveData<Float?>()
    val totalAmount : LiveData<Float?> = _totalAmount

    fun spent() {
        val price = gasPrice.value
        val distance = distanceTraveled.value
        val consumption = carConsumption.value

        if (price != null && distance != null && consumption != null) {
            _totalAmount.value = (distance / consumption) * price
        }

    }

    fun reset() {
        _gasPrice.value = null
        _distance.value = null
        _carConsumption.value = null
        _totalAmount.value = null
    }
}
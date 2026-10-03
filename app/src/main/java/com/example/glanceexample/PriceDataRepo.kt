package com.example.glanceexample

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

object PriceDataRepo {

    var ticker = "GOOGL"
        private set

    private var previousPrice = 0f
    var change = 0
        private set

    private var _currentPrice = MutableStateFlow(0f)
    val currentPrice: StateFlow<Float> get() = _currentPrice

    fun update() {
        previousPrice = currentPrice.value
        _currentPrice.value = Random.nextDouble(20.0, 35.0).toFloat()

        if (previousPrice != 0f) {
            change = ((_currentPrice.value - previousPrice) / previousPrice * 100).toInt()
        }
    }
}
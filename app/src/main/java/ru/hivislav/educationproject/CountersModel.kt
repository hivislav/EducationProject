package ru.hivislav.educationproject

class CountersModel {
    private val counters = mutableListOf(0, 0, 0)

    fun getCurrent(dataPosition: Int): Int {
        return counters[dataPosition]
    }

    fun next(dataPosition: Int): Int {
        return counters[dataPosition]++
    }

    fun set(dataPosition: Int, value: Int) {
        counters[dataPosition] = value
    }
}
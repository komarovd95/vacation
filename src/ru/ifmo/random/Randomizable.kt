package ru.ifmo.random

interface Randomizable {
    fun randomize(random: (Double, Double) -> Double): Point2D
}
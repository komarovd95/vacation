package ru.ifmo.random

import kotlin.math.*

class Sphere(private val radius: Double) : Randomizable {
    override fun randomize(random: (Double, Double) -> Double): Point2D {
        val phi = random(0.0, 2.0 * PI)
        val r = random(-radius, radius)
        val theta = acos(r)

        val scale = 80.0

        val x = (phi - PI) * scale
        val y = (theta * 2.0 - PI) * scale

        return Point2D(x, y, min(max(1.0 / sin(theta), 0.0), 1000.0))
    }
}
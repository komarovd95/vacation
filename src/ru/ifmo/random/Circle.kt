package ru.ifmo.random

data class Circle(private val center: Point2D, private val radius: Double) : Randomizable {
    override fun randomize(random: (Double, Double) -> Double): Point2D {
        val r = Math.sqrt(random(0.0, 1.0)) * radius
        val phi = random(0.0, 2.0 * Math.PI)

        val x = r * Math.cos(phi)
        val y = r * Math.sin(phi)

        return Point2D(x, y)
    }
}
package ru.ifmo.random

data class Square(private val p1: Point2D, private val p2: Point2D) : Randomizable {
    override fun randomize(random: (Double, Double) -> Double): Point2D = if (p1.x < p2.x) {
        Point2D(random(p1.x, p2.x), random(p1.y, p2.y))
    } else {
        Point2D(random(p2.x, p1.x), random(p2.y, p1.y))
    }
}
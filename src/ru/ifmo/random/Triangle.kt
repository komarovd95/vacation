package ru.ifmo.random

class Triangle(private val v1: Point2D, private val v2: Point2D, private val v3: Point2D) : Randomizable {
    override fun randomize(random: (Double, Double) -> Double): Point2D {
        var r1 = random(0.0, 1.0)
        var r2 = random(0.0, 1.0)

        if (r1 + r2 >= 1.0) {
            r1 = 1.0 - r1
            r2 = 1.0 - r2
        }

        val vec1 = Point2D(v2.x - v1.x, v2.y - v1.y)
        val vec2 = Point2D(v3.x - v1.x, v3.y - v1.y)

        val vec3 = Point2D(vec1.x * r1, vec1.y * r1)
        val vec4 = Point2D(vec2.x * r2, vec2.y * r2)

        return Point2D(vec3.x + vec4.x + v1.x, vec3.y + vec4.y + v1.y)

    }
}
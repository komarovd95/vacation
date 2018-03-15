package ru.ifmo.random

import java.awt.EventQueue
import java.util.*

fun main(args: Array<String>) {
    val x1 = args[0].toDouble()
    val y1 = args[1].toDouble()

    val x2 = args[2].toDouble()
    val y2 = args[3].toDouble()

    val x3 = args[4].toDouble()
    val y3 = args[5].toDouble()

    val n = args[6].toInt()

    val triangle = Triangle(Point2D(x1, y1), Point2D(x2, y2), Point2D(x3, y3))

    EventQueue.invokeAndWait {
        val quickShow = QuickShow("Triangle")

        quickShow.draw(triangle, n)
    }
}
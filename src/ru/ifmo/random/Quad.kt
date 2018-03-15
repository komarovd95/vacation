package ru.ifmo.random

import java.awt.EventQueue
import java.util.*

fun main(args: Array<String>) {
    val x1 = args[0].toDouble()
    val y1 = args[1].toDouble()

    val x2 = args[2].toDouble()
    val y2 = args[3].toDouble()

    val n = args[4].toInt()

    val square = Square(Point2D(x1, y1), Point2D(x2, y2))

    EventQueue.invokeAndWait {
        val quickShow = QuickShow("Quad")

        quickShow.draw(square, n)
    }
}
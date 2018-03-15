package ru.ifmo.random

import java.awt.EventQueue

fun main(args: Array<String>) {
    val centerX = args[0].toDouble()
    val centerY = args[1].toDouble()
    val radius = args[2].toDouble()

    val n = args[3].toInt()

    val circle = Circle(Point2D(centerX, centerY), radius)

    EventQueue.invokeAndWait {
        val quickShow = QuickShow("Circle")

        quickShow.draw(circle, n)
    }
}
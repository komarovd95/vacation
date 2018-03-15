package ru.ifmo.random

import java.awt.EventQueue

fun main(args: Array<String>) {
    val radius = args[0].toDouble()
    val n = args[1].toInt()

    val sphere = Sphere(radius)

    EventQueue.invokeAndWait {
        val quickShow = QuickShow("Sphere")

        quickShow.draw(sphere, n)
    }
}
package ru.ifmo.random

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel
import kotlin.math.min

class QuickShow(showTitle: String) : JFrame() {
    private lateinit var pointsToDraw: Iterable<Point2D>

    private val drawPanel = object : JPanel() {
        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            g.drawLine(0, this@QuickShow.height / 2, this@QuickShow.width, this@QuickShow.height / 2)
            g.drawLine(this@QuickShow.width / 2, 0, this@QuickShow.width / 2, this@QuickShow.height)

            val matrix = Array(this@QuickShow.height) { Array(this@QuickShow.width) { 0.0 } }
            for (p in pointsToDraw) {
                val i = p.x.toInt()
                val j = p.y.toInt()

                matrix[j][i] += p.energy
            }

            val max = matrix.maxBy { it.max()!! }!!.max()!!

            for (y in 0 until matrix.size) {
                val row = matrix[y]
                for (x in 0 until row.size) {
                    val value = min((row[x] / max) * 2047.0, 255.0)
                    g.color = Color(0, value.toInt(), 0)
                    g.drawRect(x, y, 1, 1)
                }
            }
        }
    }

    init {
        title = showTitle

        contentPane.add(drawPanel)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        size = Dimension(1200, 1200)
        isVisible = true
    }

    fun draw(randomizable: Randomizable, n: Int) {
        val random = Random()
        pointsToDraw = object : Iterable<Point2D> {
            override fun iterator(): Iterator<Point2D> = object : Iterator<Point2D> {
                private var step = 0

                override fun hasNext(): Boolean = step < n

                override fun next(): Point2D {
                    step++
                    val p2d = randomizable.randomize { f, t -> random.nextDouble() * (t - f) + f }
                    return Point2D(width / 2.0 + p2d.x, height / 2.0 - p2d.y)
//                    return p2d
                }
            }
        }
        drawPanel.repaint()
    }
}
package util

import kotlin.math.exp
import kotlin.math.sqrt

class MathUtil {
    companion object {
        fun shift(value: Double, a1: Double, b1: Double, a2: Double, b2: Double): Double {
            return (value - a1) / (b1 - a1) * (b2 - a2) + a2
        }

        fun distance(x1: Double, y1: Double, x2: Double, y2: Double): Double {
            return sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))
        }
    }
}
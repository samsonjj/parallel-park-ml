package physics

import util.MathUtil
import kotlin.math.cos
import kotlin.math.sin

class Car (
        var x: Double,
        var y: Double,

//        var x2: Double,
//        var y2: Double,

        var w: Double,
        var l: Double,

        var a: Double,
        var isPlayerCar: Boolean
) {

//    init {
//        require(MathUtil.distance(x1, y1, x2, y2) < l)
//    }

    var v: Double = 0.0

    companion object {
        const val TURNING_SPEED = 1.0 // units?
        const val MAX_ACCELERATION = 3.0 // units?

        // https://ukma.org.uk/practical-help/motoring/
        const val DEFAULT_WIDTH = 1.860 // meters
        const val DEFAULT_LENGTH = 4.779 // meters
    }

    constructor(x: Double, y: Double) : this (
            x,
            y,
            DEFAULT_WIDTH,
            DEFAULT_LENGTH,
            0.0,
            false
    )

    constructor(x: Double, y: Double, a: Double) : this (
            x,
            y,
            DEFAULT_WIDTH,
            DEFAULT_LENGTH,
            a,
            false
    )

    fun turn(value: Double, seconds: Double) {
        require(value in -1.0..1.0)
        a += value * seconds * TURNING_SPEED
    }

    fun accelerate(value: Double, seconds: Double) {
        require(value in -1.0..1.0)
        val acceleration = MathUtil.shift(value, -1.0, 1.0, -MAX_ACCELERATION, MAX_ACCELERATION)
        v += acceleration * seconds
    }

    var count = 1
    fun update(seconds: Double) {
        val dx = (cos(a) * v) * seconds
        val dy = (sin(a) * v) * seconds
        x += dx
        y += dy

        count ++
        if (isPlayerCar) {
            println("$v: v, dx: $dx, dy: $dy, x: $x, y: $y, count: $count")
        }
    }
}
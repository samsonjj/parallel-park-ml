package physics

class Car (
        var x: Double,
        var y: Double,

        var w: Double,
        var l: Double,

        var a: Double,
) {

    companion object {
        const val TURNING_SPEED = 1 // units?
        const val MAX_ACCELERATION = 1 // units?
        const val MAX_DECELERATION = 1 // units?

        // https://ukma.org.uk/practical-help/motoring/
        const val DEFAULT_WIDTH = 1.860 // meters
        const val DEFAULT_LENGTH = 4.779 // meters
    }

    constructor(x: Double, y: Double) : this(
            x,
            y,
            DEFAULT_WIDTH,
            DEFAULT_LENGTH,
            0.0,
    ) { }

    fun turn() {}
    fun accelerate() {}
    fun decelerate() {}
}
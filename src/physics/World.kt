package physics

import kotlin.math.PI

class World(var playerCar: Car) {

    companion object {
        const val DEFAULT_MAP_WIDTH = 500.0
        const val DEFAULT_MAP_HEIGHT = 500.0
    }

    var mapWidth: Double = DEFAULT_MAP_WIDTH
    var mapHeight: Double = DEFAULT_MAP_HEIGHT
    var cars: MutableList<Car> = mutableListOf(playerCar)

    constructor(playerCar: Car, width: Double, height: Double) : this(playerCar) {
        this.mapWidth = width
        this.mapHeight = height
    }

    fun update() {
        playerCar.a += .05
//        car.x += cos(car.a / 180.0 * 2 * PI)
//        car.y += sin(car.a / 180.0 * 2 * PI)
//        println(playerCar.a / 180 * 2 * PI)
    }
}
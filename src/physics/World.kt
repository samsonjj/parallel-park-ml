package physics

class World(var playerCar: Car) {

    companion object {
        const val DEFAULT_MAP_WIDTH = 20.0
        const val DEFAULT_MAP_HEIGHT = 20.0
    }

    var mapWidth: Double = DEFAULT_MAP_WIDTH
    var mapHeight: Double = DEFAULT_MAP_HEIGHT

    /**
     * expose manipulations on the world's cars through
     * list operations on this instance variable
     */
    var cars: MutableList<Car> = mutableListOf(playerCar)

    constructor(playerCar: Car, width: Double, height: Double) : this(playerCar) {
        this.mapWidth = width
        this.mapHeight = height
    }

    fun update(seconds: Double) {
        for (car in this.cars) {
            car.update(seconds)
        }
//        playerCar.a += .05
//        car.x += cos(car.a / 180.0 * 2 * PI)
//        car.y += sin(car.a / 180.0 * 2 * PI)
//        println(playerCar.a / 180 * 2 * PI)
    }
}
package sample

data class Car (
        var x: Double,
        var y: Double,
        var w: Double,
        var l: Double,
        var a: Double,
)

class Game {
    var mapWidth = 800.0
    var mapHeight = 400.0

    var car = Car(0.0, 250.0, 60.0, 100.0, 90.0)
    var cars = listOf(
            Car(50.0, 0.0, 60.0, 100.0, 90.0),
            Car(350.0, 0.0, 60.0, 100.0, 90.0)
    )

    fun input() {}

    fun update() {
        car.x++
    }
}
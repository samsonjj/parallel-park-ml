package game

import display.Render
import javafx.scene.Scene
import physics.Car
import physics.World

class Game {
    private var world: World = createWorld()
    private var render: Render = Render(world)
    val scene: Scene
        get() = render.scene

    private fun createWorld(): World {
        val world = World(Car(250.0, 250.0, 60.0, 100.0, 90.0))
        world.cars.addAll(listOf(
                Car(50.0, 0.0, 60.0, 100.0, 90.0),
                Car(350.0, 0.0, 60.0, 100.0, 90.0)
        ))
        return world
    }

    fun startLoop() {
        render.startLoop()
    }
}
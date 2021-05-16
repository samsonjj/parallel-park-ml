package game

import display.Render
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.stage.Stage
import physics.Car
import physics.World
import kotlin.math.PI

/**
 * Game class is responsible for initializing and maintaining components which control the following:
 * 1) state
 * 2) display
 * 3) looping
 * It does so by managing Render, and World objects
 */
class Game(stage: Stage) {
    companion object {
        const val SECONDS_PER_FRAME = 1.0 / 60.0
    }

    private var world: World = createWorld()
    private var render: Render = Render(world) {
        processInputs()
        world.update(SECONDS_PER_FRAME)
    }
    private val scene: Scene
        get() = render.scene

    private var acceleratePressed = false
    private var deceleratePressed = false
    private var turnLeftPressed = false
    private var turnRightPressed = false

    init {
        // set up Render class
        stage.scene = scene

        // set up inputs
        scene.setOnKeyPressed { event ->
            handleKeyEvent(event, true)
        }
        scene.setOnKeyReleased { event ->
            handleKeyEvent(event, false)
        }
    }

    private fun createWorld(): World {
        // player car
        val world = World(Car(20.0, 20.0, Car.DEFAULT_WIDTH, Car.DEFAULT_LENGTH, 0.0, true), 40.0, 40.0)
        // other cars
        world.cars.addAll(listOf(
                Car(5.0, 0.0, 0.0),
                Car(20.0, 0.0, PI / 2.0)
        ))
        return world
    }

    private fun handleKeyEvent(event: KeyEvent, active: Boolean) {
        if (event.code == KeyCode.W) {
            acceleratePressed = active
        }
        if (event.code == KeyCode.S) {
            deceleratePressed = active
        }
        if (event.code == KeyCode.A) {
            turnLeftPressed = active
        }
        if (event.code == KeyCode.D) {
            turnRightPressed = active
        }
    }

    private fun processInputs() {
        if (acceleratePressed) world.playerCar.accelerate(1.0, SECONDS_PER_FRAME)
        if (deceleratePressed) world.playerCar.accelerate(-1.0, SECONDS_PER_FRAME)
        if (turnLeftPressed) world.playerCar.turn(1.0, SECONDS_PER_FRAME)
        if (turnRightPressed) world.playerCar.turn(-1.0, SECONDS_PER_FRAME)
    }

    fun startLoop() {
        render.startLoop()
    }
}
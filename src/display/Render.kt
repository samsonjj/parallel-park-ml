package display

import javafx.animation.AnimationTimer
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.shape.Rectangle
import physics.Car
import physics.World
import javafx.scene.input.KeyCode
import util.MathUtil
import kotlin.math.PI

class Render(private val world: World, private val updateFn: () -> Unit) {

    companion object {
        const val LENGTH_SCALE = 20.0
        const val ANGLE_SCALE = -180.0 / PI
    }

    private val carNodeMap: Map<Car, Rectangle> = world.cars.map {
        it to getRectangle(it)
    }.toMap()

    private val timeline: AnimationTimer = createTimeline()
    private val root = Group()
    val scene = Scene(root, world.mapWidth * LENGTH_SCALE, world.mapHeight * LENGTH_SCALE)
    val renderFn = { updateNodes() }

    init {
        root.children.addAll(carNodeMap.values)
    }

    fun startLoop() {
        timeline.start()
    }

    /**
     * this just updates the Nodes in carToNode
     * updating the Nodes is equivalent to rendering, since Main just displays all nodes every frame
     * a better name might be "UpdateDisplay"
     */
    fun updateNodes() {
        for ((car, rect) in carNodeMap.entries) {
            updateRectangle(rect, car)
        }
    }

    private fun createTimeline(): AnimationTimer {
        return object : AnimationTimer() {
            override fun handle(arg0: Long) {
                updateFn()
                renderFn()
            }
        }
    }

    private fun getRectangle(car: Car): Rectangle {
        return updateRectangle(Rectangle(), car)
    }

    private fun updateRectangle(rect: Rectangle, car: Car): Rectangle {
        // length of a car is parallel to it's angle
        rect.width = car.l * LENGTH_SCALE
        rect.height = car.w * LENGTH_SCALE
        rect.rotate = car.a * ANGLE_SCALE
        // rect.transforms.add
        rect.x = car.x * LENGTH_SCALE
        rect.y = MathUtil.shift(car.y * LENGTH_SCALE, 0.0, world.mapHeight * LENGTH_SCALE, world.mapHeight * LENGTH_SCALE, 0.0) - rect.height
        return rect
    }
}
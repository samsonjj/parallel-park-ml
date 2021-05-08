package display

import javafx.animation.AnimationTimer
import javafx.animation.Timeline
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.shape.Rectangle
import physics.Car
import physics.World

class Render(private val world: World) {

    private val carNodeMap: Map<Car, Rectangle> = world.cars.map {
        it to getRectangle(it)
    }.toMap()

    private val timeline: AnimationTimer = createTimeline()
    private val root = Group()
    val scene = Scene(root, world.mapWidth, world.mapHeight)

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
    private fun updateNodes() {
        for ((car, rect) in carNodeMap.entries) {
            updateRectangle(rect, car)
        }
    }

    private fun createTimeline(): AnimationTimer {
        return object : AnimationTimer() {
            override fun handle(arg0: Long) {
                world.update()
                updateNodes()
            }
        }
    }

    private fun getRectangle(car: Car): Rectangle {
        return updateRectangle(Rectangle(), car)
    }

    private fun updateRectangle(rect: Rectangle, car: Car): Rectangle {
        rect.x = car.x
        rect.y = car.y
        rect.width = car.w
        rect.height = car.l
        rect.rotate = car.a
        return rect
    }
}
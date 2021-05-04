package sample

import javafx.animation.AnimationTimer
import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Timeline
import javafx.application.Application
import kotlin.Throws
import javafx.fxml.FXMLLoader
import javafx.scene.Group
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.shape.Rectangle
import javafx.stage.Stage
import javafx.util.Duration
import java.lang.Exception

class Main : Application() {

    lateinit var mainCarRect: Rectangle
    lateinit var game: Game

    private fun createScene(): Scene {
        val root = Group()
        val scene = Scene(root, game.mapWidth, game.mapHeight)

        mainCarRect = Rectangle(game.car.w, game.car.l)
        val parkedRects: List<Rectangle> = game.cars.map {
            val r = Rectangle(it.x, it.y, it.w, it.l)
            r.rotate = it.a
            r
        }

        mainCarRect.rotate = 90.0

        root.children.add(mainCarRect)
        root.children.addAll(parkedRects)

        return scene
    }

    private fun render() {
        mainCarRect.x = game.car.x
        mainCarRect.y = game.car.y
    }

    private fun startGameLoop() {
        val animator: AnimationTimer = object : AnimationTimer() {
            override fun handle(arg0: Long) {
                game.update()
                render()
            }
        }
        animator.start()
    }

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        primaryStage.title = "Hello World"

        // 1)
        game = Game()
        // 2)
        primaryStage.scene = createScene()
        primaryStage.show()
        // 3)
        startGameLoop()
    }

    fun main(args: Array<String>) {
        launch(*args)
    }
}

fun main(args: Array<String>) {
    Main().main(args)
}

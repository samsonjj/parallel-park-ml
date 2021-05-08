package game

import javafx.animation.AnimationTimer
import javafx.application.Application
import kotlin.Throws
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.shape.Rectangle
import javafx.stage.Stage
import java.lang.Exception

class Main : Application() {

    lateinit var mainCarRect: Rectangle
    lateinit var game: Game

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        primaryStage.title = "Hello World"

        // 1)
        game = Game()
        // 2)
        primaryStage.scene = game.scene
        primaryStage.show()
        // 3)
        game.startLoop()
    }

    fun main(args: Array<String>) {
        launch(*args)
    }
}

fun main(args: Array<String>) {
    Main().main(args)
}

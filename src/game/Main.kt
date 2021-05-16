package game

import javafx.application.Application
import kotlin.Throws
import javafx.stage.Stage
import java.lang.Exception

class Main : Application() {

    lateinit var game: Game

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        primaryStage.title = "Parallel Parking Game"

        game = Game(primaryStage)
        primaryStage.show()
        game.startLoop()
    }

    fun main(args: Array<String>) {
        launch(*args)
    }
}

fun main(args: Array<String>) {
    Main().main(args)
}

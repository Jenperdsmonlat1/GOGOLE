package com.example.webbrowser

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle


class HelloApplication : Application() {

    private var x = 0.0
    private var y = 0.0
    override fun start(stage: Stage) {
        val fxmlLoader: Parent = FXMLLoader.load(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader)
        stage.title = "WebBrowser"
        stage.initStyle(StageStyle.UNDECORATED)
        stage.scene = scene

        fxmlLoader.setOnMousePressed { event ->
            x = event.sceneX
            y = event.sceneY
        }

        fxmlLoader.setOnMouseDragged { event ->
            stage.x = event.sceneX - x
            stage.y = event.sceneY - y
        }

        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}

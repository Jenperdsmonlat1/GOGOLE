package com.example.webbrowser

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.scene.web.WebEngine
import javafx.scene.web.WebView
import javafx.stage.Stage
import java.net.URL
import java.util.*

class WebPageRenderController() : Initializable {

    @FXML
    private lateinit var Root: VBox

    @FXML
    private lateinit var exitButton: Button

    @FXML
    private lateinit var favoriteButton: Button

    @FXML
    private lateinit var menuButton: Button

    @FXML
    private lateinit var inputSearch: TextField

    @FXML
    private lateinit var maximizeButton: Button

    @FXML
    private lateinit var reduceButton: Button

    @FXML
    private lateinit var refreshButton: Button

    @FXML
    private lateinit var searchButton: Button

    @FXML
    private lateinit var webView: WebView

    public var urle: String = ""
    private lateinit var engine: WebEngine
    private  lateinit var stage: Stage
    private lateinit var scene: Scene
    private var etat: Int = 0

    public fun exit(e: ActionEvent): Unit {
        stage = Root.scene.window as Stage
        stage.close()
    }

    public fun reduce(e: ActionEvent): Unit {
        stage = Root.scene.window as Stage
        stage.isIconified = true
    }

    public fun setMax(e: ActionEvent): Unit {
        stage = Root.scene.window as Stage

        var result = if (etat == 0) {
            stage.isMaximized = true
            etat = 1
        } else {
            stage.isMaximized = false
            etat = 0
        }
    }

    public fun setUrl(url: String) {
        urle = url
        loadPage(urle)
        inputSearch.text = urle
    }

    public fun returne(e: ActionEvent) {
        val root: Parent = FXMLLoader.load(HelloApplication::class.java.getResource("hello-view.fxml"))
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
    }

    @Override
    public override fun initialize(arg0: URL, arg1: ResourceBundle?): Unit {
        engine = webView.engine
    }

    public fun loadPage(url: String): Unit {
        if (::engine.isInitialized) {
            engine.load(url)
            println(engine.userAgent)
        } else {
            println("Erreur")
        }
    }

    public fun refresh(e: ActionEvent): Unit {
        engine.reload()
    }

    /**public fun goToHistorique(e: ActionEvent): Unit {
        val root: Parent = FXMLLoader.load(HelloApplication::class.java.getResource("historique-view.fxml"))
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
    }**/
}
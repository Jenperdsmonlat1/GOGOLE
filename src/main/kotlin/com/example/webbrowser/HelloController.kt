package com.example.webbrowser

import com.example.webbrowser.db.SQLiteHistory
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.stage.Stage
import javafx.stage.StageStyle

class HelloController {
    @FXML
    private lateinit var Root: VBox

    @FXML
    private lateinit var btnAmazon: Button

    @FXML
    private lateinit var btnDeepl: Button

    @FXML
    private lateinit var btnGactu: Button

    @FXML
    private lateinit var btnGithub: Button

    @FXML
    private lateinit var btnRecherche: Button

    @FXML
    private lateinit var btnTrivago: Button

    @FXML
    private lateinit var btnYoutube: Button

    @FXML
    private lateinit var exitButton: Button

    @FXML
    private lateinit var favoriteButton: Button

    @FXML
    private lateinit var menuButton: Button

    @FXML
    private lateinit var inputRecherche: TextField

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

    public fun goToAmazon(e: ActionEvent): Unit {
        val loader: FXMLLoader = FXMLLoader(HelloApplication::class.java.getResource("web-page-render.fxml"))
        val root: Parent = loader.load()
        val controller: WebPageRenderController = loader.getController()
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
        controller.setUrl("http://www.amazon.fr/")
    }

    public fun goToDeepl(e: ActionEvent): Unit {

        val loader: FXMLLoader = FXMLLoader(HelloApplication::class.java.getResource("web-page-render.fxml"))
        val root: Parent = loader.load()
        val controller: WebPageRenderController = loader.getController()
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
        controller.setUrl("http://www.deepl.com/")
    }

    public fun goToGithub(e: ActionEvent): Unit {

        val loader: FXMLLoader = FXMLLoader(HelloApplication::class.java.getResource("web-page-render.fxml"))
        val root: Parent = loader.load()
        val controller: WebPageRenderController = loader.getController()
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
        controller.setUrl("http://www.github.com/")
    }

    public fun goToTrivago(e: ActionEvent): Unit {
        val loader: FXMLLoader = FXMLLoader(HelloApplication::class.java.getResource("web-page-render.fxml"))
        val root: Parent = loader.load()
        val controller: WebPageRenderController = loader.getController()
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
        controller.setUrl("http://www.trivago.fr/")
    }

    public fun goToYoutube(e: ActionEvent): Unit {
        val loader: FXMLLoader = FXMLLoader(HelloApplication::class.java.getResource("web-page-render.fxml"))
        val root: Parent = loader.load()
        val controller: WebPageRenderController = loader.getController()
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
        controller.setUrl("http://www.youtube.com/")
    }

    public fun goToGActu(e: ActionEvent): Unit {
        val loader: FXMLLoader = FXMLLoader(HelloApplication::class.java.getResource("web-page-render.fxml"))
        val root: Parent = loader.load()
        val controller: WebPageRenderController = loader.getController()
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
        controller.setUrl("http://news.google.fr/")
    }

    public fun rechercher(e: ActionEvent): Unit {
        val recherche: String = inputRecherche.getText()
        val loader: FXMLLoader = FXMLLoader(HelloApplication::class.java.getResource("web-page-render.fxml"))
        val root: Parent = loader.load()
        val controller: WebPageRenderController = loader.getController()
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
        val historique: SQLiteHistory = SQLiteHistory()
        historique.insert("https://www.google.com/search?q=$recherche")
        controller.setUrl("https://www.google.com/search?q=$recherche")
    }

    public fun showHistorique(e: ActionEvent): Unit {
        val histRoot: Parent = FXMLLoader.load(HelloApplication::class.java.getResource("historique-view.fxml"))
        val histStage: Stage = Stage()
        histStage.initStyle(StageStyle.TRANSPARENT)
        histStage.scene = Scene(histRoot)
        histStage.show()
    }

    /**public fun goToHistorique(e: ActionEvent): Unit {
        val route: Parent = FXMLLoader.load(HelloApplication::class.java.getResource("historique-view.fxml"))
        stage = ((e.source) as Node).scene.window as Stage
        scene = Scene(route)
        stage.scene = scene
        stage.show()
    }**/
}
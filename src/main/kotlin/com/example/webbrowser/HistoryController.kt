package com.example.webbrowser

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.net.URL
import java.sql.*
import java.util.*

class HistoryController : Initializable {

    @FXML
    private lateinit var exitButton: Button

    @FXML
    private lateinit var labelBox: VBox

    @FXML
    private lateinit var scrollPane: ScrollPane

    @FXML
    private lateinit var root: VBox

    private  lateinit var stage: Stage

    @Override
    public override fun initialize(p0: URL?, p1: ResourceBundle?) {
        scrollPane.content = labelBox
        setText()
    }

    public fun setText() {
        selectAll()
    }

    public fun exit(e: ActionEvent): Unit {
        stage = root.scene.window as Stage
        stage.close()
    }

    private fun connect(): Connection? {
        val url: String = "jdbc:sqlite:db_webbrowser.db"
        var conn: Connection ?= null
        val sql: String = """
                    CREATE TABLE IF NOT EXISTS historique(
                    recherche TEXT NOT NULL
                    );
                    """

        try {
            conn = DriverManager.getConnection(url)
            val stmt: Statement = conn.createStatement()
            stmt.execute(sql)
        } catch (e: SQLException) {
            println(e.message)
        }

        return conn
    }

    public fun selectAll(): Unit {
        val sql = "SELECT recherche FROM historique"
        val connection: Connection ?= connect()
        val stmt: Statement ?= connection?.createStatement()
        val rs: ResultSet ?= stmt?.executeQuery(sql)

        try {
            if (rs != null) {
                while (rs.next()) {
                    //println(rs?.getString("recherche"))
                    val historiqueLabel: Label = Label(rs?.getString("recherche"))
                    labelBox.children.add(historiqueLabel)
                    scrollPane.content = historiqueLabel
                }
            }
        } catch (e: SQLException) {
            println("Erreur lors de la sélection des éléments dans la base de donnée.")
        }
    }
}
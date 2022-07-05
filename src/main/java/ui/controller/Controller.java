package ui.controller;

import data.generator.Generator;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import ui.misc.TextAssign;
import ui.play.PlayUtils;
import ui.uiComponents.InitPane;
import ui.uiComponents.MenuPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {


    @FXML
    private Pane mainPane;
    @FXML
    private Pane initPane;
    @FXML
    private Pane menuPane;
    @FXML
    private GridPane gridPane;


    private List<Integer> values = Generator.values(24);

    @FXML
    private void initialize() {
        TextAssign.assignTextByValue(values,gridPane.getChildren());
        InitPane.initPaneRequested(initPane);
    }

    @FXML
    private void playReleased() {
        Platform.runLater(() -> {
            InitPane.initPaneBack(initPane);
            PlayUtils.disappearAfterFewSeconds(300, gridPane.getChildren());
            PlayUtils.pressToReveal(1000, gridPane.getChildren(),menuPane);
            values = Generator.values(24);
        });

    }

    @FXML
    private void menuReleased(){
        MenuPane.menuBack(menuPane);
        InitPane.initPaneRequested(initPane);
    }
}

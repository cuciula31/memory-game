package ui.uiComponents;

import javafx.scene.layout.Pane;
import ui.transition.TranslateTransition;

public class MenuPane {

    public static void menuRequested(Pane pane){
        TranslateTransition.translateY(pane,1200,250);
    }

    public static void menuBack(Pane pane){
        TranslateTransition.translateYBack(pane,1200,250);
    }

}

package ui.uiComponents;

import javafx.scene.layout.Pane;
import ui.transition.TranslateTransition;

public class InitPane {

    public static void initPaneBack(Pane pane){TranslateTransition.translateYBack(pane,1200,250);}

    public static void initPaneRequested(Pane pane){TranslateTransition.translateY(pane, 1200,250);}

}

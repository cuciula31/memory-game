package ui.play;

import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import ui.transition.FadeTransition;
import ui.uiComponents.MenuPane;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PlayUtils {

    private static List<String>  twoStrings = new ArrayList<>();
    private static List<Text> twoTexts = new ArrayList<>();
    private static int currentScore = 0;


    public static void disappearAfterFewSeconds(int delay, List<Node> elements) {

        elements.forEach(e -> {
            FadeTransition.fade(e, 1, 0, 250, delay);
        });

        elements.forEach(e -> {
            FadeTransition.fade(e, 0, 1, 250, delay + 250);
        });

        elements.forEach(e -> {
            FadeTransition.fade(e, 1, 0, 250, delay + 500);
        });

        elements.forEach(e -> {
            FadeTransition.fade(e, 0, 1, 250, delay + 750);
        });

        elements.forEach(e -> {
            FadeTransition.fade(e, 1, 0, 250, delay + 900);
        });

        elements.forEach(e -> {
            FadeTransition.fade(e, 0, 1, 250, delay + 1250);
        });

        elements.forEach(e -> {
            Pane p = (Pane) e;
            FlowPane fp = (FlowPane) p.getChildren().get(0);
            Text t = (Text) fp.getChildren().get(0);
            FadeTransition.fade(t, 1, 0, 250, delay + 1250);
        });
    }


    public static void pressToReveal(int delay, List<Node> elements, Pane pane) {

        AtomicInteger counter = new AtomicInteger();
        AtomicReference<Boolean> pauseTriggered = new AtomicReference<>(false);

        elements.forEach(e -> e.setOnMouseReleased(event -> {
            counter.getAndIncrement();

            if (counter.get() < 3) {
                Pane p = (Pane) e;
                FlowPane fp = (FlowPane) p.getChildren().get(0);
                Text t = (Text) fp.getChildren().get(0);

                twoStrings.add(t.getText());
                twoTexts.add(t);

                FadeTransition.fade(t, 0, 1, 250);
              if (twoTexts.size() == 2){
                  if (twoStrings.size() ==2 && oneEqualsTwo(twoStrings.get(0),twoStrings.get(1))){
                      twoTexts.forEach(i -> FadeTransition.fade(i,1,1,0,0));
                      currentScore+=2;
                  }else{
                      twoTexts.forEach(i -> FadeTransition.fade(i,1,0,250,delay));
                  }
              }

            } else {

                if (pauseTriggered.get().equals(false)) {
                    pauseTriggered.set(true);
                    PauseTransition pauseTransition = new PauseTransition(Duration.millis(100));
                    pauseTransition.setOnFinished(actionEvent -> {
                        counter.set(0);
                        twoStrings.clear();
                        twoTexts.clear();
                        pauseTriggered.set(false);
                    });
                    pauseTransition.play();
                }

            }

            if (currentScore==24){
                MenuPane.menuRequested(pane);
            }
        }));
    }

    private static Boolean oneEqualsTwo(String one, String two){
        return one.equals(two);
    }


}

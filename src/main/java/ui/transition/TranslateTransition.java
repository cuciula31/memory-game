package ui.transition;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class TranslateTransition {

    public static void translateX(Pane pane, int endValue, int millis) {

        pane.translateXProperty().set(0);

        Timeline timeline = new Timeline();

        KeyValue keyValue = new KeyValue(pane.translateXProperty(), endValue, Interpolator.EASE_IN);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(millis), keyValue);

        timeline.getKeyFrames().add(keyFrame);


        timeline.play();

    }

    public static void translateXBack(Pane pane, int endValue, int millis) {

        pane.translateXProperty().set(endValue);

        Timeline timeline = new Timeline();

        KeyValue keyValue = new KeyValue(pane.translateXProperty(), 0, Interpolator.EASE_IN);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(millis), keyValue);

        timeline.getKeyFrames().add(keyFrame);


        timeline.play();

    }


    public static void translateY(Pane pane, int endValue, int millis) {

        pane.translateYProperty().set(0);

        Timeline timeline = new Timeline();

        KeyValue keyValue = new KeyValue(pane.translateYProperty(), endValue, Interpolator.EASE_IN);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(millis), keyValue);

        timeline.getKeyFrames().add(keyFrame);


        timeline.play();


    }

    public static void translateYBack(Pane pane, int endValue, int millis) {

        pane.translateYProperty().set(endValue);

        Timeline timeline = new Timeline();

        KeyValue keyValue = new KeyValue(pane.translateYProperty(), 0, Interpolator.EASE_IN);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(millis), keyValue);

        timeline.getKeyFrames().add(keyFrame);


        timeline.play();


    }


}

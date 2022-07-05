package ui.misc;

import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.List;

public class TextAssign {

    public static void assignTextByValue(List<Integer> values, List<Node> nodesWithText){
       for(int i = 0; i <= 23; i++){
           Pane p = (Pane) nodesWithText.get(i);
           FlowPane fp = (FlowPane) p.getChildren().get(0);
           Text t = (Text) fp.getChildren().get(0);

           t.setText(values.get(i).toString());

       }

    }

}

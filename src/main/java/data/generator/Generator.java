package data.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {

    public static List<Integer> values(int size){
        List<Integer> tobeReturned = new ArrayList<>();

          for (int i = 0; i < size/2; i++){
              tobeReturned.add(i);
              tobeReturned.add(i);
          }

          tobeReturned.forEach(System.out::println);

        Collections.shuffle(tobeReturned);
          return tobeReturned;
        };
    }



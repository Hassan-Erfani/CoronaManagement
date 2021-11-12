package org.campus02.erfani;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.prefs.PreferenceChangeEvent;

public class CovidManager {

    public static void main(String[] args) {

        // Steiermark
        Incidence stmk20211111 = new Incidence("Steiermark", "2021-11-11", 1300);
        Incidence stmk20211110 = new Incidence("Steiermark", "2021-11-10", 1200);

        // Wien
        Incidence wien20211111 = new Incidence("Wien", "2021-11-11", 1500);
        Incidence wien20211110 = new Incidence("Wien", "2021-11-10", 1400);

        // Tirol
        Incidence tirol20211111 = new Incidence("Tirol", "2021-11-11", 900);
        Incidence tirol20211110 = new Incidence("Tirol", "2021-11-10", 700);


        ArrayList<Incidence> recordedValues = new ArrayList<>();

             recordedValues.add(stmk20211111);
             recordedValues.add(stmk20211110);

             recordedValues.add(wien20211111);
             recordedValues.add(wien20211110);

             recordedValues.add(tirol20211111);
             recordedValues.add(tirol20211110);

             recordedValues.add(new Incidence("Salzburg", "2021-11-11", 2999));

        System.out.println("Count of recorded Records: " + recordedValues.size());

        // Count der gesamten Fälle
        int countTotalIncidences = 0;
        for (int i = 0; i < recordedValues.size(); i++) {
            Incidence oneValue = recordedValues.get(i);
            //countTotalIncidences += oneValue.getNumber();

            countTotalIncidences = countTotalIncidences + oneValue.getNumber();
        }
        System.out.println("Bisher in Österreich: " + countTotalIncidences + " Fälle");
        int countTotalIncidencess = 0;
        for (Incidence incidence : recordedValues) {
            // für jeden Incidence in recordedValues
          countTotalIncidencess += incidence.getNumber();
        }

        System.out.println("Bisher in Österreich: " + countTotalIncidences + " Fälle");

        // Anzahl der Fälle je Bundesland
        HashMap<String, Integer> totalIncidencesState = new HashMap<>();
        for (Incidence recordedValue : recordedValues) {
            /*
            *  1. Ist mein Key bereits in der Liste
            *   2. wenn nein, dann muss ich den Key aufnehmen
            *      3. wenn ja, dann muss ich den Wert auslesen, summieren, new ablegen
                */ 
            if ( totalIncidencesState.containsKey(recordedValue.getState())) {
                // ja, Fall 3
                int currentValue = totalIncidencesState.get(recordedValue.getState());
                currentValue += recordedValue.getNumber();
                totalIncidencesState.put(recordedValue.getState(), currentValue);
            }
            else {
                // nein, Fall 2
                totalIncidencesState.put(recordedValue.getState(), recordedValue.getNumber());
            }
            
        }

        System.out.println("totalIncidencesState = " + totalIncidencesState);
        
    }
}

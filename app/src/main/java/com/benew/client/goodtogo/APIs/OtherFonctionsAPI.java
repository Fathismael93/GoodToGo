package com.benew.client.goodtogo.APIs;

import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OtherFonctionsAPI {

    public static ArrayList<Object> searchTrueValueInArray(List<CheckBox> arrayOfCheckBoxes) {
        ArrayList returnList = new ArrayList();

        int i = 0;
        HashMap<String, Boolean> valueOfCheckBoxes = new HashMap();

        for (int j=0; j < arrayOfCheckBoxes.size(); j++) {
            String tag = (String) arrayOfCheckBoxes.get(j).getTag();

            if (arrayOfCheckBoxes.get(j).isChecked()) {
                i++;
                valueOfCheckBoxes.put(tag, true);
            } else valueOfCheckBoxes.put(tag, false);
        }

        returnList.add(i);
        returnList.add(valueOfCheckBoxes);

        return returnList;
    }
}

package Damir.App;
import java.util.*;

public class SimpleDotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n)
    {
        name = n;
    }

    public String checkYourself(String userInput) {

        String result = "Missed";

        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "destroyed";
            } else {
                result = "hit";
            }
        }
        return result;
    }
}

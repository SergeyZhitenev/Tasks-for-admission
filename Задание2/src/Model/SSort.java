package Model;

import java.util.ArrayList;
import java.util.Collections;

public class SSort implements Strateg{
    @Override
    public ArrayList<String> sort(ArrayList<String> arr) {
        Collections.sort(arr);
        return arr;
    }
}

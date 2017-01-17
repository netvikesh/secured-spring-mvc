package net.vikesh.ssm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vikesh on 15-Jan-17.
 */
public class CountSalute {
    public static int answer(String s) {
        List<Integer> movingRight = new ArrayList<>();
        List<Integer> movingLeft = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '>') {
                movingRight.add(i);
            } else if (s.charAt(i) == '<') {
                movingLeft.add(i);
            }
        }
        //At this point right and left array are sorted in natural order.
        int saluteCount = 0;
        for (int i = 0; i < movingRight.size(); i++) {
            //find the count of values that are greater than this in moving left array
            for (int j = 0; j < movingLeft.size(); j++) {
                if (movingRight.get(i) < movingLeft.get(j)) {
                    saluteCount++;
                }
            }
        }
        return saluteCount * 2;
    }
}

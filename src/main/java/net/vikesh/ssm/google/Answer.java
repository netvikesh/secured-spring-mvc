package net.vikesh.ssm.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vikesh on 15-Jan-17.
 */
public class Answer {
    public static int[] answer(int[] data, int n) {
        if (n == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> inputCount = new HashMap<>();
        for (int index = 0; index < data.length; index++) {
            if (!inputCount.containsKey(data[index])) {
                inputCount.put(data[index], 1);
            } else {
                inputCount.put(data[index], inputCount.get(data[index]) + 1);
            }
        }
        int[] output = new int[findValidNumber(inputCount, n)];
        int outIndex = 0;
        for (int i = 0; i < data.length; i++) {
            if (inputCount.containsKey(data[i]) && inputCount.get(data[i]) <= n) {
                output[outIndex] = data[i];
                outIndex++;
            }
        }
        return output;
    }

    private static int findValidNumber(Map<Integer, Integer> inputCount, int n) {
        int i = 0;
        Set<Integer> keys = inputCount.keySet();
        for (Integer key : keys) {
            if (inputCount.get(key) <= n) {
                i = i + inputCount.get(key);
            }
        }
        return i;
    }
}
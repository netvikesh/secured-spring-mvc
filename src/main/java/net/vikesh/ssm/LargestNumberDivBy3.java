package net.vikesh.ssm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vikesh on 15-Jan-17.
 */
public class LargestNumberDivBy3 {
    public static int answer(int[] i) {
        //Edge case, if input is null or length of input is 0
        if (i == null || i.length == 0) {
            return 0;
        }

        if (i != null && i.length == 1) {
            return i[0] % 3 == 0 ? i[0] : 0;
        }
        List<Integer> inputArray = new ArrayList<>(i.length);
        for (int index = 0; index < i.length; index++) {
            inputArray.add(i[index]);
        }
        Collections.sort(inputArray);
        Collections.reverse(inputArray);
        //Now, this is reverse sorted array - highest is first
        int optimalLength = i.length;
        while (optimalLength > 0) {
            //We know that the optimal length need to be reduced by 1
            //We shall swap values from right array to left array, checking if left array became a multiple of 3.
            ArrayList<Integer> leftArray = new ArrayList<>(inputArray.subList(0, optimalLength));
            ArrayList<Integer> rightArray = new ArrayList<>(inputArray.subList(optimalLength, inputArray.size()));
            if (isDivisibleBy3(leftArray)) {
                return createNumber(leftArray);
            } else {
                for (int r = 0; r < rightArray.size(); r++) {
                    for (int l = leftArray.size() - 1; l > 0; l--) {
                        int swap = swap(leftArray, l, rightArray, r);
                        if (isDivisibleBy3(leftArray)) {
                            return createNumber(leftArray);
                        } else {
                            leftArray.set(l, swap);
                        }
                    }
                }
            }
            --optimalLength;
        }
        return 0;
    }

    private static int swap(List<Integer> leftArray, int leftArrayEndIndex, List<Integer> rightArray, int rightArrayIndex) {
        int swappedValue = leftArray.get(leftArrayEndIndex);
        leftArray.set(leftArrayEndIndex, rightArray.get(rightArrayIndex));
        return swappedValue;
    }

    private static int createNumber(List<Integer> integers) {
        Collections.sort(integers);
        Collections.reverse(integers);
        StringBuilder stringRep = new StringBuilder();
        for (Integer value : integers) {
            stringRep.append(value);
        }
        return Integer.valueOf(stringRep.toString());
    }

    private static boolean isDivisibleBy3(List<Integer> integers) {
        int sum = 0;
        for (Integer value : integers) {
            sum += value;
        }
        return (sum % 3) == 0;
    }

}

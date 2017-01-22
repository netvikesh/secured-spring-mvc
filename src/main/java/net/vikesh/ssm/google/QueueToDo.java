package net.vikesh.ssm.google;

/**
 * Created by Vikesh on 22-Jan-17.
 */
public class QueueToDo {
    public static int answer(int start, int length) {
        int sum = 0;
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < (length - row); col++) {
                sum = sum ^ ((start + col) + (length * row));
            }
        }
        return sum;
    }
}

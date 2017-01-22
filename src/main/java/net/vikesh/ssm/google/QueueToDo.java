package net.vikesh.ssm.google;

/**
 * Created by Vikesh on 22-Jan-17.
 */
public class QueueToDo {
    public static int answer(int start, int length) {
        int xor = 0;
        for (int i = start, j = 0; j < length; j++, i += length) {
            if (i == 0) {
                xor = xor ^ getXor(1, length - 1);
            } else {
                xor = xor ^ getXor(i, length - j + i - 1);
            }
        }
        return xor;
    }

    private static int f(int a) {
        int res[] = {a, 1, a + 1, 0};
        return res[a % 4];
    }

    private static int getXor(int from, int to) {
        return f(to) ^ f(from - 1);
    }
}

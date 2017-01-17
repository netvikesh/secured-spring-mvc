package net.vikesh.ssm.config;

import net.vikesh.ssm.LargestNumberDivBy3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vikesh on 15-Jan-17.
 */
public class LargestNumberDivBy3Test {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter(new File("out.txt"));
        for (int i = 999999999; i > 111111111; i--) {
            String s = Integer.toString(i);
            int[] test = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                test[j] = Integer.valueOf(s.substring(j, j + 1));
            }
            boolean expected = (i % 3 == 0);
            if (expected) {
                int value = LargestNumberDivBy3.answer(test);
                if (i > value || value % 3 != 0) {
                    writer.append("Expected " + i + " Got " + value + " Are they equal : " + (i == value) + "\n");
                    System.out.println(i + " : " + value);
                }
            }
        }
        writer.flush();
        writer.close();
    }
}

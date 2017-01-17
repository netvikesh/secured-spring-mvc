package net.vikesh.ssm.config;

import net.vikesh.ssm.Answer;

/**
 * Created by Vikesh on 15-Jan-17.
 */
public class AnswerTest {
    public static void main(String[] args) {
        int[] answer = Answer.answer(new int[]{1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9}, 1);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}

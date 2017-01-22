package net.vikesh.ssm.google;

import java.util.Random;

/**
 * Created by Vikesh on 18-Jan-17.
 */
public class FuelInjectorTest {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            System.out.println(FuelInjector.answer(Integer.toString(i)));
        }

        System.out.println(FuelInjector.answer("4"));
    }
}

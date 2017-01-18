package net.vikesh.ssm.config;

import net.vikesh.ssm.FuelInjector;

import java.util.Random;

/**
 * Created by Vikesh on 18-Jan-17.
 */
public class FuelInjectorTest {
    public static void main(String[] args) {
        Random random = new Random();

//        for (int i = 0; i < 100; i++) {
//            int rand = random.nextInt(400);
//            //rand = Math.abs(rand);
//            System.out.print(rand);
//            System.out.println(" : " + FuelInjector.answer(Integer.toString(rand)));
//        }
        System.out.println(FuelInjector.answer("351"));
        System.out.println(FuelInjector.answer("243"));
        System.out.println(FuelInjector.answer("0"));
    }
}

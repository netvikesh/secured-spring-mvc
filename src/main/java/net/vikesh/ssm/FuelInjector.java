package net.vikesh.ssm;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vikesh on 17-Jan-17.
 */
public class FuelInjector {
    private static final BigInteger zero = new BigInteger("0");
    private static final BigInteger one = new BigInteger("1");
    private static final BigInteger two = new BigInteger("2");

    public static int answer(String n) {
        BigInteger start = new BigInteger(n);
        if (start.compareTo(one) < 0) {
            return 0;
        } else if (start.equals(one)) {
            return 0;
        } else if (start.equals(two)) {
            return 1;
        }
        BigInteger next = new BigInteger("3");
        //Create all two powers
        Map<BigInteger, Integer> twoPowers = new HashMap<>();
        BigInteger now = new BigInteger("1");
        int count = 0;
        twoPowers.put(new BigInteger("1"), count++);
        while (start.compareTo(now) > 0) {
            now = now.multiply(two);
            twoPowers.put(now, count++);
        }
        if (twoPowers.containsKey(start)) {
            return twoPowers.get(start);
        }

        //find count of new numbers
        int initCount = 0;
        while (start.mod(two).equals(zero)) {
            initCount++;
            start = start.divide(two);
        }
        final BigInteger minusOne = start.subtract(one);
        final BigInteger plusOne = start.add(one);
        while (!(twoPowers.containsKey(start) || twoPowers.containsKey(minusOne) || twoPowers.containsKey(plusOne))) {
            fillAllMultiplesOf(next, plusOne, twoPowers);
            next = next.add(one);
        }
        return minOf(twoPowers.get(minusOne), twoPowers.get(plusOne)) + initCount;
    }

    private static void fillAllMultiplesOf(BigInteger next, BigInteger start, Map<BigInteger, Integer> map) {
        if (map.containsKey(next)) {
            return;
        }
        while (start.compareTo(next) > 0) {
            if (!map.containsKey(next)) {
                final BigInteger minusOne = next.subtract(one);
                final BigInteger plusOne = next.add(one);
                if (!map.containsKey(next) && map.containsKey(minusOne) && map.containsKey(plusOne)) {
                    map.put(next, minOf(map.get(minusOne), map.get(plusOne)) + 1);
                } else {
                    map.put(next, map.get(next.divide(two)) + 1);
                }
            }
            next = next.multiply(two);
        }
    }

    private static Integer minOf(Integer first, Integer second) {
        return first < second ? first : second;
    }
}
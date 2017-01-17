package net.vikesh.ssm;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vikesh on 17-Jan-17.
 */
public class FuelInjector {
    public static int answer(String n) {
        if (n == null || n.length() == 0) {
            return 0;
        }

        final BigInteger start = new BigInteger(n);
        if (start.equals(new BigInteger("1"))) {
            return 0;
        } else if (start.equals(new BigInteger("2"))) {
            return 1;
        } else {
            Map<BigInteger, Integer> twoPowers = createPowerOfTwoUpto(start);
            Map<BigInteger, Integer> secondMap = new HashMap<>();
            Node root = new Node(start);
            addFirstValueForSecondMap(twoPowers, secondMap, root);
        }
        // Your code goes here.

    }

    private static void addFirstValueForSecondMap(Map<BigInteger, Integer> twoPowers, Map<BigInteger, Integer> secondMap, Node root) {
        final BigInteger two = new BigInteger("2");
        final BigInteger one = new BigInteger("1");
        int count = 0;
        if (root.value.mod(two).equals(one)) {
            root.setDecreased(true);
            Node next = new Node(root.value.min(one));
            root.setAfterDecrease(next);
        }
    }

    private static Map<BigInteger, Integer> createPowerOfTwoUpto(BigInteger start) {
        Map<BigInteger, Integer> twoPowers = new HashMap<>();
        if (start.compareTo(new BigInteger("1")) > 0) {
            final BigInteger two = new BigInteger("2");
            BigInteger now = new BigInteger("1");
            int count = 0;
            twoPowers.put(new BigInteger("1"), count++);
            while (start.compareTo(now) > 0) {
                now = now.multiply(two);
                twoPowers.put(now, count++);
            }
        }
        return twoPowers;
    }

    static class Node {
        private final BigInteger value;
        private int distanceFromStart;
        private boolean increased;
        private boolean decreased;
        private boolean halved;
        private boolean inFirstMap;
        private boolean inSecondMap;
        private Node afterIncrease;
        private Node afterDecrease;
        private Node afterHalf;

        Node(BigInteger value) {
            this.value = value;
        }

        public Node getAfterIncrease() {
            return afterIncrease;
        }

        public void setAfterIncrease(Node afterIncrease) {
            this.afterIncrease = afterIncrease;
        }

        public Node getAfterDecrease() {
            return afterDecrease;
        }

        public void setAfterDecrease(Node afterDecrease) {
            this.afterDecrease = afterDecrease;
        }

        public Node getAfterHalf() {
            return afterHalf;
        }

        public void setAfterHalf(Node afterHalf) {
            this.afterHalf = afterHalf;
        }

        public int getDistanceFromStart() {
            return distanceFromStart;
        }

        public void setDistanceFromStart(int distanceFromStart) {
            this.distanceFromStart = distanceFromStart;
        }

        public boolean isIncreased() {
            return increased;
        }

        public void setIncreased(boolean increased) {
            this.increased = increased;
        }

        public boolean isDecreased() {
            return decreased;
        }

        public void setDecreased(boolean decreased) {
            this.decreased = decreased;
        }

        public boolean isHalved() {
            return halved;
        }

        public void setHalved(boolean halved) {
            this.halved = halved;
        }

        public boolean isInFirstMap() {
            return inFirstMap;
        }

        public void setInFirstMap(boolean inFirstMap) {
            this.inFirstMap = inFirstMap;
        }

        public boolean isInSecondMap() {
            return inSecondMap;
        }

        public void setInSecondMap(boolean inSecondMap) {
            this.inSecondMap = inSecondMap;
        }

        public BigInteger getValue() {
            return value;
        }
    }
}


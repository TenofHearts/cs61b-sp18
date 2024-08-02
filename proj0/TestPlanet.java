class TestPlanet {
    public static void main(String[] args) {
        testVel();
    }

    /**
     * Checks whether or not two Doubles are equal and prints the result.
     *
     * @param expected Expected double
     * @param actual   Double received
     * @param label    Label for the 'test' case
     * @param eps      Tolerance for the double comparison.
     */
    private static void checkEquals(double expected, double actual, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     * Tests if the update mathod correctlt calculates the Velocity.
     */
    private static void testVel() {
        System.out.println("Testing Velocity...");

        Planet p = new Planet(0.0, 0.0, 0.0, 0.0, 10.0, "Uranus");

        p.update(1.0, 10.0, 20.0);

        checkEquals(1.0, p.xxVel, "xxVel update()", 0.01);
        checkEquals(2.0, p.yyVel, "yyVel update()", 0.01);
    }
}

package demo.parallel;

public class ComplexTest {

    public static void main(String[] args) {
        testMinusWithPositiveNumbers();
        testMinusWithNegativeNumbers();
        testMinusWithMixedNumbers();
        testMinusWithZero();
        testMinusReturnsSameObject();

        testDivideWithPositiveNumbers();
        testDivideWithRealNumbers();
        testDivideWithImaginaryNumbers();
        testDivideByConjugate();
        testDivideReturnsSameObject();
        testDivideByUnitReal();
        testDivideByUnitImaginary();

        System.out.println("All tests passed!");
    }

    // ========== TESTS FOR minus() METHOD ==========

    public static void testMinusWithPositiveNumbers() {
        Complex a = new Complex(5.0, 7.0);
        Complex b = new Complex(2.0, 3.0);

        Complex result = a.minus(b);

        assertDoubleEquals(3.0, result.getRe(), "Real part should be 3.0");
        assertDoubleEquals(4.0, result.getIm(), "Imaginary part should be 4.0");
    }

    public static void testMinusWithNegativeNumbers() {
        Complex a = new Complex(-5.0, -7.0);
        Complex b = new Complex(-2.0, -3.0);

        Complex result = a.minus(b);

        assertDoubleEquals(-3.0, result.getRe(), "Real part should be -3.0");
        assertDoubleEquals(-4.0, result.getIm(), "Imaginary part should be -4.0");
    }

    public static void testMinusWithMixedNumbers() {
        Complex a = new Complex(5.0, -7.0);
        Complex b = new Complex(-2.0, 3.0);

        Complex result = a.minus(b);

        assertDoubleEquals(7.0, result.getRe(), "Real part should be 7.0");
        assertDoubleEquals(-10.0, result.getIm(), "Imaginary part should be -10.0");
    }

    public static void testMinusWithZero() {
        Complex a = new Complex(5.0, 7.0);
        Complex b = new Complex(0.0, 0.0);

        Complex result = a.minus(b);

        assertDoubleEquals(5.0, result.getRe(), "Real part should remain 5.0");
        assertDoubleEquals(7.0, result.getIm(), "Imaginary part should remain 7.0");
    }

    public static void testMinusReturnsSameObject() {
        Complex a = new Complex(5.0, 7.0);
        Complex b = new Complex(2.0, 3.0);

        Complex result = a.minus(b);

        if (a != result) {
            throw new AssertionError("minus() should return the same object");
        }
    }

    // ========== TESTS FOR divide() METHOD ==========

    public static void testDivideWithPositiveNumbers() {
        Complex a = new Complex(6.0, 8.0);
        Complex b = new Complex(2.0, 2.0);

        Complex result = a.divide(b);

        assertDoubleEquals(3.5, result.getRe(), "Real part should be 3.5");
        assertDoubleEquals(0.5, result.getIm(), "Imaginary part should be 0.5");
    }

    public static void testDivideWithRealNumbers() {
        Complex a = new Complex(10.0, 0.0);
        Complex b = new Complex(2.0, 0.0);

        Complex result = a.divide(b);

        assertDoubleEquals(5.0, result.getRe(), "Real part should be 5.0");
        assertDoubleEquals(0.0, result.getIm(), "Imaginary part should be 0.0");
    }

    public static void testDivideWithImaginaryNumbers() {
        Complex a = new Complex(0.0, 12.0);
        Complex b = new Complex(0.0, 4.0);

        Complex result = a.divide(b);

        assertDoubleEquals(3.0, result.getRe(), "Real part should be 3.0");
        assertDoubleEquals(0.0, result.getIm(), "Imaginary part should be 0.0");
    }

    public static void testDivideByConjugate() {
        Complex a = new Complex(3.0, 4.0);
        Complex b = new Complex(3.0, -4.0);

        Complex result = a.divide(b);

        assertDoubleEquals(-0.28, result.getRe(), "Real part should be -0.28");
        assertDoubleEquals(0.96, result.getIm(), "Imaginary part should be 0.96");
    }

    public static void testDivideReturnsSameObject() {
        Complex a = new Complex(6.0, 8.0);
        Complex b = new Complex(2.0, 2.0);

        Complex result = a.divide(b);

        if (a != result) {
            throw new AssertionError("divide() should return the same object");
        }
    }

    public static void testDivideByUnitReal() {
        Complex a = new Complex(7.0, 9.0);
        Complex b = new Complex(1.0, 0.0);

        Complex result = a.divide(b);

        assertDoubleEquals(7.0, result.getRe(), "Real part should remain 7.0");
        assertDoubleEquals(9.0, result.getIm(), "Imaginary part should remain 9.0");
    }

    public static void testDivideByUnitImaginary() {
        Complex a = new Complex(0.0, 8.0);
        Complex b = new Complex(0.0, 1.0);

        Complex result = a.divide(b);

        assertDoubleEquals(8.0, result.getRe(), "Real part should be 8.0");
        assertDoubleEquals(0.0, result.getIm(), "Imaginary part should be 0.0");
    }

    // ========== HELPER METHODS ==========

    private static void assertDoubleEquals(double expected, double actual, String message) {
        if (Math.abs(expected - actual) > 1e-10) {
            throw new AssertionError(message + ". Expected: " + expected + ", but was: " + actual);
        }
    }
}
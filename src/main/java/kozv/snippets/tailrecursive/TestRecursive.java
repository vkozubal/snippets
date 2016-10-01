package kozv.snippets.tailrecursive;

import java.math.BigInteger;

public class TestRecursive {
    public static void main(String[] args) {
        System.out.println(factorial(34));
    }

    static BigInteger factorial(int n) {
        return streamFactorial(BigInteger.ONE, n).invoke();
    }

    static Tail<BigInteger> streamFactorial(BigInteger x, int n) {
        return () -> {
            switch (n) {
                case 1:
                    return Tail.done(x);
                default:
                    return streamFactorial(x.multiply(BigInteger.valueOf(n)), n - 1);
            }
        };
    }
}


public class Main {

    public static void main(String[] args) {
        System.out.println(fib(64));
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);

    }


}

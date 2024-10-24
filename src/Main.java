import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(primos_linear(20));
            System.out.println(primos_recursiva_lista(20));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Integer> primos_recursiva_lista(int n) throws Exception {
        ArrayList<Integer> primos = new ArrayList<Integer>();
        if (n < 1) {
            throw new Exception("A entrada deve ser maior que 1");
        }
        return primos_recursiva(n, primos);
    }

    public static ArrayList<Integer> primos_recursiva(int n, ArrayList<Integer> primos) throws Exception {
        if (n == 1) {
            return primos;
        }
        int contador = 0;
        boolean primo = true;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && i != n) {
                primo = false;
                break;
            }
            contador ++;
            if (primo && contador == n - 1) {
                if (primos.isEmpty()) {
                    primos.add(n);
                } else {

                    primos.add(0, n);
                }
            }

        }
        return primos_recursiva(n - 1, primos);
    }
    public static ArrayList<Integer> primos_linear (int n) throws Exception {
        ArrayList<Integer> primos = new ArrayList<Integer>();
        if (n < 1) {
            throw new Exception("A entrada deve ser maior que 1");
        }

        for (int i = 2; i <= n; i++) {
            boolean primo = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo) {
                primos.add(i);
            }
        }
        return primos;
    }
}
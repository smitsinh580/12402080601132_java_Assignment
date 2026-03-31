import java.util.*;
import java.util.concurrent.*;

// Utility class to check prime
class PrimeUtil {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}


class PrimeThread extends Thread {
    int start, end;

    PrimeThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("\n[Thread] Prime numbers:");
        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}


class PrimeRunnable implements Runnable {
    int start, end;

    PrimeRunnable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("\n[Runnable] Prime numbers:");
        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

class PrimeTask implements Callable<List<Integer>> {
    int start, end;

    PrimeTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public List<Integer> call() {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}

public class Program1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter start number: ");
        int start = sc.nextInt();

        System.out.print("Enter end number: ");
        int end = sc.nextInt();

       
        PrimeThread t1 = new PrimeThread(start, end);
        t1.start();
        t1.join();

        
        Thread t2 = new Thread(new PrimeRunnable(start, end));
        t2.start();
        t2.join();

       
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<Integer>> result = executor.submit(new PrimeTask(start, end));

        System.out.println("\n[Executor] Prime numbers:");
        for (int num : result.get()) {
            System.out.print(num + " ");
        }
        System.out.println();

        executor.shutdown();
        sc.close();
    }
}

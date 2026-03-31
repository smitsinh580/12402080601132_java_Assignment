import java.util.LinkedList;
import java.util.Scanner;


class Buffer {
    private LinkedList<Integer> queue = new LinkedList<>();
    private int capacity;

    Buffer(int capacity) {
        this.capacity = capacity;
    }

   
    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); 
        }

        queue.add(value);
        System.out.println("Produced: " + value);

        notify(); 
    }

   
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); 
        }

        int val = queue.removeFirst();
        System.out.println("Consumed: " + val);

        notify(); 
        return val;
    }
}


class Producer extends Thread {
    Buffer buffer;
    int n;

    Producer(Buffer buffer, int n) {
        this.buffer = buffer;
        this.n = n;
    }

    public void run() {
        try {
            for (int i = 1; i <= n; i++) {
                buffer.produce(i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


class Consumer extends Thread {
    Buffer buffer;
    int n;

    Consumer(Buffer buffer, int n) {
        this.buffer = buffer;
        this.n = n;
    }

    public void run() {
        try {
            for (int i = 1; i <= n; i++) {
                buffer.consume();
                Thread.sleep(800);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter buffer size: ");
        int size = sc.nextInt();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Buffer buffer = new Buffer(size);

        Producer p = new Producer(buffer, n);
        Consumer c = new Consumer(buffer, n);

        p.start();
        c.start();

        sc.close();
    }
}

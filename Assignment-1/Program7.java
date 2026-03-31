// Outer class
class Outer {
    int x = 10;

    // 1️⃣ Member Inner Class
    class MemberInner {
        void display() {
            System.out.println("Member Inner Class: x = " + x);
        }
    }

    // Method to show Local Inner Class
    void showLocal() {
        int y = 20;

        // 2️⃣ Local Inner Class
        class LocalInner {
            void display() {
                System.out.println("Local Inner Class: y = " + y);
            }
        }

        LocalInner obj = new LocalInner();
        obj.display();
    }
}

// Interface for Anonymous class
interface Demo {
    void show();
}

public class Program7 {
    public static void main(String[] args) {

        Outer outer = new Outer();

        // Member Inner Class object
        Outer.MemberInner m = outer.new MemberInner();
        m.display();

        // Local Inner Class call
        outer.showLocal();

        // 3️⃣ Anonymous Inner Class
        Demo d = new Demo() {
            public void show() {
                System.out.println("Anonymous Inner Class: Hello!");
            }
        };

        d.show();
    }
}

class WrapperDemo {

    void wrapperExample() {
        // Primitive to Wrapper (Boxing)
        int a = 10;
        Integer obj = Integer.valueOf(a);

        // Wrapper to Primitive (Unboxing)
        int b = obj.intValue();

        System.out.println("Primitive value: " + a);
        System.out.println("Wrapper object: " + obj);
        System.out.println("Unboxed value: " + b);

        // Using Wrapper methods
        String str = "123";
        int num = Integer.parseInt(str);
        System.out.println("String to int using wrapper: " + num);
    }
}

class StringDemo {

    void stringExample() {
        // String (Immutable)
        String s1 = "Hello";
        s1.concat(" World");  // does not change original
        System.out.println("String: " + s1);

        // StringBuffer (Mutable)
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");  // changes original
        System.out.println("StringBuffer: " + sb);
    }
}

public class Program3 {
    public static void main(String[] args) {

        WrapperDemo w = new WrapperDemo();
        w.wrapperExample();

        System.out.println("-------------------");

        StringDemo s = new StringDemo();
        s.stringExample();
    }
}

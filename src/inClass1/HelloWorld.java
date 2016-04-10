
package inClass1;

/* 1 */
public class HelloWorld /* 2 */extends Object {

    /* 3 */public HelloWorld() {

        double d = Math.random();
        System.out.println("Hello World " + d);
        // System.out.println(new HelloWorld());
    }

    public static int sum(int... list) {

        int y = 0;
        for (int x : list)
            y += x;
        return y;
    }

}

/**
 * @(#)CounterDemo1.java
 *
 *
 * @author 
 * @version 1.00 2009/1/22
 */

public class CounterDemo1 {
        
    public static void main(String[] args) {
        Counter thing1, thing2, thing3;
        thing1 = new Counter();
        thing2 = new Counter(20);
        thing3 = new Counter(100, 10);
        
        for (int i=0; i<10; i++){
        	thing3.down();
        }
        thing3.down();
        thing3.up();
        
        System.out.println(thing3.accessor()+thing2.accessor());
        thing3.print();
        
        System.out.println(thing1.toString());
        System.out.println(thing2.toString());
        System.out.println(thing3.toString());
    }
}

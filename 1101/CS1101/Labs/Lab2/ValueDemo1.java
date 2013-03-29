/**
 * @(#)ValueDemo1.java
 *
 *
 * @author 
 * @version 1.00 2009/1/22
 */

public class ValueDemo1 {
        
    public static void main(String[] args) {
        Value value1, value2, value3;
        value1 = new Value();
        value2 = new Value(1, 3);
        value3 = new Value(100,200);
        
        value1.getValue();
        value1.toString();
        value2.getValue();
        value2.toString();
        value3.getValue();
        value3.toString();
	}
}

/**
 * @(#)tester.java
 *
 *
 * @author 
 * @version 1.00 2009/1/25
 */
public class tester {
    public static void main(String[] args) {
    	double num = 1.4%1+.5;
    	int n = (int)1.4 + (int)(1.4%1+.5);
        System.out.println("1.45%1\t"+num+"\t"+n);
    }
}

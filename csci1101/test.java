/**
 * @(#)test.java
 *
 *
 * @author 
 * @version 1.00 2009/3/3
 */

public class test {
        
    /**
     * Creates a new instance of <code>test</code>.
     */
    public test() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BankAccount ba1;
        ba1 = new BankAccount(100, 0.0075);
        System.out.println(ba1);
    }
}

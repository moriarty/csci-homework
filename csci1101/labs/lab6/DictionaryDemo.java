/* DictionaryDemo.java
 * 2009/2/18
 */

public class DictionaryDemo {
    public static void main(String[] args) {
        Dictionary d1, d2;
        d1 = new Dictionary(1000, 45000);
        d2 = new Dictionary(100, 9000);
        
        System.out.println("d1 :"+d1+"\n\nd2 :"+d2);
    }
}
/*
--------------------Configuration: <Default>--------------------
d1 :this Dictionary has: 1000 Pages, and 45000 Definitions!
Thats about 45 Definitions per Page!

d2 :this Dictionary has: 100 Pages, and 9000 Definitions!
Thats about 90 Definitions per Page!

Process completed.
*/
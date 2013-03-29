/* StudentDemo.java
 * 2009/2/18
 */
public class StudentDemo {
    public static void main(String[] args) {
        Student s1, s2, s3;
        s1 = new Student("Alex", 1234);
        s2 = new Student("Allan", 3456);
        s3 = new Student("Alex", 1234);
        System.out.println("s1 == s2 :"+s1.equals(s2)+"\ns1 == s3 :"+s1.equals(s3));
    }
}
/*
--------------------Configuration: <Default>--------------------
s1 == s2 :false
s1 == s3 :true

Process completed.
*/

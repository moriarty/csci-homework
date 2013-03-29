/* KidDemo.java
 * 2009/2/18
 */

public class KidDemo {
    public static void main(String[] args) {
        ExaggeratingKid k1, k2, k3;
        k1 = new ExaggeratingKid("Dave","Mr. Barkhouse",5,"Hi, I Can Bike.");
        k2 = new ExaggeratingKid("Allan","Mr. Barkhouse",6);
        k3 = new ExaggeratingKid("Jacon","Mr. Teacher",5);
        
        System.out.println(k1+"\n\n"+k2+"\n\n"+k3);
    }
}
/*
--------------------Configuration: <Default>--------------------
Hi, I Can Bike. I am the Best!
Did I tell you that, My name is: Dave?!
And that I am: 7 years old!
My teacher is Mr. Barkhouse

HI I'm Allan. I am 6!  I am the Best!
Did I tell you that, My name is: Allan?!
And that I am: 8 years old!
My teacher is Mr. Barkhouse

HI I'm Jacon. I am 5!  I am the Best!
Did I tell you that, My name is: Jacon?!
And that I am: 7 years old!
My teacher is Mr. Teacher

Process completed.
*/

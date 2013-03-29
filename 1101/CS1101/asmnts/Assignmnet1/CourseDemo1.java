/**
 * @(#)CoursesDemo1.java
 *
 *
 * @author 
 * @version 1.00 2009/1/25
 */


public class CourseDemo1 {

    public static void main(String[] args) {
        Course math, science, english;
        math = new Course(1,4,6,2,1);
        
        System.out.println(Math.round(14.50));
        
        math.percent();
       	math.drawGraph();
        
    }
}

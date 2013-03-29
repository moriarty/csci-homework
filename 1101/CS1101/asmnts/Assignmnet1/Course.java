/**
 * @(#)Courses.java
 *
 *
 * @author 
 * @version 1.00 2009/1/25
 */


public class Course {
	
	private int numA;
	private int numB;
	private int numC;
	private int numD;
	private int numF;
	private int numGrades;		

    public Course() {
    }
    public Course(int numA, int numB, int numC, int numD, int numF){
    	this.numA = numA;
    	this.numB = numB;
    	this.numC = numC;
    	this.numD = numD;
    	this.numF = numF;
    	numGrades = numA+numB+numC+numD+numF;    		
    }
    public void setGrades(int numA, int numB, int numC, int numD, int numF){
    	this.numA = numA;
    	this.numB = numB;
    	this.numC = numC;
    	this.numD = numD;
    	this.numF = numF;
    	numGrades = numA+numB+numC+numD+numF;    		
    }
    public void readGrades(){
    	System.out.println("there are "+numGrades+" in total, of those;");
    	System.out.println("there are :"+numA+" A's");
    	System.out.println("there are :"+numB+" B's");
    	System.out.println("there are :"+numC+" C's");
    	System.out.println("there are :"+numD+" D's");
    	System.out.println("there are :"+numF+" F's");
    }
    // public void readGrade(String grade)
	//
	// public void getGrades()
	// private int getGrade()
    public int numGrades(){
    	return numGrades;
    }
    public void percent(){
    	System.out.println("there are "+numGrades+" in total, of those;");
    	System.out.println(calcPercent(numA)+"% are A's");
    	System.out.println(calcPercent(numB)+"% are B's");
    	System.out.println(calcPercent(numC)+"% are C's");
    	System.out.println(calcPercent(numD)+"% are D's");
    	System.out.println(calcPercent(numF)+"% are F's");
    }
    private int calcPercent(int numZ){
    	int percent;
    	double dblPercent;
    	dblPercent = 100*(0.0 + numZ)/(0.0+numGrades);
    	percent = roundOff(dblPercent);
    	return percent;	
    }
    private int roundOff(double numZ){
    	int newNum = (int)numZ+(int)(numZ%1+.5);
    	return newNum;    	
    }
    public void drawGraph(){
    	System.out.println("----|----|----THE_GRAPH-|----|----|");
    	System.out.println(makeAstrix(calcPercent(numA)*0.50)+"A");
    	System.out.println(makeAstrix(calcPercent(numB)*0.50)+"B");
    	System.out.println(makeAstrix(calcPercent(numC)*0.50)+"C");
    	System.out.println(makeAstrix(calcPercent(numD)*0.50)+"D");
    	System.out.println(makeAstrix(calcPercent(numF)*0.50)+"F");
    	System.out.println("----|----|----|----|----|----|----|");    	
    }
    private String makeAstrix(double dblAstrix){
    	int intAstrix = roundOff(dblAstrix);
    	String astrix = "";
    	for (int i = 0; i < intAstrix; i++){
    		astrix +="*";
    	}
    	return astrix;    	
    }
    public String toString(){
    	String result = "numA :"+numA+"\tnumB :"+numB+"\tnumC :"+numC+"\tnumD :"+numD+"\tnumF :"+numF;
		return result;
    }
}
/**
 *	CS 1101 Lab 6
 *	Dictionary.java
 *	Alex Moriarty
 *	2009/2/17
 **/

public class Dictionary extends Book{
/**	- numDefinitions: int	**/	
	private int numDefinitions;
    public Dictionary() {   }
/**	Dictionary(int p, int d)	**/
	public Dictionary(int p, int d){
		setPages(p);
		setDefinitions(d);
	}
/**	setDefinitions(int n): void	**/
	public void setDefinitions(int n){
		numDefinitions = n;
	}
/**	getDefintions(): int	**/
	public int getDefinitions(){
		return numDefinitions;
	}
/**	computeRatio(): int	**/	
    public int computeRatio(){
    	return (int)((getDefinitions()*1.0)/(getPages()*1.0));
    }
/**	toString(): String	**/
    public String toString(){
    	return "this Dictionary has: "+getPages()+" Pages, and "+getDefinitions()+" Definitions!\nThats about "+computeRatio()+" Definitions per Page!";
    }
}
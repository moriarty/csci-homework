/**
 *	CS 1101 Lab 6
 *	Book.java
 *	Alex Moriarty
 *	2009/2/17
 **/

public class Book {
/**	- numPages: int	**/
	private int numPages;
    public Book() { }
/**	Book(int n)	**/
    public Book(int n){
    	setPages(n);
    }
/**	setPages(int n): void	**/ 
	public void setPages(int n){
		numPages = n;
	}
/**	getPages(): int	**/	
	public int getPages(){
		return numPages;
	}   
    
}
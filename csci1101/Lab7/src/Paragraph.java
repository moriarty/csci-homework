import java.util.ArrayList;
public class Paragraph {
	//Store an ArrayList of sentence array lists
	ArrayList<ArrayList<String>> sentences;
	
	//Initialize the sentence list
	public Paragraph(){
		sentences = new ArrayList<ArrayList<String>>();
	}

	//Adds a setence to the list
	public void addSentence(ArrayList<String> sentence){
		sentences.add(sentence);
	}
	
	//Find a word in a sentence
	public String find(int sentence, int word){
		//Tries to find the specified sentence number. Returns error if it doesn't exist
		try{
			ArrayList<String> curSentence = sentences.get(sentence);
			//Tries to return the specified word. Returns error if it doesn't exist
			try {
				return curSentence.get(word);
			} catch(Exception e){
				System.out.println("Invalid word number.");
			}
		} catch(Exception e){
			System.out.println("Invalid sentence number.");
		}
		return "";
	}
}

package hw6;

import java.util.ArrayList;

/**
 * <p>
 * info class
 * </p>
 * This class is used to hold the value in the map<key,value> structure.
 * The count variable keeps track of how many times the key is found in the string,
 * and the words variable keeps track of which word the key is found in.
 */
public class info {

	private int count;
	private ArrayList<String> words = new ArrayList<String>();
	
	/**
	 * to get count value
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * set count value
	 */
	public void setCount() {
		this.count++;
	}
	
	/**
	 * to get arraylist words
	 * @return words
	 */
	public ArrayList<String> getWords() {
		return words;
	}
	public void setWords(String element) {
		words.add(element);
	}
	
	/**
	 * add element to words
	 * @param element
	 */
	public void push(String element) {
		count= count+1;
		words.add(element);
	}
	
}

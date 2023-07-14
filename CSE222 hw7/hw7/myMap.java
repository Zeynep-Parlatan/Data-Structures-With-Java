package hw7;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * myMap class
 * </p>
 *
 */
public class myMap {

	private LinkedHashMap <String, info> map = new LinkedHashMap<String, info>();
	private int mapSize=0;
	private String str;
	
	/**
	 * to get mapSize
	 * @return mapSize
	 */
	public int getmapSize() {
		return mapSize;
	}
	
	/**
	 * to get map
	 * @return map
	 */
	public LinkedHashMap<String, info> getMap(){
		return map;
	}
	
	/**
	 * <p>
	 * preprocessString
	 * </p>
	 * Given string is processed to only consist of lower-case letters and spaces.
	 * If there are uppercase letters, they are converted to lowercase and any characters
	 * other than spaces or letters are removed from the string. After these operations, if 
	 * string length is zero than error message is printing.
	 * @param str
	 * @return 1 is return if there is a error, 0 is return if the preprocess operation is succesfully done.
	 */
	public int preprocessString(String str) {
				
		String processInput="";								/*used to save preprocess string*/
		int spaceCount = 0;									/*number of space*/
		
		System.out.println("Original string:      "+ str);
		
		for(int i =0; i<str.length(); i++) {
			
			if((str.charAt(i)>=97 && str.charAt(i)<=122) || str.charAt(i)==32) {
				if(str.charAt(i)==32) spaceCount +=1;
				processInput = processInput.concat(Character.toString(str.charAt(i)));
			}
			else if(str.charAt(i)>=65 && str.charAt(i)<=90) { 				/*converting uppercase to lower case*/
				char lower = Character.toLowerCase(str.charAt(i));
				processInput = processInput.concat(Character.toString(lower));
			}
			
		}
		
		if(processInput.length() == 0 || processInput.length()==spaceCount) {
			return 1;
		}
	
		this.str = processInput;
		System.out.println("Preprocessed string:  "+ processInput);
		System.out.println();
		return 0;
	}
	
	/**
	 * <p>
	 * buildMap
	 * </p>
	 * According to preprocessed string, the map is created. 
	 * In a Map structure, the number of occurrences of each letter and
	 *  the word in which it appears is stored for that letter.
	 */
	public void buildMap() {
		
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i)==' ') {
				continue;
			}
			
			char ch = str.charAt(i);
			String key = Character.toString(ch);
			
			if(map.get(key)==null) {		
				info value = new info();
				//value.count = value.count+1;
				//value.words.add(getWord(i));
				value.setCount();
				value.setWords(getWord(i));
				map.put(key, value);
				mapSize = mapSize + 1;
			}
			else {
				//map.get(key).count += 1;
				//map.get(key).words.add(getWord(i));
				map.get(key).push(getWord(i));
			}
		}
		printMap();		
	}
	
	/**
	 * <p>
	 * printMap()
	 * </p>
	 */
	public void printMap() {
		
		for(String key : map.keySet()) {
			System.out.println("Letter: "+key+" - "+"Count: "+map.get(key).getCount()+" - "+"Words: "+map.get(key).getWords());
		}
		
	}
	
	/**
	 * <p>
	 * getWord
	 * </p>
	 * It is used to retrieve the word in which that letter appears from the string.
	 * @param index
	 * @return word
	 */
	public String getWord(int index) {
		String word = null;
		int space = 0;
		if(str.indexOf(" ")== -1) {			/*Returns the word if the string has no spaces*/
			return str;
		}
		space = str.indexOf(" ");			/*index of the first space*/
		
		if(index<space) {					/*For first word*/
			word = str.substring(0, space);
			//System.out.println("word "+ word);
		}
		else {
			for(int i = space; i<str.length(); i++) {
				if(i<index) {
					if(str.charAt(i)==' ') {
						space = i;
					}
				}
				else if((i>index && str.charAt(i)==' ')) {
					word = str.substring(space+1, i);
					break;
				}
				else if(i==str.length()-1) {
					word = str.substring(space+1);
				}
			}
		}
		return word;	
	}
	
}

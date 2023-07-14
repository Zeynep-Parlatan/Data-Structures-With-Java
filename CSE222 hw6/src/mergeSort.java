package hw6;

import java.util.LinkedHashMap;

/**
 * <p>
 * mergeSort class
 * </p>
 * This class is used to sort the keys in the map created for the given string
 * according to their count values using the merge sort algorithm.
 */
public class mergeSort {

	private myMap originalMap;
	private myMap sortedMap;
	private String[] aux ;
	
	
	public String[] getAux() {
		return aux;
	}
	
	/**
	 * <p>
	 * mergeSort
	 * </p>
	 * Constructor; This is used to assign the created map to the 'originalMap' variable and to save the keys to the 'aux' array.
	 * @param Map
	 */
	public mergeSort(myMap Map) {
		originalMap = Map;
		/*sortedMap = new myMap();*/
		fillAux();
	}
	
	/**
	 * <p>
	 * fillAux
	 * </p>
	 * The keys of originalMap are stored in the aux array
	 */
	public void fillAux() {
		
		aux = new String[originalMap.getmapSize()];
		int i = 0;
		for(String key: originalMap.getMap().keySet()) {
			aux[i] = key;
			i++;
		}
		
	}
	
	/**
	 * <p>
	 * printAux
	 * </p>
	 * For printing aux array. It is used just controlling keys.
	 */
	public void printAux() {
		for(int i=0; i<aux.length; i++) {
			System.out.print(aux[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * <p>
	 * mergeSort
	 * </p>
	 * Divide operation in the MergeSort algorithm.
	 * @param aux; for key
	 */
	public void mergeSort(String[] aux) {
		
		int length = aux.length;
		
		if(length == 1) {					/*If the length of the preprocessedString is already 1, then its sorted version will be equal to itself.*/
			sortedMap = new myMap();
			for(int i=0; i<aux.length; i++) {
				sortedMap.getMap().put(aux[i],originalMap.getMap().get(aux[i]));
			}
			return;
		}
		
		int middleIndex = length/2;
		String[] leftMap = new String[middleIndex];
		String[] rightMap = new String[length-middleIndex];
		
		for(int i=0; i<length; i++) {					/*copy of the element from aux to leftMap*/
			if(i<middleIndex) {
				leftMap[i] = aux[i];
			}
			else {										/*copy of the element from aux to rightMap*/
				rightMap[i-middleIndex] = aux[i];
			}
		}
			
		//System.out.println("Left");
		//printArray(leftMap);
		mergeSort(leftMap);
		
		//System.out.println("Right");
		//printArray(rightMap);
		mergeSort(rightMap);
		
		merge(aux,leftMap,rightMap);
		
		sortedMap = new myMap();
		for(int i=0; i<aux.length; i++) {
			sortedMap.getMap().put(aux[i],originalMap.getMap().get(aux[i]));
		}
		
	}
	
	/**
	 * <p>
	 * merge
	 * </p>
	 * To sort based on the count value of the key
	 * @param aux
	 * @param left
	 * @param right
	 */
	
	public void merge(String[] aux, String[] left, String[] right) {
		
		int leftSize = left.length;
		int rightSize = right.length;
		
		int leftIndex=0, rightIndex=0, index=0;
		
		int[] leftKeyCount = new int[leftSize];				/*for count values of key*/
		int[] rightKeyCount = new int[rightSize];
		
		for(int i=0; i<leftSize; i++) {
			leftKeyCount[i] = originalMap.getMap().get(left[i]).getCount();
		}
		for(int i=0; i<rightSize; i++) {
			rightKeyCount[i] = originalMap.getMap().get(right[i]).getCount();
		}
		/*sorting*/
		while(leftIndex < leftSize && rightIndex < rightSize) {
			
			if(leftKeyCount[leftIndex]<= rightKeyCount[rightIndex]) {
				aux[index] = left[leftIndex];
				leftIndex++;
			}
			else {
				aux[index] = right[rightIndex];
				rightIndex++;
			}
			index++;
		}
		
		while(leftIndex<leftSize) {
			aux[index] = left[leftIndex];
			index++;
			leftIndex++;
		}
		while(rightIndex<rightSize) {
			aux[index] = right[rightIndex];
			index++;
			rightIndex++;
		}
		
	}
	
	/**
	 * to print sorted map
	 */
	public void printMap() {
		
		for(String key : sortedMap.getMap().keySet()) {
			System.out.println("Letter: "+key+" - "+"Count: "+sortedMap.getMap().get(key).getCount()+" - "+"Words: "+sortedMap.getMap().get(key).getWords());
		}
		
	}
	
	/*
	public void printArray(String[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}*/
	
}

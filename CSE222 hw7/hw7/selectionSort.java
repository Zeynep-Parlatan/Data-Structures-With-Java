package hw7;

public class selectionSort {

	
	private myMap originalMap;
	private myMap sortedMap;
	private String[] aux ;
	private long runningTime;
	
	public String[] getAux() {
		return aux;
	}
	
	/**
	 * to get running time
	 * @return running time
	 */
	public long getTime() {
		return runningTime;
	}
	
	/**
	 * <p>
	 * mergeSort
	 * </p>
	 * Constructor; This is used to assign the created map to the 'originalMap' variable and to save the keys to the 'aux' array.
	 * @param Map
	 */
	public selectionSort(myMap Map) {
		originalMap = Map;
		sortedMap = new myMap();
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
	 * sSort
	 * </p>
	 * Used to call the selection sort function and calculate the running time.
	 */
	public void sSort() {
		
		long start = System.nanoTime();
		selectSort();
		long end = System.nanoTime();
		
		runningTime = end - start;
		
		fillSortedMap();
	}
	
	/**
	 * <p>
	 * selectSort
	 * </p>
	 * To sort based on the count value of the key with selection sort algorithm 
	 */
	public void selectSort() {
		
		int auxLength = aux.length;
		int min = 0;
		int[] counts = new int[auxLength];
		
		for(int i=0; i<auxLength; i++) {
			counts[i] = originalMap.getMap().get(aux[i]).getCount();
		}
		
		for(int i=0; i<auxLength-1; i++) {
			min = i;
			for(int j=i+1; j<auxLength; j++) {
				if(counts[min] > counts[j]) {
					min = j;
				}
			}
			int temp = counts[i];
			counts[i] = counts[min];
			counts[min] = temp;
			
			String tmp = aux[i];
			aux[i] = aux[min];
			aux[min] = tmp;
		}
	}
	
	public void fillSortedMap() {
		
		for(int i=0; i<aux.length; i++) {
			sortedMap.getMap().put(aux[i],originalMap.getMap().get(aux[i]));
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
	
	/**
	 * to print execution time of sorting algorithm
	 */
	public void printExecutionTime() {
		System.out.println("Selection sort running time: "+ runningTime);
	}
	
}

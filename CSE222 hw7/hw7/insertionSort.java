package hw7;

public class insertionSort {

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
	public insertionSort(myMap Map) {
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
	 * iSort
	 * </p>
	 * Used to call the insertion sort function and calculate the running time.
	 */
	public void iSort() {
		
		long start = System.nanoTime();
		insertSort();
		long end = System.nanoTime();
		
		runningTime = end - start;
		
		fillSortedMap();
		
	}
	
	/**
	 * <p>
	 * insertSort
	 * </p>
	 * To sort based on the count value of the key with insertion sort algorithm 
	 */
	public void insertSort() {
		
		int auxLength = aux.length;
		int temp = 0;
		String tmp;
		int[] counts = new int[auxLength];
		int prev;
		
		//keeping count value of key
		for(int i=0; i<auxLength; i++) {	
			counts[i] = originalMap.getMap().get(aux[i]).getCount();
		}
		
		for(int i=1; i<auxLength; i++) {
			temp = counts[i];
			tmp = aux[i];
			prev = i-1;
			//System.out.println("prev: "+prev);
			while(prev >= 0 && counts[prev] > temp) {
				//System.out.println("here");
				counts[prev + 1] = counts[prev];
				aux[prev + 1] = aux[prev];
				prev--;
			}
			counts[prev + 1] = temp;
			aux[prev + 1] = tmp;	
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
		System.out.println("Insertion sort running time: "+ runningTime);
	}
}

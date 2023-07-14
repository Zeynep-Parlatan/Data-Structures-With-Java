package hw7;

public class bubbleSort {

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
	public bubbleSort(myMap Map) {
		originalMap = Map;
		runningTime = 0;
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
	 * bSort
	 * </p>
	 * Used to call the bubble sort function and calculate the running time.
	 */
	public void bSort() {
		
		long start = System.nanoTime();
		bubSort();
		long end = System.nanoTime();
		
		runningTime = end - start;
		
		fillSortedMap();
		
	}
	
	/**
	 * <p>
	 * bubSort
	 * </p>
	 * To sort based on the count value of the key with bubble sort algorithm 
	 */
	public void bubSort() {
		
		int auxLength = aux.length;
		int[] counts = new int[auxLength];
		int temp;
		String tmp;
		int flag = 0;
		
		for(int i=0; i<auxLength; i++) {
			counts[i] = originalMap.getMap().get(aux[i]).getCount();
		}
		
		for(int i=0; i<auxLength; i++) {
			flag = 0;
			for(int j=1; j<auxLength-i; j++) {
				if(counts[j-1] > counts[j]) {
					flag = 1;
					temp = counts[j];
					tmp = aux[j];
					counts[j] = counts[j-1];
					aux[j] = aux[j-1];
					counts[j-1] = temp;
					aux[j-1] = tmp;
				}
			}

			if(flag == 0) {
				//System.out.println("already sorted");
				break;
			}
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
		System.out.println("Bubble sort running time: "+ runningTime);
	}
}

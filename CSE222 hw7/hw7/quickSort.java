package hw7;

public class quickSort {

	public myMap originalMap;
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
	public quickSort(myMap Map) {
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
	 * qSort
	 * </p>
	 * Used to call the quick sort function and calculate the running time.
	 */
	public void qSort() {
		
		long start = System.nanoTime();
		int l = aux.length;
		quickSorting(aux, 0, l-1);
		long end = System.nanoTime();
		
		runningTime = end - start;
	
		fillSortedMap();
	}
	
	/**
	 * <p>
	 * quickSorting
	 * </p>
	 * To sort based on the count value of the key with quick sort algorithm 
	 */
	public void quickSorting(String[] aux, int start, int end) {
		
		if(end <= start) {
			return;
		}
		
		int pivot = partition(aux, start, end);
		quickSorting(aux, start, pivot-1);
		quickSorting(aux, pivot+1, end);
		
	}
	
	public int partition(String[] aux, int start, int end) {
		
		int length = aux.length;
		int[] counts = new int[length];
		
		for(int i=0; i<length; i++) {
			counts[i] = originalMap.getMap().get(aux[i]).getCount();
		}
		
		int pivot = counts[end];
		int i = start - 1;
		
		for(int j = start; j<= end-1; j++) {
			if(counts[j] < pivot) {
				i++;
				int temp = counts[i];
				String tmp = aux[i];
				counts[i] = counts[j];
				aux[i] = aux[j];
				counts[j] = temp;
				aux[j] = tmp;
			}
		}
		i++;
		int temp = counts[i];
		String tmp = aux[i];
		counts[i] = counts[end];
		aux[i] = aux[end];
		counts[end] = temp;
		aux[end] = tmp;
		
		return i;
	}
	
	public void printAux() {
		for(int i=0; i<aux.length; i++) {
			System.out.print(aux[i]+" ");
		}
		System.out.println();
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
		System.out.println("Quick sort running time: "+ runningTime);
	}
}

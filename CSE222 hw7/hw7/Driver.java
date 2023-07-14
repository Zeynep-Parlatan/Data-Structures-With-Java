package hw7;


/**
 * <p>
 * Driver class
 * </p>
 * To test classes
 *
 */
public class Driver {
	
	public static void Test(String str, int sort) {
		
		myMap map = new myMap();
		
		if(map.preprocessString(str) == 1) {
			System.out.println("!! Error. After the preprocessing step, there is no suitable string left !!");
		}
		else {
			
			System.out.println("The original (unsorted) map: ");
			map.buildMap();
			System.out.println();
			
			/*merge sort*/
			if(sort == 0) {
				mergeSort merge = new mergeSort(map);
				merge.mSort();
				System.out.println("The sorted map: ");
				merge.printMap();
				merge.printExecutionTime();
			}
			
			/*selection sort*/
			else if(sort == 1) {
				selectionSort select = new selectionSort(map);
				select.sSort();
				System.out.println("The sorted map: ");
				select.printMap();
				select.printExecutionTime();
			}
			/*insertion sort*/
			else if(sort == 2) {
				insertionSort insert = new insertionSort(map);
				insert.iSort();;
				System.out.println("The sorted map: ");
				insert.printMap();
				insert.printExecutionTime();
			}
			/*bubble sort*/
			else if(sort == 3) {
				bubbleSort bubble = new bubbleSort(map);
				bubble.bSort();
				System.out.println("The sorted map: ");
				bubble.printMap();
				bubble.printExecutionTime();
			}
			
			/*quicksort*/
			else if(sort == 4) {
				quickSort quick = new quickSort(map);
				quick.quickSorting(quick.getAux(), 0, quick.originalMap.getmapSize()-1);
				quick.qSort();
				System.out.println("The sorted map: ");
				quick.printMap();
				quick.printExecutionTime();
			}
			
		}
			
	}

	public static void main(String[] argc) {
		
		System.out.println("Hw6\n");
		
		/**************************************************************************************************************/
		System.out.println("\n----------------------------------------Merge Sort----------------------------------------");
		System.out.println("\n==================================> Worst case scenario <================================\n");
		Test("hhhhhhgg ffgggff eeedd ccBA",0);
		
		System.out.println("\n==================================> Average case scenario <================================\n");
		Test("ABeee ccffdd gggffgg hhhhhh",0);
		
		System.out.println("\n==================================> Best case scenario <================================\n");
		Test("ABcc ddeee ffgggff gghhhhhh",0);
		
		/**************************************************************************************************************/
		System.out.println("\n----------------------------------------Selection Sort----------------------------------------");		
		System.out.println("\n==================================> Worst case scenario <================================\n");
		Test("hhhhhhgg ffgggff eeedd ccBA",1);
		
		System.out.println("\n==================================> Average case scenario <================================\n");
		Test("ABeee ccffdd gggffgg hhhhhh",1);
		
		System.out.println("\n==================================> Best case scenario <================================\n");
		Test("ABcc ddeee ffgggff gghhhhhh",1);
		
		/**************************************************************************************************************/
		System.out.println("\n----------------------------------------Insertion Sort----------------------------------------");		
		System.out.println("\n==================================> Worst case scenario <================================\n");
		Test("hhhhhhgg ffgggff eeedd ccBA",2);
		
		System.out.println("\n==================================> Average case scenario <================================\n");
		Test("ABeee ccffdd gggffgg hhhhhh",2);
		
		System.out.println("\n==================================> Best case scenario <================================\n");
		Test("ABcc ddeee ffgggff gghhhhhh",2);
		
		/**************************************************************************************************************/
		System.out.println("\n----------------------------------------Bubble Sort----------------------------------------");	
		System.out.println("\n==================================> Worst case scenario <================================\n");
		Test("hhhhhhgg ffgggff eeedd ccBA",3);
		
		System.out.println("\n==================================> Average case scenario <================================\n");
		Test("ABeee ccffdd gggffgg hhhhhh",3);
		
		System.out.println("\n==================================> Best case scenario <================================\n");
		Test("ABcc ddeee ffgggff gghhhhhh",3);
		
		/**************************************************************************************************************/
		System.out.println("\n----------------------------------------Quick Sort----------------------------------------");
		
		
		System.out.println("\n==================================> Worst case scenario <================================\n");
		Test("hhhhhhgg ffgggff eeedd ccBA",4);
		
		System.out.println("\n==================================> Average case scenario <================================\n");
		Test("ABeee ccffdd gggffgg hhhhhh",4);
		
		System.out.println("\n==================================> Best case scenario <================================\n");
		Test("ABcc ddeee ffgggff gghhhhhh",4);
	}
}
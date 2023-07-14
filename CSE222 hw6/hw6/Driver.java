package hw6;

/**
 * <p>
 * Driver class
 * </p>
 * To test classes
 *
 */
public class Driver {
	
	public static void Test(String str) {
		
		myMap map = new myMap();
		
		if(map.preprocessString(str) == 1) {
			System.out.println("!! Error. After the preprocessing step, there is no suitable string left !!");
		}
		else {
			System.out.println("The original (unsorted) map: ");
			map.buildMap();
			System.out.println();
			mergeSort merge = new mergeSort(map);
			merge.mergeSort(merge.getAux());
			System.out.println("The sorted map: ");
			merge.printMap();
		}
	}

	public static void main(String[] argc) {
		
		System.out.println("Hw6\n");
		
		/*-----------------------------------------------------------------------------------------------------------*/
		System.out.println("\n----------------------------------------Test1----------------------------------------\n");
		Test("15//06//2023");
		
		/*-----------------------------------------------------------------------------------------------------------*/
		System.out.println("\n----------------------------------------Test2----------------------------------------\n");
		Test("'java'");
		
		/*-----------------------------------------------------------------------------------------------------------*/
		System.out.println("\n----------------------------------------Test3----------------------------------------\n");
		Test("abc aba");
		
		/*-----------------------------------------------------------------------------------------------------------*/
		System.out.println("\n----------------------------------------Test4----------------------------------------\n");
		Test("Buzzing bees buzz.");
		
		/*-----------------------------------------------------------------------------------------------------------*/
		System.out.println("\n----------------------------------------Test5----------------------------------------\n");
		Test("'Hush, hush!' whispered the rushing wind.");
		
		
	}
}

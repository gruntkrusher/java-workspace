
public class SortTester {
	
	int[] m_unsortedData;
	
	public long[] test( int[] unsorted) {
		long[] opData = new long[3];
		
		m_unsortedData = (int[]) unsorted.clone();
		
		opData[0] = bubbleSort();
		System.out.println("bubble");
		opData[1] = selectionSort();
		System.out.println("select");
		opData[2] = insertionSort();
		System.out.println("insert");
		
		return opData;
	}
	
	public void printArray(final int[] a) {
		int i;
		
		for(i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	private void swap(int[] a, int b, int c) {
		int temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	}
	
	private long bubbleSort() {
		
		// make copy of stored unsorted array
		int[] unsorted = (int[]) m_unsortedData.clone();
		
		long startTime = System.nanoTime();
		// Sort
		int i, j;
		boolean swapped = true;
		for(i = unsorted.length-1; i > 0; i--){
			if(!swapped)
				break;
			swapped = false;
			for(j = 0; j < i; j++) {
				if(unsorted[j] > unsorted[j+1]) {
					swap(unsorted, j, j+1);
					swapped = true;
				}
			}
		}
		
		// return execution time
		return System.nanoTime() - startTime;
	}
	
	private long selectionSort() {
		
		// make copy of stored unsorted array
		int[] unsorted = (int[]) m_unsortedData.clone();
		
		long startTime = System.nanoTime();
		// Sort
		int i , j, minIndex;
		
	    for (i=0; i < unsorted.length - 1; i++) {
	    	minIndex = i;
	        for(j = i+1; j < unsorted.length; j++) {
	            if (unsorted[j] < unsorted[minIndex]) {
	            	minIndex = j;
	            }
	        }
	        swap(unsorted, i, minIndex);
	    }
	    
	    // return number of operations
		return System.nanoTime() - startTime;
	}
	
	private long insertionSort() {
		
		// make copy of stored unsorted array
		int[] unsorted = (int[]) m_unsortedData.clone();
		
		long startTime = System.nanoTime();
		// Sort
		int i, j;
	    for( i=1; i < unsorted.length; i++){
	      	int temp = unsorted[i];
	      	j=i;
	        while ( j>0 && unsorted[j-1] >= temp){
	        	unsorted[j] = unsorted[j-1];
	            j--;
	            unsorted[j] = temp;
	        }
	    }
		
	    // return number of operations
	 	return System.nanoTime() - startTime;
	}
	
}

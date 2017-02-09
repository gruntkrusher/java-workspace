
public class SortTester {
	
	int[] m_unsortedData;
	
	public long[] test( int[] unsorted) {
		long[] opData = new long[3];
		
		m_unsortedData = (int[]) unsorted.clone();
		
		opData[0] = bubbleSort();
		opData[1] = selectionSort();
		opData[2] = insertionSort();
		
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
		
		long n = 0; // Number of operations used ( copy = 1, conditional = 2, swap = 3)
		
		// make copy of stored unsorted array
		int[] unsorted = (int[]) m_unsortedData.clone();
		
		// Sort
		int i, j;
		boolean swapped = true;
		for(i = unsorted.length-1; i > 0; i--){
			if(!swapped)
				break;
			swapped = false;
			for(j = 0; j < i; j++) {
				n += 2;	// conditional
				if(unsorted[j] > unsorted[j+1]) {
					swap(unsorted, j, j+1);
					swapped = true;
					n += 3;	// swap
				}
			}
		}
		
		// return number of operations
		return n;
	}
	
	private long selectionSort() {
		
		long n = 0; // Number of operations used ( copy = 1, conditional = 2, swap = 3)
		
		// make copy of stored unsorted array
		int[] unsorted = (int[]) m_unsortedData.clone();
		
		// Sort
		int i , j, minIndex;
		
	    for (i=0; i < unsorted.length - 1; i++) {
	    	minIndex = i;
	    	n++;	// copy
	        for(j = i+1; j < unsorted.length; j++) {
	        	n += 2;	// conditional
	            if (unsorted[j] < unsorted[minIndex]) {
	            	minIndex = j;
	            	n++;	// copy
	            }
	        }
	        swap(unsorted, i, minIndex);
	        n += 3;	// swap
	    }
	    
	    // return number of operations
		return n;
	}
	
	private long insertionSort() {
		
		long n = 0; // Number of operations used ( copy = 1, conditional = 2, swap = 3)
		
		// make copy of stored unsorted array
		int[] unsorted = (int[]) m_unsortedData.clone();
		
		// Sort
		int i, j;
	    for( i=1; i < unsorted.length; i++){
	      	int temp = unsorted[i];
	      	j=i;
	      	
	      	n += 2;	// conditional
	        while ( j>0 && unsorted[j-1] >= temp){
	        	unsorted[j] = unsorted[j-1];
	            j--;
	            unsorted[j] = temp;
	            n += 3;	// swap
	        }
	    }
		
	    // return number of operations
	 	return n;
	}
	
}

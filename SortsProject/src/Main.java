import java.util.Random;


public class Main {
	
	public static void main(String[] args) {
		double nanoToSec = 1000000000;
		long[][] plotData = new long[1][3];
		int[] unsortedData;
		SortTester sT = new SortTester();
		
		unsortedData = best(1000000);
		plotData[0] = sT.test(unsortedData);
		
		for(int i = 0; i < plotData.length; i++) {
			System.out.println("bubble: " + plotData[i][0] + " selection: " + plotData[i][1] + " insertion: " + plotData[i][2]);
			System.out.println("bubble: " + plotData[i][0]/nanoToSec + " selection: " + plotData[i][1]/nanoToSec + " insertion: " + plotData[i][2]/nanoToSec);
			System.out.println();
		}
	}
	
	static int[] best(final int size) {
		
		int numSwaps = (int)(size * 0.005);
		Random rn = new Random();
		int[] a = new int[size];
		
		for(int i = 0; i < size; i++) {
			a[i] = i+1;
		}
		
		for(int i = 0; i < numSwaps; i++) {
			swap(a, rn.nextInt(Integer.MAX_VALUE) % size, rn.nextInt(Integer.MAX_VALUE) % size);
		}
		
		
		return a;
	}
	
	static int[] worst(final int size) {
		
		int[] a = new int[size];
		
		for(int i = 0; i < size; i++) {
			a[i] = size - i;
		}
		
		return a;
	}
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}

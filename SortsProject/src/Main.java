import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Main {
	
	public static void main(String[] args) {
		
		double nanoToSec = 1000000000;
		int[] testLengths = {100, 1000, 10000 };
		long[][] plotData = new long[9][3];
		int[] unsortedData;
		SortTester sT = new SortTester();
		
		try {
			PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
			System.setOut(out);
			
		} catch (FileNotFoundException e) {
			
			System.out.print(e.getMessage());
		}
		
		// best Sorts
		System.out.println("----BEST----\n");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
			{
				unsortedData = best(testLengths[i]);
				plotData[i] = sT.test(unsortedData);
				System.out.println(testLengths[i] + "  bubble: " + plotData[i][0] + " selection: " + plotData[i][1] + " insertion: " + plotData[i][2]);
				System.out.println(testLengths[i] + "  bubble: " + plotData[i][0]/nanoToSec + " selection: " + plotData[i][1]/nanoToSec + " insertion: " + plotData[i][2]/nanoToSec);
				System.out.println();
			}
		}
		
		// random Sorts
		System.out.println("----RAND----\n");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
			{
				unsortedData = random(testLengths[i]);
				plotData[i+3] = sT.test(unsortedData);
				System.out.println(testLengths[i] + "  bubble: " + plotData[i+3][0] + " selection: " + plotData[i+3][1] + " insertion: " + plotData[i][2]);
				System.out.println(testLengths[i] + "  bubble: " + plotData[i+3][0]/nanoToSec + " selection: " + plotData[i+3][1]/nanoToSec + " insertion: " + plotData[i+3][2]/nanoToSec);
				System.out.println();
			}
		}
		
		// worst Sorts
		System.out.println("----Worst----\n");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
			{
				unsortedData = worst(testLengths[i]);
				plotData[i+6] = sT.test(unsortedData);
				System.out.println(testLengths[i] + "  bubble: " + plotData[i+6][0] + " selection: " + plotData[i+6][1] + " insertion: " + plotData[i+6][2]);
				System.out.println(testLengths[i] + "  bubble: " + plotData[i+6][0]/nanoToSec + " selection: " + plotData[i+6][1]/nanoToSec + " insertion: " + plotData[i+6][2]/nanoToSec);
				System.out.println();
			}
		}
		
		System.out.println("done");
		
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
	
	static int[] random(final int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < size; i++) {
			list.add(i+1);
		}
		Collections.shuffle(list);
		
		int[] a = new int[size];
		for(int i = 0; i < size; i++) {
			a[i] = list.get(i);
		}
		
		return a;
	}
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}

package SortJava;
//importing the libraries that will be needed in this program
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Random;

//This class has Bubble Sort, Insertion Sort, Selection sort, Recursive merge Sort, Shell Sort and Quick Sort
public class SortShow extends JPanel {


		// An array to hold the lines_lengths to be sorted
		public int[] lines_lengths;
		//The amount of lines needed
		public final int total_number_of_lines = 256;
		 // An array to holds the scrambled lines_lengths
		public int[] scramble_lines;
		//A temp Array that is used later for sorts
		public int[] tempArray;

		//the default constructor for the SortShow class
		public SortShow(){
			//assigning the size for the lines_lengths below
			lines_lengths = new int[total_number_of_lines];
			for(int i = 0; i < total_number_of_lines; i++)
				lines_lengths[i] =  i+5;

		}


		//A method that scrambles the lines
		public void scramble_the_lines(){
			//A random generator
			Random num = new Random();
			//Randomly switching the lines
			for(int i = 0; i < total_number_of_lines; i++){
				//getting a random number using the nextInt method (a number between 0 to i + 1)
				int j = num.nextInt(i + 1);
				//swapping The element at i and j
				swap(i, j);
			}
			//assigning the size for the scramble_lines below
			scramble_lines = new int[total_number_of_lines];
			//copying the now scrambled lines_lengths array into the scramble_lines array
			//to store for reuse for other sort methods
			//so that all sort methods will use the same scrambled lines for fair comparison
			for (int i = 0; i < total_number_of_lines; i++)
			{
				scramble_lines[i] = lines_lengths[i];
			}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}

		//Swapping method that swaps two elements in the lines_lengths array
		public void swap(int i, int j){
			//storing the i element in lines_lengths in temp
			int temp = lines_lengths[i];
			//giving i element in lines_lengths the value of j element in lines_lengths
			lines_lengths[i] = lines_lengths[j];
			//giving j element in lines_lengths the value of temp
			lines_lengths[j] = temp;
		}
	    public void bubbleSort(){
			//getting the date and time when the bubble sort starts
			Calendar start = Calendar.getInstance();
			//for loop to iterate over each element the array
				for(int i = 0; i < lines_lengths.length-1; i++){
					//Comparing and swapping the elements
					for (int j = 0;  j < lines_lengths.length-1-i; j++){
						//comparing the adjacent element
						if (lines_lengths[j] > lines_lengths[j+1]){
							//swapping the elements
							swap(j,j+1);
							paintComponent(this.getGraphics());
							//Causing a delay for 1ms

						}
					}
				}
			//getting the date and time when the bubble sort ends
			Calendar end = Calendar.getInstance();
			//getting the time it took for the bubble sort to execute
			//subtracting the end time with the start time
			SortGUI.selectionTime = end.getTime().getTime() - start.getTime().getTime();
			//Causing a delay for 10ms
			delay(10);

		}
		//The selectionSort method
		public void SelectionSort(){
			//getting the date and time when the selection sort starts
			Calendar start = Calendar.getInstance();
			//Using the selection sort to lines_lengths sort the array
			//For loop to iterate through each element of the array
			for (int i = 0; i < lines_lengths.length - 1; i++) {
				//minimum index after each loop
				int minimumIndex = getIndexOfSmallest(i, lines_lengths.length-1);
				//swapping minimum index after each iteration
				swap(i, minimumIndex);
			}
			//getting the date and time when the selection sort ends
			Calendar end = Calendar.getInstance();
			//getting the time it took for the selection sort to execute
			//subtracting the end time with the start time
	        SortGUI.selectionTime = end.getTime().getTime() - start.getTime().getTime();
			//Causing a delay for 10ms
			delay(10);
		}
		//this method gets the smallest element in the array of lines_lengths
		public int getIndexOfSmallest(int first, int last){
			//Selecting the first element as the minimum index
			int minIndex = first;

			for (int i = first + 1; i <= last; i++){
				//Changing the minimum index if the current minimum index element
				//is greater than the compared element
				if (lines_lengths[i] < lines_lengths[minIndex]){
					//reassigning the minimum index
					minIndex = i;
					paintComponent(this.getGraphics());

				}
			}

			return minIndex; //returns minimum index

		}

	///////////////////////////////////////////////////////////////////////////////////

	public void insertionSort(){
		//getting the date and time when the insertion sort starts
		Calendar start = Calendar.getInstance();
		//Looping through the second element as the first is considered already sorted.
		for (int i = 1; i < lines_lengths.length; i++) {
			int key = lines_lengths[i];
			int j = i - 1;
			//comparing the key value with the element before to find the correct index for key
			while (j >= 0 && lines_lengths[j] > key) {
				lines_lengths[j + 1] = lines_lengths[j];
				j--;
			}
			lines_lengths[j + 1] = key;
			paintComponent(this.getGraphics());
		}

		//getting the date and time when the insertion sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the insertion sort to execute
		//subtracting the end time with the start time
		SortGUI.insertionTime = end.getTime().getTime() - start.getTime().getTime();
		//Causing a delay for 10ms
		delay(10);

	}
	//////////////////////////////////////////////////
	public void shellSort(){
		//getting the date and time when the selection sort starts
		Calendar start = Calendar.getInstance();
			int n = lines_lengths.length;
			// Start with a large gap, then reduce the gap
			for (int gap = n/2; gap > 0; gap /= 2) {
				// Do a gapped insertion sort for this gap size.
				// The first gap elements a[0..gap-1] are already in gapped order
				// keep adding one more element until the entire array is gap sorted
				for (int i = gap; i < n; i += 1) {
					// add arr[i] to the elements that have been gap sorted
					// save arr[i] in temp and make a hole at position i
					int temp = lines_lengths[i];
					// shift earlier gap-sorted elements up until the correct location for arr[i] is found
					int j;
					for (j = i; j >= gap && lines_lengths[j - gap] > temp; j -= gap) {
						lines_lengths[j] = lines_lengths[j - gap];
					}
					// put temp (the original arr[i]) in its correct location
					lines_lengths[j] = temp;
					paintComponent(this.getGraphics());

				}
			}
		//getting the date and time when the selection sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the selection sort to execute
		//subtracting the end time with the start time
		SortGUI.shellTime = end.getTime().getTime() - start.getTime().getTime();
		//Causing a delay for 10ms
		delay(10);
	}

	//////////////////////////////////////////////////
		//recursive merge sort method
	//recursive merge sort method
	public void R_MergeSort() {
		//getting the date and time when the recursive merge sort starts
		Calendar start = Calendar.getInstance();
		//assigning the total number of lines to variable n
		int n = lines_lengths.length;

		// Creating a copy of the original scrambled lines
		int []tempArray = new int[total_number_of_lines];
		//assigning first and last variables as the first number(0) and last number(255)
		int first = 0;
		int last = n-1;

		//Input array
		for( int i = 0; i<n; i++)
		{
			tempArray[i] = scramble_lines[i];
		}

		//calling function R_MergerSort
		R_MergeSort(lines_lengths, first, last);

		Calendar end = Calendar.getInstance();
		//getting the time it took for the iterative merge sort to execute
		//subtracting the end time with the start time
		SortGUI.rmergeTime = end.getTime().getTime() - start.getTime().getTime();
	}


	//recursive merge sort method
	public void R_MergeSort ( int[] arr, int first, int last){
		//assigning total number of lines to n again (256)
		int n = lines_lengths.length;

		//finding the middle element (for the first iteration, it would be 128)
		int mid = (first + last) / 2;

		//comparing first and last element to call the recursive function and break down array into smaller parts
		if (first < last) {

			//the first half of the original array
			R_MergeSort(arr, first, mid);
			//the second half of the original array
			R_MergeSort(arr, mid + 1, last);
			//calling the merging function to sort in smaller arrays and merge together
			R_Merge(arr, first, mid, last);

			//redrawing the lines_lengths
			paintComponent(this.getGraphics());

		}

	}
	//recursive merge sort method
	public void R_Merge(int[] arr, int first, int mid, int last){

		//creating a temporary array
		int[] temp = new int[last - first + 1];
		//assigning the first and middle element along with 'k'(which is used to merge into a sorted array)
		int i = first;
		int j = mid + 1;
		int k = 0;

		//comparing i and j to mid and last.
		while (i <= mid && j <= last) {
			//when condition is true, i and j in original array are compared to each other
			if (arr[i] <= arr[j]) {
				//when condition is true, the value in arr[i] is assigned to temporary array's k element
				temp[k] = arr[i];
				i++;
			}
			else {

				//when condition is false, the value in arr[j] is assigned to temporary array's k element
				temp[k] = arr[j];
				j++;
			}
			//k value is incremented to the next position, to enter next smallest value
			k++;
		}

		//elements sorted into temporary array (from first to mid elements)
		while (i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}

		//elements sorted into temporary array (from mid+1 to last elements)
		while (j <= last) {
			temp[k] = arr[j];
			j++;
			k++;
		}

		//arranges into one sorted array
		for (k = 0; k < temp.length; k++) {
			arr[first + k] = temp[k];
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////

		//iterative merge sort method
		public void I_MergeSort()
		{
		//getting the date and time when the iterative merge sort starts
		Calendar start = Calendar.getInstance();
		//assigning the size for the tempArray below
		tempArray = new int[total_number_of_lines];
		//saving the value of total_number_of_lines
		int beginLeftovers = total_number_of_lines;


		for (int segmentLength = 1; segmentLength <= total_number_of_lines/2; segmentLength = 2*segmentLength)
		{
			beginLeftovers = I_MergeSegmentPairs(total_number_of_lines, segmentLength);
			int endSegment = beginLeftovers + segmentLength - 1;
			if (endSegment < total_number_of_lines - 1)
			{
			I_Merge(beginLeftovers, endSegment, total_number_of_lines - 1);
			}
		}

		// merge the sorted leftovers with the rest of the sorted array
		if (beginLeftovers < total_number_of_lines) {
			I_Merge(0, beginLeftovers-1, total_number_of_lines - 1);
		}
		//getting the date and time when the iterative merge sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the iterative merge sort to execute 
		//subtracting the end time with the start time
	    SortGUI.imergeTime = end.getTime().getTime() - start.getTime().getTime();
			//Causing a delay for 10ms
			delay(10);
		}

	// Merges segments pairs (certain length) within an array 
	public int I_MergeSegmentPairs(int l, int segmentLength)
	{
		//The length of the two merged segments 

		//You suppose  to complete this part (Given).
		int mergedPairLength = 2 * segmentLength;
		int numberOfPairs = l / mergedPairLength;

		int beginSegment1 = 0;
		for (int count = 1; count <= numberOfPairs; count++)
		{
			int endSegment1 = beginSegment1 + segmentLength - 1;

			int beginSegment2 = endSegment1 + 1;
			int endSegment2 = beginSegment2 + segmentLength - 1;
			I_Merge(beginSegment1, endSegment1, endSegment2);

			beginSegment1 = endSegment2 + 1;
			//redrawing the lines_lengths
			paintComponent(this.getGraphics());

		}
		// Returns index of last merged pair
		return beginSegment1;
		//return 1;//modify this line
	}

	public void I_Merge(int first, int mid, int last)
	{
		//You suppose  to complete this part (Given).
		// Two adjacent sub-arrays
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// While both sub-arrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // Next available location in tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
		{
			// Invariant: tempArray[beginHalf1..index-1] is in order
			if (lines_lengths[beginHalf1] < lines_lengths[beginHalf2])
			{
				tempArray[index] = lines_lengths[beginHalf1];
				beginHalf1++;
			}
			else
			{
				tempArray[index] = lines_lengths[beginHalf2];
				beginHalf2++;
			}
		}
		//redrawing the lines_lengths
		paintComponent(this.getGraphics());

		// Finish off the nonempty sub-array

		// Finish off the first sub-array, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			// Invariant: tempArray[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf1];

		// Finish off the second sub-array, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			// Invariant: tempa[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf2];

		// Copy the result back into the original array
		for (index = first; index <= last; index++)
			lines_lengths[index] = tempArray[index];
	}
	//////////////////////////////////////////////////////////////////////
	public void quickSort() {
		//getting the date and time when the quicksort starts
		Calendar start = Calendar.getInstance();
		//first element index
		int low = 0;
		//last element index
		int high = lines_lengths.length - 1;
		//Calling quickSort helper method
		quickRecursive(low, high);
		//getting the date and time when the quicksort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the quicksort to execute
		//subtracting the end time with the start time
		SortGUI.quickTime = end.getTime().getTime() - start.getTime().getTime();
		//Causing a delay for 10ms
		delay(10);
	}

	public void quickRecursive(int first, int last) {
		//checking if there is an unsorted element
		if (first < last) {
			//partitioning the array to get the index
			int pivotIdx = partition(first, last);
			//recursion to sort the left sub array
			quickRecursive(first, pivotIdx - 1);
			//recursion to sort the right sub array
			quickRecursive(pivotIdx + 1, last);
		}
	}

	public int partition(int low, int high) {
		//Initializing index variable
		int i = low - 1;
		//Initializing the pivot
		int pivot = lines_lengths[high];
        //Sub-array iteration and swap elements less than pivots
		for (int j = low; j <= high - 1; j++) {
			//Increase index i and swap if the element is less than pivot
			if (lines_lengths[j] < pivot) {
				i++;
				//swapping method
				swap(i, j);
			}
			paintComponent(this.getGraphics());
		}
		swap(i + 1, high);
		return i + 1;
	}



	//////////////////////////////////////////////////////////////////////	

		//This method resets the window to the scrambled lines display
		public void reset(){
			if(scramble_lines != null)
			{
				//copying the old scrambled lines into lines_lengths
				for (int i = 0; i < total_number_of_lines; i++)
				{
					lines_lengths[i] = scramble_lines[i] ;
				}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
			}


		//This method colours the lines and prints the lines
		public void paintComponent(Graphics g){
 			super.paintComponent(g);
			//A loop to assign a colour to each line
			for(int i = 0; i < total_number_of_lines; i++){
				//using eight colours for the lines
				if(i % 8 == 0){
					g.setColor(Color.green);
				} else if(i % 8 == 1){
					g.setColor(Color.blue);
				} else if(i % 8 == 2){
					g.setColor(Color.yellow);
				} else if(i%8 == 3){
					g.setColor(Color.red);
				} else if(i%8 == 4){
					g.setColor(Color.black);
				} else if(i%8 == 5){
					g.setColor(Color.orange);
				} else if(i%8 == 6){
					g.setColor(Color.magenta);
				} else
					g.setColor(Color.gray);

				//Drawing the lines using the x and y-components
				g.drawLine(4*i + 25, 300, 4*i + 25, 300 - lines_lengths[i]);
			}

		}
	//A delay method that pauses the execution for the milliseconds time given as a parameter
	public void delay(int time){
		try{
			Thread.sleep(time);
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
	}

	}


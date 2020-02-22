// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	if(a == null) {
    		return a;
    	}
    	
    	double tempValue;
    	for(int i = 0; i < a.length; i++) {
    		for(int j = i; j > 0; j--) {
    			if(a[j] < a[j - 1]) {
    				tempValue = a[j];
    				a[j] = a[j - 1];
    				a[j-1] = tempValue;
    			}
    		}
    	}
    	return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	
    	if(a == null) {
    		return a;
    	}
    	
		double tempValue;
    	for(int i = 0; i < (a.length - 1); i++) {
    		int baseValue = i;
    		for(int j = i+1; j < a.length; j++) {
    			if(a[j] < a[baseValue]) {
    				baseValue = j;
    			}
    			tempValue = a[baseValue];
    			a[baseValue] = a[i];
    			a[i] = tempValue;
    		}
    		
    	}
    	return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[], int low, int high){
    	
    	if(a == null) {
    		return a;
    	}
    	
    	if(low < high) {
    		int partition = partition(a, low, high);
    		quickSort(a, low, partition - 1);
    		quickSort(a, partition+1, high);


    	}
		return a;
    }//end quicksort
    
    private static int partition(double a[], int low, int high) {
    	
    	
    	double pivotPoint = a[high];
    	int  i = low - 1;
    	for(int j = low; j < high; j++) {
    		if(a[j] <= pivotPoint) {
    			i++;
    		}
    		
    		double temp = a[i+1];
    		a[i] = a[j];
    		a[j] = temp;

    	}
    	double temp = a[i+1];
		a[i+1] = a[high];
		a[high] = temp;
		return i;
    	
    	
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

		 //todo: implement the sort
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	
    	if(a == null || a.length <= 1) {
    		return a;
    	}
    	
    	int pivot = a.length / 2;
    	double[] left = new double[pivot];	//splitting array into merge-groups
    	for(int i = 0; i < pivot; i++) {
    		left[i] = a[i];
    	}
    	
    	double[] right = new double[a.length - pivot];
    	for(int i = pivot; i < a.length; i++) {
    		right[i - pivot] = a[i];
    	}
    	
    	mergeSortRecursive(left);
    	mergeSortRecursive(right);
    	
    	int i,j,k;	//variables will be used by multiple loops
    	i = j = k = 0;
    	
    	while(i < left.length && j < right.length) {	//merging groups
    		if(left[i] < right[j]) {
    			a[k] = left[i];
    			i++;
    		}
    		else {
    			a[k] = right[j];
    			j++;
    		}
			k++;

    	}
    	while(i < left.length) { //what is not initially sorted (left over) will be added to end of merge groups
    		a[k] = left[i];
    		i++;
    		k++;
    	}
    	while(j < right.length) {
    		a[k] = right[k];
    		j++;
    		k++;
    	}
    	
    	

    	
    	return a;
   }//end mergeSortRecursive
    	
    


   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class

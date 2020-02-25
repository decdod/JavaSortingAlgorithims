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
     * @return array sorted in aschighing order.
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
    }//high insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in aschighing order
     *
     */
    static double [] selectionSort (double a[]){
    	
    	for(int i = 0; i < (a.length - 1); i++) {
    		int baseValue = i;
    		for(int j = i+1; j < a.length; j++) {
    			if(a[j] < a[baseValue]) {
    				baseValue = j;
    			}
    			double tempValue;

    			tempValue = a[baseValue];
    			a[baseValue] = a[i];
    			a[i] = tempValue;
    		}
    		
    	}
    	return a;
    }//high selectionsort
    

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in aschighing order
     *
     */
    static double[] quickSort (double a[]) {
    	quickSort(a, 0, a.length-1);
    	return a;
    }
    
    static void quickSort(double a[], int low, int high) {
        if (low < high) {
            int partitionIndex = partition(a, low, high);
     
            quickSort(a, low, partitionIndex-1);
            quickSort(a, partitionIndex+1, high);
        }
    }
    	
    static int partition(double a[], int low, int high) {
        double pivot = a[high];
        int i = (low-1);
     
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
     
                double swapTemp = a[i];
                a[i] = a[j];
                a[j] = swapTemp;
            }
        }
     
        double swapTemp = a[i+1];
        a[i+1] = a[high];
        a[high] = swapTemp;
     
        return i+1;
    }
    


    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in aschighing order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in aschighing sorted order.
     */
  static double[] mergeSortIterative (double a[]) {
	  	int n  = a.length;
    	double[] duplicate = new double[n];
    	for (int count = 1; count < n; count = count*2) {
    		for (int count2 = 0; count2 < n-count; count2 += count) {
    			int low = count2;
    			int middle = count+low-1;
    			int high;
    			if (2*count+low-1 > n-1) {
    				high = n-1;
    			}
    			else{
    				high = 2*count+low-1;
    			}
    			merge(a, duplicate, low, middle, high);
    			count2 += count;
    		}
    	}
		return a;
    	}
    	//end mergesortIterative
    	


  static void merge (double[] a, double[] duplicate, int low, int middle, int high) {
	  		boolean check = false;
	  		int n = duplicate.length;
    		int count = low;
    		int count2 = middle+1;
    		for (int iter4 = count; iter4<=high;iter4++) {
    			duplicate[iter4] = a[iter4];
    		}
    		for (int count3 = count; count3 <= high; count3++) {
    			if(high >= count2 && count2 < n && count < n && duplicate[count2]<duplicate[count]){
    				check = true;
    			}
    			if (count>middle || (high >= count2 && check)) {
    				a[count3] = duplicate[count2++];
    			}
    			else {
    				a[count3] = duplicate[count++];
    			}
    		}
  }

    	
//
//    static double[] mergeSortIterative (double a[]) {
//    	if(a == null || a.length <= 1) {
//    		return a;
//    	}
//    	int size, low;
//		int N = a.length - 1; //size of array
//		for( size = 1 ; size <= N-1; size = (size + size)) {
//			for( low = 0; low < N - 1; low += (size + size)) {
//				int mid = Math.min(low + size - 1, N-1);
//				int high = Math.min(low + (size + size - 1), N-1);
//				int lowBoundary = mid - low + 1;
//				int midBoundary = high - mid;
//				
//				merge(a, low, mid, high, lowBoundary, midBoundary);
//					
//				}
//			}
//		return a;
//			
//		}
//	
//    //high mergesortIterative
//    
//    
//    
//    private static void merge(double[] a, int low, int mid, int high, int lowBoundary, int midBoundary) {
//    	//variables will be used by multiple loops
//    	
//    	//instead of auxiliary these are temporary arrays with boundary limits
//    	double lowArray[] = new double[lowBoundary];
//    	double highArray[] = new double[midBoundary];
//    	int count = 0;
//    	while(count < lowBoundary) {
//    		lowArray[count] = a[low + count++];
//    	}
//    	count = 0;
//    	while(count < midBoundary) {
//    		highArray[count] = a[mid + 1 + count++];
//    	}
//    	int i, j;
//    	i = j = 0;
//    	int k=0;
//
//    	
//    	while(i < lowBoundary && j < midBoundary) {	//merging groups
//    		if(lowArray[i] <= highArray[j]) {
//    			a[k] = lowArray[i];
//    			i++;
//    		}
//    		else {
//    			a[k] = highArray[j];
//    			j++;
//    		}
//			k++;
//
//    	}
//    	while(i < lowBoundary) { //what is not initially sorted (low over) will be added to high of merge groups
//
//    		a[k] = lowArray[i];
//    		i++;
//    		k++;
//    	}
//    	while(j < midBoundary) {
//
//    		a[k] = highArray[j];
//    		j++;
//    		k++;
//    	}
//    			
//	}

	/**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in aschighing sorted order.
     */
    
    static double[] mergeSortRecursive (double a[]) {
    	
    	if(a == null || a.length <= 1) {
    		return a;
    	}
    	
    	int pivot = a.length / 2;
    	double[] low = new double[pivot];	//splitting array into merge-groups
    	for(int i = 0; i < pivot; i++) {
    		low[i] = a[i];
    	}
    	
    	double[] right = new double[a.length - pivot];
    	for(int i = pivot; i < a.length; i++) {
    		right[i - pivot] = a[i];
    	}
    	
    	mergeSortRecursive(low);
    	mergeSortRecursive(right);
    	
    	int i,j,k;	//variables will be used by multiple loops
    	i = j = k = 0;
    	
    	while(i < low.length && j < right.length) {	//merging groups
    		if(low[i] < right[j]) {
    			a[k] = low[i];
    			i++;
    		}
    		else {
    			a[k] = right[j];
    			j++;
    		}
			k++;

    	}
    	while(i < low.length) { //what is not initially sorted (low over) will be added to high of merge groups

    		a[k] = low[i];
    		i++;
    		k++;
    	}
    	while(j < right.length) {

    		a[k] = right[j];
    		j++;
    		k++;
    	}
    	
    	

    	
    	return a;
   }//high mergeSortRecursive
    	
    


   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }
    
    

 }//high class

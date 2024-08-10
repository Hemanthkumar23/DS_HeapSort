public class HeapSort {

    static void heapify(int a[], int n, int i) {

        int largest = i; // Initialize largest as root

        int left = 2 * i +1; //left child

        int right = 2 * i +2; //right child

        //If left child larger than root
        if( left < n && a[left] > a[largest]) {
            largest = left;
        }
        if( right < n && a[right] > a[largest]) {
            largest = right;
        }

        //If root is largest
        if(largest != i) {
            // swap a[i] with a[largest]
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, n, largest);
        }

    }

    static void heapSort(int a[], int n) {

        for(int i=n/2-1; i>=0; i--){
            heapify(a,n,i);
        }

        // One by one extract an element from heap
        for(int i=n-1;i>=0;i--) {
            // Move current root element to end
            // swap a[0] with a[i]
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, i, 0);
        }
    }
    static void printArray(int[] a, int n) {

        for( int i=0; i<n; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 28, 6, 7};

        int n = arr.length;

        System.out.println("Before sorting array elements are: \n");

        HeapSort.printArray(arr,n);
        heapSort(arr, n);

        System.out.println("After sorting array elements are: \n");

        HeapSort.printArray(arr, n);
    }
}
package SecondFiveStepsOfProjects.SerachAndSorting;

public class Array {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void linearSearch(int [] list, int item){
        boolean found=false;

        for(int i:list){

            if(i==item){
                found=true;
                break;
            }
            else{
                found=false;
            }
        }

        if(found)
            System.out.println("The item is found :)");
        else
            System.out.println("The item is not found :(");
    }


    public boolean binarySearch(int[] list,int item,int from,int to){
        int mid;
        if(from>to){
            return false;
        }
        else{
            mid=(from+to)/2;

            if(list[mid]==item)
                return true;
            else if(item<list[mid])
                return   binarySearch(list,item,from,mid-1);
            else
                return binarySearch(list,item,mid+1,to);
        }
    }

    public void selectionSort(int[]list){
        for(int i=0;i<list.length;i++){
            for(int j=i;j<list.length;j++){
                if(list[i]>list[j]){
                    int t=list[i];
                    list[i]=list[j];
                    list[j]=t;
                }
            }

        }
    }

    public void bubbleSort(int[]list){
        for(int i=0;i<list.length;i++){

            for(int j=0;j<(list.length-1);j++){

                if(list[j]>list[j+1]){
                    int t=list[j];
                    list[j]=list[j+1];
                    list[j+1]=t;
                }
            }
        }
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i;


            while (j > 0 && arr[j-1] > key) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
        }
    }


    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        swap(arr, middle, high);

        int left = low;
        int right = high - 1;

        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        swap(arr, left, high);

        return left;
    }

    public  void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];



    // Copy elements to the left array
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

    // Copy elements to the right array
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }


    public  void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);

            heapify(arr, i, 0);
        }
    }


    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }


        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }


}



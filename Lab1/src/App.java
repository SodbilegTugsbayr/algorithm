import java.util.Arrays;

public class App {
    public  int[] insertionSort(int[] list){
        int key, i;
        for(int j =1; j < list.length; j++){
            key = list[j];
            i = j - 1;
            while(i >= 0 && list[i] > key){
                list[i+1] = list[i];
                i--;
            }
            list[i+1] = key;
        }
        return list;
    }
    

    public int findMax(int[] arr,int l, int r){
        if(l == r){
            return arr[l];
        }
        int mid =(l + r)/2;

        int maxLeft = findMax(arr, l, mid);
        int maxRight = findMax(arr, mid+1, r);

        return Math.max(maxLeft, maxRight);
    }

    public void mergeSort(int[] list, int p, int r){
        if(p < r){
            int q = (p + r)/2;
            mergeSort(list, p, q);
            mergeSort(list, q+1, r);

            merge(list, p, q, r);
        }
    }

    public void merge(int[] list, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for(int i = 0; i < n1; i++){
            left[i] = list[p + i];
        }

        for(int j = 0; j < n2; j++){
            right[j] = list[q + j + 1];
        }

        int i = 0, j = 0;
        int k = p;

        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            list[k] = left[i];
            i++;
            k++;
        }

        while(j < n2){
            list[k] = right[j];
            j++;
            k++;
        }

    }

    public int binarySearch(int[] list, int min, int max, int key){
        int mid =(min + max)/2;
        if(list[mid] == key)
        return mid;
        else if(list[mid] < key)
        return binarySearch(list, mid, max, key);
        else
        return binarySearch(list, min, mid, key);
    }
    public static void main(String[] args) {
        App app = new App();

        int[] arr = {132, 3, 4, 1, 45, 5, 64, 62};

        app.mergeSort(arr, 0, 7);

        System.out.println(Arrays.toString(arr));

        System.out.println("max : " + app.findMax(arr,0, 7));
        System.out.println(app.binarySearch(arr, 0, 7, 5));
    }
}

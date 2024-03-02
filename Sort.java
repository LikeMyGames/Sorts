import java.util.ArrayList;

public class Sort{
    public static void merge(int[] arr){
        arr = mergeSort(arr, 0, arr.length-1);
    }
    
    private static int[] mergeSort(int[] arr, int first, int last){
        int arrLen = arr.length;
        if(arr.length == 1)
            return arr;
        if(arrLen == 2){
            if(arr[1]>arr[0])
                return arr;
            else{
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
                return arr;
            }
        }
        int[] arr1 = new int[arrLen/2];
        int[] arr2;
        if(arrLen%2 != 0)
            arr2 = new int[(arrLen/2)+1];
        else
            arr2 = new int[arrLen/2];
        for(int i = 0; i<arr.length; i++){
            if(i<arr1.length)
                arr1[i] = arr[i];
            else
                arr2[i-arr1.length] = arr[i];
        }
        arr1 = mergeSort(arr1, first, arr1.length-1);
        arr2 = mergeSort(arr2, arr1.length, last);
        int[] newArr = new int[arr.length];
        int i=0, j=0, k=0;
        while(k<newArr.length){
            if(j == arr2.length){
                newArr[k] = arr1[i];
                k++;
                i++;
            }
            else if(newArr.length%2 != 0 && j+1 == newArr.length){
                newArr[k] = arr2[j];
                k++;
                j++;
            }
            else if(i == arr1.length){
                newArr[k] = arr2[j];
                k++;
                j++;
            }
            else{
                if(arr1[i] > arr2[j]){
                    newArr[k] = arr2[j];
                    k++;
                    j++;
                }
                else {
                    newArr[k] = arr1[i];
                    k++;
                    i++;
                }
            }
        }
        return newArr;
    }

    public static void stalin(int[] arr){
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for(int i = 0; i<newArr.size(); i++){
            newArr.set(i, arr[i]);
        }
        for(int i = 0; i<newArr.size()-1; i++){
            if(newArr.get(i) > newArr.get(i+1)){
                newArr.remove(i);
            }
        }
    }









}

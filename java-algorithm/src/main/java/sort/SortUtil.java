package sort;

/**
 * 排序工具类
 */
public abstract class SortUtil {

    // 冒泡排序
    public static void BubbleSort(int[] arr) {
        for (int loop = 0; loop < arr.length-1 ; loop++ ) {
            boolean flag = true;
            for ( int index = 0; index< arr.length-1-loop ; index++ ) {
                if( arr[index+1] < arr[index] ){
                    swap(arr,index+1,index);
                    flag = false;
                }
            }
            if( flag ) break;
        }
    }

    private static void swap(int[] arr,int i,int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

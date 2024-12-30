public class QuickSort {
    // 快速排序主函数
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取分区索引
            int pi = partition(arr, low, high);

            // 递归排序左半部分和右半部分
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 分区函数
    private static int partition(int[] arr, int low, int high) {
        // 选择最左边的元素作为基准值
        int pivot = arr[low];
        System.out.println("pivot="+pivot);
        int i = low + 1; // 从基准值的下一个元素开始
        int j = high;

        while (true) {
            // 从左向右找到第一个大于等于基准值的元素
            while (i <= j && arr[i] < pivot) {
                i++;
            }

            // 从右向左找到第一个小于等于基准值的元素
            while (i <= j && arr[j] > pivot) {
                j--;
            }

            // 如果i和j相遇或交叉，退出循环
            if (i >= j) {
                break;
            }

            // 交换arr[i]和arr[j]
            System.out.println("交换找到的最大值和最小值 。最大值 arr["+i+"]="+arr[i]+" , 最小值 arr["+j+"]="+ arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            System.out.println("交换完成 arr["+i+"]="+arr[i]+" , arr["+j+"]="+ arr[j]);
            System.out.print("中途结果： ");
            printArray(arr);
            // 继续移动指针
            i++;
            j--;
        }

        // 将基准值放到正确的位置
        System.out.println(" arr["+low+"]="+arr[low]+" , arr["+j+"]="+ arr[j]);
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        System.out.print("一轮结束： ");
        printArray(arr);
        // 返回基准值的索引
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 11, 25, 12, 2};
        System.out.println("排序前的数组:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后的数组:");
        printArray(arr);
    }

    // 辅助方法：打印数组
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
package DataStucture.Sort;

public class QuickSort implements MySort{
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int array[], int low, int high) {
        //종료조건
        if (low >= high) return;
        //피벗을 중간 값으로 지정
        int pivotIndex = low + ((high - low) / 2);
        int pivot = array[pivotIndex];

        int left = low;
        int right = high;

        while (left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(array, low, right);
        quickSort(array, left, high);

    }
}

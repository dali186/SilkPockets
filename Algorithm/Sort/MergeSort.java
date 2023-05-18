package DataStucture.Sort;

public class MergeSort implements MySort {
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low >= high) return;

        int mid = low + ((low + high) / 2);

        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);

        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int idx = 0;

        int left = low;
        int right = mid + 1;

        while (left >= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp[idx] = array[left];
                left++;
            } else {
                temp[idx] = array[right];
                right++;
            }
            idx++;
        }
        //본래 배열에 값이 남아 있는 경우
        while (left <= mid) {
            temp[idx] = array[left];
            idx++;
            left++;
        }

        while (right <= high) {
            temp[idx] = array[right];
            idx++;
            right++;
        }

        //temp를 array로 복사
        for (int i = low; i <= high; i++) {
            array[i] = temp[i - low];
        }
    }
}

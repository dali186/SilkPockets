package DataStucture.Sort;

public class InsertionSort implements MySort{
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[i + 1] = array[j];
                j = j - 1;
            }
            array[j] = key;
        }
    }
}

package DataStucture.Sort;

import java.util.Arrays;

public class BinarySearch {
    public int search(int ary[], int target) {
        int index = ary.length / 2;
        if (ary[index] == target) {
            return ary[index];
        } else if (ary[index] > target) {
            int[] upper = Arrays.copyOfRange(ary, 0, index);
            return search(upper, target);
        } else if (ary[index] < target){
            int[] lower = Arrays.copyOfRange(ary, index+1, ary.length);
            return search(lower, target);
        }
        return -1;
    }
}

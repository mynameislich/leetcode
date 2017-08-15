
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zuoyzhao
 */
public class MedianFinder {

    public MedianFinder() {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> intList1 = new ArrayList<Integer>(nums1.length);

        for (int i = 0; i < nums1.length; i++) {
            intList1.add(nums1[i]);
        }
        ArrayList<Integer> intList2 = new ArrayList<Integer>(nums2.length);

        for (int i = 0; i < nums2.length; i++) {
            intList2.add(nums2[i]);
        }

        ArrayList temp_list = mergingTwoArrays(intList1, intList2);
        double result = 0.0;
        if (!temp_list.isEmpty()) {
            if (temp_list.size() % 2 == 0) {
                result = ((Integer) temp_list.get(temp_list.size() / 2) + (Integer) temp_list.get(temp_list.size() / 2 - 1)) * 0.5;
            } else {
                result = (Integer) temp_list.get(temp_list.size() / 2);
            }
        } else {
            return 0.0;
        }
        return result;
    }

    public ArrayList mergingTwoArrays(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        ArrayList result = new ArrayList();

        int counter = 0;
        int i = 0;
        do {
            if (counter < nums2.size() && i < nums1.size()) {
                if (nums1.get(i) >= nums2.get(counter)) {
                    result.add(nums2.get(counter));
                    counter++;
                }

                else if (nums1.get(i) < nums2.get(counter)) {
                    result.add(nums1.get(i));
                    i++;
                }
            } else if (counter >= nums2.size() && i < nums1.size()) {
                result.add(nums1.get(i));
                i++;
            } else if (counter < nums2.size() && i >= nums1.size()) {
                result.add(nums2.get(counter));
                counter++;
            }
        } while (counter < nums2.size() || i < nums1.size());

        return result;
    }

    /*public static void main(String[] args) {
        ArrayList nums1 = new ArrayList();
        ArrayList nums2 = new ArrayList();
        nums1.add(3);
        nums1.add(3);
        nums1.add(9);
        nums1.add(12);
        nums1.add(19);
        nums2.add(1);
        nums2.add(9);
        nums2.add(18);
        nums2.add(20);
        nums2.add(22);
        double result = 0.0;
        int[] temp1 = {1,3};
        int[] temp2 = {2};
        MedianFinder temp = new MedianFinder();
        result = temp.findMedianSortedArrays(temp1, temp2);

        System.out.println(result);

    }*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zuoyuan
 */
public class MostWaterContainer {

    public MostWaterContainer() {
    }

    public int maxArea(int[] height) {
        int result = 0;
        /*int counter1 = 0;
         int counter2 = height.length - 1;
         do {
         int temp_area = (counter2 - counter1) * (Math.min(height[counter1], height[counter2]));
         if (temp_area > result) {
         result = temp_area;
         }
         counter1++;
         counter2--;
         } while (counter1 < counter2);*/
        // wrong logic above
        int counter1 = 0;
        int counter2 = height.length - 1;
        do {
            int temp_area = (counter2 - counter1) * (Math.min(height[counter1], height[counter2]));
            if (temp_area > result) {
                result = temp_area;
            }
            if (height[counter1] > height[counter2]) {
                counter2--;
            } else {
                counter1++;
            }
        } while (counter1 < counter2);
        return result;
    }

    public static void main(String[] args) {
        MostWaterContainer temp = new MostWaterContainer();
        int[] height = {1, 1};
        int result = temp.maxArea(height);
        System.out.println(result);
    }
}

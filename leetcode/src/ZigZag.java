/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zuoyzhao
 */
public class ZigZag {

    public ZigZag() {
    }

    public String convert(String s, int numRows) {
        String result = "";
        char[][] arr = new char[numRows][s.length()];
        boolean down = true;
        int rowCount = 0;
        int dirChanges = 0;
        if (numRows == 1) {
            return s;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                arr[rowCount][dirChanges] = c;
                if (rowCount == numRows - 1) {
                    down = false;
                    dirChanges++;
                }
                if (rowCount == 0) {
                    down = true;
                    dirChanges++;
                }
               
                if (down) {
                    rowCount++;
                } else {
                    rowCount--;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (arr[i][j] != Character.MIN_VALUE) {
                    result = result + arr[i][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ZigZag temp = new ZigZag();
        String s = temp.convert("ABC", 2);
        System.out.println(s);
    }
}

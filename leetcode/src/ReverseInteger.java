/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zuoyzhao
 */
public class ReverseInteger {

    public ReverseInteger() {
    }

   public int reverse(int x) {
        int result = 0;
        if (x > Math.pow(2, 31)) {
            return 0;
        }
        String temp = "";
        if (x == 0) {
            return 0;
        }
        if (x > 0) {
            String s = Integer.toString(x);
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                temp = temp + c;
            }
            try {
                result = Integer.parseInt(temp);
            } catch (Exception e) {
                return 0;
            }
        } else {
            String s = Integer.toString(x);
            for (int i = s.length() - 1; i > 0; i--) {
                char c = s.charAt(i);
                temp = temp + c;
            }
            try {
                result = -1 * Integer.parseInt(temp);
            } catch (Exception e) {
                return 0;
            }

        }
        return result;
    }

   /* public static void main(String[] args) {
        ReverseInteger temp = new ReverseInteger();
        int n = temp.reverse(964632435);
        System.out.println(Math.pow(2, 31));
    }*/
}

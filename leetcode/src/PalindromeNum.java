/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zuoyzhao
 */
public class PalindromeNum {

    public PalindromeNum() {
    }

    public boolean isPalindrome(int x) {
        boolean result = true;
        /*int bot = 1;
        do {
            bot = bot * 10;
        } while (x / bot >= 10);
        do {
            if (x > 0 && x < 10) {
                return true;
            }
            int head = x / bot;
            int tail = x % 10;
            if (head != tail) {
                return false;
            }
            x = x - bot * head;
            x = (x - tail) / 10;
            bot = bot / 100;
        } while (x != 0);*/
        // above failed the case of input 1000021, try to use string to solve it
        String s = Integer.toString(x);
        do {
            if (s.length() == 1) {
                return true;
            }
            char h = s.charAt(0);
            char t = s.charAt(s.length() - 1);
            if (h != t) {
                return false;
            }
            s = s.substring(1, s.length() - 1);
        } while (s.length() != 0);
        return result;
    }

    public static void main(String[] args) {
        PalindromeNum temp = new PalindromeNum();
        boolean ans = temp.isPalindrome(1000021);
    }
}

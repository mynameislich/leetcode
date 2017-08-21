/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zuoyzhao
 */
public class LongestCommonPrefix {

    public LongestCommonPrefix() {
    }

    public String findLCP(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = "";
        //StringBuilder sb = new StringBuilder("");
        int min = strs[0].length();
        for (String str : strs) {
            if (str.length() < min) {
                min = str.length();
            }
        }
        for (int i = 0; i < min; i++) {
            boolean commonChar = true;
            for (String str : strs) {
                if (str.charAt(i) != strs[0].charAt(i)) {
                    commonChar = false;
                    break;
                }
            }
            if (commonChar == false) {
                break;
            } else {
                result = strs[0].substring(0, i + 1);
            }
        }
        // result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix temp = new LongestCommonPrefix();
        //["babb","caa"]
        String[] strs = {"babb", "caa"};
        temp.findLCP(strs);
    }
}

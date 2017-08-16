/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zuoyuan
 */
public class String2Int {

    public String2Int() {
    }

    public int myAtoi(String str) {
        int result = 0;
        String s = "";
        boolean negative = false;
        boolean somethingAhead = false;
        boolean numAhead = false;
        boolean spaced = false;
        int SignCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int temp = Character.getNumericValue(c);
            if (temp >= 0 && temp < 10) {
                s = s + c;
                numAhead = true;
            } else if (c == '-') {
                negative = !negative;
                somethingAhead = true;
                SignCounter++;
            } else if (c == '+') {
                somethingAhead = true;
                SignCounter++;
            } else if (c == ' ') {
                spaced = true;
                if (somethingAhead && spaced) {
                    return 0;
                } else if (numAhead && spaced) {
                    break;
                }
            } else {
                break;
            }
        }
        try {
            if (s == "") {
                return 0;
            }
            if (SignCounter > 1) {
                return 0;
            }
            result = Integer.parseInt(s);
            if (negative) {
                result = -1 * result;
            }
        } catch (Exception e) {
            try {
                long avoidOverflows = Long.parseLong(s);
                if (avoidOverflows > 2147483647 && !negative) {
                    return 2147483647;
                }
                if (avoidOverflows > 2147483647 && negative) {
                    return -2147483648;
                }
                result = (int) avoidOverflows;
                if (result > 0) {
                    if (negative) {
                        result = -1 * result;
                    }
                }
                if (result < 0) {
                    if (!negative) {
                        result = Math.abs(result);
                    }
                }
                return result;
            } catch (NumberFormatException e2) {
                if (str.length() >= 10) {
                    if (str.charAt(0) == '-') {
                        return -2147483648;
                    } else {
                        return 2147483647;
                    }
                }

            }
            return 0;
        }
        return result;
    }

   /* public static void main(String[] args) {
        String2Int temp = new String2Int();
        int n = temp.myAtoi("+");
        System.out.println(n);
    }*/
}

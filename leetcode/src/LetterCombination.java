
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zuoyzhao
 */
public class LetterCombination {

    public LetterCombination() {
    }

    public List<String> digitsToLetters(String digits) {
        List<String> result = new ArrayList();
        String[] elements = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.isEmpty()) {
            return result;
        }
        result.add("");
        int length_required = 0;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) == '1') {
                continue;
            } else {
                length_required++;
            }
        }
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) == '1') {
                continue;
            } else {
                List temp_list = new ArrayList();
                int index = Character.getNumericValue(digits.charAt(i));
                for (int j = 0; j < elements[index].length(); j++) {
                    List temp_list_itr = addALetter(result, elements[index].charAt(j));
                    temp_list.addAll(temp_list_itr);
                }
                result.addAll(temp_list);
            }
        }
        ArrayList real_result = new ArrayList();
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).length() == length_required){
                real_result.add(result.get(i));
            }
        }
        return real_result;
    }

    public List<String> addALetter(List<String> strs, char c) {
        List<String> result = new ArrayList();
        for (String str : strs) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(c);
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {

        LetterCombination temp = new LetterCombination();
        ArrayList strs = (ArrayList) temp.digitsToLetters("123");
    }
}

package leetcode.string.two_pointer;

/**
 * Created by lenovo on 2019/5/6.
 * 反转字符串中的元音字符
 */
public class _345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        String del = "aeiouAEIOU";
        char []array = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            while(start < end && !del.contains(array[start]+""))
                start ++;
            while(start < end && !del.contains(array[end]+""))
                end--;

            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start ++;
            end--;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        _345_Reverse_Vowels_of_a_String test = new _345_Reverse_Vowels_of_a_String();
        test.reverseVowels("hello");
        System.out.println("hello".charAt(1) != 'e');
    }
}

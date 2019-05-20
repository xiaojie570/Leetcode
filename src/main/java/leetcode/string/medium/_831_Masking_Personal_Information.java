package leetcode.string.medium;

/**
 * Created by lenovo on 2019/5/20.
 * 隐藏个人信息：邮箱 或者 电话号
 */
public class _831_Masking_Personal_Information {
    private final String[] starters = {"", "+*-", "+**-", "+***-"};

    public String maskPII(String S) {
        if (S == null) {
            return "";
        }
        S = S.toLowerCase();
        if (S.indexOf('@') != -1) {
            return maskEmail(S);
        } else {
            return maskPhone(S);
        }
    }

    private String maskEmail(String S) {
        String name1 = S.substring(0, S.indexOf('@'));
        char first = name1.charAt(0);
        char last = name1.charAt(name1.length() - 1);
        String remaining = S.substring(S.indexOf('@'), S.length());
        return first + "*****" + last + remaining;
    }

    private String maskPhone(String S) {
        String phonePlain = S.replaceAll("[\\+\\-\\(\\)\\s]", "");
        String lastFour = phonePlain.substring(phonePlain.length() - 4, phonePlain.length());
        String start = starters[phonePlain.length() - 10];
        return start + "***-***-" + lastFour;
    }

    public static void main(String[] args) {
        String s = "+(501321)-50-23431";

        System.out.println(s);
    }
}

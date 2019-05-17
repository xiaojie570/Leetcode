package leetcode.string.math;

/**
 * Created by lenovo on 2019/5/17.
 * 复数相乘
 */
public class _537_Complex_Number_Multiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] i1 = a.split("\\+");

        String[] ii1 = a.split("\\+")[1].split("i");
        String[] i2 = b.split("\\+");
        String[] ii2 = b.split("\\+")[1].split("i");

        int eqq1 = Integer.parseInt(i1[0]) * Integer.parseInt(i2[0]);
        int eqq2 = Integer.parseInt(i1[0]) * Integer.parseInt(ii2[0]);
        int eqq3 = Integer.parseInt(ii1[0]) * Integer.parseInt(i2[0]);
        int eqq4 = Integer.parseInt(ii1[0]) * Integer.parseInt(ii2[0]);

        int sum = eqq1 - eqq4;
        int e = eqq2 + eqq3;
        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        sb.append('+');
        sb.append(e);
        sb.append("i");
        return sb.toString();
    }

    public static void main(String[] args) {
        _537_Complex_Number_Multiplication test = new _537_Complex_Number_Multiplication();
        String a = "1+1i";
        String b = "1+1i";
        test.complexNumberMultiply(a,b);
    }
}

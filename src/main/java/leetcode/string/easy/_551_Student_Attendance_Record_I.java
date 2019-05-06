package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/6.
 *  Student Attendance Record I
 *  给定一个字符串，包含三类字符：A、L、P，如果超过2个A或者连续有三个以上的L出现那么就返回false，否则返回true
 *  【解题思路】
 *        使用两个变量来记录 L 和 A字符出现的次数，如果超过给定的次数就返回false
 */
public class _551_Student_Attendance_Record_I {
    public boolean checkRecord(String s) {
        int length = s.length();
        int l = 0, a = 0;
        for(int i = 0; i < length; i++) {
            if(s.charAt(i) == 'L') {
                l++;
                if (l == 3)
                    return false;
            }
            else{
                l = 0;
            }
            if(s.charAt(i) == 'A') {
                a ++;
                if(a == 2)
                    return false;
            }
        }
        return true;
    }
}

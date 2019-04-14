package leetcode.string.medium;

/**
 * Created by lenovo on 2019/4/14.
 * 判断给定的IP地址是否是有效的IP地址。
 * IP地址分为两类：IPV4 和 IPV6，其中IPV4分割符为"."，IPV5的分割符为" :"
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Input: "256.256.256.256"
 * Output: "Neither"
 */
public class _468_Validate_IP_Address {
    public String validIPAddress(String IP) {
        if ("".equals(IP)) {return "Neither";} // 如果给定的IP是空串，就不是有效的
        if (IP.contains(".")) {return validIPv4(IP);}  // 如果字符串中包含的是“.”则判断其是否符合IPV4的规则
        else if (IP.contains(":")) {return validIPv6(IP);} // 如果字符串中包含的是“：”则判断其是否符合IPV6的规则
        else return "Neither";
    }

    public String validIPv4(String IP) {
        if (IP.charAt(IP.length()-1) == '.' || IP.charAt(0) == '.') // 如果第一个元素或者最后一个元素是"."，那么这个是无效的
            return "Neither";
        String[] str = IP.split("\\."); // 使用“.” 来对IP地址进行分割，将分割的数据放到str字符串数组中
        if (str.length != 4)  // 因为IP应该是4段的，所以如果str的长度不等于4，则这个是无效的
            return "Neither";
        int substr;
        char ch;
        for (int i = 0; i < str.length; i++) {
            if(str[i].length() > 3 || "".equals(str[i]))  // 因为IP的某一段长度应该小于等于3，所以如果长度大于3，则该IP是无效的
                return "Neither";
            if(str[i].length()>1 && str[i].charAt(0) == '0') // 如果某一段的IP长度大于1的话，那该IP的这一段的第一个字符不应该为 0
                return "Neither";
            for(int j = 0; j < str[i].length(); j++) { // 然后判断每一个段的每一个字符，每个字符应该满足是 0 - 9 的字符
                ch = str[i].charAt(j);
                if ((ch>='0' && ch<='9')) continue;
                return "Neither";
            }
            substr = Integer.parseInt(str[i]);  // 同时每一段字符的大小应该在 0-255 之间
            if (!(substr >= 0 && substr < 256))
                return "Neither";
        }
        return "IPv4";
    }

    public String validIPv6(String IP) {
        IP = IP.toLowerCase();
        if (IP.charAt(IP.length()-1)==':' || IP.charAt(0) == ':')
            return "Neither";
        String[] str = IP.split(":");
        if (str.length != 8)  // IPV6应该有8段
            return "Neither";
        char ch;
        for (int i = 0; i < str.length; i++) {
            if(str[i].length() > 4 || "".equals(str[i])) // 每一段的长度应该小于等于4
                return "Neither";
            for(int j = 0; j < str[i].length(); j++) {
                ch = str[i].charAt(j);
                if ((ch>='a' && ch<='f') || (ch>='0' && ch<='9')) continue;
                return "Neither";
            }
        }
        return "IPv6";
    }
}

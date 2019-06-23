package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/6.
 * 给定一个字符串，转换为 Goat_Latin 格式，转换的规则如下：
 *  1. 如果单词以元音开头，直接在单词后面添加 ma 即可
 *  2. 如果单词不以元音开头，先将第一个字母移到单词后面，添加 ma
 *  3. 从第一个单词开始，每个单词都加上若干个 a 的后缀。第一个单词加 "a"， 第二个单词加 “aa”，以此类推。
 *  【解题思路】
 *          注意，最后多出的一个空格，使用 trim 去掉即可。
 *          判断是否是 元音字母，使用一个字符串即可
 *
 *         CSDN: https://blog.csdn.net/xiaojie_570/article/details/93396934
 */
public class _824_Goat_Latin {
    public String toGoatLatin(String S) {
        String[] a=S.split(" ");
        String vowels="aeiouAEIOU";
        StringBuilder res=new StringBuilder();
        for(int i=0;i<a.length;i++){
            char[] arr=a[i].toCharArray();
            StringBuilder str=new StringBuilder();
            for(int j=0;j<=i;j++){
                str.append("a");
            }
            if(vowels.indexOf(arr[0])!=-1) res.append(a[i]+"ma"+str.toString()+" ");
            else
                res.append(new StringBuilder(a[i]).delete(0,1).toString()+arr[0]+"ma"+str.toString()+" ");
        }
        return res.toString().trim();
    }
}

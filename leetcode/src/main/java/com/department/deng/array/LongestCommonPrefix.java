package com.department.deng.array;

/**
 * Created by deng on 19-4-11.
 * 最长公共前缀
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    /**
     * 二分查找法
     * <p>
     * 这个想法是应用二分查找法找到所有字符串的公共前缀的最大长度 L。 算法的查找区
     * 间是 (0 \ldots minLen)(0…minLen)，其中 minLen 是输入数据中最短的字符串的长度，
     * 同时也是答案的最长可能长度。
     * 每一次将查找区间一分为二，然后丢弃一定不包含最终答案的那一个。算法进行的过程中一共会出现两种可能情况：
     * <p>
     * S[1...mid] 不是所有串的公共前缀。 这表明对于所有的 j > i S[1..j] 也不是公共前缀，
     * 于是我们就可以丢弃后半个查找区间。
     * <p>
     * S[1...mid] 是所有串的公共前缀。 这表示对于所有的 i < j S[1..i] 都是可行的公共前缀，
     * 因为我们要找最长的公共前缀，所以我们可以把前半个查找区间丢弃。
     */

    public String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        //最终跳出while循环的时候，low=hight+1，或者是high=low-1,最终相加除以2都能拿到正确的边界值
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

}

package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/2 15:54
 * desc   : 字符串转换整数 (atoi) https://leetcode.cn/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        List<Integer> integerPart = new ArrayList<>();
        List<Integer> decimalPart = new ArrayList<>();
        boolean isDecimalPart = false;
        int signStatus = 0;
        boolean isRealNumber = false;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == ' ') {
                if (signStatus != 0) {
                    break;
                }
            } else if (charAt >= '0' && charAt <= '9') {
                if (signStatus == 0) {
                    signStatus = 1;
                }
                if (isDecimalPart) {
                    decimalPart.add(charAt - '0');
                } else {
                    if (charAt == '0' && !isRealNumber) {
                        continue;
                    }
                    isRealNumber = true;
                    integerPart.add(charAt - '0');
                    if (integerPart.size() > 10) {
                        return signStatus == -1 ? -2147483648 : 2147483647;
                    }
                }
            } else if ((charAt == '-' || charAt == '+') && signStatus == 0) {
                signStatus = (charAt == '-' ? -1 : 1);
            } else if (charAt == '.') {
                isDecimalPart = true;
            } else {
                break;
            }
        }
        if (integerPart.size() == 10) {
            String compareMaxNum = "214748364";
            for (int i = 0; i < integerPart.size(); i++) {
                Integer integer = integerPart.get(i);
                if (i == integerPart.size() - 1) {
                    if (signStatus == -1 && integer > 8) {
                        return -2147483648;
                    } else if (signStatus == 1 && integer > 7) {
                        return 2147483647;
                    }
                } else {
                    if (integer > compareMaxNum.charAt(i) - '0') {
                        return signStatus == -1 ? -2147483648 : 2147483647;
                    } else if (integer < compareMaxNum.charAt(i) - '0') {
                        break;
                    }
                }
            }
        }
        int result = 0;
        int pow = 1;
        for (int i = integerPart.size() - 1; i >= 0; i--) {
            result += integerPart.get(i) * pow;
            pow *= 10;
        }
        return result * signStatus;
    }

    public static void main(String[] args) {
//        System.out.println("result = " + new StringToIntegerAtoi().myAtoi("4193 with words"));
//        System.out.println("result = " + new StringToIntegerAtoi().myAtoi("aa --+42.22 ppa"));
//        System.out.println("result = " + new StringToIntegerAtoi().myAtoi("91283472332"));
        System.out.println("result = " + new StringToIntegerAtoi().myAtoi("1095502006p8"));
    }

}

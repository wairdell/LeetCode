package com.wairdell.leetcode.exapmle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * date   : 2023/12/1 10:32
 * desc   :
 */
public class Myers {

    public static void main(String[] args) {
        Myers myers = new Myers();
        myers.myers("ABCABBA", "CBABAC");
    }

    void myers(String stra, String strb) {
        int n = stra.length();
        int m = strb.length();

        Map<Integer, Integer> v = new HashMap<>();
        v.put(1, 0);

        Map<Integer, Map<Integer, Integer>> vs = new HashMap<>();
        Map<Integer, Integer> temp = new HashMap<>();
        temp.put(1, 0);
        vs.put(0, temp);

        loop:
        for (int d = 0; d <= n + m; d++) {
            Map<Integer, Integer> tmp = new HashMap<>();
            for (int k = -d; k <= d; k += 2) {
                boolean down = ((k == -d) || ((k != d) && v.get(k + 1) > v.get(k - 1)));
                int kPrev = down ? k + 1 : k - 1;
                int xStart = v.get(kPrev);
                int yStart = xStart - kPrev;
                int xMid = down ? xStart : xStart + 1;
                int yMid = xMid - k;
                int xEnd = xMid;
                int yEnd = yMid;
                while (xEnd < n && yEnd < m && stra.charAt(xEnd) == strb.charAt(yEnd)) {
                    xEnd++;
                    yEnd++;
                }
                v.put(k, xEnd);
                tmp.put(k, xEnd);

                if (xEnd == n && yEnd == m) {
                    vs.put(d, tmp);
                    Stack<int[]> snakes = solution(vs, n, m, d);
                    printRes(snakes, stra, strb);
                    break loop;
                }
            }
            vs.put(d, tmp);
        }

    }

    Stack<int[]> solution(Map<Integer, Map<Integer, Integer>> vs, int n, int m, int d) {
        Stack<int[]> snakes = new Stack<>();

        Map<String, Integer> p = new HashMap<>();
        p.put("x", n);
        p.put("y", m);
        for (; d > 0; d--) {
            Map<Integer, Integer> v = vs.get(d);
            Map<Integer, Integer> vPrev = vs.get(d - 1);
            int k = p.get("x") - p.get("y");

            int xEnd = v.get(k);
            int yEnd = xEnd - k;

            boolean down = ((k == -d) || ((k != d) && (vPrev.get(k + 1) > vPrev.get(k - 1))));
            int kPrev = down ? k + 1 : k - 1;
            int xStart = vPrev.get(kPrev);
            int yStart = xStart - kPrev;
            int xMid = down ? xStart : xStart + 1;
            int yMid = xMid - k;

            snakes.add(0, new int[]{xStart, xMid, xEnd});

            p.put("x", xStart);
            p.put("y", yStart);
        }
        return snakes;
    }

    void printRes(Stack<int[]> snakes, String stra, String strb) {
        String consoleStr = "";
        int yOffset = 0;

        for (int index = 0; index < snakes.size(); index++) {
            int[] snake = snakes.get(index);
            int s = snake[0];
            int m = snake[1];
            int e = snake[2];
            if (index == 0 && s != 0) {
                for (int j = 0; j < s; j++) {
                    consoleStr += stra.charAt(j) + " ";
                    yOffset++;
                }
            }

            if (m - s == 1) {
                consoleStr += "D[" + stra.charAt(s) + "] ";
            } else {
                consoleStr += "A[" + strb.charAt(yOffset) + "] ";
                yOffset++;
            }

            for (int i = 0; i < e - m; i++) {
                consoleStr += stra.charAt(m + i) + " ";
                yOffset++;
            }
        }
        System.out.println(consoleStr);


    }

}

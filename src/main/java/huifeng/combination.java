package huifeng;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class combination {
    static String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static String[] combination1(int[] arr) {
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] <= 1)
                continue;
            if (!queue.isEmpty()) {
                int curLen = queue.size();
                while (curLen > 0) {
                    String head = queue.poll();
                    for (int j = 0; j < dict[arr[i] - 2].length(); ++j) {
                        queue.add(head + dict[arr[i] - 2].charAt(j));
                    }
                    --curLen;
                }
            } else {
                for (int j = 0; j < dict[arr[i] - 2].length(); ++j) {
                    queue.add(String.valueOf(dict[arr[i] - 2].charAt(j)));
                }
            }
        }
        return queue.toArray(new String[queue.size()]);
    }

    public static String[] combination2(int[] arr) {
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; ++i) {
            int[] digitArr = {arr[i] / 10, arr[i] % 10};
            for (int digit : digitArr) {
                if (digit <= 1)
                    continue;
                if (!queue.isEmpty()) {
                    int curLen = queue.size();
                    while (curLen > 0) {
                        String head = queue.poll();
                        for (int j = 0; j < dict[digit - 2].length(); ++j) {
                            queue.add(head + dict[digit - 2].charAt(j));
                        }
                        --curLen;
                    }
                } else {
                    for (int j = 0; j < dict[digit - 2].length(); ++j) {
                        queue.add(String.valueOf(dict[digit - 2].charAt(j)));
                    }
                }
            }
        }
        return queue.toArray(new String[queue.size()]);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
//        System.out.println(Arrays.toString(combination1(arr)));
        int[] arr2 = {2,3,4,5};
        System.out.println(Arrays.toString(combination2(arr2)));
    }
}

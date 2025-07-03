package algorithm.test.baekjoon.solved.No2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i <N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int ans1 = Math.round((float) sum / N);

        Arrays.sort(arr);

        int ans2 = arr[N / 2];

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (int num : arr) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        List<Integer> modes = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                modes.add(key);
            }
        }
        Collections.sort(modes);
        int ans3 = (modes.size() > 1) ? modes.get(1) : modes.get(0);

        int ans4 = arr[N - 1] - arr[0];

        sb.append(ans1).append("\n").append(ans2).append("\n").append(ans3).append("\n").append(ans4).append("\n");

        System.out.println(sb);
    }
}
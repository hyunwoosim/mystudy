package algorithm.test.baekjoon.solved.No2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mergeSort {
    static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];

        for(int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N-1);

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
    public static void mergeSort(int left, int right) {
        if(left >= right) return;

        int mid =  (left + right) / 2;
        System.out.println("1. mid = " + mid);

        mergeSort(left, mid);
        mergeSort(mid +1, right);

        merge(left, mid, right);
    }
    public static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        System.out.println(" 2.i = " + i + "j = " + j+ "k = " + k);

        while(i <= mid && j <= right) {
            System.out.println("3. i = " + i);
            System.out.println("3. j = " + j);
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid) {
            System.out.println("4. i = " + i);
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            System.out.println("5. j = " + j);
            temp[k++] = arr[j++];
        }

        for (int l = left; l <=right; l++) {
            System.out.println("6. l = " + l);
            arr[l] = temp[l];
         }
    }
}
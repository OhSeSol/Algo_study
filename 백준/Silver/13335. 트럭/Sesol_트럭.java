import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> trucks = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 1;
        Queue<Integer[]> q = new ArrayDeque<>();
        int cur = trucks.peek();
        q.offer(new Integer[]{trucks.poll(), 1});
        while (!trucks.isEmpty() || !q.isEmpty()) {
            time++;
            for (Integer[] arr : q) {
                arr[1]++;
            }
            if (q.peek()[1] > w) {
                cur -= q.poll()[0];
            }
            if (!trucks.isEmpty() && cur + trucks.peek() <= l) {
                cur += trucks.peek();
                q.offer(new Integer[]{trucks.poll(), 1});
            }
        }
        System.out.println(time);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class uva_10190{

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer("");
        String m = "";
        while ((m = br.readLine()) != null) {
            String[] str = m.split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int[] list = getBoo(x, y);
            if (list.length == 0) {
                sb.append("Boring!\n");
            } else {
                for (int i = 0; i < list.length; i++) {
                    if (i > 0) {
                        sb.append(" ");
                    }
                    sb.append(list[i]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    static int[] getBoo(int x, int m) {
        if(x<=1 || m<=1)
            return new int[0];
        LinkedList<Integer> list = new LinkedList<Integer>();
        boolean flag = true;
        int temp = x;
        while (temp > 1) {
            list.add(temp);
            if (temp % m == 0) {
                temp /= m;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            list.add(1);
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        } else {
            return new int[0];
        }
    }
}
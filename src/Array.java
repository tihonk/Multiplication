import java.util.ArrayList;
import java.util.Scanner;

public class Array {
    private static int k;
    private static int m;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String stringOne = scn.nextLine();
        String stringTwo = scn.nextLine();

        String[]numbersOne = stringOne.split("\\s");
        String[]numbersTwo = stringTwo.split("\\s");

        int n = Short.parseShort(numbersOne[0]);
        m = Short.parseShort(numbersOne[1]);
        k = Short.parseShort(numbersOne[2]);

        final long [] A = new long[n];
        for (int i = 0; i<n; i++){
            A[i]= Long.parseLong(numbersTwo[i]);
        }


        int mask = 0;
        int limit = 1 << A.length;
        while (mask < limit) {
            boolean x = printPermutation(mask, A);
            if (x){
                break;
            } else {
                mask++;}
        }
    }

    private static boolean printPermutation(int mask, long[] array) {
        boolean b = false;
        long x = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if ((mask & (1 << i)) != 0 || mask == k) {
                x = x*array[i];
                arr.add(i);
            }
        }
        if(x==m && arr.size()== k) {
            StringBuilder builder = new StringBuilder();
            for (Integer value : arr) {
                builder.append(1+value).append(" ");
            }
            String result = builder.toString();
            System.out.println(result);
            b = true;
        }
        return b;
    }
}
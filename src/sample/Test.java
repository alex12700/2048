package sample;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Алексаелп on 18.03.2017.
 */
public class Test {
    private static void pause(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        int x[][] = new int[4][4];
        int t[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                x[i][j] = 0;
                t[i][j] = x[i][j];
            }
        }
//        Arrays.fill(t,9);
//        Arrays.fill(x,9);
        System.out.println(Arrays.equals(t,x));
        int[][] a1 = new int[10][4];
        int[][] a2 = new int[10][4];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                a1[i][j] = 9;
                a2[i][j] = a1[i][j];
            }
        }

        int[] q = new int[4];
        int[] w = new int[4];
        for (int i = 0; i < 4; i++) {
            q[i] = 0;
            w[i] = 0;
        }
        System.out.println(Arrays.equals(q,w));
        System.out.println(q[2] == w[2]);
// заполняем их девятками
//        Arrays.fill(a1, 9);
//        Arrays.fill(a2, 9);
//        System.out.println("Сравним: " + Arrays.equals(a1, a2));

        Random rand = new Random();


        int amount_start = 0;
        while (amount_start < 16) {
            int two_start = rand.nextBoolean() ? 2 : 4;
            int start_positionX = rand.nextInt(4);
            int start_positionY = rand.nextInt(4);
            if (x[start_positionX][start_positionY] == 0) {
                x[start_positionX][start_positionY] = two_start;
                amount_start++;
            }
        }


        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();

        pause(1);

        for (int j = 0; j < 4; j++) {
            for (int i = 3; i >= 0; i--) {
                for (int k = i - 1; k >= 0; k--) {
                    if (x[k][j] != 0) {
                        if (x[i][j] == 0) {
                            x[i][j] = x[k][j];
                            x[k][j] = 0;
                        } else {
                            if (x[i][j] == x[k][j]) {
                                x[i][j] += x[k][j];
                                x[k][j] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

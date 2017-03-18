package sample;

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
            for (int i = 0; i < 4; i++) {
                for (int k = i + 1; k < 4; k++) {
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
    }
}

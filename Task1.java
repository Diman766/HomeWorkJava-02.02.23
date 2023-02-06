import java.util.LinkedList;
import java.util.Queue;

public class Task1 {

    public static void main(String[] args) {
        int[][] labirint = new int[11][11];
        for (int i = 0; i < labirint[0].length; i++) {
            labirint[0][i] = -1;
            labirint[10][i] = -1;
        }
        for (int j = 0; j < labirint.length; j++) {
            labirint[j][0] = -1;
            labirint[j][10] = -1;
        }
        labirint[1][4] = -1;
        labirint[2][4] = -1;
        int x = 1;
        int y = 1;
        labirint[x][y] = 1;
        print(labirint);

        Queue<Integer> queueOfNext = new LinkedList<Integer>();
        queueOfNext.add(x * 10 + y);
        while (queueOfNext.size() > 0) {
            int z = queueOfNext.remove();
            x = z / 10;
            y = z % 10;
            if (labirint[x - 1][y] == 0) {
                queueOfNext.add((x - 1) * 10 + y);
                labirint[x - 1][y] = labirint[x][y] + 1;
            }
            if (labirint[x][y + 1] == 0) {
                queueOfNext.add(x * 10 + y + 1);
                labirint[x][y + 1] = labirint[x][y] + 1;
            }
            if (labirint[x + 1][y] == 0) {
                queueOfNext.add((x + 1) * 10 + y);
                labirint[x + 1][y] = labirint[x][y] + 1;
            }
            if (labirint[x][y - 1] == 0) {
                queueOfNext.add(x * 10 + y - 1);
                labirint[x][y - 1] = labirint[x][y] + 1;
            }
        }
        print(labirint);

        x = 7;
        y = 9;
        while (labirint[x][y] > 1){
            if (labirint[x][y] == labirint[x - 1][y] + 1) {
                labirint[x][y] = -2;
                x = x - 1;
            } 
            else if (labirint[x][y] == labirint[x][y + 1] + 1) {
                labirint[x][y] = -2;
                y = y + 1;
            } 
            else if (labirint[x][y] == labirint[x + 1][y] + 1) {
                labirint[x][y] = -2;
                x = x + 1;
            } 
            else if (labirint[x][y] == labirint[x][y - 1] + 1) {
                labirint[x][y] = -2;
                y = y - 1;
            }
             
        }
        labirint[x][y] = -2;
        print(labirint);
    }

    public static void print(int[][] puzzle) {
        for (int[] row : puzzle) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
        System.out.println();
    }


}

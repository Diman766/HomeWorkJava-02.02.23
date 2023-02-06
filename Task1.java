import java.util.LinkedList;
import java.util.Queue;
// import java.util.ArrayList;
// import java.util.Arrays;

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
        // labirint[1][4] = -1;
        // labirint[2][4] = -1;
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
        // labirint[x][y] = -2;
        while (labirint[x][y] > 1){
            if (labirint[x][y] == labirint[x - 1][y] - 1) {
                labirint[x][y] = -2;
                x = x - 1;
                print(labirint);
            } 
            if (labirint[x][y] == labirint[x][y + 1] - 1) {
                labirint[x][y] = -2;
                y = y + 1;
                print(labirint);
            } 
            if (labirint[x][y] == labirint[x + 1][y] - 1) {
                labirint[x][y] = -2;
                x = x + 1;
                print(labirint);
            } 
            if (labirint[x][y] == labirint[x][y - 1] - 1) {
                labirint[x][y] = -2;
                y = y - 1;
                print(labirint);
            }
            
            // if (labirint[x][y] == labirint[x - 1][y] - 1) {
            //     labirint[x][y] = -2;
            //     x = x - 1;
            //     print(labirint);
            // } else if (labirint[x][y] == labirint[x][y + 1] - 1) {
            //     labirint[x][y] = -2;
            //     y = y + 1;
            //     print(labirint);
            // } else if (labirint[x][y] == labirint[x + 1][y] - 1) {
            //     labirint[x][y] = -2;
            //     x = x + 1;
            //     print(labirint);
            // } else if (labirint[x][y] == labirint[x][y - 1] - 1) {
            //     labirint[x][y] = -2;
            //     y = y - 1;
            //     print(labirint);
            // }  
        }
        // print(labirint);
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

    // public static String str(int x, int y) {
    // String str = Integer.toString(x);
    // str += Integer.toString(x);
    // return str;
    // }

    // public static int[] coordinates(String str) {
    // int[] x = new int[2];
    // x[0] = (Integer.parseInt(str) / 10);
    // x[1] = (Integer.parseInt(str) % 10);
    // return x;
    // }

    // public void findPath(int x,int y) {
    // ArrayList<Pair<Integer,Integer>> queue = new ArrayList<>();
    // queue.add(new Pair<Integer,Integer>());
    // int[][] mas;
    // mas[x][y] = 1;
    // while (queue.size() > 0) {
    // Pair<Integer,Integer> cur = queue.remove(queue.size() - 1);
    // int x = cur.x;
    // int y = cur.y;
    // //
    // if (x < width - 1 && mas[x + 1][y] == 0) {
    // queue.add(new Pair<Integer,Integer>(x+1, y);
    // mas[x+1][y] = 1;
    // }
    // if (x > 0 && mas[x - 1][y] == 0) {
    // queue.add(new Pair<Integer,Integer>(x-1,y);
    // mas[x-1][y] = 1;
    // }
    // if (y < height - 1 && mas[x][y+1] == 0) {
    // queue.add(new Pair<Integer,Integer>(x, y + 1);
    // mas[x][y+1] = 1;
    // }
    // if (y > 0 && mas[x][y-1] == 0) {
    // queue.add(new Pair<Integer,Integer>(x, y - 1);
    // mas[x][y-1] = 1;
    // }
    // //
    // }
    // }

}

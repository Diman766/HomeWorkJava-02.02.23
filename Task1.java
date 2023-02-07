import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        
        int [][] lab = reader();
        // int[][] labirint = new int[11][11];
        // for (int i = 0; i < labirint[0].length; i++) {
        //     labirint[0][i] = -1;
        //     labirint[10][i] = -1;
        // }
        // for (int j = 0; j < labirint.length; j++) {
        //     labirint[j][0] = -1;
        //     labirint[j][10] = -1;
        // }
        // labirint[1][4] = -1;
        // labirint[2][4] = -1;
        // int x = 1;
        // int y = 1;
        // labirint[x][y] = 1;
        // print(labirint);
        int[] cat = new int [2];
        for (int i=0; i<lab.length; i++){
          for (int j=0; j<lab[0].length; j++){
              if (lab[i][j] == 1){
                cat[0] = i;
                cat[1] = j;
                // lab[i][j] = 0;
               }
            }
        }
        System.out.println(cat[0]);
        System.out.println(cat[1]);

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<lab.length; i++){
            for (int j=0; j<lab[0].length; j++){
                if (lab[i][j] == -2){
                  list.add(i);
                  list.add(j);
                  lab[i][j] = 0;
                }
            }
        }
        // System.out.println(list);
        // print(lab);
        // System.out.println(lab[0].length);

        Queue<Integer> queueOfNext = new LinkedList<Integer>();
        int rows = lab[0].length;
        // int colomns = lab[0].length;
        queueOfNext.add(cat[0] * rows + cat[1]);
        while (queueOfNext.size() > 0) {
            int z = queueOfNext.remove();
            int x = z / rows;
            // System.out.println(rows);
            // System.out.print(x);
            int y = z % rows;
            // System.out.println(y);

            if (lab[x - 1][y] == 0) {
                queueOfNext.add((x - 1) * rows + y);
                lab[x - 1][y] = lab[x][y] + 1;
                // print(lab);
            }
            if (lab[x][y + 1] == 0) {
                queueOfNext.add(x * rows + y + 1);
                lab[x][y + 1] = lab[x][y] + 1;
                // print(lab);
            }
            if (lab[x + 1][y] == 0) {
                queueOfNext.add((x + 1) * rows + y);
                lab[x + 1][y] = lab[x][y] + 1;
                // print(lab);
            }
            if (lab[x][y - 1] == 0) {
                queueOfNext.add(x * rows + y - 1);
                lab[x][y - 1] = lab[x][y] + 1;
                // print(lab);
            }
        }
        print(lab);
        System.out.println(list);
        int x = list.get(0);
        int y = list.get(0);

        while (lab[x][y] > 1){
            if (lab[x][y] == lab[x - 1][y] + 1) {
                lab[x][y] = -2;
                x = x - 1;
            } 
            else if (lab[x][y] == lab[x][y + 1] + 1) {
                lab[x][y] = -2;
                y = y + 1;
            } 
            else if (lab[x][y] == lab[x + 1][y] + 1) {
                lab[x][y] = -2;
                x = x + 1;
            } 
            else if (lab[x][y] == lab[x][y - 1] + 1) {
                lab[x][y] = -2;
                y = y - 1;
            }
             
        }
        lab[x][y] = -2;
        print(lab);
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

    public static int[][] reader() {
        List<Integer> list = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        int a = 0;
        String temp;

        do {
            System.out.print("Введите размер лабиринта по горизонтали  ");
            temp = console.next();
            a = tryParseInt(temp);
        } while (a <= 0);
        list.add(a);

        do {
            System.out.print("Введите размер лабиринта по вертикали  ");
            temp = console.next();
            a = tryParseInt(temp);
        } while (a <= 0);
        list.add(a);

        int[][] labirint = new int[list.get(1) + 2][list.get(0) + 2];
        for (int i = 0; i < labirint[0].length; i++) {
            labirint[0][i] = -1;
            labirint[list.get(1) + 1][i] = -1;
        }
        for (int j = 0; j < labirint.length; j++) {
            labirint[j][0] = -1;
            labirint[j][list.get(0) + 1] = -1;
        }

        print(labirint);

        do {
            System.out.print("Введите координату по горизонтали котика  ");
            temp = console.next();
            a = tryParseInt(temp);
        } while (a <= 0 || a > list.get(0));
        list.add(a - 1);

        do {
            System.out.print("Введите координату по вертикали котика  ");
            temp = console.next();
            a = tryParseInt(temp);
        } while (a <= 0 || a > list.get(1));
        list.add(a - 1);
        labirint[list.get(3) + 1][list.get(2) + 1] = 1;
        print(labirint);

        do {
            System.out.print("Стены нужны ? 1 - НЕТ , 2 - ДА  ");
            temp = console.next();
            a = tryParseInt(temp);
        } while (a <= 0 || a > 3);
        list.add(a);

        if (list.get(4) == 2) {
            do {
                System.out.print("Введите количество сегментов стен  ");
                temp = console.next();
                a = tryParseInt(temp);
            } while (a <= 0 || a >= list.get(0) * list.get(1));
            list.set(4, a);

            while (list.get(4) > 0) {
                do {
                    System.out.print("Введите координату по горизонтали ячейки стены  ");
                    temp = console.next();
                    a = tryParseInt(temp);
                } while (a <= 0 || a > list.get(0));
                list.add(a);
                int x = a;

                do {
                    System.out.print("Введите координату по вертикали ячейки стены  ");
                    temp = console.next();
                    a = tryParseInt(temp);
                } while (a <= 0 || a > list.get(1));
                list.add(a );
                int y = a;
                list.set(4, list.get(4) - 1);
                labirint[y][x] = -1;
                print(labirint);
            }
        }

            
        

        do {
            System.out.print("Введите количество выходов  ");
            temp = console.next();
            a = tryParseInt(temp);
        } while (a <= 0 || a >= list.get(0) * list.get(1));
        list.set(4, a);

        while (list.get(4) > 0) {
            do {
                System.out.print("Введите координату по горизонтали ячейки выхода  ");
                temp = console.next();
                a = tryParseInt(temp);
            } while (a <= 0 || a > list.get(0));
            list.add(a);
            int x = a;

            do {
                System.out.print("Введите координату по вертикали ячейки выхода  ");
                temp = console.next();
                a = tryParseInt(temp);
            } while (a <= 0 || a > list.get(1));
            list.add(a );
            int y = a;
            list.set(4, list.get(4) - 1);
            labirint[y][x] = -2;
            print(labirint);
        }

        console.close();
        return labirint;

    }


    public static Integer tryParseInt(String temp) {
        try {
            return Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

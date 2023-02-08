import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        int[][] lab = reader();
        int[] cat = new int[2];
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if (lab[i][j] == 1) {
                    cat[0] = i;
                    cat[1] = j;
                }
            }
        }
        // System.out.println(cat[0]);
        // System.out.println(cat[1]);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if (lab[i][j] == -2) {
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
        queueOfNext.add(cat[0] * rows + cat[1]);
        while (queueOfNext.size() > 0) {
            int z = queueOfNext.remove();
            int x = z / rows;
            int y = z % rows;

            if (lab[x - 1][y] == 0) {
                queueOfNext.add((x - 1) * rows + y);
                lab[x - 1][y] = lab[x][y] + 1;
            }
            if (lab[x][y + 1] == 0) {
                queueOfNext.add(x * rows + y + 1);
                lab[x][y + 1] = lab[x][y] + 1;
            }
            if (lab[x + 1][y] == 0) {
                queueOfNext.add((x + 1) * rows + y);
                lab[x + 1][y] = lab[x][y] + 1;
            }
            if (lab[x][y - 1] == 0) {
                queueOfNext.add(x * rows + y - 1);
                lab[x][y - 1] = lab[x][y] + 1;
            }

        }
        print(drawWay(findShortWay(list, lab), lab));
    }

    public static int[][] drawWay(List<Integer> wayList, int[][] lab) {
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if(lab[i][j] != -1){
                    lab[i][j] = 0; 
                }
            }
            
        }
        for (int i = 0; i < wayList.size(); i += 2) {
            lab[wayList.get(i)][wayList.get(i + 1)] = -2;
        }
        return lab;
    }

    public static List<Integer> findShortWay(List<Integer> wayList, int[][] lab) {
        if (wayList.size() == 2) {

            return findWay(lab, wayList.get(0), wayList.get(1));
        } else {
            List<Integer> way1 = new ArrayList<>();
            List<Integer> way2 = new ArrayList<>();
            way1 = findWay(lab, wayList.get(0), wayList.get(1));

            for (int i = 2; i < wayList.size(); i += 2) {
                way2 = findWay(lab, wayList.get(i), wayList.get(i + 1));
                if (way1.size() > way2.size()) {
                    way1 = way2;
                }
            }
            return way1;
        }

    }

    public static List<Integer> findWay(int[][] lab, int x, int y) {

        List<Integer> way = new ArrayList<>();

        while (lab[x][y] != 1) {
            if (lab[x][y] == lab[x - 1][y] + 1) {
                way.add(x);
                way.add(y);
                x = x - 1;
            } else if (lab[x][y] == lab[x][y + 1] + 1) {
                way.add(x);
                way.add(y);
                y = y + 1;
            } else if (lab[x][y] == lab[x + 1][y] + 1) {
                way.add(x);
                way.add(y);
                x = x + 1;
            } else if (lab[x][y] == lab[x][y - 1] + 1) {
                way.add(x);
                way.add(y);
                y = y - 1;
            }
            
        }
        way.add(x);
        way.add(y);
       
        return way;
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
                list.add(a);
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
            list.add(a);
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

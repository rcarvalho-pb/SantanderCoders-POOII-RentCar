package util;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUIHelper {

    public static String askSimpleInput(String message) {
        System.out.printf("%s%n# : ", message);
        return new Scanner(System.in).nextLine().trim();
    }

    public static int askID(List<?> lista) {
        if (lista.isEmpty())
            return -1;
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s%n# : ", "Digite o Id");
        int choose;
        do {
            try {
                choose = sc.nextInt();
            } catch (InputMismatchException e) {
                choose = -9;
                sc.nextLine();
            }
        } while (choose < 0 || choose >= lista.size());
        return choose;
    }

    public static int printChooseOption(String message, String... options){
        System.out.printf("%s%n# : ", message);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d - %s%n# : ", i, options[i]);
        }
        return options.length;
    }

    public static int chooseOption(int length) {
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            try {
                choose = sc.nextInt();
            } catch (InputMismatchException e) {
                choose = -9;
                sc.nextLine();
                System.out.println("\nOpção inválida\n");
            }
        } while (choose < 0 || choose >= length);
        return choose;
    }

    public static boolean askConfirm(String message, String yes, String no) {
        String[] op = new String[2];
        op[0] = yes;
        op[1] = no;
        printChooseOption(message, yes, no);
        return chooseOption(2) == 0;
    }

    public static BigDecimal askNumber(String message) {
        System.out.printf("%s%n# : ", message);
        Scanner sc = new Scanner(System.in);
        BigDecimal number;
        do {
            try {
                number = sc.nextBigDecimal();
            } catch (InputMismatchException e) {
                number = null;
            }
        } while (number == null);
        return number;
    }

    public static int drawWithRightPadding(String text, int width, char pad) {
        int count = 0;
        do {
            int limit = Math.min(text.length(), width - 4);
            String row = text.substring(0, limit);
            text = text.substring(row.length());
            row = "# " + row + String.valueOf(pad).repeat(width - row.length() - 4) + " #";
            System.out.println(row);
            count++;
        } while (!text.isEmpty());
        return count;
    }

    public static int drawWithPadding(String text, int width) {
        int count = 0;
        do {
            int limit = Math.min(text.length(), width - 4);
            String row = text.substring(0, limit);
            text = text.substring(row.length());
            int padding = (width - row.length()) / 2;
            row = "#" + " ".repeat(padding-1) + row;
            row = row + " ".repeat(width - row.length() - 1) + "#";
            System.out.println(row);
            count++;
        } while (!text.isEmpty());
        return count;
    }

    public static void drawHeader(String title, int width) {
        drawLine(width);
        drawWithPadding(title, width);
        drawLine(width);
    }

    public static void drawLine(int width) {
        System.out.println("#".repeat(width));
    }

    public static void fillVSpace(int lines, int width) {
        drawWithPadding(" ".repeat(lines * width), width);
    }

    public static String columnPaddingLeft(String text, int width, char pad) {
        while(text.length() < width){
            text = String.valueOf(pad).concat(text);
        }
        return text;
    }

    public static String columnPaddingRight(String text, int width, char pad) {
        while(text.length() < width){
            text = text.concat(String.valueOf(pad));
        }
        return text;
    }

}

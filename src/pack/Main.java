package pack;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        IllegalArgumentException exception = new IllegalArgumentException("\nUsage: \"programName function\"\n" +
                "where \"function\" is NumberConvertor|ArraySort|RandomNumbers|KbdInput");
        Main main = new Main();
        if(args.length < 1) throw exception;
        if(args[0].toLowerCase().equals("arraysort"))
            main.ArraySort();
        else if(args[0].toLowerCase().equals("numberconvertor"))
            main.NumberConverter();
        else if(args[0].toLowerCase().equals("randomnumbers")) {
            if(args.length < 4) throw new IllegalArgumentException("\nUsage: \"programName randomNumbers n min max\"");
            try {
                int N = Integer.parseInt(args[1]);
                int min = Integer.parseInt(args[2]);
                int max = Integer.parseInt(args[3]);
                main.RandomNumbers(N, min, max);
            }
            catch (NumberFormatException e) {
                System.err.println("Error: One or more values is not a number");
            }
        }
        else if(args[0].toLowerCase().equals("kbdinput"))
            main.KbdInput();
        else
            throw exception;
    }
    private void KbdInput() {
        char[] array = new char[0];
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("");
        char ch = 0;
        while((ch = sc.next().charAt(0)) != '/'){
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = ch;
        }
        System.out.println(new String(array));
    }
    private void RandomNumbers(int n, int min, int max) {
        int[] array = new int[n];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(min, max);
        }
        System.out.println(Arrays.toString(array));
    }
    private void NumberConverter() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int base = 10, resultBase = 10;
            long argument = 0;

            System.out.println("Enter three numbers separated by a space [InputNumber InputBase OutputBase] > ");
            String input = scanner.next(), inputBase = scanner.next(), outputBase = scanner.next();
            if (input.trim().toLowerCase() == "q") break;
            try {
                base = Integer.parseInt(inputBase, 10);
                resultBase = Integer.parseInt(outputBase);
                argument = Long.parseLong(input, base);
            } catch (NumberFormatException e) {
                System.err.println("Error: One or more values is not a number");
                continue;
            }
            System.out.println(Long.toUnsignedString(argument, resultBase));
        }
    }
    private void ArraySort() {
        int[] array = new int[16];
        for (int i = array.length-1; i >= 0; i--) {
            array[array.length - i - 1] = (int)Math.pow(2, i);
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

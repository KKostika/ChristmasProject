package gr.kiki;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Project01 {

    public static void main(String[] args) throws IOException {
        final int THRESHOLD = 5;
        File inFile = new File("numberPr01.txt");
        File outFile = new File("numbersOutPr01.txt");
        PrintStream ps = new PrintStream(outFile);
        int n = 6;
        int[] row = new int[6];
        Scanner scanner = new Scanner(inFile);

        ArrayList<Integer> numbers = new ArrayList<>();

        while (scanner.hasNextInt()){
            numbers.add(scanner.nextInt());
        }

        for(int i =0; i <= numbers.size() - n; i++) {
            for (int j= i + 1; j <= numbers.size() - n + 1; j++) {
                for (int k = j +1; k <= numbers.size() - n + 2; k++) {
                    for (int m = k + 1; m <= numbers.size() - n + 3; m++) {
                        for (int l = m + 1; l <= numbers.size() - n + 4; l++) {
                            for (int p = l +1; p < numbers.size(); p++) {
                                row[0] = numbers.get(i);
                                row[1] = numbers.get(j);
                                row[2] = numbers.get(k);
                                row[3] = numbers.get(m);
                                row[4] = numbers.get(l);
                                row[5] = numbers.get(p);

                                if (isEven(row, THRESHOLD) && notEven(row, THRESHOLD) && nextInteger(row, 2) && maxThrInt(row, 3) && sameTen(row, 3)) {
                                    ps.printf("%d\t%d\t%d\t%d\t%d\t%d\n",numbers.get(i),numbers.get(j),numbers.get(k),numbers.get(m),numbers.get(l),numbers.get(p));
                                }
                            }
                        }
                    }
                }
            }

        }
        System.out.println("File generated at "+ outFile.getAbsolutePath());
    }

    private static boolean isEven(int[] arr,int num) {
        int count = 0;

        for( int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return (count < num);
    }

    private static boolean notEven(int[] arr, int num) {
        int count = 0;

        for(int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 != 0) {
                count++;
            }
        }
        return (count < num);
    }

    private static boolean nextInteger(int[] arr, int num) {
        int consecutiveCount = 0;

        for (int i = 0; i <= 3; i++) {
            if (arr[i] == arr[i + 1] - 1 && arr[i] == arr[i + 2] - 2) {
                consecutiveCount++;
                break;
            }
        }

        return consecutiveCount >= 1;
    }

    private static boolean maxThrInt(int[] arr, int numb) {
        int[] endings = new int[10];


        for (int num : arr) {
            endings[num % 10]++;
        }

        return Arrays.stream(endings).anyMatch(e -> e <= numb);
    }

    public static boolean sameTen(int[] arr, int threshold) {
        int[] ten = new int[6];

        for (int num : arr) {
            ten[num/10]++;
        }

        return Arrays.stream(ten).anyMatch(t -> t <= threshold);
    }


}




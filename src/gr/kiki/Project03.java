package gr.kiki;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Project03 {

    public static void main(String[] args) {
        String[][] arr = new String[128][2];
        File inFile = new File("latinText.txt");

        try (Scanner scanner = new Scanner(inFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] boa = line.split("");
                boolean found = false;
                int map = 0;

                for (int i = 0; i < boa.length; i++) {
                    found = false;
                    for (int j = 0; j < arr.length; j++) {

                        //System.out.println(boa[i]+" j:"+j+" "+ arr[j][0]);
                        if (boa[i].equals(" ") || boa[i].equals("\n") || boa[i].equals(",") || boa[i].equals(".") || boa[i].equals("\\s*")) {
                            found = true;

                        } else if (boa[i].equals(arr[j][0])) {
                            arr[j][1] = String.valueOf((Integer.parseInt(arr[j][1]) + 1));
                            found = true;

                        } else if (arr[j][0] == null) {
                            map = j;
                            break;
                        }
                    }
                    if (!found) {
                        arr[map][0] = boa[i];
                        arr[map][1] = "1";
                    }
                }
            }
            for (String[] el : arr) {
                if (el[0] == null ) {
                    break;
                }
                System.out.println(el[0] + " " + el[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

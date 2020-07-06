package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static String baseConversion(String number,
                                        int sBase, int dBase) {
        return new BigInteger(number, sBase).toString(dBase);
    }

    public static Boolean stringBaseCheck(String number,
                                       int sBase, int dBase) {
        boolean isProper = true;
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (sBase > 10) {
                if ((int) chars[i] < 48 || ((int) chars[i] > 57 && (int) chars[i] < 65)
                        || (int) Character.toUpperCase(chars[i]) > 54 + sBase) {
                    isProper = false;
                    break;
                }
            } else {
                if ((int) chars[i] < 48 || ((int) chars[i] > 57 && (int) chars[i] < 65)
                        || (int) Character.toUpperCase(chars[i]) > 47 + sBase) {
                    isProper = false;
                    break;
                }
            }
        }
        return isProper;
    }


    public static <e> void main(String[] args) {
        String awnser = "";
        do {
            Scanner in = new Scanner(System.in);
            int sBase = 0;
            int dBase = 0;
            System.out.println("Enter the number");
            String s = in.nextLine();
            System.out.println("Enter the source base");
            do
                if (in.hasNextInt()) {
                    sBase = in.nextInt();
                    if (sBase > 36 || sBase < 2) {
                        System.out.println("Over 36 or less than 2. Try again");
                    }
                } else {
                    System.out.println("Not a number");
                    return;
                } while (sBase > 36 || sBase < 2);
            System.out.println("Enter the destination base");
            do
                if (in.hasNextInt()) {
                    dBase = in.nextInt();
                    if (dBase > 36 || dBase < 2) {
                        System.out.println("Over 36 or less than 2. Try again");
                    }
                } else {
                    System.out.println("Not a number");
                    return;
                }
            while (dBase > 36 || dBase < 2);
            try {
                if(stringBaseCheck(s, sBase, dBase))
                    System.out.println("Result "+baseConversion(s, sBase, dBase));
                else System.out.println("Not proper number");
            } catch (Error error) {
                System.out.println(error);
            }
            System.out.println("Press y or Y to continue: ");
            awnser = in.next();
        } while (awnser.equals("y")||awnser.equals("Y"));
    }
}

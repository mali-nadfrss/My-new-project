package com.mali.encryption;

import java.io.*;
import java.util.*;

/* HackerRank Encryption problem
https://www.hackerrank.com/challenges/encryption/problem
An English text needs to be encrypted using the following encryption scheme.
First, the spaces are removed from the text. Let  be the length of this text.
Then, characters are written into a grid, whose rows and columns have the following constraints:
*/
public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int len = s.length();
        int row = (int)Math.sqrt(len) ;
        if((row * row) < len){
            row = row +1;
        }
        List<String> strs = new ArrayList();
        for(int i = 0 ; i < row ; i++){
            strs.add("");
        }
        for(int i = 0 ; i < len ; ){
            for(int j = 0 ; j< row ; j++){
                if(i >= len){
                    break;
                }
                String a = strs.get(j);
                a = a+s.charAt(i);
                strs.set(j,a);
                i++;
            }
        }
        String ans = "";
        for(int j = 0 ; j< row ; j++){
            ans = ans + strs.get(j)+" ";
        }
        ans = ans;
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/

        System.out.println(encryption("I Love Sam 143"));
    }
}
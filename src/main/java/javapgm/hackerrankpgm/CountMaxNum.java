package javapgm.hackerrankpgm;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class CountMaxNum {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
    // Write your code here
    Collections.sort(candles);
    int count=0;
    int k = candles.size()-1;
    for(int i=k;i>=0;i--) {
        if(candles.get(k) == candles.get(i)) {
            count++;
        } else {
            break;
        }
    }
    System.out.println(count);
    return count;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("console")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = CountMaxNum.birthdayCakeCandles(candles);
        
        String s="07:05:45PM";
        System.out.println(s.substring(s.length()-2, s.length()));

        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }

}

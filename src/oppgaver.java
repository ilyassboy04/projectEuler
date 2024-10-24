import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class oppgaver {

    public static void oppgave1() { //sum of multiples of 3 & 5 under 1000
        int sum = 0;
        for (int i = 0; i < 1_000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void oppgave2() { //sum of even numbers in fib under 4*10^6
        int n1 = 1;
        int n2 = 2;
        int n3 = 0;
        int sum = 2;
        while (sum < 4_000_000) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.println(n3);
            if (n3 % 2 == 0) {
                sum += n3;
            }
        }
        System.out.println(sum);
    }

    public static void oppgave3() { // largest prime factor of 600851475143
        double tall = 600_851_475_143D;// too large for int, we have to write 'D' for double even if datatype is double or Java will treat it as int even if we specified double
        double stoerstePrimtall = 0;
        int n = 2;
        while (n * n <= tall) {
            if (tall % n == 0) {
                tall /= n;
                stoerstePrimtall = tall;
                System.out.println(n);
            } else {
                n++;
            }
        }
        if (tall > 1) {
            stoerstePrimtall = tall;
        }
        System.out.println(stoerstePrimtall);
    }

    public static int oppgave4() {
        int largestPalindrome = 0;

        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int product = i * j;
                if (palindromeCheck(product) && product > largestPalindrome) {
                    largestPalindrome = product;
                }
            }
        }
        System.out.println(largestPalindrome);
        return largestPalindrome;
    }

    public static boolean palindromeCheck(int num) {
        int originalNum = num;
        int reversedNum = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            reversedNum = reversedNum * 10 + lastDigit;
            num /= 10;
        }

        return originalNum == reversedNum;
    }

    public static void oppgave5() { //Smallest multible evenly divisble by 1-20
        int number = 1;
        int i = 2;
        boolean solution = false;
        while (!solution) {
            for (i = 2; i <= 20; i++) {
                for (int j = 2; j <= 20; j++) {
                    if (number % j != 0) {
                        number++;
                    } else {
                        solution = true;
                    }
                }
            }
            System.out.println(number);
        }
    }

    public static void oppgave6() { // sum square difference (1+2...100)^2 vs (1^2 + ... 100^2)
        double number1 = 0;
        double number2 = 0;
        double svar = 0;
        int n = 2;
        for (int i = 1; i <= 100; i++) {
            number1 += Math.pow(i, n);
            number2 += i;
        }
        number2 = Math.pow(number2, n);
        svar = number2 - number1;
        System.out.println(svar / 1_000_000);
    }

    public static void oppgave7() { //the 10_001th prime number
        int[] tall = new int[10_001];
        int indeks = 0;
        tall[0] = 2;
        tall[1] = 3;
        for (int prime = 4; indeks < 10_001; prime++)
            if (prime % tall[indeks] != 0) {
                tall[indeks] = prime;
                indeks++;
            }
        System.out.println(tall[tall.length] - 1);
    }

    public static void oppgave8() {

    }

    public static void oppgave9() { //Pythagorean triplet, find abc for a + b + c = 1_000 & a<b<c where a^2 + b^2 = c^2
        int limit = 1_000;
        for (int a = 1; a < limit; a++) {
            for (int b = a + 1; b < limit; b++) {
                int c = limit - b - a; // a + b + c = limit (1000)
                if (c > 0 && (a * a + b * b == c * c)) {
                    System.out.println(a + " " + b + " " + c);
                    System.out.println(a * b * c);
                    return; //stops after first triplet, not needed in this code bc we know that there's only one
                }
            }
        }
    }

    public static void oppgave10() { //summation of primes below two million
    }

    public static void oppgave11() { //Largest product in a grid
        Scanner scanner = new Scanner(System.in);
        int[][] grid = new int[20][20];

        System.out.println("enter grid form PE");
        for (int i = 0; i < 20; i++) {
            String row = scanner.nextLine(); // reads an entire row,
            String[] numbers = row.split(" "); // splits the row into numbers
            for (int j = 0; j < numbers.length; j++) {
                grid[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        int biggestVerticalProduct = 0;
        int newProduct = 0;
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                newProduct = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j]; //this shall give the largest product vertically ont the first row of the grid (only a test)
                if (newProduct > biggestVerticalProduct) { // problem: will only do right-left, some values will be missing with left-right diagonals.
                    biggestVerticalProduct = newProduct;
                }
            }
        }
        int biggestHorisontalProduct = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length - 3; j++) {
                newProduct = grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3];
                if (newProduct > biggestHorisontalProduct) {
                    biggestHorisontalProduct = newProduct;
                }
            }
        }

        int biggestLeft_Right_Down_Diagonal = 0;
        for (int i = 0; i < grid.length-3; i++){
            for (int j = 0; j < grid[i].length -3; j++){
                newProduct = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
                if (newProduct > biggestLeft_Right_Down_Diagonal){
                    biggestLeft_Right_Down_Diagonal = newProduct;
                }
            }
        }
        int biggestRight_Left_Down_Diagonal = 0;
        for (int i = 0; i < grid.length-3; i++){
            for (int j = 0; j < grid[i].length-3; j++){
                newProduct = grid[i+3][j] * grid[i+2][j+1] * grid[i+1][j+2] * grid[i][j+3];
                if(newProduct > biggestRight_Left_Down_Diagonal){
                    biggestRight_Left_Down_Diagonal = newProduct;
                }
            }
        }
        System.out.println("Biggest vertical: " + biggestVerticalProduct);
        System.out.println("Biggest Horisontal: " + biggestHorisontalProduct);
        System.out.println("Biggest RLD-diagonal: " + biggestRight_Left_Down_Diagonal);
        System.out.println("Biggest LFD-diagonal: " + biggestLeft_Right_Down_Diagonal);
        
    }
}





import org.w3c.dom.Node;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

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
        long result = 1;
        for (int i = 1; i <= 20; i++){
            result = (result*i)/gcd((int)result, i);
        }

        System.out.println(result);
    }
    private static int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
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
        int primtallLimit = 10_001;
        int primtallCount = 1; // 2 er allerede et primtall, men i utregningen vil ikke bli telt
        int tall = 2;

        while (primtallCount < primtallLimit){
            tall++;
            boolean erPrimtall = true;
            for (int i = 2; i <= Math.sqrt(tall); i++){
                if (tall%i==0){
                    erPrimtall = false;
                    break;
                }
            }
            if (erPrimtall){
                primtallCount++;
            }
        }

        System.out.println("primtallnummer: " + primtallCount +" er: " + tall);
    }

    public static void oppgave8() { // largest product in a series
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me the big number");
        StringBuilder numberSeriesBuilder = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("END")){ // have to manually end it
            numberSeriesBuilder.append(line);
        }
        scanner.close();

        String numberSeries = numberSeriesBuilder.toString(); // converts to string
        long maxProduct = 0;

        for(int i = 0; i <= numberSeries.length()-13; i++){
            long product = 1;
            for (int j = 0; j<13; j++){
                int digit = Character.getNumericValue(numberSeries.charAt(i + j));
                product *= digit;
            }
            if (product > maxProduct){
                maxProduct = product;
            }
        }
        System.out.println(maxProduct);

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
        long sumOfPrimes = 0;
        int tall = 2;

        while (tall<2_000_000){
            boolean isPrime = true;

            for(int i = 2; i<=Math.sqrt(tall); i++){
                if(tall%i==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                sumOfPrimes+=tall;
            }
            tall++;
        }
        System.out.println(sumOfPrimes);
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

    public static void oppgave12() { // Highly divisible Triangular Number
        long triangularNumber = 0;
        int n = 1; //triangle number index (formerly "teller")

        while (true) {
            triangularNumber += n; //neste triangulaer
            n++;

            int divisorCount = 0;
            long sqrt = (long) Math.sqrt(triangularNumber);


            for (long i = 1; i <= sqrt; i++) { //teller bare opp til roten og opddater divisorCount i par
                if (triangularNumber % i == 0) {
                    divisorCount += 2;
                }
            }
            if (sqrt * sqrt == triangularNumber) {
                divisorCount--; //hvis det er et perfekt kvadrattal så fjerner vi dobbelt telling siden divisoren er samme
            }
            if (divisorCount > 500) {
                System.out.println(divisorCount);
                System.out.println(triangularNumber);
                break;
            }
        }
    }

    public static void oppgave13() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        while(true){
            String line = scanner.nextLine();
            if(line.equals("END")){
                break;
            }
            input.append(line).append("\n");
        }
        scanner.close();

        String[] tall = input.toString().split("\n");
        BigInteger sum =  BigInteger.ZERO; // . zero/one/two is how we initialize with BigInteger.

        for(String nummer : tall){
            sum = sum.add(new BigInteger(nummer)); //adding the BigInteger together (new BigInt is the parsing from String)
        }

        String sumString = sum.toString();
        String firstTenDigits = sumString.substring(0,10); //from start and ten out.

        System.out.println(firstTenDigits);

    }

    public static void oppgave14() { //Longest Collatz sequence (3n+1)
        int teller = 2;
        int max = 0;
        int maxIndeks = 0;
        while (teller < 1_000_000) {
            int antall = 1;
            long tall = teller;

            while (tall != 1) {
                if (tall % 2 == 0) {
                    tall /= 2;
                    antall++;
                } else {
                    tall = (tall * 3) + 1;
                    antall++;
                }
            }
            if(antall> max) {
                max = antall;
                maxIndeks = teller;
            }
            System.out.println(teller);
            teller++;
        }
        System.out.println("lengste sekvensen er : "+ max +" og tilhører tallet: " + maxIndeks);

    }
    public static void oppgave15(int n, int k){ //lattice paths (biniomial formula)
        if (k > n-k){
            k= n-k;
        }
        long tall = 1;
        for (int i = 0; i<k;i++){
            tall = tall*(n-i) / (i+1);
        }
        System.out.println(tall);
    }

    static class Node{
        int verdi;
        Node venstre, høyre;

        public Node(int verdi){
            this.verdi = verdi;
        }
    }

    public static final Map<Node, Integer> minne = new HashMap<>();

    public static Node lagBT(){
        int[][] BT2D = {
                {75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
        };

        Node[][] noder = new Node[BT2D.length][];
        //oppretter nodene fra 2D-arrayet
        for (int i = 0; i < BT2D.length; i++){
            noder[i] = new Node[BT2D[i].length];
            for (int j = 0; j < BT2D[i].length; j++){
                noder[i][j] = new Node(BT2D[i][j]);
            }
        }
         //linker nodene
        for (int i = 0; i<BT2D.length-1; i++){
            for (int j = 0; j< BT2D[i].length; j++){
                noder[i][j].venstre = noder[i + 1][j];
                noder[i][j].høyre = noder[i+1][j+1];
            }
        }
        return noder[0][0];
    }

    public static int oppgave18(Node node){
        if (node == null){
            return 0;
        }
        if(minne.containsKey(node)) return minne.get(node);
        int venstreSum = oppgave18(node.venstre);
        int høyreSum = oppgave18(node.høyre);

        int maxSum = node.verdi + Math.max(venstreSum, høyreSum);
        minne.put(node, maxSum);


        return maxSum;
    }

    public static void oppgave19(){
        //Solved with pen and paper by probabilty with ~2% margin
    }

    public static void oppgave20(){
        long faktorial = 1l;
        //too long to handle- convert to string maybe?
        for (int i = 1; i<101; i++){
            faktorial = faktorial*i;
            System.out.println(faktorial);
        }
        System.out.println(faktorial);
    }


}





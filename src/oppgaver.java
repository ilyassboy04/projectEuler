public class oppgaver {

    public static void oppgave1 (){ //sum of multiples of 3 & 5 under 1000
        int sum = 0;
        for (int i = 0; i < 1_000; i++){
            if (i%3==0 || i%5==0){
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void oppgave2(){ //sum of even numbers in fib under 4*10^6
        int n1 = 1;
        int n2= 2;
        int n3 = 0;
        int sum = 2;
        while (sum < 4_000_000){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.println(n3);
            if(n3%2==0) {
                sum += n3;
            }
        }
        System.out.println(sum);
    }

    public static void oppgave3() { // largest prime factor of 600851475143
        double tall = 600_851_475_143D;// too large for int, we have to write 'D' for double even if datatype is double or Java will treat it as int even if we specified double
        double stoerstePrimtall = 0;
        int n = 2;
        while (n*n <= tall){
            if (tall%n == 0){
                tall/=n;
                stoerstePrimtall = tall;
                System.out.println(n);
            } else {
                n++;
            }
        }
        if (tall > 1){
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
        for (int i = 1; i <=100; i++){
            number1 += Math.pow(i,n);
            number2 += i;
        }
        number2 = Math.pow(number2,n);
        svar = number2-number1;
        System.out.println(svar/1_000_000);
    }
}
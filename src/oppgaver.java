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

    public static void oppgave4() { // Largest palindrome product of the product of two 3-digit numbers YYY * YYY =
        // answer will be between 10k - 1mil bc the smallest product of YYY * YYY is 10k and largest is slightly under 1mil
    }
}

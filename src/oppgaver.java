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
        double tall = 600_851_475_143D; // too large for int, we have to write 'D' for double even if datatype is double or Java will treat it as int even if we specified double
        double floor_function = Math.floor(Math.sqrt(tall));
        double svar = floor_function;
        boolean ferdig = false;
        while (ferdig != true) {
            int i = 2;
            if (svar % i == 0) {
                svar = svar / i;
                i++;
                System.out.println(svar);
            }
        }
    }
}

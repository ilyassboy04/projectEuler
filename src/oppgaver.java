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

    }
}

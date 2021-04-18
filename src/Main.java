
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ///https://www.youtube.com/watch?v=RG5rWV6in38&list=TLGGGO0ecV5KdhkxNzA0MjAyMQ&ab_channel=Pepcoding

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give Numeral System (like for Senary give 6) : ");
        int numeral = Integer.parseInt(scanner.nextLine());
        Cryptarithmetic crp = new Cryptarithmetic(numeral);
        crp.readInput(scanner);
        crp.solve(0);



    }




}

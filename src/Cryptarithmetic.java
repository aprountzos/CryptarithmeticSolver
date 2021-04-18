import java.util.HashMap;
import java.util.Scanner;

public class Cryptarithmetic {

    int numeralSystem;
    String uniqueCharacters = "";
    HashMap<Character, Integer> assigned;
    String[] puzzleWords ;
    boolean[] usedNumbers ;

    public Cryptarithmetic(int numeralSystem) {
        this.numeralSystem = numeralSystem;
        assigned = new HashMap<>();
        puzzleWords = new String[3];
        usedNumbers = new boolean[numeralSystem];
    }


    public void populateAssigned(){
        for(String world:puzzleWords){
            for( int i=0; i< world.length(); i++){
                if(!assigned.containsKey(world.charAt(i))){
                    assigned.put(world.charAt(i),-1);
                    uniqueCharacters += world.charAt(i);
                }
            }
        }
    }

    public void readInput(Scanner scanner){
        System.out.println("Give puzzle: ");
        String s = scanner.nextLine();
        String[] temp = s.split(" ");
        String[] temp2 = new String[3];

        puzzleWords[0] = temp[0];
        puzzleWords[1] = temp[2];
        puzzleWords[2] = temp[4];
        populateAssigned();

    }

    public  int getNum(String s){
        String num = "";

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            num += this.assigned.get(ch);
        }
        return Integer.parseInt(num);
    }

    public void check() {

            int num1 = convertToDecimal(getNum(puzzleWords[0]));
            int num2 = convertToDecimal(getNum(puzzleWords[1]));
            int num3 = convertToDecimal(getNum(puzzleWords[2]));
            if (num1 + num2 == num3) {
                if((puzzleWords[2].length()> puzzleWords[0].length() && puzzleWords[2].length()> puzzleWords[1].length())){
                    if(Integer.toString(getNum(puzzleWords[2])).length() > Integer.toString(getNum(puzzleWords[0])).length()
                            && Integer.toString(getNum(puzzleWords[2])).length() > Integer.toString(getNum(puzzleWords[1])).length()){

                        System.out.println(getNum(puzzleWords[0]) + " + " +getNum(puzzleWords[1]) + " = " + getNum(puzzleWords[2]));
                    }

                }else  System.out.println(getNum(puzzleWords[0]) + " + " +getNum(puzzleWords[1]) + " = " + getNum(puzzleWords[2]));
        }




    }

    public void solve(int index){

        if ( index == this.uniqueCharacters.length()){
            check();
            return;
        }

        char character = uniqueCharacters.charAt(index);
        for(int num = 0; num< numeralSystem; num++){
            if(usedNumbers[num] == false){
                usedNumbers[num] = true;
                assigned.put(character,num);
                solve(index + 1);
                assigned.put(character,-1);
                usedNumbers[num] = false;
            }
        }
    }

    //stack Overflow code
    public  int convertToDecimal(int number) {
        String str = Integer.toString(number);
        int v = 0;
        int total = 0;
        int pow = 0;
        str = str.toUpperCase();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9')
                v = c - '0';
            else if (c >= 'A' && c <= 'Z')
                v = 10 + (c - 'A');
            total += v * Math.pow(numeralSystem, pow);
            pow++;
        }
        return total;
    }
}

import java.util.Scanner;

/**
 * Created by blackj on 2/10/2017.
 */
public class SubsetGenerator {
    private static Scanner in = new Scanner(System.in);

    private static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private static int[] decimalNumbers;
    private static String[] binaryNumbers;
    private static String[] subsets;

    public static String toBinary(int num, int n){
        String binaryString = "";
        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            binaryString += binary[i];
        }

        int missingZeros = n - binaryString.length();

        for(int i = 0; i < missingZeros; i++){
            binaryString = "0" + binaryString;
        }
        return binaryString;
    }


    private static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }


    private static String toCharacters(String binary, int n){
        String characters = "";
        int[] binaryNumberArray = new int[n];
        String binaryString = reverse(binary);
        for(int i = 0; i < n; i++){
            binaryNumberArray[i] = binaryString.charAt(i); //Reverses
        }

        int y = 0;
        for(int x: binaryNumberArray){
            if(x == '1'){
                characters += letters[y];
            }
            y++;
        }
        return characters;
    }

    public static void main(String [] args){
        System.out.print("Enter number: ");
        int n = in.nextInt();

        decimalNumbers = new int[(int)(Math.pow(2, n))]; //Create array for the decimal numbers
        binaryNumbers = new String[(int)(Math.pow(2, n))]; //Create array for the binary numbers
        subsets = new String[(int)(Math.pow(2, n))]; //Create an array for the strings

        for(int i = 0; i <= ((int)Math.pow(2,n) - 1); i++){ //Fill array with numbers 0 through 2^n-1
            decimalNumbers[i] = i;
        }

        int i = 0;
        for(int x : decimalNumbers){
            binaryNumbers[i] = toBinary(x, n);
            i++;
        }

        i = 0;
        for(String x : binaryNumbers){
            subsets[i] = toCharacters(x, n);
            i++;
        }
        for(String x : subsets){
            System.out.println(x);
        }
    }
}

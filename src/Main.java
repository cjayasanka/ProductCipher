import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        String plainText = "plain.txt";
        String line;

        String encryptText = "encryptText.txt";

        String decryptText = "decryptText.txt";


        //authentication
        String password;
        int mode;
        Scanner scannermode = new Scanner(System.in);
        System.out.print("Type 1 for Encrypt, type 2 for Decrypt : ");
        mode = scannermode.nextInt();

        if (mode == 1){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type Secret key (8 or more char) : ");
            password = scanner.next();
            while (password.length()<8){
                System.out.print("Type 8 or more char : ");
                password = scanner.next();
            }
            System.out.print("Please retype key : ");
            if (password.equals(scanner.next())){
                System.out.println("done");

                //read file
                try {
                    FileReader fileReader =
                            new FileReader(plainText);

                    BufferedReader bufferedReader =
                            new BufferedReader(fileReader);

                    FileWriter fileWriter =
                            new FileWriter(encryptText);

                    BufferedWriter bufferedWriter =
                            new BufferedWriter(fileWriter);

                    while((line = bufferedReader.readLine()) != null) {


                        //encryption
                        char[] text = line.toCharArray();
                        char[] encrypted = new char[text.length];

                        char[] one = makeArrayOne(password);
                        char[] two = makeArrayTwo(password);

                        for (int i =0; i < text.length; i++){
                            encrypted[i] = two[new String(one).indexOf(text[i])];
                        }
                        //System.out.println(new String(encrypted));
                        bufferedWriter.write(new String(encrypted));
                        bufferedWriter.newLine();

                    }

                    bufferedReader.close();
                    bufferedWriter.close();
                }
                catch(FileNotFoundException ex) {
                    System.out.println(
                            "Unable to open file '" +
                                    plainText + "'");
                }
                catch(IOException ex) {
                    System.out.println(
                            "Error reading file '"
                                    + plainText + "'");
                }


            }else{
                System.out.println("key mismatch");
            }
        }else if(mode == 2){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type Secret key : ");
            password = scanner.next();

                //read file
                try {
                    FileReader fileReader =
                            new FileReader(encryptText);

                    BufferedReader bufferedReader =
                            new BufferedReader(fileReader);

                    FileWriter fileWriter =
                            new FileWriter(decryptText);

                    BufferedWriter bufferedWriter =
                            new BufferedWriter(fileWriter);

                    while((line = bufferedReader.readLine()) != null) {


                        //encryption
                        char[] text = line.toCharArray();
                        char[] decrypted = new char[text.length];

                        char[] one = makeArrayOne(password);
                        char[] two = makeArrayTwo(password);

                        for (int i =0; i < text.length; i++){
                            decrypted[i] = one[new String(two).indexOf(text[i])];
                        }
                        //System.out.println(new String(encrypted));
                        bufferedWriter.write(new String(decrypted));
                        bufferedWriter.newLine();

                    }

                    bufferedReader.close();
                    bufferedWriter.close();
                }
                catch(FileNotFoundException ex) {
                    System.out.println(
                            "Unable to open file '" +
                                    plainText + "'");
                }
                catch(IOException ex) {
                    System.out.println(
                            "Error reading file '"
                                    + plainText + "'");
                }


            }else{
                System.out.println("key mismatch");
            }
        }




    static char[] makeArrayOne(String password){

        String arrOne = "";
        String alphabet = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

        for(int i =0; i < password.length(); i++){
            if(!arrOne.contains(password.substring(i,i+1))){
                arrOne = arrOne + password.substring(i,i+1);
            }
        }

        for(int i =0; i < alphabet.length(); i++){
            if(!arrOne.contains(alphabet.substring(i,i+1))){
                arrOne = arrOne + alphabet.substring(i,i+1);
            }
        }

        return arrOne.toCharArray();
    }

    static char[] makeArrayTwo(String password){

        int val = 0;
        char[] alpha = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();
        char[] alphabet = new char[95];

        for(int i =0; i < password.length(); i++){
            val = val + (int)password.substring(i,i+1).toCharArray()[0];
        }

        for(int i =0; i < alpha.length; i++){
            alphabet[i] = alpha[(val+i)%95];
        }

        return alphabet;
    }
}
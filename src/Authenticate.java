import java.util.Scanner;

public class Authenticate {

    public static void main(String[] args) {
        String password;
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
        }else{
            System.out.println("key mismatch");
        }

    }
}

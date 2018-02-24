import java.io.*;

public class Write {
    public static void main(String [] args) {

        String fileName = "temp.txt";

        try {
            FileWriter fileWriter =
                    new FileWriter(fileName);

            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);


            bufferedWriter.write("Test");
            bufferedWriter.write(" More Test");
            bufferedWriter.newLine();
            bufferedWriter.write("Hello");

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
        }
    }
}
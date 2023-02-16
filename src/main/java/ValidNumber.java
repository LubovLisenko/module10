import java.io.*;
import java.util.Scanner;


public class ValidNumber {

    public void read() {
        File file = new File("file.txt");
        String str = null;
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    str = scanner.nextLine();
                           if ((str.matches("^((\\([0-9]{3}\\) )|([0-9]{3}\\-))[0-9]{3}\\-[0-9]{4}$")) ||
                              (str.matches("^(([0-9]{3}\\-))[0-9]{3}\\-[0-9]{4}$"))) {
                        System.out.println("str = " + str);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        ValidNumber validNumber = new ValidNumber();
        validNumber.read();

    }
}


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadWriteClass {

    public static void main(String[] args) throws IOException {
        File file = new File("file1.txt");
        String str = null;
        UserDto userDto = new UserDto();

        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                str = scanner.nextLine();
                while (scanner.hasNext()) {
                    str = scanner.nextLine();
                    String[] splitedLine = str.split(" ");
                    String name = splitedLine[0];
                    String age = splitedLine[1];
                    userDto.setName(name);
                    userDto.setAge(age);

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String toJson = gson.toJson(userDto);
                    System.out.println(toJson);
//                    OutputStream fos = new FileOutputStream("users.json");
//                    fos.write(toJson.getBytes());
                    FileWriter fileWriter = new FileWriter("users.json", true);
                    gson.toJson(userDto,fileWriter);
                    fileWriter.close();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

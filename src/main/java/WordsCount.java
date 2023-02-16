import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class WordsCount {
    public void readCount() {
        File file = new File("words.txt");
        Map<String, Integer>  map = new HashMap<>();
        String str = null;
        int currentCount = 1;
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    str = scanner.nextLine();
                    String[] splitedLine = str.split(" ");
                    for (String word:splitedLine) {
                        if (map.containsKey(word)){
                            currentCount = map.get(word);
                            map.put(word,currentCount + 1);

                        } else {
                            map.put(word,currentCount);
                        }
                    }
                }

                Comparator<String> compare = new Comparator<>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return (map.get(o1).compareTo(map.get(o2))) > 0 ? 1 : -1;
                    }
                };
                Map <String, Integer> result = new TreeMap<>(compare.reversed());
                result.putAll(map);
                    System.out.println(result);



            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        WordsCount wordsCount = new WordsCount();
        wordsCount.readCount();



    }
}

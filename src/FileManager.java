import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
        public String readFile(String filePath) {
            // Логика чтения файла
           String readFile = "фаил не считался";
            StringBuilder content = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            readFile = content.toString();
            return readFile;
            }


        public boolean writeFile(String content, String filePath) {
            // Логика записи файла
            boolean output = false;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(content);
                System.out.println("Фаил записан");
                output = true;
            } catch (IOException e) {
                e.printStackTrace();
            }return output;
        }

        public boolean createOutputFolder(String folderPath) {
            Path path = Paths.get(folderPath);
            try {
                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                    System.out.println("Папка создана: " + folderPath);
                } else {
                    System.out.println("Папка уже существует: " + folderPath);
                }
                return true;
            } catch (IOException e) {
                System.out.println("Ошибка при создании папки: " + folderPath);
                e.printStackTrace();
                return false;
            }
        }

}

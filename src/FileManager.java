import java.io.*;

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


        public void writeFile(String content, String filePath) {
            // Логика записи файла
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(content);
                System.out.println("Фаил записан");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}

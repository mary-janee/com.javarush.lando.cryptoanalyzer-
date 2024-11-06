import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Validator {

    public int getValidatedKey() {//получение ключа
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Введите ключ");

            try {
                key = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Пожалуйста, введите целое числовое значение.");
            }
        }

        return key;
    }

    public String  validKey(int key, int alphabetLen) {
        // Проверка ключа
        String validKey = String.valueOf(key);
        int vKey = key;
        if(Math.abs(key) >=alphabetLen){
            if(key>0){
            while(Math.abs(key)>=alphabetLen){
                vKey = Math.abs(key)-alphabetLen;
        }}
            if(key<0){
                while(Math.abs(key)>=alphabetLen){
                    vKey = Math.abs(key)-alphabetLen;
                }
            vKey=-1*vKey;

            }}
        if(vKey==0){
            validKey = "Нулевой ключ ничего не сделает";
        }
        else {
            validKey = String.valueOf(vKey);
        }

    return validKey;
    }
    public  String getValidatedFilePath() {
        System.out.println("Введите адрес фаила");
        Scanner scanner = new Scanner(System.in);
        String filePath;

        while (true) {
            filePath = scanner.nextLine();

            if (filePath == null || filePath.trim().isEmpty()) {
                System.out.println("Ошибка: Путь к файлу не может быть пустым.");
                continue;
            }

            if (!filePath.contains(".") || filePath.endsWith(".")) {
                System.out.println("Ошибка: Путь должен содержать расширение файла.");
                continue;
            }

            return filePath;
        }
    }
    public boolean isFileExist(String file) {
   try (InputStream inputStream = new FileInputStream(file)) {
        // Если файл открыт успешно, он существует
        return true;
    } catch (FileNotFoundException e) {
        System.out.println("Файл не найден: " + e.getMessage());
        return false;
    } catch (IOException e) {
        System.out.println("Ошибка при чтении файла: " + e.getMessage());
        return false;
    }}


    public String modeChecked(String mode){// проверка режима
        Scanner scanner = new Scanner(System.in);
        boolean input = true;

        while (input == (mode==null)|| (!mode.equals("1")&&!mode.equals("2"))){
            System.out.println("Введите число от 1 до 2 включительно");
            mode = scanner.nextLine();
        }
        return mode;
    }
}




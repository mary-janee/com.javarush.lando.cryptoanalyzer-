import java.io.File;
import java.util.Scanner;
public class MainApp {

    public static void main(String[] args) {
        // Логика для выбора режима работы, вызов соответствующих методов
        Validator validator = new Validator();
        Cipher cipher = new Cipher();
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        BruteForce bruteForce = new BruteForce();
        int key;
        //получаем входные данные и сразу валидируем их

        System.out.println("Выберите режим работы, 1 -- шифровка, 2 -- дешифровка с ключом, 3 -- дешифровка BruteForce");
        String mode = scanner.nextLine();


        String file =  validator.getValidatedFilePath(); //Получаем путь к исходному фаилу
        while(validator.isFileExist(file)!=true) {
            System.out.println("Введите путь к исходному файлу:");
            file = scanner.nextLine();
        } ;

        String text = fileManager.readFile(file);//читаем содержимое фаила


        if(mode.equals("1")){ //шифровка
            String newFile = validator.getValidatedFilePath();
            key = validator.getValidatedKey();
            key = Integer.parseInt(validator.validKey(key, cipher.alphabetLen ));

            String encrypted = cipher.encrypt(text, key);
            fileManager.writeFile(encrypted, newFile);

        }
        else if (mode.equals("2")) {
            String newFile = validator.getValidatedFilePath();
            key = validator.getValidatedKey();
            key = Integer.parseInt(validator.validKey(key, cipher.alphabetLen ));

            String decrypted = cipher.decrypt(text, key);
            fileManager.writeFile(decrypted, newFile);
        } else if (mode.equals("3")) {
            System.out.println("Введите путь к папке для сохранения результатов Brute Force и в конце добавьте слэш; Название фаилов будет состоять из названия папки и текущего ключа");
            String outputFolder = scanner.nextLine();
            while (!new File(outputFolder).exists()) {
                System.out.println("Указанная папка не существует. Попробуйте снова:");
                outputFolder = scanner.nextLine();
            }
            bruteForce.bruteForceDecrypt(text, outputFolder);

        }

    }
}

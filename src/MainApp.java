import java.util.Scanner;
public class MainApp {

    public static void main(String[] args) {
        // Логика для выбора режима работы, вызов соответствующих методов
        Validator validator = new Validator();
        Cipher cipher = new Cipher();
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        int key;
        //получаем входные данные и сразу валидируем их

        System.out.println("Выберите режим работы, 1 -- шифровка, 2 -- дешифровка с ключом");
        String mode = scanner.nextLine();


        String file =  validator.getValidatedFilePath(); //Получаем путь к исходному фаилу
        while(validator.isFileExist(file)!=true) {
            System.out.println("Введите путь к исходному файлу:");
            file = scanner.nextLine();
        } ;

        String newFile = validator.getValidatedFilePath();//Получаем путь для записи
        String text = fileManager.readFile(file);//читаем содержимое фаила

        //режим работы



        if(mode.equals("1")){ //шифровка
            key = validator.getValidatedKey();
            key = Integer.parseInt(validator.validKey(key, cipher.alphabetLen ));

            String encrypted = cipher.encrypt(text, key);
            fileManager.writeFile(encrypted, newFile);

        }
        else if (mode.equals("2")) {
            key = validator.getValidatedKey();
            key = Integer.parseInt(validator.validKey(key, cipher.alphabetLen ));

            String decrypted = cipher.decrypt(text, key);
            fileManager.writeFile(decrypted, newFile);
        }

    }
}

import java.util.Scanner;
public class MainApp {

    public static void main(String[] args) {
        // Логика для выбора режима работы, вызов соответствующих методов
        Validator validator = new Validator();
        Cipher cipher = new Cipher();
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        //получаем входные данные

        System.out.println("Введите ключ");
        int key = Integer.parseInt(scanner.nextLine());
        key = Integer.parseInt(validator.validKey(key, cipher.alphabetLen ));
        System.out.println("Введите путь сходного фаила");
        String file = scanner.nextLine();
        validator.isFileExists(file);
        System.out.println("По какому адресу сохранить фаил");
        String newFile = scanner.nextLine();
        String text = fileManager.readFile(file);

        //режим работы

        System.out.println("Выберите режим работы, 1 -- шифровка, 2 -- дешифровка с ключом, 3 -- BruteForce дешифровка ");
        String mode = scanner.nextLine();

        boolean input = true;

        while (input == (mode==null)|| (!mode.equals("1")&&!mode.equals("2")&&!mode.equals("3"))){
            System.out.println("Введите число от 1 до 3 включительно");
            mode = scanner.nextLine();
        }
        if(mode.equals("1")){ //шифровка

            String encrypted = cipher.encrypt(text, key);
            fileManager.writeFile(encrypted, newFile);

        }
        else if (mode.equals("2")) {


             String decrypted = cipher.decrypt(text, key);
             fileManager.writeFile(decrypted, newFile);
        }

    }
}

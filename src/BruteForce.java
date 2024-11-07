

public class BruteForce {
    Cipher cipher = new Cipher();
    FileManager fileManager = new FileManager();

    public void bruteForceDecrypt(String encryptedText, String outputFolder) {

        if (!fileManager.createOutputFolder(outputFolder)) {
            System.out.println("Не удалось создать папку для результатов: " + outputFolder);
            return;
        }


            for (int shift = 1; shift < cipher.alphabetLen; shift++) {

            String decryptedText = cipher.decrypt(encryptedText, shift);
            String fileName = outputFolder + "brutte"+ shift + ".txt"; // Имя файла с путём
                System.out.println("Попытка сохранить файл: " + fileName); // выводим путь перед записью
                if (fileManager.writeFile(decryptedText, fileName)) {
                    System.out.println("Файл успешно сохранён: " + fileName);
                } else {
                    System.out.println("Ошибка при сохранении файла: " + fileName);

                }
    }
}}
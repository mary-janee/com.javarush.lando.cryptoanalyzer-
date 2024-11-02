import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
public class Validator {


    public String  validKey(int key, int alephLen) {
        // Проверка ключа
        String validKey = String.valueOf(key);
        int vKey = key;
        if(Math.abs(key) >=alephLen){
            if(key>0){
            while(Math.abs(key)>=alephLen){
                vKey = Math.abs(key)-alephLen;
        }}
            if(key<0){
                while(Math.abs(key)>=alephLen){
                    vKey = Math.abs(key)-alephLen;
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
    public boolean isFileExists(String filePath) {
        boolean isFileExists;
        try (InputStream inputStream = new FileInputStream(filePath)) {
            isFileExists = true;
        } catch (FileNotFoundException e) {
            isFileExists = false;
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            isFileExists = false;
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
       return isFileExists;
    }

}






public class Cipher {
    private static final char[] ALPHABET = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О',
            'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г',
            'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х',
            'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ',', '«', '»',
            '"', '\'', ':', '!', '?', ' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
    public int alphabetLen = ALPHABET.length;


        public String encrypt(String text,int shift){
            String encrypt;
            char[] sameText  = text.toCharArray();
            StringBuilder encryptBuilder = new StringBuilder();

            // берем символы по отдельности находим такое в массиве . берем знак + ключ и пишем
            for (int i = 0; i < sameText.length; i++) {
                boolean symbolFound = false;
                for (int j = 0; j < alphabetLen; j++) {
                    if (sameText[i] == ALPHABET[j]) {
                        int newIndex = (j + shift) % alphabetLen;
                        encryptBuilder.append(ALPHABET[newIndex]);
                        symbolFound = true;

                        break;
                    }
                }
                if (!symbolFound) {
                    encryptBuilder.append(sameText[i]);

                }}
            encrypt = encryptBuilder.toString();
            return encrypt;
        }

        public String decrypt(String encryptedText,int shift) {
            String decrypt = "Расшифровка не удалась";
            StringBuilder decryptBuilder = new StringBuilder();
            char[] sameText = encryptedText.toCharArray();
            for (int i = 0; i < sameText.length; i++) {
                boolean symbolFound = false;
                for (int j = 0; j < alphabetLen; j++) {
                    if (sameText[i] == ALPHABET[j]) {
                        int newIndex = (j - shift) % alphabetLen;
                        if (newIndex < 0) {
                            newIndex += alphabetLen;
                        }
                        decryptBuilder.append(ALPHABET[newIndex]);
                        symbolFound = true;
                        break;
                    }
                }
                if (!symbolFound) {
                    decryptBuilder.append(sameText[i]);

                }}
              return decryptBuilder.toString();

            }

        }
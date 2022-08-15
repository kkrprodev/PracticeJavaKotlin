package encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class EncryptOrDecryptFiles {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        File inputDirectory = new File("D:\\EnDe");
        System.out.println("Is directory : " + inputDirectory.isDirectory());
        File[] files = inputDirectory.listFiles();
        Arrays.asList(files).forEach(inputFile -> {
            encryptOrDecryptFile(inputFile, Cipher.DECRYPT_MODE, "QWERTYUIASDFGHJK");
        });
    }

    private static void encryptOrDecryptFile(File inputFile, int cipherMode, String secretKey) {
        String transformation = "AES";
        String algorithm = "AES";
        try {
            Key keySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(cipherMode, keySpec);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            FileInputStream fis = new FileInputStream(inputFile);
            fis.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            String outputFileName = inputFile.getName() + "__Out";
            File outputFile = new File(inputFile.getParentFile() + File.separator + outputFileName);

            FileOutputStream fos = new FileOutputStream(outputFile);
            fos.write(outputBytes);

            fis.close();
            fos.close();

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IOException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

    }



}

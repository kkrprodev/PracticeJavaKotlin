package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class PathsUtil {

    public static void main(String[] args) throws IOException {
        Path file = getFileInTheCodebase(Path.of("file1.txt"));
        ByteBuffer byteBuffer = readFromFile(file);
        String convertedToString = convertToString(byteBuffer);
        int status = writeToFile(file, convertedToString);
        System.out.println("Write Status: " + status);
    }

    static String convertToString(ByteBuffer bb) {

        /* Charset charset = Charset.forName("US-ASCII");
         CharBuffer charBuffer = StandardCharsets.UTF_8.decode(bb);*/

        byte[] array = bb.array();
        String s = new String(array).replaceAll("\0", "");
        return s;
    }

    static ByteBuffer readFromFile(Path file) throws IOException {
        FileChannel readChannel = FileChannel.open(file, StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(Math.multiplyExact(1024,1));
        System.out.println("BB limit: " + byteBuffer.limit());

        int readStatus = readChannel.read(byteBuffer);
        System.out.println("Read Status: " + readStatus);
        readChannel.close();
        return byteBuffer;
    }

    static int writeToFile(Path file, String data) throws IOException {
        FileChannel fileChannel = FileChannel.open(file, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        int status = fileChannel.write(ByteBuffer.wrap(data.getBytes(StandardCharsets.UTF_8)));
        fileChannel.close();
        return status;
    }

    static Path getFileInTheCodebase(Path filePath) throws IOException {
        Path codebase = Paths.get("codebase");

        // Creating codebase
        if (!Files.exists(codebase)) Files.createDirectory(codebase);

        // Check if this is a directory or not
        System.out.println(Files.isDirectory(codebase));

        // Get file in codebase
        Path file = codebase.resolve(filePath);

        if(!Files.exists(file)) Files.createFile(file);

        // Print absolute path
        System.out.println(file.toAbsolutePath());

        return file;
    }

}

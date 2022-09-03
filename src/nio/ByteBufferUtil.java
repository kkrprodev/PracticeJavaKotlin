package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class ByteBufferUtil {

    public static void main(String[] args) throws IOException {
        //basicOperations();
        fileOperations();
    }

    static void fileOperations() throws IOException {
        String msg = "Hi, There!";
        Path file = PathsUtil.getFileInTheCodebase(Path.of("file1.txt"));
        ByteBuffer bb = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(bb.array()));

        FileChannel fileChannel = FileChannel.open(file, StandardOpenOption.WRITE, StandardOpenOption.APPEND);

        fileChannel.write(bb);

        System.out.println(bb + Arrays.toString(bb.array()));

        System.out.println(bb.get(5));

        bb.position(5);
        bb.put((byte) 105);
        System.out.println(bb + Arrays.toString(bb.array()));
        System.out.println(new String(bb.array()));
    }


    static void basicOperations() {

        ByteBuffer bb = ByteBuffer.allocate(8);
        System.out.println(bb + Arrays.toString(bb.array()));

        // byte ranges from -128 to 127
        byte b1 = 127;
        bb.put(b1);
        System.out.println(bb + Arrays.toString(bb.array()));

        bb.position(3);
        byte b2 = -128;
        bb.put(b2);

        System.out.println(bb + Arrays.toString(bb.array()));

        bb.flip();
        System.out.println(bb + Arrays.toString(bb.array()));
        System.out.println(bb.get(3));

        bb.position(4);
        bb.flip();
        System.out.println(bb + Arrays.toString(bb.array()));
        System.out.println(bb.get(3));

        bb.limit(8);
        bb.position(7);
        bb.put((byte) 8);

        System.out.println(bb + Arrays.toString(bb.array()));

        System.out.println(bb.get(7));

    }

}

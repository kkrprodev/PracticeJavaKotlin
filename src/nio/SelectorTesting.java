package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Set;

public class SelectorTesting {

    public static void main(String[] args) throws Exception {
        serverSocChannelTesting();
    }

    public static void serverSocChannelTesting() throws IOException, InterruptedException {
        Selector s = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(5454));
        serverSocketChannel.configureBlocking(false);
        SelectionKey selectionKey = serverSocketChannel.register(s, SelectionKey.OP_ACCEPT);

        while (true) {

            Thread.sleep(3000);
            s.select();
            Set<SelectionKey> selectedKeys = s.selectedKeys();
            Iterator<SelectionKey> iter = selectedKeys.iterator();
            while (iter.hasNext()) {

                SelectionKey key = iter.next();
                if (key.isAcceptable()) {

                    System.out.println("Received Msg");
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(s, SelectionKey.OP_READ);
                }
                iter.remove();

            }
        }

    }
}

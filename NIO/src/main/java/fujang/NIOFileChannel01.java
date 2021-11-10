package fujang;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "Hello fujang";
        FileOutputStream fileOutputStream = new FileOutputStream("/home/mbfjllybl/IdeaProjects/netty-test/NIO/src/main/java/fujang/1.txt");

        //实际类型 FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put(str.getBytes());

        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        fileOutputStream.close();

    }
}

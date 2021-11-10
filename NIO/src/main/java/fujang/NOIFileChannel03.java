package fujang;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NOIFileChannel03 {
    public static void main(String[] args) throws IOException {

        File file1 = new File("/home/mbfjllybl/IdeaProjects/netty-test/NIO/src/main/java/fujang/1.txt");
        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileChannel channel1 = fileInputStream1.getChannel();

        File file2 = new File("/home/mbfjllybl/IdeaProjects/netty-test/NIO/src/main/java/fujang/2.txt");
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        FileChannel channel2 = fileOutputStream2.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {

            byteBuffer.clear();

            int read = channel1.read(byteBuffer);

            if (read == -1) {
                break;
            }

            byteBuffer.flip();
            channel2.write(byteBuffer);
        }

        fileInputStream1.close();
        fileOutputStream2.close();

    }
}

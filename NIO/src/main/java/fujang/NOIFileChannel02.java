package fujang;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NOIFileChannel02 {
    public static void main(String[] args) throws IOException {

        File file = new File("/home/mbfjllybl/IdeaProjects/netty-test/NIO/src/main/java/fujang/1.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        channel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();

    }
}

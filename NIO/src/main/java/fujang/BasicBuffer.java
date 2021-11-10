package fujang;

import java.nio.IntBuffer;
import java.nio.channels.Channel;

public class BasicBuffer {
    public static void main(String[] args) {
        // 创建一个buffer,大小为5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // 在buffer中放入数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i);
        }

        // 将buffer读写切换
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            // get取出
            System.out.println(intBuffer.get());
        }

    }
}

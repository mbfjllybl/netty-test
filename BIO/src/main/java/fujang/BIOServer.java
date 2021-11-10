package fujang;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("Server has exced");

        while (true) {
            final Socket socket = serverSocket.accept(); //阻塞

            System.out.println("one client has connected...");

            executorService.execute(new Runnable() {
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    public static void handler(Socket socket) {
        try {
            System.out.println(Thread.currentThread().getId() + "/" + Thread.currentThread().getName());

            byte[] bytes = new byte[1024];

            InputStream inputStream = socket.getInputStream();

            while (true) {
                int read = inputStream.read(bytes); //阻塞
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("connection has been closed...");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

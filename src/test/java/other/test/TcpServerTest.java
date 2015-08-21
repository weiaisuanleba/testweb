package other.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpServerTest {

    public static List<Socket> clients = new ArrayList<Socket>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(14002);
            System.out.println("服务器启动，端口：14002");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress());
                clients.add(socket);
                new Thread(new ListenerClient(socket));
                System.out.println(clients.size());
            }
        } catch (IOException e) {
            System.out.println("服务器停止，端口：14001");
            e.printStackTrace();
        }
    }

}

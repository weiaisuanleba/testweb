package server.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpServerTest extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(TcpServerTest.class);

    private static final Integer PORT = 14002;


    /**
     *  存放所有的socket链接 其中有可能含有不能识别的设备
     */
    public static List<Socket> clients = new ArrayList<Socket>();


    public TcpServerTest() {
        new Thread(this).start();
    }


    /**
     * 开启 TCP 服务
     */
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            LOGGER.info("服务器启动，端口：" + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                new Thread(new ListenerClient(socket));
                LOGGER.info("host address: {}", socket.getInetAddress().getHostAddress());
                LOGGER.info("clients size : {}", clients.size());
            }
        } catch (IOException e) {
            LOGGER.info("服务器停止，端口：" + PORT);
            e.printStackTrace();
        }
    }

}

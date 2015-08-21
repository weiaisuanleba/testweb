package server.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo1 on 2015/8/11.
 * <p>
 * socket 仓库，存放所有 设备的 socket连接   单例模式
 */
public class SocketStore {

    /**
     * socket  集合，key 暂时使用 产品编号 modelNumber
     */
    public static final Map<String, Socket> SOCKET_MAP = new HashMap<String, Socket>();

    private SocketStore() {
    }


    /**
     * 根据socket 发送信息
     *
     * @param socket  socket
     * @param message 信息
     * @return 是否成功
     */
    public static boolean sendMessage(Socket socket, String message) {

        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());
            outputStream.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}

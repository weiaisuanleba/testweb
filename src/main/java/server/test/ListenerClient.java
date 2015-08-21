package server.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/*这个类是服务器端的等待客户端发送信息*/
public class ListenerClient extends Thread {
    private static final Logger LOGGER = LoggerFactory.getLogger(TcpClientTest.class);

    private PrintWriter writer;
    private Socket client;
    private List<Socket> clients = TcpServerTest.clients;
    private Map<String, Socket> socketMap = SocketStore.SOCKET_MAP;

    public ListenerClient(Socket client) {
        this.client = client;
        this.start();
    }

    // 为每一个客户端创建线程等待接收信息，然后把信息广播出去
    public void run() {
        try (InputStream input = client.getInputStream()) {
            while (true) {
                /* 暂定长度 后续修改 */
                byte[] buf = new byte[1024];
                int len = input.read(buf);
                if (len < 0) {
                    LOGGER.info("disconnect: {}", client);
                    clients.remove(client);
                    client.close();
                    break;
                }
                String msg = new String(buf, 0, len);
                if (msg.matches("modelnumber=.*")) {
                    this.putSocketMap(msg);
                }else {
                    sendMsg(msg);
                }
                LOGGER.info("client massage: {}", msg);
            }
        } catch (IOException e) {
            LOGGER.error("client read error : {}", e.toString());
        }
    }


    /**
     *  判断 该 socket 是否为 已拥有的产品 如果有就保存到 socketMap 中
     *  读数据库后续实现
     *
     * @param msg  设备编号请求
     * @return 是否添加
     */
    private boolean  putSocketMap(final String msg){
        String[] strings = msg.split("=");
        String modelNumber = strings[1];
        socketMap.put(modelNumber, client);
        clients.remove(client);
        LOGGER.info("socketMap size: {}", socketMap.size());
        return true;
    }


    // 把信息广播到所有用户
    public synchronized void sendMsg(String msg) {
        try {
            for (int i = 0; i < clients.size(); i++) {
                Socket client = clients.get(i);
                writer = new PrintWriter(client.getOutputStream(), true);
                writer.println(msg);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
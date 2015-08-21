package other.test;

import server.test.TcpServerTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/*这个类是服务器端的等待客户端发送信息*/
public class ListenerClient extends Thread {
    BufferedReader reader;
    PrintWriter writer;
    Socket client;
    List<Socket> clients = TcpServerTest.clients;

    public ListenerClient(Socket client) {
        this.client = client;
        this.start();
    }

    // 为每一个客户端创建线程等待接收信息，然后把信息广播出去
    public void run() {
        String msg = "";
        while (true) {
            try {
                InputStream input = client.getInputStream();
                System.out.println();

                byte[] buf = new byte[1024];
                int len = input.read(buf);
                System.out.println(client);
                System.out.println(len);
                if (len < 0) {
                    clients.remove(client);
                    client.close();
                    break;
                }
                msg = new String(buf, 0, len);
                System.out.println(msg);
                sendMsg(msg);

            } catch (IOException e) {
                System.out.println(e.toString());
                break;
            }
        }
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
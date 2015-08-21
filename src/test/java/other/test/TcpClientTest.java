package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientTest {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("222.187.129.134", 8080);
            // 向服务器端发送数据
            OutputStream os = socket.getOutputStream();
            os.write("test".getBytes());

            // 接收服务器端数据
            InputStream is = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = is.read(buf);
            System.out.println(new String(buf, 0, len));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

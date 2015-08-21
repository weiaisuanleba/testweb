package web.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.test.SocketStore;
import web.test.pojo.Product;

import java.net.Socket;

/**
 * Created by WK on 2015/8/16.
 */
@RestController
@RequestMapping("/operator")
public class SocketController {

    @RequestMapping("/send")
    public boolean list(Product product, String operator) {
        Socket socket = SocketStore.SOCKET_MAP.get(product.getModelNumber());
        if (socket == null) {
            return false;
        }
        String message = "";
        if ("true".equals(operator)) {
            message="ESPKLED1";
        } else if ("false".equals(operator)) {
            message="ESPGLED1";
        }
        SocketStore.sendMessage(socket, message);
        return false;
    }

}

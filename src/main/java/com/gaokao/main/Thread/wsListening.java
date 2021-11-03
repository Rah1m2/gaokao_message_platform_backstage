package com.gaokao.main.Thread;

import com.gaokao.main.POJO.User;
import com.gaokao.main.WebSocket.HeartbeatEndPoint;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.websocket.WebSocketContainer;
import java.util.Map;

@Component
@Order(value = 1)
public class wsListening implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        System.out.println("test thread.");
        HeartbeatEndPoint heartbeatEndPoint;
//        for (Map<String, Object> onlineUser : HeartbeatEndPoint.onlineUsers) {
////            User user = (User) onlineUser.get("user");
//
//        }
    }
}
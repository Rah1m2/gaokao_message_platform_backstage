package com.gaokao.main.Listener;

import com.gaokao.main.VO.UserAnaly;
import com.gaokao.main.WebSocket.HeartbeatEndPoint;

import java.io.IOException;
import java.util.Map;
import java.util.TimerTask;

public class SendMsg extends TimerTask {

    public void run() {
        System.out.println("thread processing...");
        HeartbeatEndPoint heartbeatEndPoint;
        for (Map.Entry<UserAnaly, HeartbeatEndPoint> entry : HeartbeatEndPoint.onlineUsers.entrySet()) {
            heartbeatEndPoint = entry.getValue();
            heartbeatEndPoint.onlineTime += 15;
            try {
                heartbeatEndPoint.sendInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

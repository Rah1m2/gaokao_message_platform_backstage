package com.gaokao.main.Listener;

import com.gaokao.main.VO.UserAnaly;
import com.gaokao.main.WebSocket.HeartbeatEndPoint;

import java.io.IOException;
import java.util.Map;
import java.util.TimerTask;

public class PushMsg extends TimerTask {

    private HeartbeatEndPoint heartbeatEndPoint;

    public PushMsg(HeartbeatEndPoint heartbeatEndPoint) {
        this.heartbeatEndPoint = heartbeatEndPoint;
    }

    public void run() {
        System.out.println("tips: thread processing...");
        try {
            heartbeatEndPoint.sendInfo();
        } catch (IOException e) {
            System.out.println("信息发送异常。");
            e.printStackTrace();
        }
    }

}


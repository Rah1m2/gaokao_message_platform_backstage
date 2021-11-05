//package com.gaokao.main.Thread;
//
//import com.gaokao.main.POJO.User;
//import com.gaokao.main.WebSocket.HeartbeatEndPoint;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.WebSocketContainer;
//import java.io.IOException;
//import java.util.Map;
//
//@Component
//@EnableAsync
//@Order(value = 1)
//public class wsListening implements InitializingBean {
//
//    private ThreadPoolTaskExecutor taskExecutor;
//
//    @Autowired
//    public wsListening(ThreadPoolTaskExecutor taskExecutor) {
//        this.taskExecutor = taskExecutor;
//    }
//
//    @Async("taskExecutor")
//    public void afterPropertiesSet() {
//
//        taskExecutor.execute(new Runnable() {
//             public void run() {
//                System.out.println("test thread.");
//                HeartbeatEndPoint heartbeatEndPoint;
//                for (Map.Entry<String, HeartbeatEndPoint> entry : HeartbeatEndPoint.onlineUsers.entrySet()) {
//                    String user_id = entry.getKey();
//                    heartbeatEndPoint = entry.getValue();
//                    try {
//                        heartbeatEndPoint.sendInfo();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//             }
//        });
//
////        WsThread wsThread = new WsThread();
////        Thread thread = new Thread(wsThread, "wsThread");
////        System.out.println("test");
////        thread.start();
//
//    }
//
//
//}
//
////class WsThread implements Runnable {
////
////    public void run() {
////        System.out.println("test thread.");
////        HeartbeatEndPoint heartbeatEndPoint;
////        for (Map.Entry<String, HeartbeatEndPoint> entry : HeartbeatEndPoint.onlineUsers.entrySet()) {
////            String user_id = entry.getKey();
////            heartbeatEndPoint = entry.getValue();
////            try {
////                heartbeatEndPoint.sendInfo();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////        try {
////            Thread.sleep(200);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////    }
////
////}
//
////class testFor implements Runnable{
////
////    private List<String> list;
////
////    private Map<String, String> map;
////
////    public testFor(List<String> list, Map<String, String> map) {
////        this.list = list;
////        this.map = map;
////    }
////
////    @Override
////    public void run() {
////        for (int i = 0; i < list.size(); i++) {
////            System.out.println(Thread.currentThread().getName()+"="+list.get(i));
////            map.put(Thread.currentThread().getName()+ "----" + i, list.get(i));
////        }
////    }
////}
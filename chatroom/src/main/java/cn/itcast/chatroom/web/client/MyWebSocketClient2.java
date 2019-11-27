package cn.itcast.chatroom.web.client;

import cn.itcast.chatroom.domain.Message;
import cn.itcast.chatroom.domain.User;
import cn.itcast.utils.GsonUtils;
import org.apache.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyWebSocketClient2 extends WebSocketClient {
    public MyWebSocketClient2(URI serverUri, Draft_6455 draft_6455, Map<String, String> headers, int connectTimeOut) {
        super(serverUri, draft_6455, headers, connectTimeOut);
    }

    public static Logger logger = Logger.getLogger(MyWebSocketClient2.class);

    @Override
    public void onOpen(ServerHandshake serverHandshake) {

        System.out.println("onOpen.....");

    }

    /*
    服务端发送过来的消息
     */
    @Override
    public void onMessage(String s) {
        System.out.println("onMessage....." + s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("onClose...." + i + "-----" + s + "-----" + b);
    }

    @Override
    public void onError(Exception e) {
        System.out.println("onError");
    }

    public static void main(String[] args) throws URISyntaxException, InterruptedException {


        String userName="www";
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", "JSESSIONID=1345391D0C50435F6E0896F28759C769");
        User user = new User();
        user.setNickname(userName);
        headers.put("loginUser",GsonUtils.toJson(user));
        MyWebSocketClient2 client = new MyWebSocketClient2(new URI("ws://127.0.0.1:8080/chatroom/ws"), new Draft_6455(), headers, 10000);
        if (client == null) {
            logger.error("client is null");
            return;
        }
        client.connect();
        while (!client.getReadyState().equals(READYSTATE.OPEN)) {
            Thread.sleep(3000);
            System.out.println("正在连接...");
        }
        System.out.println("连接成功...");

        //连接成功,发送信息
        Message message = new Message();
        message.setDate(new Date());
        message.setText("aaa,你好");
        message.setFromName(userName);
        message.setFrom(userName);
        message.setTo("aaa");
        while (true) {
            Thread.sleep(3000);
            System.out.println(userName+"--- send message...");
            client.send(GsonUtils.toJson(message));
        }
    }

}

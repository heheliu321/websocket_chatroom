
1.本文使用内置的tomcat 访问地址http://localhost:8080/chatroom/chat/login
websocket地址--->ws://127.0.0.1:8080/chatroom/ws
MyWebSocketClient client = new MyWebSocketClient(new URI("ws://127.0.0.1:8080/chatroom/ws"), new Draft_6455(), headers, 10000);
2.使用用户aaa和www分别登录，获取到头域Cookie: JSESSIONID=9BED8BA56B6BE0E92777C743979F2B30和Cookie: JSESSIONID=9BED8BA56B6BE0E92777C743979F2B30
3.填写到这里       
            String userName="aaa";
            Map<String, String> headers = new HashMap<>();
            headers.put("Cookie", "JSESSIONID=6CD7248AD419C7DFDC696FA01C28A467");
4.可以实现两个用户互相发消息

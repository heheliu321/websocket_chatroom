### 1.访问方式

本文使用内置的tomcat 访问地址web http://localhost:8080/chatroom/

websocket地址--->ws://127.0.0.1:8080/chatroom/ws
MyWebSocketClient client = new MyWebSocketClient(new URI("ws://127.0.0.1:8080/chatroom/ws"), new Draft_6455(), headers, 10000);
（注意new Draft_6455()是必不可少的）

### 2.客户端登录运行

使用用户aaa和www分别登录，获取到头域Cookie: JSESSIONID=9BED8BA56B6BE0E92777C743979F2B30和Cookie: JSESSIONID=9BED8BA56B6BE0E92777C743979F2B30
注意

MyWebSocketClient

```
        String userName="aaa";
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", "JSESSIONID=6CD7248AD419C7DFDC696FA01C28A467");
```

```
MyWebSocketClient2
```

```
        String userName="www";
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", "JSESSIONID=1345391D0C50435F6E0896F28759C769");
```



### 3.可以实现两个用户互相发消息


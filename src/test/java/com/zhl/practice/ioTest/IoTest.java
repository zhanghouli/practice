package com.zhl.practice.ioTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-09-04 10:44
 **/
public class IoTest {

    public static void main(String[] args) {
        DemoServer demoServer = new IoTest().new DemoServer();
        demoServer.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(), demoServer.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class DemoServer extends Thread {

        private ServerSocket serverSocket;

        public int getPort(){
            return serverSocket.getLocalPort();
        }

        @Override
        public void run() {
            try{
                // 端口0表示自动绑定一个空闲端口
                serverSocket = new ServerSocket(0);
//                while (true) {
//                    // 调用accept方法，阻塞等待客户端连接
//                    Socket socket = serverSocket.accept();
//                    // 建立连接后，启动一个单独线程负责回复客户端请求
//                    RequestHandler requestHandler = new RequestHandler(socket);
//                    requestHandler.start();
//                }
                 // 使用线程池来避免不断创建新线程造成的浪费
                ExecutorService executor = Executors.newFixedThreadPool(8);
                while (true) {
                    Socket socket = serverSocket.accept();
                    RequestHandler requestHandler = new RequestHandler(socket);
                    executor.execute(requestHandler);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

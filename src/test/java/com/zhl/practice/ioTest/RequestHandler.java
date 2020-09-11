package com.zhl.practice.ioTest;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-09-04 10:49
 **/
public class RequestHandler extends Thread{

    private Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("Hello world !");
            printWriter.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

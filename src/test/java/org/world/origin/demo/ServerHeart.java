package org.world.origin.demo;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年9月30日
 * *********************************************
 * </pre>
 */
public class ServerHeart extends Thread{

	private ServerSocket server = null;
    Object obj = new Object();

    @Override
    public void run() {
        try {
            server = new ServerSocket(9090);

            while (true) {
                Socket client = server.accept();
                synchronized (obj) {
                    new Thread(new Client(client)).start();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 客户端线程
     * 
     * @author USER
     *
     */
    class Client implements Runnable {
        Socket client;

        public Client(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    ObjectInput in = new ObjectInputStream(client.getInputStream());
                    Demo entity = (Demo) in.readObject();
                    System.out.println(entity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 程序的入口main方法
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("开始检测客户端是否在线...");
        new ServerHeart().start();
    }
}

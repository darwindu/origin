package org.world.origin.demo;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
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
public class ClientSender {

	private ClientSender() {}

    Socket sender = null;
    private static ClientSender instance;

    public static ClientSender getInstance() {
        if (instance == null) {
            synchronized (ClientHeart.class) {
                instance = new ClientSender();
            }
        }
        return instance;
    }

    public void send() {
        try {
            sender = new Socket(InetAddress.getLocalHost(), 9090);
            while (true) {
                ObjectOutputStream out = new ObjectOutputStream(sender.getOutputStream());
                Demo obj = new Demo();
                obj.setName("xiaoming");
                obj.setSex("男");
                out.writeObject(obj);
                out.flush();

                System.out.println("已发送...");
                Thread.sleep(5000);
            }
        } catch (Exception e) {

        }
    }
}

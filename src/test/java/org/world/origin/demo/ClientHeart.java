package org.world.origin.demo;

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
public class ClientHeart extends Thread{

	@Override
    public void run() {

        try {
            while (true) {
                ClientSender.getInstance().send();
                synchronized (ClientHeart.class) {
                    // this.wait(5000);
                    Thread.sleep(2000);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 程序的入口main方法
     * 
     * @param args
     */
    public static void main(String[] args) {
        ClientHeart client = new ClientHeart();
        client.start();
    }
}

package org.world.origin.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * ECDSA: 椭圆曲线数字签名算法（Elliptic Curve Digital Signatrue Algorithm）
 * 特点：速度快，强度高，签名短
 * 参考：https://blog.csdn.net/lovelichao12/article/details/75007189/
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2018年5月17日
 * *********************************************
 * </pre>
 */
public class SecurityECDSA {
	private static String src = "imooc security ecdsa";  
	  
    public static void main(String[] args) {  
        jdkECDSA();  
    }  
      
    public static void jdkECDSA() {  
        try {  
            //1.初始化密钥  
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");  
            keyPairGenerator.initialize(256);  
            KeyPair keyPair = keyPairGenerator.generateKeyPair();  
            ECPublicKey ecPublicKey = (ECPublicKey)keyPair.getPublic();  
            ECPrivateKey ecPrivateKey = (ECPrivateKey)keyPair.getPrivate();  
              
            //2.执行签名  
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());  
            KeyFactory keyFactory = KeyFactory.getInstance("EC");  
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);  
            Signature signature = Signature.getInstance("SHA1withECDSA");  
            signature.initSign(privateKey);  
            signature.update(src.getBytes());  
            byte[] result = signature.sign();  
            System.out.println("jdk ecdsa sign : " + Hex.encodeHexString(result));  
              
            //3.验证签名  
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());  
            keyFactory = KeyFactory.getInstance("EC");  
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);  
            signature = Signature.getInstance("SHA1withECDSA");  
            signature.initVerify(publicKey);  
            signature.update(src.getBytes());  
            boolean bool = signature.verify(result);  
            System.out.println("jdk ecdsa verify : " + bool);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
    }  
}

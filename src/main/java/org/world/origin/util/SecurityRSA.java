package org.world.origin.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;


/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:   
 * RSA是目前最有影响力的公钥加密算法，它能够抵抗到目前为止已知的绝大多数密码攻击，已被ISO推荐为公钥数据加密标准。
 * 特性：安全性抗和否认性
 * 主要包括两类：MD、SHA
 * 参考：https://blog.csdn.net/lovelichao12/article/details/75007189/
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2018年5月17日
 * *********************************************
 * </pre>
 */
public class SecurityRSA {
	
	private static String src = "imooc security rsa";  
	  
    public static void main(String[] args) {  
        jdkRSA();  
    }  
      
    public static void jdkRSA() {  
        try {  
            //1.初始化密钥  
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");  
            keyPairGenerator.initialize(512);  
            KeyPair keyPair = keyPairGenerator.generateKeyPair();  
            RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();  
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();  
              
            //2.执行签名  
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());  
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);  
            Signature signature = Signature.getInstance("MD5withRSA");  
            signature.initSign(privateKey);  
            signature.update(src.getBytes());  
            byte[] result = signature.sign();  
            System.out.println("jdk rsa sign : " + Hex.encodeHexString(result));  
              
            //3.验证签名  
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());  
            keyFactory = KeyFactory.getInstance("RSA");  
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);  
            signature = Signature.getInstance("MD5withRSA");  
            signature.initVerify(publicKey);  
            signature.update(src.getBytes());  
            boolean bool = signature.verify(result);  
            System.out.println("jdk rsa verify : " + bool); 
            
            Provider[] ps = Security.getProviders();
            for(Provider p : ps) {
            	System.out.println("p:" + p.getName());
            	System.out.println("info:" + p.getInfo());
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}

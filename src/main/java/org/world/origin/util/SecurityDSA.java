package org.world.origin.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * DSA是Schnorr和ElGamal签名算法的变种，被美国NIST作为DSfS(DigitalSignature Standard)。
 * DSA是基于整数有限域离散对数难题的，其安全性与RSA相比差不多。DSA的一个重要特点是两个素数公开，这样，当使用别人的p和q时，即使不知道私钥，你也能确认它们是否是随机产生的，还是作了手脚。RSA却做不到。
 * DSA仅包含数字签名
 * 参考：https://blog.csdn.net/lovelichao12/article/details/75007189/
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2018年5月17日
 * *********************************************
 * </pre>
 */
public class SecurityDSA {
	private static String src = "imooc security dsa";  
	  
    public static void main(String[] args) {  
        jdkDSA();  
    }  
      
    public static void jdkDSA() {  
        try {  
            //1.初始化密钥  
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");  
            keyPairGenerator.initialize(512);  
            KeyPair keyPair = keyPairGenerator.generateKeyPair();  
            DSAPublicKey dsaPublicKey = (DSAPublicKey) keyPair.getPublic();  
            DSAPrivateKey dsaPrivateKey = (DSAPrivateKey)keyPair.getPrivate();  
              
            //2.执行签名  
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(dsaPrivateKey.getEncoded());  
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");  
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);  
            Signature signature = Signature.getInstance("SHA1withDSA");  
            signature.initSign(privateKey);  
            signature.update(src.getBytes());  
            byte[] result = signature.sign();  
            System.out.println("jdk dsa sign : " + Hex.encodeHexString(result));  
              
            //3.验证签名  
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(dsaPublicKey.getEncoded());  
            keyFactory = KeyFactory.getInstance("DSA");  
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);  
            signature = Signature.getInstance("SHA1withDSA");  
            signature.initVerify(publicKey);  
            signature.update(src.getBytes());  
            boolean bool = signature.verify(result);  
            System.out.println("jdk dsa verify : " + bool);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
}

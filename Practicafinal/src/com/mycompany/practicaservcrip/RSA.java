/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicaservcrip;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import static java.lang.System.out;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

public class RSA {

    public String cifrar(String llavePublicaBase64, String txt) {
        KeyFactory kf = null;
        try {
            kf = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Base64.Decoder decoder = Base64.getDecoder();
        Base64.Encoder encoder = Base64.getEncoder();
        
        X509EncodedKeySpec ks = new X509EncodedKeySpec(decoder.decode(llavePublicaBase64));
        Key pub = null;
        try {
            pub = kf.generatePublic(ks);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        Cipher rsa = null;
        try {
            rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsa.init(Cipher.ENCRYPT_MODE, pub);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] txtCifradoBytes = null;
        try {
            txtCifradoBytes = rsa.doFinal(txt.getBytes());
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        String txtCifrado = encoder.encodeToString(txtCifradoBytes);
        return txtCifrado;
    }

    public String descifrar(String llavePrivadaBase64, String txt) {
        KeyFactory kf = null;
        try {
            kf = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(decoder.decode(llavePrivadaBase64));
        PrivateKey pvt = null;
        try {
            pvt = kf.generatePrivate(ks);
        } catch (InvalidKeySpecException ex) {
            JOptionPane.showMessageDialog(null, "Llave invalida");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cipher rsa = null;
        try {
            rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Llave invalida");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            JOptionPane.showMessageDialog(null, "Llave invalida");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsa.init(Cipher.DECRYPT_MODE, pvt);
        } catch (InvalidKeyException ex) {
            JOptionPane.showMessageDialog(null, "Llave invalida");
            //JOptionPane.showMessageDialog(null, "Hash invalido");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] cifrado = null;
        try {
            cifrado = decoder.decode(txt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Llave invalida");
        }
        byte[] bytesDesencriptados = null;
        try {
            bytesDesencriptados = rsa.doFinal(cifrado);
        } catch (IllegalBlockSizeException ex) {
            JOptionPane.showMessageDialog(null, "Llave invalida");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            JOptionPane.showMessageDialog(null, "Llave invalida");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        String textoDesencripado = new String(bytesDesencriptados);
        return textoDesencripado;
    }
}

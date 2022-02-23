/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicaservcrip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public final class AES {

    public  String IV = "AAAAAAAAAAAAAAA";
    public  String key = "1234567812345678";
    public  String modoOperacion = "CBC";
    public  String nameFile = "";
    public  String path = "";
    public  String pathDest = "";
    public  int width;
    public  int height;
    public  int tamanioFinal;
    /**
     * Solution sample in main.
     *
     * @param args ignored args
     */
    public SecretKeySpec getSKey(String myKey) throws UnsupportedEncodingException {
        SecretKeySpec key = new SecretKeySpec(myKey.getBytes("UTF-8"), "AES");
        return key;
    }

    public boolean modoValido(String modo) {
        if (modo.equals("ECB") || modo.equals("CBC") || modo.equals("CFB") || modo.equals("OFB") || modo.equals("CTR")) {
            return true;
        }
        return false;
    }

    public  String getModoOperacion() {
        String res = "AES/" + modoOperacion + "/PKCS5Padding";
        return res;
    }
    
    public  String getName(String name) {
        String res = "";
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == '.') {
                break;
            }
            res += name.charAt(i);
        }
        return res;
    }

    public  String getText(String path) throws FileNotFoundException, IOException {
        FileReader fr
                = new FileReader(path);

        int i;
        String res = "";
        while ((i = fr.read()) != -1) {
            res += (char)i;
            //System.out.print((char) i);
        }
        return res;
    }

    public  void crearTexto(String path,String txt){
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(txt);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String cifrar2(String txt) {
        try {
            SecretKeySpec secret_key = getSKey(key);
            String modoOperacion2 = modoOperacion;
            String modoOperacion = getModoOperacion();
            String txtPlano = txt;
            
            byte[] cipher = encrypt(secret_key, txtPlano.getBytes(), modoOperacion);
            //String pathDestAct = pathDest + "\\" + getName(nameFile) + modoOperacion2 + ".txt";
        
            //System.out.println(pathDestAct);
            Base64.Encoder encoder = Base64.getEncoder();
            String textoCifrado = encoder.encodeToString(cipher);
            return textoCifrado;
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JOptionPane.showMessageDialog(null, errors.toString());
        }
        return "mierda";
    }
    
    public void cifrar(String agregar) {
        try {
            SecretKeySpec secret_key = getSKey(key);
            String modoOperacion2 = modoOperacion;
            String modoOperacion = getModoOperacion();
            String txtPlano = getText(path);
            
            byte[] cipher = encrypt(secret_key, txtPlano.getBytes(), modoOperacion);
            String pathDestAct = pathDest + "\\" + getName(nameFile) + modoOperacion2 + ".txt";
        
            System.out.println(pathDestAct);
            Base64.Encoder encoder = Base64.getEncoder();
            String textoCifrado = encoder.encodeToString(cipher);
            
            if(agregar.length() >= 0){
                textoCifrado += '\n';
                textoCifrado += agregar;
            }
            crearTexto(pathDestAct, textoCifrado);
            JOptionPane.showMessageDialog(null, "Texto cifrado con exito");
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JOptionPane.showMessageDialog(null, errors.toString());
        }
    }

    public void decifrar(String txt) {
        try {
            SecretKeySpec secret_key = getSKey(key);
            String modoOperacion2 = modoOperacion;
            String modoOperacion = getModoOperacion();
            String txtCifradoBase64 = txt;
            
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] txtCifradoBytes = decoder.decode(txtCifradoBase64);
            
            byte[] decipher = decrypt(secret_key, txtCifradoBytes , modoOperacion);
            String pathDestAct = pathDest + "/" + getName(nameFile) + modoOperacion2 + ".txt";
            crearTexto(pathDestAct, new String(decipher));
            JOptionPane.showMessageDialog(null, "Texto descifrado con exito");

        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JOptionPane.showMessageDialog(null, errors.toString());
        }
    }
    
    public String decifrar2(String txt) {
        try {
            SecretKeySpec secret_key = getSKey(key);
            String modoOperacion2 = modoOperacion;
            String modoOperacion = getModoOperacion();
            String txtCifradoBase64 = txt;
            
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] txtCifradoBytes = decoder.decode(txtCifradoBase64);
            
            byte[] decipher = decrypt(secret_key, txtCifradoBytes , modoOperacion);
            return new String(decipher);

        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JOptionPane.showMessageDialog(null, errors.toString());
        }
        return "";
    }
    
    public byte[] encrypt(Key key, byte[] content, String modoOperacion) {
        Cipher cipher;
        byte[] encrypted = null;
        try {
            cipher = Cipher.getInstance(modoOperacion);
            if (modoOperacion.equals("AES/ECB/NoPadding")) {
                cipher.init(Cipher.ENCRYPT_MODE, key);
            } else {
                cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
            }
            encrypted = cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;

    }

    public byte[] decrypt(Key key, byte[] content, String modoOperacion) {
        Cipher cipher;
        byte[] decrypted = null;
        try {
            cipher = Cipher.getInstance(modoOperacion);
            if (modoOperacion.equals("AES/ECB/NoPadding")) {
                cipher.init(Cipher.DECRYPT_MODE, key);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
            }
            decrypted = cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypted;

    }

}

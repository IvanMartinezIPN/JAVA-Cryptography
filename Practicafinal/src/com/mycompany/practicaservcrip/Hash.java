/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicaservcrip;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Hash {

    String getHash(String value) {
        // With the java libraries
        String sha1 = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sha1;

    }
    String getTxtSinHash(String txt){
        String res = "";
        for(int i = 0; i < txt.length()-40; i++){
            res += txt.charAt(i);
        }
        return res;
    }
    String getTxtHash(String txt){
        String res = "";
        for(int i = txt.length()-40; i < txt.length(); i++){
            res += txt.charAt(i);
        }
        return res;
    }
    boolean compare(String txt,String hash){
        //System.out.println(getTxtSinHash(txt));
        //System.out.println(getTxtHash(txt));
        String h1 = getHash(txt);
        System.out.println("Hash: " +h1);
        if(h1.equals(hash))return true;
        return false;
    }
}

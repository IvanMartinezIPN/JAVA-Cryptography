/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicaservcrip;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Files {

    String getText(String path,boolean ultima) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(path)); 
        String st; 
        String res = "";
        ArrayList<String> lineas = new ArrayList<String>();
        while ((st = br.readLine()) != null) {
            System.out.println(st + " " + st.length());
            lineas.add(st);
        }
        int fin = lineas.size();
        if(ultima == false){
            fin--;
        }
        for(int i = 0; i < fin; i++){
            for(int j = 0; j < lineas.get(i).length(); j++){
                res += lineas.get(i).charAt(j);
            }
            if(i != fin-1){
                res += '\n';
            }
        }
        return res;
    }
    String getHashCifrado(String path) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(path)); 
        String st; 
        String res = null;
        while ((st = br.readLine()) != null) {
            res = st;
        }
        return res;
    }
    public String getName(String name){
        String res = "";
        for(int i = 0; i < name.length(); i++){
            if(name.charAt(i) == '.')break; 
            res += name.charAt(i);
        }
        return res;
    }
    void create(String path, String name, String txt) {
        name = getName(name);
        name += "_hash.txt";
        path += "\\"+name;
        System.out.println(path);
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(txt);
            myWriter.close();
            JOptionPane.showMessageDialog(null, "Archivo creado en: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

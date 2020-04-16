
package wallet_1;

/**
 *
 * @author Santacruz
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.*;


import javax.management.RuntimeErrorException;

import java.security.MessageDigest;


class wallet{
    public static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        String seed = "";
        tema("Bienvenido");
        tema("wallet");
        seed = leer.next();
        System.out.println(seed + " " + retornasha256(seed));
        String hash = retornasha256(seed);
        documento(hash+".txt",seed);
    }
    public static String retornasha256(String semilla) {
        try {
            MessageDigest codificacion = MessageDigest.getInstance("SHA-256");
            byte [] hash = codificacion.digest(semilla.getBytes("utf-8"));
            StringBuffer Hexa = new StringBuffer();
            
            for(int i =0; i< hash.length; i++){
                String CodHexa = Integer.toHexString(0xff & hash[i]);
                if(CodHexa.length() == 1) Hexa.append('0');
                Hexa.append(CodHexa);
            }
            return Hexa.toString();

        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }  
    }
    
    public static void documento(String wallet, String informacion){
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        
        try{
            f = new File(wallet);
            w =  new FileWriter(f);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);
            
            wr.append(informacion);
            
        }catch (Exception e){
            System.out.println("Ocurrio un error");
        }
    }
    
    public static void tema(String tema) {
        System.out.println("|-----------------------|\n|      " + tema + "     |\n|-----------------------|");
    }*/
}

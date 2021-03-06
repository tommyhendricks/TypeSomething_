/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Tommy Hendricks
 */
public class PromptGetter {
    private static String stringToReturn;

    public PromptGetter(){
        stringToReturn = "temp";
    }
    
    private static void getPromptFromAPI(){
        do{
            try{ 
                URL oracle = new URL("https://api.quotable.io/random?minLength=100");        
                URLConnection yc = oracle.openConnection();        
                InputStream inStream = yc.getInputStream();        
                InputStreamReader inStreamReader = new InputStreamReader(inStream);        
                BufferedReader in = new BufferedReader(inStreamReader);        
                String inputLine;        
                StringBuilder sb = new StringBuilder();        

                while ((inputLine = in.readLine()) != null){                        
                    sb.append(inputLine);            
                    sb.append("\n");        }        
                in.close();        

                String myJsonData = sb.toString();
                JsonElement jelement = new JsonParser().parse(myJsonData);
                JsonObject jobject = jelement.getAsJsonObject();
                stringToReturn = jobject.get("content").toString();
//              
//                JsonArray jarray = jobject.getAsJsonArray("quotes");
//                JsonElement firstIndex = jarray.get(0);
//                jobject = firstIndex.getAsJsonObject();
               
                }
            catch(Exception e){
                // TODO: Produce useful error messages for the user
                e.printStackTrace();
            }
        }while(!(stringToReturn.length() < 300));
    }
    
    public static String getPrompt(){
        getPromptFromAPI();
        //return "123456789";
        return stringToReturn;
    }
    
    
}

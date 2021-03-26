/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
    private String stringToReturn;

    public PromptGetter(){
        try{ 
            URL oracle = new URL("http://api.icndb.com/jokes/random?limitTo=nerdy");        
            URLConnection yc = oracle.openConnection();        
            InputStream inStream = yc.getInputStream();        
            InputStreamReader inStreamReader = new InputStreamReader(inStream);        
            BufferedReader in = new BufferedReader(inStreamReader);        
            String inputLine;        
            StringBuilder sb = new StringBuilder();        
            
            while ((inputLine = in.readLine()) != null){            
                System.out.println(inputLine);            
                sb.append(inputLine);            
                sb.append("\n");        }        
            in.close();        
            
            JsonParser jp = new JsonParser();        
            JsonElement root = jp.parse(sb.toString());        
            JsonObject objRoot = root.getAsJsonObject();        
            JsonElement valueElem = objRoot.get("value");        
            JsonObject objValue = valueElem.getAsJsonObject();        
            JsonElement joke = objValue.get("joke");        
            System.out.println(joke.getAsString());
            this.stringToReturn = joke.getAsString();
            }
        catch(Exception e){
            // TODO: Produce useful error messages for the user
            e.printStackTrace();
        }
    }
    
    public String getPrompt(){
       
        return this.stringToReturn;
    }
    
    
}

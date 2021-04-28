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
    private String stringToReturn;

    public PromptGetter(){
        this.getPromptFromAPI();
    }
    
    public void getPromptFromAPI(){
        do{
            try{ 
                URL oracle = new URL("https://opinionated-quotes-api.gigalixirapp.com/v1/quotes?rand=t&author?rand=t&tmode?rand=t");        
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

                String myJsonData = sb.toString();
                JsonElement jelement = new JsonParser().parse(myJsonData);
                JsonObject jobject = jelement.getAsJsonObject();
                JsonArray jarray = jobject.getAsJsonArray("quotes");
                JsonElement firstIndex = jarray.get(0);
                jobject = firstIndex.getAsJsonObject();
                this.stringToReturn = jobject.get("quote").toString();
                }
            catch(Exception e){
                // TODO: Produce useful error messages for the user
                e.printStackTrace();
            }
        }while(!(this.stringToReturn.length() < 200));
    }
    
    public String getPrompt(){
        //return "This is the test prompt I hope that you like it. This is the second sentence. This is the third one.";
        //return "the short test one";
        return this.stringToReturn;
    }
    
    
}

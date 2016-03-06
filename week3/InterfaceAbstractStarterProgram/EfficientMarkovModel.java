
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel{

    private int myN;
    private HashMap<String,ArrayList<String>> text;
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
 public   EfficientMarkovModel(int N){
     
     myN=N;
     text = new HashMap<String,ArrayList<String>>();
     
    }
    
    public String toString(){
        
       return "this is order of "+ this.myN;
}

public ArrayList<String> buildMap(String key){
               int pos = 0;
               ArrayList<String> follows= new ArrayList<String>();
               while(myText.indexOf(key,pos)!=-1){
            
            
                    pos=myText.indexOf(key,pos)+key.length();
                    if(myText.length()<pos+1)break;
                    follows.add(myText.substring(pos,pos+1));    
                
              
               }
               text.put(key,follows);
               
               return follows;
     
    
}

public String getRandomText(int numChars){
        
        StringBuffer sb =  new StringBuffer();
        int index = myRandom.nextInt(myText.length()-myN);
        String key = myText.substring(index,index+myN);
        sb.append(key);
        for(int k=0; k < numChars-myN; k++){
            
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){
                break;
              }
              
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        
        //printHashMapInfo();
        return sb.toString();
    }
    
    protected ArrayList<String> getFollows(String key){
   
        
            if (text.containsKey(key)) {
               // Okay, there's a key but the value is null
               return text.get(key);
            } else {
               // Definitely no such key
               return buildMap(key);
               
            }
        
       //return follows;
    }
    
    public void printHashMapInfo(){
        
        System.out.println("hashmap: "+text.toString());
        System.out.println("hasmap size: "+text.size());
        
        String maxKey = null;
        ArrayList<String> maxValue = new ArrayList<String>();
        int maxLen = 0;
        
        for (Entry<String, ArrayList<String>> e : text.entrySet()) {
            int len = e.getValue().size();
        
            if (len > maxLen) {
                //maxKey = e.getKey();
                maxLen = len;
                //maxValue = e.getValue();
            }
        }
        
        for (Entry<String, ArrayList<String>> e : text.entrySet()) {
            int len = e.getValue().size();
        
            maxKey = e.getKey();
            if ( len == maxLen) {
                
                
                maxValue.add(maxKey);
            }
        }
        
        System.out.println("max hash: length: "+ maxLen +" maxKeys: " +maxValue.toString());
        
        
    }

}
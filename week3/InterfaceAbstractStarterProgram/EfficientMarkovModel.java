
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel{

    private int myN;
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public String toString(){
        
       return "this is order of ";
}

public void buildMap(){
    
     HashMap<String,ArrayList> text = new HashMap();
    
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
        
        return sb.toString();
    }
    
        protected ArrayList<String> getFollows(String key){
	    int pos=0;
	    ArrayList<String> follows= new ArrayList<String>();
	    
	    while(myText.indexOf(key,pos)!=-1){
    	    
            
	        pos=myText.indexOf(key,pos)+key.length();
	        if(myText.length()<pos+1)break;
	        follows.add(myText.substring(pos,pos+1));	 
	        
    	  
    	}
	   return follows;
	}
	
	public void method printHashMapInfo(){
	    
	    
	    
	   }

}
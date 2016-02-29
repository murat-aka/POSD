
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
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

}

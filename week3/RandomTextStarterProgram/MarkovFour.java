
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import java.util.*;

public class MarkovFour {
private String myText;
	private Random myRandom;
	
	public MarkovFour() {
		myRandom = new Random();
	}
	
	public ArrayList<String> getFollows(String key){
	    int pos=0;
	    ArrayList<String> follows= new ArrayList<String>();
	    
	    while(myText.indexOf(key,pos)!=-1){
    	    
            
	        pos=myText.indexOf(key,pos)+key.length();
	        if(myText.length()<pos+1)break;
	        follows.add(myText.substring(pos,pos+1));	 
	        
    	  
    	}
	   return follows;
	}
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
		
		StringBuffer sb =  new StringBuffer();
		int index = myRandom.nextInt(myText.length()-4);
		String key = myText.substring(index,index+4);
		sb.append(key);
		for(int k=0; k < numChars-4; k++){
			
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
}


/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.util.Random;
import java.util.*;

public class MarkovModel  extends AbstractMarkovModel{

	private int myN;
	
	public MarkovModel(int N) {
		myRandom = new Random();
		myN = N;
	}

	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
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
}

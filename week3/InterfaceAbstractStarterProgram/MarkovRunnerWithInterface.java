
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		int seed = 42;
		
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size,seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size,seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size,seed);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size,seed);
        
        
        size=50;
        st = "yes-this-is-a-thin-pretty-pink-thistle";
        st.replace('\n', ' ');
        EfficientMarkovModel mEff = new EfficientMarkovModel(2);
        runModel(mEff,st,size,seed);

    }

	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
	
	public void compareMethods(){
	    
	    FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 1000;
		int seed = 42;
		
        
		long start1 = System.nanoTime();
		//System.out.println("time: "+System.nanoTime());
        MarkovModel mThree = new MarkovModel(2);
        runModel(mThree, st, size,seed);
      
        
        long start2 = System.nanoTime();
        System.out.println("time: "+(start2-start1));
        
        EfficientMarkovModel mEff = new EfficientMarkovModel(2);
        runModel(mEff,st,size,seed);
        
        long end = System.nanoTime();
	    System.out.println("time: "+ (end-start2));
	    
	    
	   }
	
}

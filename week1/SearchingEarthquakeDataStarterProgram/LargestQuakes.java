

/**
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.*;

public class LargestQuakes
{
    public int indexOfLargest(ArrayList<QuakeEntry> data){
        
        int maxIndex = 0;        
        
            for(int k=0; k<data.size() ;k++){
                
                if(data.get(k).getMagnitude()>data.get(maxIndex).getMagnitude()){
                  
                  maxIndex =k;   
                
                }
                              
            }
        
         return maxIndex;
        
    }
    
    
      public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        // TO DO
        

        for(int j=0; j<howMany ;j++){
           
            int minIndex = indexOfLargest(quakeData);
            for(int k=0; k<quakeData.size() ;k++){
                
                if(quakeData.get(k).getMagnitude()>quakeData.get(minIndex).getMagnitude()){
                  
                  minIndex =k;   
                
                }
                              
            }
        
            ret.add(quakeData.get(minIndex));
            quakeData.remove(minIndex); 
           
        }  
        
        return ret;
    }
    
        public void findLargetsQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());

        Location jakarta  = new Location(-6.211,106.845);

        ArrayList<QuakeEntry> close = getLargest(list,5);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            
            System.out.printf("%s\n",entry);
        }
        System.out.println("number found: "+close.size());
    }
    
}

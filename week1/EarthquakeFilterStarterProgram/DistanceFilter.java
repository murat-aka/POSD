
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter{
    
        
        private Location current; 
        private double distanceMax; 
    
    public DistanceFilter(Location loc, double max) { 
        current = loc;
        distanceMax = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return (qe.getLocation().distanceTo(current) <= distanceMax); 
    } 

}

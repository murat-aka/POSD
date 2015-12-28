import java.util.*;
import edu.duke.*;

public class EarthQuakeClient
{

    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }
    
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,String where,
    String phrase){
        
        
         ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
            // Starts with
        for(QuakeEntry qe : quakeData){
            
            if(where.equalsIgnoreCase("start"))
            {
                boolean  b = qe.getInfo().startsWith(phrase);  // true
                if(b)answer.add(qe);
            }
            
            // Ends with
            if(where.equalsIgnoreCase("end"))
            {
                boolean  b = qe.getInfo().endsWith(phrase);  // true
                if(b)answer.add(qe);
            }
            //b = string.endsWith("dam");             // true
            
            // Anywhere, including beginning
            if(where.equalsIgnoreCase("any"))
            {
                boolean  b = qe.getInfo().indexOf(phrase) >= 0;  // true
                if(b)answer.add(qe);
            }
           // b = string.indexOf("I am") >= 0;        // true
            
            // To ignore case, regular expressions must be used
        }
        
        return answer;
    }
    
      public void quakesByPhrase() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = filterByPhrase(parser.read(source),"any","Creek");
        System.out.println("read data for "+parser.read(source).size()+" quakes");
        //dumpCSV(list);
        for(QuakeEntry qe : list){ System.out.println(qe.toString());}
        System.out.println("found "+list.size()+" quakes that match the criteria");

    }
    
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,
    double minDepth, double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData){
            
            if(qe.getDepth() > minDepth && qe.getDepth() < maxDepth)answer.add(qe);
        }
        

        return answer;
    }
    
    public void quakesOfDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = filterByDepth(parser.read(source),-10000,-8000);
        System.out.println("read data for "+parser.read(source).size()+" quakes");
        //dumpCSV(list);
        for(QuakeEntry qe : list){ System.out.println(qe.toString());}
        System.out.println("found "+list.size()+" quakes that match the criteria");

    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData){
            
            if(qe.getMagnitude() > magMin)answer.add(qe);
        }
        

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData){
            
            if(qe.getLocation().distanceTo(from) < distMax)answer.add(qe);
        }

        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = filterByMagnitude(parser.read(source),5.0);
        System.out.println("read data for "+parser.read(source).size()+" quakes");
        //dumpCSV(list);
        for(QuakeEntry qe : list){ System.out.println(qe.toString());}
        System.out.println("found "+list.size()+" quakes that match the criteria");

    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);
        
        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);

        // TODO
        ArrayList<QuakeEntry> closeones = filterByDistanceFrom(list,1000000,city); 
        for(QuakeEntry qe : closeones){ System.out.println(qe.getLocation().distanceTo(city)/1000+" " +qe.getInfo());}
        System.out.println("found "+closeones.size()+" quakes");
        
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }
}

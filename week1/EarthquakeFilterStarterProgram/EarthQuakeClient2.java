import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2
{
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        return answer;
    } 
    
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilter maf= new MatchAllFilter();
        Filter f1 = new MagnitudeFilter(1.0,4.0);
        Filter f2 = new DepthFilter(-180000,-30000);
        Filter f3 = new PhraseFilter("any","o");
        maf.addFilter(f1);
        maf.addFilter(f2);
        maf.addFilter(f3);
        
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        
        dumpCSV(quakes);
        
        System.out.println("found: "+quakes.size());
        
        System.out.println(maf.getName());
        
    }
    
        public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilter maf= new MatchAllFilter();
        
        Filter f1 = new MagnitudeFilter(0.0,5.0);
        
        Location colorado = new Location (55.7308, 9.1153);
        Filter f2= new DistanceFilter(colorado,3000000);
        
        Filter f3 = new PhraseFilter("any","e");
        
        maf.addFilter(f1);
        maf.addFilter(f2);
        maf.addFilter(f3);
        
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        
        dumpCSV(quakes);
        
        System.out.println("found: "+quakes.size());
        
    }

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        EarthQuakeClient2 eqc = new EarthQuakeClient2(); 
        //Filter f = new MinMagFilter(4.0); 
        //Filter f = new MagnitudeFilter(3.5,4.5);
        Location tokyo = new Location (39.7392, -104.9903);
        Filter f= new DistanceFilter(tokyo,1000000);
        ArrayList<QuakeEntry> m8  = filter(list, f); 
        Filter f2 = new PhraseFilter("end","a");
        //Filter f2 = new DepthFilter(-55000,-20000);
        //ArrayList<QuakeEntry> m8  = filter(list, f2);
        ArrayList<QuakeEntry> m7  = filter(m8, f2); 
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } 
        
        System.out.println("found: "+m7.size());
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
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

}

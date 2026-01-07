import java.util.LinkedList;
import java.util.Queue;

public class Track {
    private int currentWeight, weightLimit;
    private String cityNameDestination;
    private Queue <CarTrain> myTrack;

    public Track(int weight, int limit, String destination){
        currentWeight = weight;
        weightLimit = limit;
        cityNameDestination = destination;
        myTrack = new LinkedList <CarTrain> ();
    }//end constructor

    public int getCurrentWeight(){
        return currentWeight;
    }//end getCurrentWeight

    public int getWeightLimit(){
        return weightLimit;
    }//end getWeightLimit

    public String toString(){

    }//end toS

    /*
    public boolean canAddCar(CarTrain car){
        if(currentWeight < weightLimit)
            return true;
    } //end canAddCar

    public void addCar(CarTrain car){

    }

    public void setMilesAfterInspection(){
        CarTrain.miles = 100;
    }
    
    
    */
    
}// end Track class
import java.util.LinkedList;
import java.util.Queue;

public class Track {
    private int currentWeight, weightLimit;
    private String cityNameDestination;
    private Queue <CarTrain> myTrack;

    public Track(){
        myTrack = new LinkedList <CarTrain> ();
    }//end constructor

    public Track(int weight){
        currentWeight = weight;
        myTrack = new LinkedList <CarTrain> ();
    }//end constructor

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
        return "This is track is going to " + cityNameDestination + "." + " It has a weight limit of " + weightLimit + ". The current weight of cars on this track is " + currentWeight + ".";
    }//end toString

    
    public boolean canAddCar(CarTrain car){
        if(currentWeight < weightLimit){
            if(currentWeight + car.getMiles() <= weightLimit){
                currentWeight += car.getWeight();
                return true;
            }//end if 
            else
                return false;              
        }//end nested if 
        else
            return false;          
    } //end canAddCar

    public void addCar(CarTrain car){
        myTrack.add(car);
    }//end addCar

    public void removeCar(CarTrain car) {
        myTrack.remove(car);
    }//end removeCar

    public void setMilesAfterInspection(){
        for(CarTrain car: myTrack){
            if(car.needsInspection())
                car.setMiles(100);
        }//end for each loop
    }//end setMilesAfterInspection

    public boolean isEmpty(){
        return myTrack.isEmpty();
    }//end isEmpty

    public CarTrain removeNextCar() {
        return myTrack.remove();
    }

}// end Track class
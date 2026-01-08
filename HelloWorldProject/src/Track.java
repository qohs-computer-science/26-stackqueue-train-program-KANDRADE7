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
        String print = "";
            print += myTrack.remove().getName() + "\n" + myTrack.remove().getProduct() +"\n" +
            car.getOrigin()+"\n"+car.getDestination()+"\n"+car.getWeight()
            +"\n"+car.getMiles();
        }//end for each loop
    }//end toString

    
    public boolean canAddCar(CarTrain car){
        if(currentWeight < weightLimit){
            if(currentWeight + car.getMiles() <= weightLimit)
                return true;
            else
                return false;              
        }//end nested if 
        else
            return false;          
    } //end canAddCar

    public void addCar(CarTrain car){
        myTrack.push(car);
    }//end addCar

    public void setMilesAfterInspection(){
        for(CarTrain car: myTrack){
            if(car.needsInspection())
                car.setMiles(100);
        }//end for each loop
    }//end setMilesAfterInspection
    
    

    
}// end Track class
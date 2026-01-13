public class CarTrain {
    private String name, product, origin, destination;
    private int weight, miles;

    public CarTrain(String id, String contents, String originCity, 
    String end, int ibs, int milesTravelled){
        name = id;
        product = contents;
        origin = originCity;
        destination = end ;
        weight = ibs;
        miles = milesTravelled;
    }//end constructor

    //engine constructor 
    public CarTrain(String id, String city){
        name = id; 
        destination = city;
    }//end constructor 

    public String getName(){
        return name;
    }//end getId

    public String getProduct(){
        return product;
    }//end getProduct 
 
    public String getOrigin(){
        return origin;
    }//end getOrigin

    public String getDestination(){
        return destination;
    }//end getDestination

    public int getWeight(){
        return weight;
    }// end getWeight

    public int getMiles(){
        return miles; 
    }//end getMiles

    public void setMiles (int newMiles){
        miles = newMiles; 
    }//end setMiles

    public boolean needsInspection(){
        return miles > 700; 
    }// end needsInspection

    public String toString(){
        if(product==null){
            return name + " leaving for " + destination + " with the following cars: ";
        }
        return name + "\ncontents=" + product + "\noriginCity=" + origin +
        "\ndestination=" + destination + " \nweight=" + weight + "\nmiles=" + miles;
    }//end toString

}// end CarTrain class

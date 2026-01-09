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
        if(miles > 700)
            return true;
        else 
            return false;
    }// end needsInspection

    public String toString(){
        return "contents=" + product + "\noriginCity=" + origin +
        "\ndestination=" + destination + " \nweight=" + weight + "\nmiles=" + miles;
    }//end toString

}// end CarTrain class

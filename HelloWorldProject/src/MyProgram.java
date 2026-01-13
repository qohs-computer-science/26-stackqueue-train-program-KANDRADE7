/*
Katherine Andrade
1/6/2026
Period 6 CP3
A train program that consists of a CarTrain and Track class. Uses queues to store and sort cars
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {
	public static int val = 0;
	public static void main(String[] args) {

		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
		
		//create tracks
		Track track0 = new Track(); //processing intially then sort
		Track track1 = new Track(); // queue for overweight cars. loop through and use setMilesAfterInspection
		Track trackA = new Track(0, limitTrackA, "Trenton");
		Track trackB = new Track(0, limitTrackB, "Charlotte");
		Track trackC = new Track(0, limitTrackC, "Baltimore");
		Track trackD = new Track(0);

		Scanner x = new Scanner(System.in);
		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();

			//process cars from text to track0
			while(!name.equals("END")) {
				if(name.indexOf("CAR") ==0){
					String id = name;
					String contents = x.nextLine();
					String origin = x.nextLine();
					String destination = x.nextLine();
					int weight = (int) x.nextInt();
					int miles = (int) x.nextInt(); 
					CarTrain car = new CarTrain(id, contents, origin, destination, weight, miles);
					track0.addCar(car);
				}//end if
				else if(name.indexOf("ENG") ==0){
					String engineId= name;
					String city = x.nextLine();
					CarTrain engine = new CarTrain(engineId, city);
					track0.addCar(engine);
				}//end else if
				name = x.nextLine();
			}//end while loop
		}//end try
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		//sorting 
		while (!track0.isEmpty()){
			CarTrain car = track0.removeNextCar();
			String cityName = car.getDestination();
			if(car.needsInspection())
				track1.addCar(car);
            //check if engine 
			if(car.getName().indexOf("ENG") ==0){
				String engine = car.getName();
			///move engine to correct track
			}//end if
			if(cityName.equals("Trenton"))
				trackA.addCar(car);
			else if(cityName.equals("Charlotte"))
				trackB.addCar(car);	
			else if(cityName.equals("Baltimore"))
				trackC.addCar(car);			
			else 
				trackD.addCar(car);	
		}//end while loop


	}//end main
	public static void organizeCars(CarTrain car, Track trackA, Track trackB, Track trackC, Track trackD){
		String cityName = car.getDestination();
		if(cityName.equals("Trenton"))
			trackA.addCar(car);
		else if(cityName.equals("Charlotte"))
			trackB.addCar(car);	
		else if(cityName.equals("Baltimore"))
		trackC.addCar(car);			
		else 
			trackD.addCar(car);	
	}//end organizeCars
	
	public static void depart(Track track, String engineId, String city){
		System.out.println(engineId + " leaving for " + city + " with the following cars:");
		while(!track.isEmpty()){
			CarTrain c = track.removeNextCar();
			if(c.getName().indexOf("CAR") ==0)
				System.out.println(c.getName() + " containing " + c.getProduct());
		}//end while loop
		System.out.println();
	}//end depart funct

	public static void addCarWithLimit(CarTrain car, Track track, String city){
		if(!track.canAddCar(car)){
			depart(track, "ENG00000", city);
		}
		track.addCar(car);
	}//end addWithCaution

}// end MyProgram

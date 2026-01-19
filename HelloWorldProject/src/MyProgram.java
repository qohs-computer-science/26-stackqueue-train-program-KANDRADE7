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
					track0.addCar(new CarTrain(id, contents, origin, destination, weight, miles));
				}//end if
				else if(name.indexOf("ENG") ==0){
					String city = x.nextLine();
					track0.addCar(new CarTrain(name, city));
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

			//if engine signal, depart immediately 
			if(car.getName().indexOf("ENG") ==0){
				String engineId = car.getName();
				if(cityName.equals("Trenton"))
					depart(trackA, engineId, "Trenton");
				else if(cityName.equals("Charlotte"))
					depart(trackB, engineId, "Charlotte");
				else if(cityName.equals("Baltimore"))
					depart(trackC, engineId, "Baltimore");
			}//end if
			//if needs inspection, send to track 1
			else if(car.needsInspection()){
				track1.addCar(car);
			}
			
			//adding cars to respective tracks 
			else{
				if(cityName.equals("Trenton"))
					addCarWithLimit(car, trackA, "Trenton");
				else if(cityName.equals("Charlotte"))
					addCarWithLimit(car, trackB, "Charlotte");	
				else if(cityName.equals("Baltimore"))
					addCarWithLimit(car, trackC, "Baltimore");			
				else 
					trackD.addCar(car);	
			}//end else	
		}//end while loop

		//inspect cars
		track1.setMilesAfterInspection();
		while(!track1.isEmpty()){
			CarTrain car = track1.removeNextCar();
			String dest = car.getDestination();

			if(dest.equals("Trenton"))
				addCarWithLimit(car, trackA, dest);
			else if(dest.equals("Charlotte"))
				addCarWithLimit(car, trackB, dest);
			else if(dest.equals("Baltimore"))
				addCarWithLimit(car, trackC, dest);
			else
				trackD.addCar(car);
		}//end while loop
		
		//depart trackD
		//add code

		//depart remaining tracks
		depart(trackA, "ENG00000", "Trenton");
		depart(trackB, "ENG00000", "Charlotte");
		depart(trackC, "ENG00000", "Charlotte");

		
	}//end main
	
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

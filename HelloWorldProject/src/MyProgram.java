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
		//creates tracks
		Track track0 = new Track(); //processing intially then sort
		Track track1 = new Track(); // queue for overweight cars. loop through and use setMilesAfterInspection
		Track trackA = new Track(0, limitTrackA, "Trenton");
		System.out.println(trackA.toString());
		Track trackB = new Track(0, limitTrackB, "Charlotte");
		Track trackC = new Track(0, limitTrackC, "Baltimore");
		Track trackD = new Track(0);

		Scanner x = new Scanner(System.in);
		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();
			System.out.println(name);
			
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
					System.out.println(engineId + " departure for " + city);
				}//end else if
				name = x.nextLine();
			}//end while loop
		}//end try
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		CarTrain buggy = new CarTrain("CAR00001", "coal", "Pittsburgh", "Baltimore", 13000, 229);
		System.out.println(buggy.toString());
		System.out.println(buggy.needsInspection());

		
		
		

	} //end main
}// end MyProgram



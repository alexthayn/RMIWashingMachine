package WashingMachine;

import java.rmi.Naming;
import java.util.Scanner;

public class WashingMachineDriver {
	public static void main(String[] args) {
		WashingMachine washingMachine = null;
		int machineNum;
		
		if(args.length < 2) {
			System.out.println("Washing machine <Location> <number>" );
			System.exit(1);
		}
		
		try {
			machineNum = Integer.parseInt(args[1]);
			
			washingMachine = new WashingMachine(args[0],machineNum);
			Naming.rebind("//"+args[0]+"/washingmachine",washingMachine);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int choice;
		
		System.out.println(washingMachine);
		System.out.println("Welcome to Alex's laundromat!\n");
		
		while(true) {
			System.out.println(
					"\nPlease select an option: \n"+
					"1. Insert a quarter (cost $1.00)\n"+
					"2. Eject quarters\n"+
					"3. Start Machine\n"+
					"4. Cancel Wash");
			choice = in.nextInt();
			
			switch(choice) {
				case 1: 
					washingMachine.insertQuarter(1);
					break;
				case 2: 
					washingMachine.ejectQuarters();
					break;
				case 3: 
					washingMachine.start();
					break;
				case 4: 
					washingMachine.cancel();
					break;
				default:
					System.out.println("That is an invalid option you bum!.");
			}
		}

	}
}

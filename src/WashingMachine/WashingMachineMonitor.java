package WashingMachine;

import java.rmi.*;

public class WashingMachineMonitor {
	WashingMachineRemote machine;
	
	public WashingMachineMonitor(WashingMachineRemote wmr) {
		this.machine = wmr;
	}
	
	public void report() {
		try {
			System.out.println("Washing machine location: "+ machine.getLocation());
			System.out.println("Machine number: " + machine.getMachineNum());
			System.out.println("Current state: " + machine.getStringState());
		}catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

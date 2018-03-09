package WashingMachine;

import java.rmi.Naming;

public class WashingMachineMonitorTestDriver {
	public static void main(String[] args) {
		String[] location = {"rmi://localhost/1/washingmachine",
		                     "rmi://localhost/2/washingmachine",
		                     "rmi://localhost/3/washingmachine"}; 
		
		if (args.length > 0)
        {
            location = new String[1];
            location[0] = "rmi://" + args[0] + "/washingmachine";
        }
		
		WashingMachineMonitor[] monitor = new WashingMachineMonitor[location.length];
		
		
		
		for (int i=0;i < location.length; i++) {
			try {
           		WashingMachineRemote machine = (WashingMachineRemote) Naming.lookup(location[i]);
           		monitor[i] = new WashingMachineMonitor(machine);
				System.out.println(monitor[i]);
        	} catch (Exception e) {
            	e.printStackTrace();
        	}
		}
 
		for(int i=0; i < monitor.length; i++) {
			monitor[i].report();
		}
	}
}

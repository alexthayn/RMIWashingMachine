# Java RMI Washing Machine

## Skills used
* Java programming language
* Remote method invocation (RMI)
* State pattern
* Proxy pattern
* Object oriented principles
* Open/Closed Principle

## How to run on Windows Command Prompt
0. Navigate to the project directory 
1. Start the RMI registry: >start rmiregistry
2. Create n washing machine instances: java WashingMachine.WashingMachineDriver localhost/<location> <machine num>
  * >java WashingMachine.WashingMachineDriver localhost/Ephraim 3
  * >java WashingMachine.WashingMachineDriver localhost/Moroni 2
  * >java WashingMachine.WashingMachineDriver localhost/Manti 1
3. Start up the remote monitor: >java WashingMachine.WashingMachineMonitorTestDriver

## Description

### Business Requirements
A fictional business owner has multiple laundromats and wants the ability to check the state of all washing machines from one central location. Using remote method invocation and the proxy pattern I was able to write a program for him that monitors all the machines he owns and displays each machine’s current state.

### State Pattern
The washing machine implemented the state pattern because it helps create code that is more easily maintained and closed for modification but open for extension. The washing machine can always have states added to it such as an “out of order state” that could easily be added. The only drawback to using this approach is that it can contain a lot of duplicate code between states which could be resolved by creating an abstract state class and using generic error responses for actions that are invalid.

### Proxy Pattern
Using a remote proxy pattern, we can monitor the washing machines that are in place at multiple locations. I gave the monitor a reference to a proxy version of a washing machine and the proxy pretends it’s the real object but it’s actually communicating over the network to the real object. I also added the ability for the washing machine to be able to accept requests over the network.

### Remote Method Invocation
I implemented the remote monitoring with Java RMI which allowed me to invoke methods on a remote washing machine object. I make each remote washing machine available to the monitor by binding it to the registry and the monitoring program can then fetch the remote washing machine from the registry and invoke its methods.

## Class Diagram
![Class Diagram for RMI Washing Machine Program](https://github.com/alexthayn/RMIWashingMachine/blob/master/Class%20Diagram.png)

## State Diagram
![State Diagram for RMI Washing Machine Program](https://github.com/alexthayn/RMIWashingMachine/blob/master/StateDiagram.png)

#### Not Fully Paid:
•	Eject quarters: eject any quarters currently in machine
•	Insert quarter: add $0.25 to total
•	Press start: do nothing
•	Press cancel: do nothing
#### Has Paid:
•	Eject quarters: eject four quarters
•	Insert quarter: eject the inserted quarter
•	Press Start: start the washing machine
•	Press Cancel: do nothing
#### Running: 
•	Eject quarters: do nothing
•	Insert quarter: eject the inserted quarter
•	Press start: do nothing
•	Press cancel: stop the machine

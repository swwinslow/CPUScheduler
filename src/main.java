import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		int quantum = 0;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Round Robin (1) | First Come, First Serve (2) | Shortest Job First (3)");
		
		System.out.print("Please enter the CPU Scheduling: ");
		String scheduler = in.nextLine();
		
		System.out.println(scheduler);
		if(scheduler.equals("1")){
			System.out.println("we are going to round robin");
			System.out.println("Please enter the Quantum Number: ");
			quantum = Integer.parseInt(in.nextLine());

		} else if(scheduler.equals("2")){
			System.out.println("we are going to FCFS");
		} else if (scheduler.equals("3")){
			System.out.println("we are going to SJF");
		}
		
		System.out.println("Job information");
		
		int[] ID = new int[10];
		int[] bursts = new int[10];
		
		String exitCode = "Y";
		int count = -1;
		
		do{
			count++;
			System.out.print("Please enter the job ID: " );
			int jobID = Integer.parseInt(in.nextLine());
			ID[count] = jobID;
			
			System.out.print("Please enter the burst time for Job #" + jobID);
			int jobBurst = Integer.parseInt(in.nextLine());
			bursts[count] = jobBurst;
			
			System.out.print("Contine: Y | Exit: X");
			exitCode = in.nextLine();
			
		}while(exitCode.equals("Y"));
		
		
		//todo figure out how many object we need.
		for (int i = 0; i < ID.length; i++){
			System.out.println(ID[i]);
			System.out.println(bursts[i]);

		}
		
		
		
		//Round Robin
		RoundRobin x = new RoundRobin(quantum, ID, bursts);
		String results ="";
		results = x.compute();
		System.out.println("this is from the main class:" + results);
		
		//Shortest Job First
		ShortestJobFirst a = new ShortestJobFirst( ID, bursts);

		results = a.compute();
		System.out.println("this is from the main class:" + results);
		
		//FCFS
		FirstInFirstServed b = new FirstInFirstServed( ID, bursts);

		results = b.compute();
		System.out.println("this is from the main class:" + results);
		
		
		
		
	
		
	
		
		
	
		


	}

}

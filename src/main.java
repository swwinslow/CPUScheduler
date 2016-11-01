import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		int quantum = 0;
		boolean valid = true;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Round Robin (1) | First Come, First Serve (2) | Shortest Job First (3)");
		
		System.out.print("Please enter the CPU Scheduling: ");
		String scheduler = in.nextLine();
		
		System.out.println(scheduler);
		if(scheduler.equals("1")){
			System.out.println("We are going to round robin.");
			System.out.println("Please enter the Quantum Number: ");
			quantum = Integer.parseInt(in.nextLine());

		} else if(scheduler.equals("2")){
			System.out.println("We are going to FCFS.");
		} else if (scheduler.equals("3")){
			System.out.println("We are going to SJF.");
		} else{
			System.out.println("That is not an option");
			valid = false;
		}
		
		
		if (valid==true){
			
			//pull this out so its clean
			System.out.println("Job information");
			
			
			ArrayList<Integer> ID = new ArrayList<Integer>();
			ArrayList<Integer> bursts = new ArrayList<Integer>();
			
			String exitCode = "Y";
			int count = -1;
			
			do{
				count++;
				System.out.print("Please enter the job ID: " );
				int jobID = Integer.parseInt(in.nextLine());
				ID.add(jobID);
				
				System.out.print("Please enter the burst time for Job #" + jobID);
				int jobBurst = Integer.parseInt(in.nextLine());
				bursts.add(jobBurst);
				
				System.out.print("To Enter Another Job: Y | To Exit: N");
				exitCode = in.nextLine();
				
			}while(exitCode.equals("Y"));
			
			
			System.out.println("The jobs you've entered along with their burst times:");
			for (int i = 0; i < count + 1; i++){
				System.out.print("Job" + ID.get(i) + ", ");
				System.out.println(bursts.get(i));
			}
			
			
			if(scheduler.equals("1")){
				//Round Robin
				RoundRobin x = new RoundRobin(quantum, ID, bursts);
				ArrayList<Integer> results;
				results = x.compute();
				System.out.println("Round Robin Results:" + results);
				for (int i=0; i<results.size(); i++){
					System.out.println(results.get(i));
				}
			}else if (scheduler.equals("2")){
				//FCFS
				FirstInFirstServed b = new FirstInFirstServed( ID, bursts);
				ArrayList<Integer> results;
				results = b.compute();
				System.out.println("First In First Served Results:" + results);
				
			}else{
				//Shortest Job First
				ShortestJobFirst a = new ShortestJobFirst( ID, bursts);
				ArrayList<Integer> results;
				results = a.compute();
				System.out.println("Shortest Job First Results:" + results);	
				for (int i=0; i<results.size(); i++){
					System.out.println(results.get(i));
				}
			}

		}else{
			//quit
			System.exit(1);
		}
	}
	
	
	
}

import java.util.ArrayList;
import java.util.Collections;
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
			ArrayList<RR> roundRobinArrayList = new ArrayList<RR>();
			ArrayList<ShortestJobFirst> sjfArrayList = new ArrayList<ShortestJobFirst>();


			int count = -1;

			
			
			
			String exitCode = "Y";

			
			
			
			
			
			
			
			if(scheduler.equals("1")){
				
				do{
					System.out.print("Please enter the job ID: " );
					int jobID = Integer.parseInt(in.nextLine());
					
					System.out.print("Please enter the burst time for Job #" + jobID);
					int jobBurst = Integer.parseInt(in.nextLine());
					
					roundRobinArrayList.add(new RR(jobID, jobBurst));
					
					
					System.out.print("To Enter Another Job: Y | To Exit: N");
					exitCode = in.nextLine();
					
				}while(exitCode.equals("Y"));
				
				RR data = new RR();
				data.compute(roundRobinArrayList, quantum);
				
				
			}else if (scheduler.equals("2")){
				
				Boolean x = false;
				
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
								
				//FCFS
				FirstInFirstServed b = new FirstInFirstServed( ID, bursts);
				ArrayList<Integer> results;
				results = b.compute();
				
				for (int i = 1; i < results.size(); i = i + 3){
					System.out.println("Job# " + results.get(i-1) + " | Burst Time: " + results.get(i) + " | Wait Time: " + results.get(i+1));
				}
				
			}else{
				
				Boolean x = false;
				
				do{
					count++;
					System.out.print("Please enter the job ID: " );
					int jobID = Integer.parseInt(in.nextLine());
//					ID.add(jobID);
					
					System.out.print("Please enter the burst time for Job #" + jobID);
					int jobBurst = Integer.parseInt(in.nextLine());
//					bursts.add(jobBurst);
									
			
					sjfArrayList.add(0, new ShortestJobFirst(jobID, jobBurst));

					
					
					
//					for (int p = 0; p < sjfArrayList.size(); p++){
//						
//						for (int j = 1; j <  sjfArrayList.size(); j++){
//							if (sjfArrayList.get(p).getBurst() > sjfArrayList.get(j).getBurst()){
//								Collections.swap(sjfArrayList, p, j);
//							} else {
//								
//							}
//								
//						}
//					}
					
					for (int j = 0; j <  sjfArrayList.size() -1; j++){
						if (sjfArrayList.get(j).getBurst() > sjfArrayList.get(j+1).getBurst()){
							Collections.swap(sjfArrayList, j, j+1);
						} else {
							
						}
							
					}
					
					System.out.println("Shortest Job First so far:");	
					for (int i=0; i<sjfArrayList.size(); i++){
						System.out.println(sjfArrayList.get(i).getID());
					}
					
					System.out.print("To Enter Another Job: Y | To Exit: N");
					exitCode = in.nextLine();
					
//					sjfArrayList.add(new ShortestJobFirst(jobID, jobBurst));
					x = true;

					
				}while(exitCode.equals("Y"));
				
				//Shortest Job First
				
				
				
				
				
				
				System.out.println("Shortest Job First Results:");	
				for (int i=0; i<sjfArrayList.size(); i++){
					System.out.println(sjfArrayList.get(i).getID());
				}
			}

		}else{
			//quit
			System.exit(1);
		}
	}
	
	
	
}

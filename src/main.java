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
				
				//COMPUTE
				ArrayList<Integer> jobSequence = new ArrayList<Integer>();
				ArrayList<Integer> jobBurst = new ArrayList<Integer>();
				boolean value = true;
				ArrayList<Integer> throwAway = new ArrayList<Integer>();
				
				while(value == true){
					int countRR = roundRobinArrayList.size();
					
					for(int i=0; i < countRR; i++){
						
						RR x = roundRobinArrayList.get(i);
						int id = x.getID();

						int burstsRR = x.getburstTime();
					
				
						
						if(burstsRR <= quantum){
							int remaining = burstsRR;
							jobSequence.add(id);
							jobBurst.add(remaining);
							throwAway.add(x.getID());

						}else{
							int remaining = burstsRR - quantum;
							jobSequence.add(id);
							jobBurst.add(quantum);
							x.setburstTime(remaining);
						}
					}
					
					for (int i = 0; i < throwAway.size(); i++){
						
						for (int t = 0; t < roundRobinArrayList.size(); t++){
							if (roundRobinArrayList.get(t).getID() == throwAway.get(i)){
								System.out.println("we have hit the same ids");
								roundRobinArrayList.remove(t);
								if(roundRobinArrayList.size() == 0){
									value = false;
									break;
								}
							}
						}
					
						
					}
				}
				
				//results
				System.out.println("Order:");
				for (int i = 0; i < jobSequence.size(); i++){
					System.out.println("Job#"+ jobSequence.get(i) + " Burst Time: " + jobBurst.get(i));
				}
				
		
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
				
				int countFCFS = ID.size();
				int waitingTime = 0;
				ArrayList<Integer> jobInfo = new ArrayList<Integer>();

				for(int i=0; i<count; i++){
					jobInfo.add(ID.get(i));
					jobInfo.add(bursts.get(i));
					if(i==0){
						jobInfo.add(waitingTime);
					}else{
						waitingTime += bursts.get(i-1);
						jobInfo.add(waitingTime);
					}
				}
				
				//not being printed right now
				int totalBurstTime = 0;
				for (int i = 0; i < ID.size(); i++){
					totalBurstTime += bursts.get(i);
				}
				
				for (int i = 1; i < jobInfo.size(); i = i + 3){
					System.out.println("Job# " + jobInfo.get(i-1) + " | Burst Time: " + jobInfo.get(i) + " | Wait Time: " + jobInfo.get(i+1));
				}
				
			}else{
				//SHORTEST JOB FIRST
				
				Boolean x = false;
				
				do{
					count++;
					System.out.print("Please enter the job ID: " );
					int jobID = Integer.parseInt(in.nextLine());
					
					System.out.print("Please enter the burst time for Job #" + jobID);
					int jobBurst = Integer.parseInt(in.nextLine());
			
					sjfArrayList.add(0, new ShortestJobFirst(jobID, jobBurst));

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
					
					x = true;

					
				}while(exitCode.equals("Y"));

				//COMPUTE
				
				int countSJF = sjfArrayList.size();
				int waitingTime = 0;
				ArrayList<Integer> jobInfo = new ArrayList<Integer>();
				ShortestJobFirst lastSJF = new ShortestJobFirst();

				for(int i=0; i<countSJF; i++){
					if(i == 0){
						
					} else {
						lastSJF = sjfArrayList.get(i-1);

					}

					ShortestJobFirst sjf = sjfArrayList.get(i);

					jobInfo.add(sjf.getID());
					jobInfo.add(sjf.getBurst());
					if(i==0){
						jobInfo.add(waitingTime);
					}else{
						waitingTime += lastSJF.getBurst();
						jobInfo.add(waitingTime);
					}
				}
				
//				//not being printed right now
//				int totalBurstTime = 0;
//				for (int i = 0; i < ID.size(); i++){
//					totalBurstTime += bursts.get(i);
//				}
				
				//results

				for (int i = 1; i < jobInfo.size(); i = i + 3){
					System.out.println("Job# " + jobInfo.get(i-1) + " | Burst Time: " + jobInfo.get(i) + " | Wait Time: " + jobInfo.get(i+1));
				}
				
			}

		}else{
			//quit
			System.exit(1);
		}
	}
	
	
	
}

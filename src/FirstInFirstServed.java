import java.util.ArrayList;

public class FirstInFirstServed {
	
			private ArrayList<Integer> idList = new ArrayList<Integer>();
			private ArrayList<Integer> burst = new ArrayList<Integer>();
			public ArrayList<Integer> jobInfo = new ArrayList<Integer>();

			
			public FirstInFirstServed(ArrayList<Integer> ids, ArrayList<Integer> bu){
				this.idList = ids;
				this.burst = bu;
			}
			
			public ArrayList<Integer> compute(){
				int count = idList.size();
				int waitingTime = 0;
				for(int i=0; i<count; i++){
					jobInfo.add(idList.get(i));
					jobInfo.add(burst.get(i));
					if(i==0){
						jobInfo.add(waitingTime);
					}else{
						waitingTime += burst.get(i-1);
						jobInfo.add(waitingTime);
					}
				}
				
				//not being printed right now
				int totalBurstTime = 0;
				for (int i = 0; i < idList.size(); i++){
					totalBurstTime += burst.get(i);
				}
				
				return jobInfo;
			}
			
}

import java.util.ArrayList;

public class RR {
	
	private int id;
	private int burstTime;
	
	public RR(){
		
	}
	
	public RR (int oID, int oburstTime) {
		this.id = oID;
		this.burstTime = oburstTime;
	}
	public void setburstTime(int x){
		this.burstTime = x;
	}
	
	public int getburstTime(){
		return this.burstTime;
	}
	public int getID(){
		return this.id;
	}
	
	ArrayList<Integer> jobSequence = new ArrayList<Integer>();
	ArrayList<Integer> jobBurst = new ArrayList<Integer>();

	
	int quantum = 4;
	public void compute(ArrayList<RR> rr){

		boolean value = true;
		boolean second = false;
		ArrayList<Integer> lost = new ArrayList<Integer>();
		
		while(value == true){
			int count = rr.size();
			
			for(int i=0; i < count; i++){
				
				RR x = rr.get(i);
				int id = x.getID();

				int bursts = x.getburstTime();
			
		
				
				if(bursts <= quantum){
					int remaining = bursts;
					jobSequence.add(id);
					jobBurst.add(remaining);
					lost.add(x.id);

				}else{
					int remaining = bursts - quantum;
					jobSequence.add(id);
					jobBurst.add(quantum);
					x.setburstTime(remaining);
				}
			}
			
			for (int i = 0; i < lost.size(); i++){
				
				for (int t = 0; t < rr.size(); t++){
					if (rr.get(t).id == lost.get(i)){
						System.out.println("we have hit the same ids");
						rr.remove(t);
						if(rr.size() == 0){
							value = false;
						}
					}
				}
			
				
			}
		}
		
		for (int i = 0; i < jobSequence.size(); i++){
			System.out.println(jobSequence.get(i));
			System.out.println(jobBurst.get(i));

		}
		System.out.println("This is the remaining:::");
		for (int i = 0; i < rr.size(); i++){
			System.out.println(rr.get(i));
			

		}
			
	}

}

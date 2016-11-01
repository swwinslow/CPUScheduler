import java.util.ArrayList;

public class RoundRobin {

	private int quantum;
	private ArrayList<Integer> id = new ArrayList<Integer>();
	private ArrayList<Integer> burst = new ArrayList<Integer>();
	
	public ArrayList<Integer> jobSequence = new ArrayList<Integer>();
	public ArrayList<Integer> jobBurst = new ArrayList<Integer>();

	
	public RoundRobin(int q, ArrayList<Integer> ids, ArrayList<Integer> bu){
		this.quantum = q;
		this.id = ids;
		this.burst = bu;
	}
	
	public ArrayList<Integer> compute(){
		
		boolean value = true;
		boolean second = false;
		
		ArrayList<Integer> lost = new ArrayList<Integer>();
		
		while(value == true){
			int count = id.size();
			System.out.println(count);
			for(int i=0; i< count; i++){
				System.out.println(i);
				int ID = id.get(i);
				int bursts = burst.get(i);
				System.out.println("This is the job " + i + "burst size" + bursts);
				
				if(bursts <= quantum){
					int remaining = bursts;
					jobSequence.add(ID);
					jobBurst.add(remaining);
					lost.add(i);
					System.out.println("This is the size:  " + id.size());
					if(id.size() == 0){
						value = false;
						break;
					}
				}else{
					int remaining = bursts - quantum;
					jobSequence.add(ID);
					jobBurst.add(quantum);
					burst.set(i, remaining);
				}
			}
			if(second == true){
				value = false;
			} else{
				second = true;
			}
			for (int i = 0; i < lost.size(); i++){
				id.remove(lost.get(i));
				burst.remove(lost.get(i));
				System.out.println("we are removing" + lost.get(i));
				if (id.size() == 0){
					System.out.println("WE ARE DONNNNNEEEE");
				
					value = false;
					break;
				}
			}
		}
		
		//return jobSequence with jobBurst
		return jobSequence;

	}
}


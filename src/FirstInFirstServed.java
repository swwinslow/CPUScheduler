
public class FirstInFirstServed {
	
	//FCFS class
			private int[] id;
			private int[] burst;
			
			public FirstInFirstServed(int[] ids, int[] bu){
				this.id = ids;
				this.burst = bu;
			}
			
			public String compute(){
				int count = 0;
				for (int i = 0; i < id.length; i++){
					count += burst[i];
				}
				
				return "The total is " + count;
			}

}

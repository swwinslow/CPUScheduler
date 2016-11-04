import java.util.ArrayList;

public class FirstInFirstServed {
	
			private ArrayList<Integer> idList = new ArrayList<Integer>();
			private ArrayList<Integer> burst = new ArrayList<Integer>();
			public ArrayList<Integer> jobInfo = new ArrayList<Integer>();

			
			public FirstInFirstServed(ArrayList<Integer> ids, ArrayList<Integer> bu){
				this.idList = ids;
				this.burst = bu;
			}
					
}

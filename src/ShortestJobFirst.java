import java.util.ArrayList;

public class ShortestJobFirst {
	
		
		private ArrayList<Integer> jobInfo = new ArrayList<Integer>();


		private int id;
		private int burst;
		
		public ShortestJobFirst(){
			
		}
		
		public ShortestJobFirst(int oID, int oBurst){
			this.id = oID;
			this.burst = oBurst;
		}
		
		public int getID(){
			return id;
		}
		
		public int getBurst(){
			return burst;
		}

}

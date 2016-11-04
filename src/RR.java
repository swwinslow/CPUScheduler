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

}

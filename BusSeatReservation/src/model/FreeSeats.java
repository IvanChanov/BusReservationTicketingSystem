package model;

import java.io.Serializable;
import java.util.ArrayList;

public class FreeSeats implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<Integer> list = new ArrayList<>(50);
    private int seatNumber= 0 ;
    
	public int addPassenger()
    {
    	seatNumber++;
    	if(seatNumber > 50)
    	{
    		seatNumber = 50;
    		return -1 ;
    	}
    	list.add(seatNumber);
    	return seatNumber;
    }
   
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public int getFreeSeats() {
		int size = 50 - (list.size());
		if(size < 0 )
		{
			return 0 ;
		}
		else return size ;
		
	}
	
}

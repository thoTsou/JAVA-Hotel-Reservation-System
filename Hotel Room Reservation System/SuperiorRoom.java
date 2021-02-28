import java.util.ArrayList;

public class SuperiorRoom extends Room {



private ArrayList<Amenity> amList = new ArrayList<Amenity>();
/* this counter is used in order to get amList's size (used for a  for()  statement in choise 6)*/
private int counter;


public SuperiorRoom ( int roomNum , int roomFloor , int roomSize , double roomPrice , Amenity amenity)
{
super(roomNum , roomFloor , roomSize , roomPrice);
this.setRoomAmenities(amenity);
}

SuperiorRoom (){};


public Amenity getRoomAmenities( int i )
{	
		return this.amList.get(i) ;		
}



public void setRoomAmenities(Amenity amenity)
{	
this.amList.add(amenity);
this.counter++;
}

public int getCounter()
{	
return this.counter;
}



}
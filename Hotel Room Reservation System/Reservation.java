import java.util.Date;
import java.util.ArrayList;

public class Reservation {
	
	private Room room;
	private Client client;	
	private int people;
	private Date checkIn;
	private Date checkOut;
	private double discount;		
	private ArrayList<Amenity> amList = new ArrayList<Amenity>();
	private double totalCost;
	
	
	public Reservation( Client client,Room room , int people , Date checkIn , Date checkOut , double discount , double totalCost )
	{
		this.setClient(client);
		this.setRoom(room);
		this.setPeople(people);
		this.setCheckIn(checkIn);
		this.setCheckOut(checkOut);
		this.setDiscount(discount);
		this.setTotalCost(totalCost);
		
	}
	
	Reservation(){};
	
	
	
	public void setClient( Client client)
	{
	this.client=client;
	}



	public Client getClient()
	{
	return this.client;

	}
	
	
	
	public void setRoom( Room room)
	{
	this.room=room;
	}



	public Room getRoom()
	{
	return this.room;

	}
	
	public void setPeople( int people)
	{
	this.people=people;
	}



	public int getPeople()
	{
	return this.people;

	}
	
	public void setCheckIn( Date checkIn)
	{
	this.checkIn=checkIn;
	}



	public Date getCheckIn()
	{
	return this.checkIn;

	}
	
	public void setCheckOut( Date checkOut)
	{
	this.checkOut=checkOut;
	}



	public Date getCheckOut()
	{
	return this.checkOut;

	}
	
	public void setDiscount( double discount)
	{
	this.discount=discount;
	}



	public double getDiscount()
	{
	return this.discount;
	}
	
	public void setTotalCost( double totalCost)
	{
	this.totalCost=totalCost;
	}



	public double getTotalCost()
	{
	return this.totalCost;
	}
	
	public void setAmenities( Amenity amenity)
	{
	this.amList.add( amenity );
	}



	public Amenity getAmenities(int i)
	{
	return this.amList.get(i);
	}
	
	
	
		
}

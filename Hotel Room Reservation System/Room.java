
public class Room  {

private int roomNum;
private int roomFloor;
private int roomSize;
private double roomPrice;

public Room ( int roomNum , int roomFloor , int roomSize , double roomPrice)
{
this.setRoomNum(roomNum);
this.setRoomFloor(roomFloor);
this.setRoomSize(roomSize);
this.setRoomPrice(roomPrice);
}

Room(){};




public void setRoomNum(int roomNum)
{
this.roomNum=roomNum;
}



public int getRoomNum()
{
return this.roomNum;

}

public void setRoomFloor(int roomFloor)
{
this.roomFloor=roomFloor;
}



public int getRoomFloor()
{
return this.roomFloor;

}

public void setRoomSize(int roomSize)
{
this.roomSize=roomSize;
}



public int getRoomSize()
{
return this.roomSize;

}

public void setRoomPrice( double roomPrice)
{
this.roomPrice=roomPrice;
}



public double getRoomPrice()
{
return this.roomPrice;
}



}



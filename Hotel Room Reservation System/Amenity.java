
public class Amenity{

private String amenityCode;
private String amenityCategory;
private String amenityDes;
private double amenityPrice;

public Amenity ( String amenityCode , String amenityCategory , String amenityDes ,  double amenityPrice )
{
this.setAmenityCode(amenityCode);
this.setAmenityCategory(amenityCategory);
this.setAmenityDes(amenityDes);
this.setAmenityPrice(amenityPrice);
}


public void setAmenityCode(String amenityCode)
{
this.amenityCode=amenityCode;
}



public String getAmenityCode()
{
return this.amenityCode;

}

public void setAmenityCategory(String amenityCategory)
{
this.amenityCategory=amenityCategory;
}



public String getAmenityCategory()
{
return this.amenityCategory;

}

public void setAmenityDes(String amenityDes)
{
this.amenityDes=amenityDes;
}



public String getAmenityDes()
{
return this.amenityDes;

}

public void setAmenityPrice(double amenityPrice)
{
this.amenityPrice=amenityPrice;
}



public double getAmenityPrice()
{
return this.amenityPrice;
}


public String toString()
{
String str = new String ("Amenity code : "+this.amenityCode+"\n"+
		                   "Amenity's category : "+this.amenityCategory+"\n"+
		                   "Amenity's description : "+this.amenityDes+"\n"+
		                   "Amenity's price : "+this.amenityPrice+"\n" ) ;

  return str;
}


}


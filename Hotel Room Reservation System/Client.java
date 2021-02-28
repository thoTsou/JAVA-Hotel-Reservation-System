
public class Client  {
	
	private String clientID;
	private String clientName;
	private String clientSurName;
	private String clientAddress;
	private String clientPhoneNum;
	
	public Client(String clientID , String clientName , String clientSurName , String clientAddress , String clientPhoneNum)
	{
		this.setClientID(clientID);
		this.setClientName(clientName);
		this.setClientSurName(clientSurName);
		this.setClientAddress(clientAddress);
		this.setClientPhoneNum(clientPhoneNum);
	}
	
	
	
	
	public void setClientID( String clientID)
	{
	this.clientID=clientID;
	}



	public String getClientID()
	{
	return this.clientID;

	}
	
	public void setClientName( String clientName)
	{
	this.clientName=clientName;
	}



	public String getClientName()
	{
	return this.clientName;

	}
	
	public void setClientSurName( String clientSurName)
	{
	this.clientSurName=clientSurName;
	}



	public String getClientSurName()
	{
	return this.clientSurName;

	}
	
	public void setClientAddress( String clientAddress)
	{
	this.clientAddress=clientAddress;
	}



	public String getClientAddress()
	{
	return this.clientAddress;

	}
	
	public void setClientPhoneNum( String clientPhoneNum)
	{
	this.clientPhoneNum=clientPhoneNum;
	}



	public String getClientPhoneNum()
	{
	return this.clientPhoneNum;

	}

}

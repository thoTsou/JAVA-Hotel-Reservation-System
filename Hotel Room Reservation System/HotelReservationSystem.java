import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;




public class HotelReservationSystem   {

public static void main(String[] args)  {
	
		
	boolean firstTime = true ;
	String subChoise;
	int floors ;
	int floorRooms ;
	
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Amenity> amenityList = new ArrayList<Amenity>();
	ArrayList<Room> roomList = new ArrayList<Room>();
	ArrayList<Client> clientList = new ArrayList<Client>();
	ArrayList<Reservation> resList = new ArrayList<Reservation>();
	

	
	
	String subMenu = new String("[a] Insert a standard room"+"\n"+ 
	 		"[b] Insert a superior room"); 
	
	
	String menu = new String("[1] Insert Amenity"+"\n"+ 
			"[2] Insert Room (Standard or Superior)"+"\n"+ 
			"[3] Insert Client"+"\n"+ 
			"[4] Book Room"+"\n"+ 
			"[5] Cancel Room Reservation"+"\n"+ 
			"[6] Order Amenity (Available only in Superior Rooms)"+"\n"+ 
			"[7] Hotel Capacity"+"\n"+ 
			"[8] Room Availability"+"\n"+ 
			"[0] Exit");
	

	
	do {
           System.out.println("Please type the number of this Hotel floors ( it can not have more than 9 .If it only has a basement type 0 )");
           floors = sc.nextInt() ;
      }while( floors<0 || floors>9 );
	
	do {
           System.out.println("Please type the number of this Hotel number of rooms per floor ( can not have more than 99 )");
           floorRooms = sc.nextInt() ;
      }while( floorRooms<1 || floorRooms> 99 );
	
	int[][] Hotel = new int[ (floors+1) ][floorRooms];
	
	
	int choise;
	
	do 
	{
	System.out.printf(menu+"\n");
	System.out.println("What action would you like to complete ? (type the number only)");
	choise = sc.nextInt();
	  
	        if( choise==1 )
	        {
	    	 
	    	            System.out.println("Type a code for the new amenity ( do not leave any space ) ");
	    	           String answer = new String( sc.next() );
	    	        
	    	           boolean elementFound=false;
	    	           
	        	       /* check if code already exists  at amenityList (elementFound).If it already exist do not create a new amenity with this code */
	    	           
	    	           for(int i=0 ; i<amenityList.size() ; i++)
	                   	{
	    		             if(  answer.equals( amenityList.get(i).getAmenityCode() )  )
	    		               {
	    		                 elementFound=true;
   	        	                  System.out.println("This amentity you would like to insert , does arleady exist");
   	        	                  break;
	    		               }
	        	         }
	    	           
	    	           /*if given code does not already exist in amenityList (elementFound==false) , create a new amenity object and add it to amenityList */ 
	    	           
	    	            if(elementFound == false)
	    	             {
	    	            	Amenity amenity = new Amenity("0" , "0" , "0" ,  0);
	    		          
	    		            amenity.setAmenityCode( answer );
	    	 
	    	               System.out.println("Type the category of this amenity (string , do not leave space between words) ");
	    	               amenity.setAmenityCategory( sc.next() );
	    	 
	    	                System.out.println("Give a subscription of this amenity (string , do not leave space between words) ");
	    	                amenity.setAmenityDes( sc.next() );
	    	                
	    	                double price1;
	    	                do {
	    	                System.out.println("Type the Price for this amenity(double) ");
	    	                price1= sc.nextDouble();
	    	                }while( price1<=0 ) ;
	    	                	amenity.setAmenityPrice( price1 );
	    	 
	    	                amenityList.add(amenity);
	    	    
	    	              }
	    	    
	    	
	    	 
	     }
	     
	     if(choise==2)
	     {
	    	 do {
	    		System.out.println(subMenu); 
	    		 
	    		 System.out.println("insert type of room (type a or b )");
	    		 
	    		 subChoise = new String( sc.next() );
	    		 
	    		 if( subChoise.equals("a") )
	    		 {
	    			 
	    			 System.out.println("Remember that every room's number first digit refers to its floor and the other two indicate its number. The first room's number for every floor is 01 and not 00 ");
	    			 
	    			 int roomNumber;
	    			   
			         do {
		                   System.out.println("Type room's number ( XXX )");
	    	                roomNumber = sc.nextInt() ;
			         }while( ((roomNumber/100)<0) || ((roomNumber/100)>9) );
	    			         
	    			         
	  	    	                
	  	    	              /* check if code already exists  at roomList (elementFound).If it already exist do not create a new room with this code */
	  	    	           
    	                        boolean elementFound=false;
    	                        
        	
    	                          for(int i=0 ; i<roomList.size() ; i++)
                   	              {
    		                          if(  roomNumber == roomList.get(i).getRoomNum()  )
    		                            {
    		                             elementFound=true;
	        	                          System.out.println("The room you would like to insert , does arleady exist");
	        	                          break;
    		                            }
        	                        }
    	                          
    	                          /*if given code does not already exist in roomList (elementFound==false) , create a new StandardRoom object and add it to roomList */ 
    	   
    	                           if(elementFound == false)
    	                           {
   	                        	/* the code is always written as ( XXX ).First number refers to the floor of the room.We store the second and the third number and we build the items of the Hotel Array */
    	                        	   int ekat = (roomNumber/100);
    	                        	   
   			  	    	            int  dekades=( (roomNumber % 100) / 10 ) ;
   			  	    	           
   			  	    	           int monades=(  ( (roomNumber%100)% 10 ) / 1 ) ; 
    			  	    	           
    	                        	   Room stRoom = new StandardRoom( 0 , 0 , 0 , 0 );
	  	    	        
    	            	               stRoom.setRoomNum(roomNumber);
    	            	               
    	            	
    	            	               int fl;
    	            	               
    	                                            	
    	            	               do {         	
  	            	                     System.out.println("Type room's floor (integer)");
  		  	    	                     fl =  sc.nextInt() ;
  	                                    }while( fl != ekat );
    	            	               
    	            	               stRoom.setRoomFloor( fl );
    	                                    
    	            	               if(dekades == 0) {
		  	    	                    	Hotel [ stRoom.getRoomFloor() ] [ (monades - 1 )] = stRoom.getRoomNum()  ;
		  	    	                     }else {
		  	    	                    	 
		  	    	                    	int rooNum =  ( ( dekades *10 ) + (monades-1) ) ;
		  	    	                    	 
		  	    	                    	Hotel [ stRoom.getRoomFloor()  ] [ rooNum ] = stRoom.getRoomNum()  ;
		  	    	                     }
    	            	               
    	            	                    int cap1;
    	                                    do {
    		  	    	                    System.out.println("Type room's capacity (integer)");
    		  	    	                    cap1=sc.nextInt();
    	                                    }while(cap1 <= 0);
    		  	    	                    stRoom.setRoomSize( cap1 );
    		  	    	 
    		  	    	 
    		  	    	                  double price2;
    		  	    	                do {
    		  	    	                System.out.println("Type the Price of this standard room (double) ");
    		  	    	                price2= sc.nextDouble();
    		  	    	                }while( price2<=0 ) ;
    		  	    	                	stRoom.setRoomPrice( price2 );
    		  	    	 
    		  	    	                
    		  	    	                  roomList.add(stRoom);
    		  	 
    	            	
    	                                }
	  
	    			 
	    		 }
	    		 else if( subChoise.equals("b") )
	    		 {
	    			 System.out.printf("Remember that every room's number first digit refers to its floor and the other two indicate its number. The first room's number for every floor is 01 and not 00 \n\n");
	    			 
	    			 int rNumber;
	    			 
	    			 do {
			                   System.out.println("Type room's number ( XXX )");
	    	                rNumber = sc.nextInt() ;
  			         }while( ((rNumber/100)<0) || ((rNumber/100)>9) );
    	   
    	                /* check if code already exists  at roomList (elementFound).If it already exist do not create a new room with this code */

                      boolean elementFound=false;
                      
	
                      for(int i=0 ; i<roomList.size() ; i++)
       	              {
                          if(  rNumber ==  roomList.get(i).getRoomNum()  )
                            {
                             elementFound=true;
	                          System.out.println("The room you would like to insert , does arleady exist");
	                          break;
                            }
                        }
                      
                      /*if given code does not already exist in roomList(elementFound==false) , create a new SuperiorRoom object and add it to roomList */ 
 
                         if(elementFound == false)
                         {
                        	 /* the code is always written as ( XXX ).First number refers to the floor of the room.We store the second and the third number and we build the items of Hotel Array */
                        	 int eka =( rNumber / 100);
                        	 
		  	    	            int  dek=( (rNumber % 100) / 10 ) ;
		  	    	           
		  	    	           int mon=(  ( (rNumber%100)% 10 ) / 1 ) ;
 	                 
                        	 Room supRoom = new SuperiorRoom(); 
                        	 
          	               supRoom.setRoomNum(rNumber);
          	               
          	             int fl2;
        	               
                         do {         	
 	                     System.out.println("Type room's floor (integer)");
   	                     fl2 =  sc.nextInt() ;
                         }while( fl2 != eka );
                         
                         supRoom.setRoomFloor( fl2 );
                         

	  	    	                     
	  	    	                   if(dek == 0) {
	  	    	                    	Hotel [ supRoom.getRoomFloor() ] [ (mon - 1 )] = supRoom.getRoomNum()  ;
	  	    	                     }else {
	  	    	                    	 
	  	    	                    	int roomNum =  ( ( dek *10 ) + (mon-1) ) ;
	  	    	                    	 
	  	    	                    	Hotel [ supRoom.getRoomFloor() ] [ roomNum ] = supRoom.getRoomNum()  ;
	  	    	                     }
                         
                         
                         

	  	    	                 int cap2;
                                 do {
	  	    	                    System.out.println("Type room's capacity (integer)");
	  	    	                    cap2=sc.nextInt();
                                 }while(cap2 <= 0);
	  	    	                    supRoom.setRoomSize( cap2 );
	  	    	 
	  	    	 
	  	    	                  double price3;
		  	    	                do {
		  	    	                System.out.println("Type the Price for this superior Room (double) ");
		  	    	                price3= sc.nextDouble();
		  	    	                }while( price3<=0 ) ;
		  	    	                	supRoom.setRoomPrice( price3 );
	  	    	                  
	  	    	                
	  	    	                String code=new String(); ;
	  	    	              int k ;
	  	    	                
	  	    	                do {
	  	    	                	System.out.println("Register available amenities for this superior room by typing the amenity's unique code , one per time (if you're done press 0)");
	  	    	                	code = new String ( sc.next() );
	  	    	                	
	  	    	                	if( ! code.equals("0")  ) 
	  	    	                	{
	  	    	                	
	  	    	                                for( k=0 ; k<amenityList.size() ; k++ )
	  	    	                                    {
	  	    	                	                 if( code.equals( amenityList.get(k).getAmenityCode() )  )
	  	    	                	                     {
	  	    	                		                 ((SuperiorRoom) supRoom).setRoomAmenities( amenityList.get(k) );
	  	    	                	                     }
	  	    	                                    }	  	    	                
	  	    	                	}
	  	    	               
	  	    	                }while( ! code.equals("0") );
	  	    	                          
	  	    	                  roomList.add(supRoom);
	  	    	              
	  	    	               
                         }	 
	    		 }
	    		 
	    		 
	    	 }while( (!"a".equals(subChoise) ) && (!"b".equals(subChoise)) );
	    		 
	    	 
	     }	     
	     
	     if(choise==3)
	     {
	    	 
	    	 
	            System.out.println("Type the ID code of the new client (string , do not leave space between letters) ");
	           String answer = sc.next();
	   
	           /* check if ID already exists  at clientList (elementFound).If it already exist do not create a new client with this ID */
	   
	           boolean elementFound=false;
	           
 	
	           for(int i=0 ; i<clientList.size() ; i++)
	              {
                   if(  answer.equals( clientList.get(i).getClientID() ) )
                     {
                      elementFound=true;
                       System.out.println("This client is already registered");
                       break;
                     }
                 }
	           
	           /*if given ID does not already exist in clientList(elementFound==false) , create a new client object and add it to clientList */ 
	           
	            if(elementFound == false)
	             {
		            
	            	Client client = new Client("0" , "0" , "0" , "0" , "0" );
	            	
		            client.setClientID( answer );
	 
	               System.out.println("Type client's name (string , do not leave space between words)");
	               client.setClientName( sc.next() );
	 
	                System.out.println("Type client's surname (string , do not leave space between words)");
	                client.setClientSurName( sc.next() );
	 
	 
	                System.out.println("Type client's address (string , do not leave space between words)");
	                client.setClientAddress( sc.next() );
	                
	                System.out.println("Type client's phone number (string , do not leave space between numbers or symbols)");
	                client.setClientPhoneNum( sc.next() );
	 
	                clientList.add(client);
	    
	              }
	    	 	    	 	 
	    
	     }
	     
	     if(choise==4)
	     {
	    	 int counter=0;
	    	 int pos=0;
	    	boolean noRooms=true ;
	    	
	    	Date dateIn ;
	    	 Date dateOut ;
	    	 
	    	 /*create Date objects in order to handle given dates */
	    	do {
	    
	    	System.out.println(" Give date of check in ( MM/dd/yyyy ) ");
	    	 dateIn =new Date ( sc.next() ) ;
	    	 
	    	 
	    	
	    	
	    	System.out.println("Give date of check out ( MM/dd/yyyy ) ");
	          dateOut = new Date ( sc.next() ) ;
	         
	    	}while( dateOut.before(dateIn) || dateOut==(dateIn) ) ;
	         
	    	
	    	System.out.printf( "Available rooms : \n\n" ) ;
	    	
	    	int m,n;
	    	if(firstTime == true) {
	    		/*this if statement only works for the first time that user wants to make a reservation */
	    		System.out.printf( " All rooms are available \n\n" ) ;
	    		
	    		for( m=0 ; m < (floors+1) ; m++) 
			       {	    		
		    		for( n=0 ; n < floorRooms ; n++ )
		    		{
		    			if(m==0)
		    		System.out.printf("00"+Hotel[m][n]+"\t");
		    			else
		    				System.out.printf(Hotel[m][n]+"\t");
		    		}
		    		System.out.printf("\n");
			       }
	    		
	    		System.out.printf("\n");
	    		
	    	}
	    	else { /*this if statement works for all others reservations except the first*/
	    			    		 	         
	    		/*if  room from the roomList has not been reserved at all , display it*/	
   	         for(int i=0 ; i < roomList.size() ; i++)
   		    	{
   		    	          for(int j=0 ; j < resList.size() ; j++)
   		    	          {
   		    	             if( roomList.get(i).getRoomNum()  !=  resList.get(j).getRoom().getRoomNum()  )
   		    	               {
   		    	                  counter=(counter+1); 		    	                 
   		    	                }
	    	         
   		    	          }
   		    	          
   		    	          if( counter == resList.size() )
   		    	           {
   		    	        	  if(roomList.get(i).getRoomFloor() == 0) {
   		    	           System.out.printf( "00"+roomList.get(i).getRoomNum()+"\n" ) ; 
   		    	        noRooms=false ;
   		    	        	  }else {
   		    	        		 System.out.printf( roomList.get(i).getRoomNum()+"\n" ) ; 
   		   		    	        noRooms=false ;
   		    	        	  }
   		    	            }
   		    	          
   		    	       counter=0;
   		    	}
   	      /*if  room from the resList is available between the dates that user inputed above , display it*/
	    	         for ( int l=0 ; l < resList.size() ; l++)
	   	            {
	   		              
	   		              
	   		              if(  (  dateIn.before( resList.get(l).getCheckIn() ) )  &&   (  dateOut.before( resList.get(l).getCheckIn() ) )   )
	   		              {
	   		            	if(resList.get(l).getRoom().getRoomFloor() == 0) {
	    		    	           System.out.printf( "00"+roomList.get(l).getRoomNum()+"\n" ) ; 
	    		    	        noRooms=false ;
	    		    	        	  }else {
	    		    	        		 System.out.printf( roomList.get(l).getRoomNum()+"\n" ) ; 
	    		   		    	        noRooms=false ;
	    		    	        	  }
	   		              }
	   		              
	   		              if( (  dateIn.after( resList.get(l).getCheckOut() ) )  &&   (  dateOut.after( resList.get(l).getCheckOut() ) ) )
	   		              {
	   		            	if(resList.get(l).getRoom().getRoomFloor() == 0) {
	    		    	           System.out.printf( "00"+roomList.get(l).getRoomNum()+"\n" ) ; 
	    		    	        noRooms=false ;
	    		    	        	  }else {
	    		    	        		 System.out.printf( roomList.get(l).getRoomNum()+"\n" ) ; 
	    		   		    	        noRooms=false ;
	    		    	        	  }
	   		              }
	   		              
	   		           
	   		              if( (  dateIn == ( resList.get(l).getCheckOut() ) )  &&   (  dateOut.after( resList.get(l).getCheckOut() ) ) )
	   		              {
	   		            	if(resList.get(l).getRoom().getRoomFloor() == 0) {
	    		    	           System.out.printf( "00"+roomList.get(l).getRoomNum()+"\n" ) ; 
	    		    	        noRooms=false ;
	    		    	        	  }else {
	    		    	        		 System.out.printf( roomList.get(l).getRoomNum()+"\n" ) ; 
	    		   		    	        noRooms=false ;
	    		    	        	  }
	   		              }
	   		              
	   		           if( (  dateIn.before( resList.get(l).getCheckIn() ) )  &&   (  dateOut==( resList.get(l).getCheckIn() ) ) )
	   		              {
	   		        	if(resList.get(l).getRoom().getRoomFloor() == 0) {
 		    	           System.out.printf( "00"+roomList.get(l).getRoomNum()+"\n" ) ; 
 		    	        noRooms=false ;
 		    	        	  }else {
 		    	        		 System.out.printf( roomList.get(l).getRoomNum()+"\n" ) ; 
 		   		    	        noRooms=false ;
 		    	        	  }
	   		              }
	   		              
	   		             
	   		              
	   	              }
	    	         
	    	         
	    		    		    	         	    	           	    	
	    	}
	    	
	    	
	    	
if( (noRooms == false) || (firstTime==true) ) {
	
	        firstTime=false;
	    	
	    
	    	Reservation reservation = new Reservation();
	    	
	    	System.out.println("Please Select one room ");
	    	int roomCode = (sc.nextInt());
	    	
	    	int k = 0;
	    	
              for( k=0 ; k<roomList.size() ; k++ )
              {
              	if( roomCode == ( roomList.get(k).getRoomNum() )  )
              	{
              		reservation.setRoom( roomList.get(k) );
              		pos = k;
              		break;
              	}
              }
	
	    	
	    	
	    System.out.println("Type the ID code of the new client ");
		           String answer = new String( sc.next() );
		   
		   
		           boolean elementFound=false;
		           
	 	
		           for(int i=0 ; i<clientList.size() ; i++)
		              {
	                   if(  answer.equals( clientList.get(i).getClientID() ) )
	                     {
	                      elementFound=true;
	                       System.out.println("This client is already registered");		                 
	                       break;
	                     }
	                 }
		   
		            if(elementFound == false)
		             {
			            
		            	Client client = new Client("0" , "0" , "0" , "0" , "0" );
		            
			            client.setClientID( answer );
			            
		 
		               System.out.println("Type client's name (string , do not leave space between words)");
		               client.setClientName( sc.next() );
		 
		                System.out.println("Type client's surname (string , do not leave space between words)");
		                client.setClientSurName( sc.next() );
		 
		 
		                System.out.println("Type client's address (string , do not leave space between words)");
		                client.setClientAddress( sc.next() );
		                
		                System.out.println("Type client's phone number (string , do not leave space between numbers or symbols)");
		                client.setClientPhoneNum( sc.next() );
		                
		                clientList.add(client);
		               
		               
		              }
		      
	
			    	
			    	int t = 0;
		              for( t=0 ; t<clientList.size() ; t++ )
		              {
		              	if( answer.equals( clientList.get(t).getClientID() )  )
		              	{
		              		reservation.setClient( clientList.get(t) );
		              		break;
		              	}
		              }
			    	
			        int capacity;
			    	do {
			    		
			    	System.out.println("Type the number of people that are going to stay in the room ? ");			    	
			    	capacity = sc.nextInt();
			    	
			    	if(capacity > roomList.get(pos).getRoomSize())
			    		System.out.println("There is not enought room");
			    	
			    	}while( (capacity<0) || ( capacity > roomList.get(pos).getRoomSize() ));
			    		reservation.setPeople( capacity );
			    	
			    	int perc;
			    	do {
			    	System.out.println("Type percentage of discount ( integer only ,without % ) ? ");	
			    	perc=( sc.nextInt() );
			    	}while( perc <0 );
			    	reservation.setDiscount( perc );
			    	
			    				    	
			    	reservation.setCheckIn( dateIn );
			    				    	
			    	reservation.setCheckOut( dateOut );
			    	
			    	reservation.setTotalCost( roomList.get(pos).getRoomPrice() );
			    	
			    	
			    	
			    	resList.add(reservation);
/* if no rooms are available between given dates and this is not the first time that we make a book ,this else if works  */			    	
}else if( noRooms == true  ){
	    
	    if( firstTime== false )
	    System.out.println("No available rooms beetween given dateIn - dateOut ");
	    
	    }
	    	
	    	noRooms=true;
	    	
	
	     }
	     
	     if(choise==5)
	     {
	    	 System.out.printf("\n");
	    	 
	    	 int removeCode;
	    	 String date1 = new String();
	    	 String date2 = new String();
	    	 
	    	 for(int k=0 ; k < resList.size() ; k++)
	    	 {
	    		 date1 = new SimpleDateFormat("MM-dd-yyyy").format( resList.get(k).getCheckIn() );
	    			date2 = new SimpleDateFormat("MM-dd-yyyy").format( resList.get(k).getCheckOut() );
	    		 
				   System.out.printf("Code "+k+" refers to the reservation with the following information :  \n");
				   
				   if(resList.get(k).getRoom().getRoomFloor() == 0) {
				   System.out.printf("Room number : 00"+resList.get(k).getRoom().getRoomNum()+"\n"+
						             "Check in date : "+date1+"\n"+
						             "Check out date : "+date2+"\n" );
				   }else {
					   System.out.printf("Room number : "+resList.get(k).getRoom().getRoomNum()+"\n"+
					             "Check in date : "+date1+"\n"+
					             "Check out date : "+date2+"\n" );
				   }
		
				   System.out.printf("\n");
	    	 }
	    	 
	    	 
	    	 
	    	 
			 do {
				   System.out.println("Type reservation's code in order to remove it  ");
	                removeCode = sc.nextInt() ;
		         }while( (removeCode<0) || ( removeCode>resList.size() ) );
	    	 
	    	 
	    	 
	    	 
	    	 for (int i=0 ; i < resList.size() ; i++)
	    	 {
	    		 if( removeCode == i )
	    		 {
	    			resList.remove(i);
	    			System.out.println(" Reservation removed successfuly ");
	    			break;
	    			
	    		 }
	    	 }
	    	 
	    	 
	    	 
	    	 
	     }
	     
	     if(choise==6)
	     {
	    	 
	    	 int num;
	    	 int resNum ;
	    	 int code2;
	    	 String date3=new String();
	    	 String date4=new String();
	    	 
	    	 for(int k=0 ; k < resList.size() ; k++)
	    	 {
	    		 date3 = new SimpleDateFormat("MM-dd-yyyy").format( resList.get(k).getCheckIn() );
	    			date4 = new SimpleDateFormat("MM-dd-yyyy").format( resList.get(k).getCheckOut() );
	    		 
				   System.out.printf("Code "+k+" refers to the reservation with the following information :  \n");
				   
				   if(resList.get(k).getRoom().getRoomFloor() == 0) {
				   System.out.printf("Room number : 00"+resList.get(k).getRoom().getRoomNum()+"\n"+
						             "Check in date : "+date3+"\n"+
						             "Check out date : "+date4+"\n" );
				   }else {
					   System.out.printf("Room number : "+resList.get(k).getRoom().getRoomNum()+"\n"+
					             "Check in date : "+date3+"\n"+
					             "Check out date : "+date4+"\n" );
				   }
		
				   System.out.printf("\n");
	    	 }
	    	 
	    	  
	    		    System.out.println("Type reservation's code as displayed above ");
	                code2 = sc.nextInt() ;
	                resNum = resList.get(code2).getRoom().getRoomNum() ;
		         
	    	
	    	 double total = 0;
	    	 
	    	 int posRoom = 0;
	    	 
	    	 int posRes=0;
	    	 
	    	 int i;
	    	 
	    	 for (i=0 ; i < resList.size() ; i++)
    	     {
	    		 if( resNum == resList.get(i).getRoom().getRoomNum() )
	    		 {
	    			 /* store Room's (maybe superior) position at resList */
	    			 posRes=i;  
	    			 break;
	    		 }
	    		 
    	     }
	    	 
	    	 boolean found=false;
	    	 
	    	 int k;
	    	 for ( k=0 ; k < roomList.size() ; k++)
    	     {
		          if( ( resNum == roomList.get(k).getRoomNum() ) && (roomList.get(k) instanceof SuperiorRoom) )
		          {
		        	  found=true;
		        	  /* store SuperiorRoom's position at roomList */
		        	  posRoom = k;
		        	  break;
		          }
	    	 
    	     }
	    	 
	    	 
	    	 
	   if(found == true) /* if inputed room number refers to a SuperiorRoom */ 
	   {
		   
		   
		   if(resList.get(posRes).getRoom().getRoomFloor() == 0) {
	     	System.out.printf("Available amenities for 00"+resNum+" room : \n");
		   }else {
			   System.out.printf("Available amenities for "+resNum+" room : \n");
		   }
	     	
	     	for(i=0 ; i < ( ((SuperiorRoom)(roomList.get(posRoom))).getCounter() ) ; i++) {
	     		System.out.println( ((SuperiorRoom)(roomList.get(posRoom))).getRoomAmenities(i).toString() );
	     		System.out.printf("\n");
	     	}
	     	
	     	System.out.printf("\n\n");
	     	
	     	
	     	
	     	System.out.println("How many amenities would you like to choose ( type the number ) ? " ); 
	     	 num = sc.nextInt();
	     	
	         
	     	
	     	total = roomList.get(posRoom).getRoomPrice() ;
	     	double discount = resList.get(posRes).getDiscount() ;
	     	double amTotal=0;
	        
	    		   for(int t=0 ; t < num ; t++)
	    		       {
	    			   
	    			   System.out.println("give "+(t+1)+"st code" );
	    			   String code = new String( sc.next() );
	    			   
	    			       			   
	    			     for(int j=0 ; j < amenityList.size() ; j++)
	    			     {
	    		              if( code.equals( amenityList.get(j).getAmenityCode() ) )
	    		        		   {    		        	 
	    		        		     amTotal= amTotal + ( amenityList.get(j).getAmenityPrice() ) ;
	    		        		     resList.get(posRes).setAmenities( amenityList.get(j) );
	    		        		     }
	    			     }
	    			    	    			     
	    				    			     
	    		       }

        		    
      		     total=( (amTotal+total) - ( ( (amTotal+total) * ( discount ) ) / 100 ) );
      		     
      		     
      		     resList.get(posRes).setTotalCost( total );
	    		   
	    		   
	    		   total=0;
	    		   amTotal=0;

	  }
	   
	   
	   
	     }
	     
	     if(choise==7)
	     {
	    	 
	    	 int counter = 0 ;
	    	 Date dateIn;
	    	 Date dateOut;
	    	 
	    	 do {
	    	 System.out.println("Give date of check in ( MM/dd/yyyy) ");
		    	dateIn = new Date( sc.next() );
		    	
		    	System.out.println("Give date of check out ( MM/dd/yyyy) ");
		    	dateOut = new Date( sc.next() );
	    	 }while( dateOut.before(dateIn) || dateOut==(dateIn) );
		    	
		    	System.out.println( "Available rooms : " ) ;
		    	System.out.printf( "\n" ) ;
		    	
		    	int i, j , l ;
		    	for(i=0 ; i < roomList.size() ; i++)
		    	{
		    	          for(j=0 ; j < resList.size() ; j++)
		    	          {
		    	             if( roomList.get(i).getRoomNum()  !=  resList.get(j).getRoom().getRoomNum()   )
		    	               {
		    	                  counter=(counter+1);
		    	                }
		    	          }

		    	          if( counter == resList.size() ) {
		    	        	  if(roomList.get(i).getRoomFloor() == 0) {
		   		    	           System.out.printf( "00"+roomList.get(i).getRoomNum()+"\n" ) ; 
		   		    	        	  }else {
		   		    	        		 System.out.printf( roomList.get(i).getRoomNum()+"\n" ) ; 
		   		    	        	  }
		    	          }

		    	          counter = 0;
		    	}
		    	
		    	 for ( l=0 ; l < resList.size() ; l++)
	   	            {
	   		              
	   		              
	   		              if(  (  dateIn.before( resList.get(l).getCheckIn() ) )  &&   (  dateOut.before( resList.get(l).getCheckIn() ) )   )
	   		              {
	   		            	if(resList.get(l).getRoom().getRoomFloor() == 0) {
	  		    	           System.out.printf( "00"+roomList.get(l).getRoomNum()+"\n" ) ; 
	  		    	        	  }else {
	  		    	        		 System.out.printf( roomList.get(l).getRoomNum()+"\n" ) ; 
	  		    	        	  }
	   		              }
	   		              
	   		              if( (  dateIn.after( resList.get(l).getCheckOut() ) )  &&   (  dateOut.after( resList.get(l).getCheckOut() ) ) )
	   		              {
	   		            	if(resList.get(l).getRoom().getRoomFloor() == 0) {
		  		    	           System.out.printf( "00"+roomList.get(l).getRoomNum()+"\n" ) ; 
		  		    	        	  }else {
		  		    	        		 System.out.printf( roomList.get(l).getRoomNum()+"\n" ) ; 
		  		    	        	  }
	   		              }
	   		              
	   		           
	   		              if( (  dateIn == ( resList.get(l).getCheckOut() ) )  &&   (  dateOut.after( resList.get(l).getCheckOut() ) ) )
	   		              {
	   		            	if(resList.get(l).getRoom().getRoomFloor() == 0) {
		  		    	           System.out.printf( "00"+roomList.get(l).getRoomNum()+"\n" ) ; 
		  		    	        	  }else {
		  		    	        		 System.out.printf( roomList.get(l).getRoomNum() +"\n") ; 
		  		    	        	  }
	   		              }
	   		              
	   		           if( (  dateIn.before( resList.get(l).getCheckIn() ) )  &&   (  dateOut==( resList.get(l).getCheckIn() ) ) )
	   		              {
	   		        	if(resList.get(l).getRoom().getRoomFloor() == 0) {
	  		    	           System.out.printf( "00"+roomList.get(l).getRoomNum()+"\n" ) ; 
	  		    	        	  }else {
	  		    	        		 System.out.printf( roomList.get(l).getRoomNum()+"\n" ) ; 
	  		    	        	  }
	   		              }
	   		              
	   		              
	   		              
	   	              }
    	
	     }
	    	 
	     
	     if(choise==8)
	     {
	    	 
	    	 
	    	 System.out.println( "Please give date ( MM/dd/yyyy ) " ) ;
		    	Date date = new Date( sc.next() );
		    	
		    	System.out.printf( "Available rooms : \n\n" ) ;
		    	
	    	/*create a new array with the same items as Hotel , but this sHotel's type is string  */
		    	
		    	String[][] sHotel  = new String[ (floors+1) ][floorRooms];
		    	
		    	String str2 = new String();
		    	
		    	int i , j;
		    	
		    	for(i=0 ; i < (floors+1) ; i++) 
			       {		    		
		    		for( j=0 ; j < floorRooms ; j++ )
		    		{		    			
		    			if(i == 0) {
		    			
		    			str2 = String.valueOf(Hotel[i][j]);
		    			
		    			sHotel[i][j] = ("00"+str2); 
		    			}else {
		    				String str = String.valueOf(Hotel[i][j]);
			    			
			    			sHotel[i][j] = (str); 		    				
		    			}
	    			
		    		}
		    		
			       }
		    	
		 
		    	/* check for reserved rooms between inputed dates and change the items of sHotel */
		    	int k,l;
		    	
		       for(l=0 ; l < resList.size() ; l++) 
		       {
		    	   if(  (  date.after(resList.get(l).getCheckIn() ) )  &&   ( date.before( resList.get(l).getCheckOut() ) ) )	    		   
		    	   {
		    		 
		               for(   k=0 ; k<(floors+1) ; k++)
		               { 

		                for (   j=0 ; j<floorRooms ; j++ ) 
		                 {
		                	
		                		if( Hotel[k][j] == resList.get(l).getRoom().getRoomNum()  )
			                	   {
		                			
		                			sHotel[k][j] = ("[ "+sHotel[k][j]+" ]");
		                			
			                	   }
		                	
		                	}
			               
		                }
		      

		             } 
		    	   
		    	   if( date == ( resList.get(l).getCheckIn() ) ) {
		    		   for(   k=0 ; k<(floors+1) ; k++)
		               { 

		                for (   j=0 ; j<floorRooms ; j++ ) 
		                 {
		                	
		                		if( Hotel[k][j] == resList.get(l).getRoom().getRoomNum()  )
			                	   {
		                			
		                			sHotel[k][j] = ("[ "+sHotel[k][j]+" ]");
		                			
			                	   }
		                	
		                	}
			               
		                }
		    		   
		    	   }
		    	              
		    }
		       
		       
		    	/*Display sHotel Array with the changes made above */
		       
		       int p,o;
		       for( p=0 ; p < (floors+1) ; p++) 
		       {	    		
	    		for( o=0 ; o < floorRooms ; o++ )
	    		{
	    		System.out.printf(sHotel[p][o]+"\t");
	    		}
	    		System.out.printf("\n");
		       }
		       
		       /* undo changes at sHotel Array , in order to use option 8 again later */
		       for(i=0 ; i < (floors+1) ; i++) 
		       {	    		
	    		for(  j=0 ; j < floorRooms ; j++ )
	    		{	    			
	    			if(i == 0) {
	    			
	    			 str2 = String.valueOf(Hotel[i][j]);
	    			
	    			sHotel[i][j] = ("00"+str2); 
	    			}else {
	    				 str2 = String.valueOf(Hotel[i][j]);
		    			
		    			sHotel[i][j] = (str2); 	    				
	    			}
 			
	    		}
	    		
		       }
		       
		       System.out.printf( "\n" ); 
		}  

	     
	   
	}while( choise != 0 );
				
	
	sc.close();
	
	}




	
}

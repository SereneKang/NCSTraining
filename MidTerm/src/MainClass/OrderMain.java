
//Name: Kang Kui Xuan 
package MainClass;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Map.Entry;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import exceptions.InvalidCategryException;
import model.Order;
import service.IOrderService;
import sorting.sortOrder;

public class OrderMain implements IOrderService{
	
	Scanner sc=new Scanner(System.in);
	Scanner scString=new Scanner(System.in);
	
	public List<Order> getSample() {
		String line="";
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("d-MMM-yy");
		BufferedReader bufferedRead;
		List<Order> orderList=new ArrayList<>();
		
		try {
			bufferedRead = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.14.1.RELEASE\\MidTerm\\Order.csv"));
			while((line=bufferedRead.readLine())!=null) {
			
				String data[]=line.split(",");
			
				try {
					String getUser=data[0];
					String getCatogory=data[1];
					int getCost=Integer.parseInt(data[2]);
					LocalDate getDate=LocalDate.parse(data[3],formatter);
					String getAction=data[4];
					orderList.add(new Order(getUser,getCatogory,getCost,getDate,getAction));
					
				}catch(Exception e) {
					e.printStackTrace();
				}	
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return orderList;
	}
	
	
	public static void main(String[] args) {
		
		
		OrderMain obj=new OrderMain();
		int mainexist=0,exist1,exist2,exist3,exist4,exist5,exist6,exist7,exist8;
		
		while (mainexist==0) {
			System.out.println("\n=======================================Main Menu=======================================");
			System.out.println("1. Get All Orders By Category ");
			System.out.println("2. Get Total Order Cost");
			System.out.println("3. Get All Canceled Order");
			System.out.println("4. Create Order Map By User");
			System.out.println("5. Filter Orders ");
			System.out.println("6. Get Orders Based On Order Value");
			System.out.println("7. Generate PDF Reports");
			System.out.println("8. Exit");
			int choice=obj.sc.nextInt();
			
			switch (choice) {
			case 1:{
				exist1=1;
				while(exist1==1) {
					
					System.out.print("Category of Orders: ");
					String categories=obj.scString.next();
					try {
						obj.getAllOrdersByCategory(categories).stream().forEach((a)->System.out.println(a));
						
					
					} catch (InvalidCategryException e) {
						
						System.out.println(e.getMsg());
				}
					
					System.out.println();
					System.out.println("****************************************************************************");
					System.out.println("*                      0. Back to Main Menu                                *");
					System.out.println("*                      1. Continue                                         *");
					System.out.println("****************************************************************************");
					System.out.println("\nPlease enter your choice: ");
					exist1=obj.sc.nextInt();
				}
				
				break;
			}
			case 2:{
				exist2=1;
				while(exist2==1) {
					
					System.out.print("Category of Orders: ");
					String cOrder=obj.scString.next();
					
					try {
						int total=obj.getTotalOrderCost(cOrder);
						System.out.println("Total cost of "+cOrder+": "+total); 
						
					} catch (InvalidCategryException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMsg());
						
					}
					
					System.out.println();
					System.out.println("****************************************************************************");
					System.out.println("*                      0. Back to Main Menu                                *");
					System.out.println("*                      1. Continue                                         *");
					System.out.println("****************************************************************************");
					System.out.println("\nPlease enter your choice: ");
					exist2=obj.sc.nextInt();
				}
				
				break;
			}	
			case 3:{
				exist3=1;
				while(exist3==1) {
					
					obj.getAllCanceledOrder().stream().forEach((a)->System.out.println(a));
					
					
					
					System.out.println();
					System.out.println("****************************************************************************");
					System.out.println("*                      0. Back to Main Menu                                *");
					System.out.println("*                      1. Continue                                          *");
					System.out.println("****************************************************************************");
					System.out.println("\nPlease enter your choice: ");
					exist3=obj.sc.nextInt();
				}
				
				break;
			}	
			case 4:{
				exist4=1;
				while(exist4==1) {
			
					Map<String,List<Order>> map=obj.createOrderMapByUser();
					
					for(Entry<String,List<Order>> entry:map.entrySet()) {
						
					
						System.out.println(entry);
					}
					
				
					
				
					
					System.out.println();
					System.out.println("****************************************************************************");
					System.out.println("*                      0. Back to Main Menu                                *");
					System.out.println("*                      1. Continue                                         *");
					System.out.println("****************************************************************************");
					System.out.println("\nPlease enter your choice: ");
					exist4=obj.sc.nextInt();
				}
				
				break;
			}	
			case 5:{
				exist5=1;
				while(exist5==1) {
					
					System.out.print("Action of Orders: ");
					String action=obj.scString.next();
					
					obj.filterOrders(action).stream().forEach((a)->System.out.println(a));
					
					System.out.println();
					System.out.println("****************************************************************************");
					System.out.println("*                      0. Back to Main Menu                                *");
					System.out.println("*                      1. Continue                                         *");
					System.out.println("****************************************************************************");
					System.out.println("\nPlease enter your choice: ");
					exist5=obj.sc.nextInt();
					
				}
				
				break;
			}	
			case 6:{
				exist6=1;
				while(exist6==1) {
					
					obj.getOrdersBasedOnOrderValue().stream().forEach((o)->System.out.println(o));
					
					System.out.println();
					System.out.println("****************************************************************************");
					System.out.println("*                      0. Back to Main Menu                                *");
					System.out.println("*                      1. Continue                                         *");
					System.out.println("****************************************************************************");
					System.out.println("\nPlease enter your choice: ");
					exist6=obj.sc.nextInt();
				}
				
				break;
			}	
			case 7:{
				exist7=1;
				while(exist7==1) {
					
					if(obj.generatePDFReports()) {
						System.out.println("\nCongrats! Generate PDF Report Successfully !!! \n");
					}else {
						System.out.println("\n\t\tError! Cannot write PDF Report !!!");
					}
					
					System.out.println();
					System.out.println("****************************************************************************");
					System.out.println("*                      0. Back to Main Menu                                *");
					System.out.println("*                      1. Continue                                         *");
					System.out.println("****************************************************************************");
					System.out.println("\nPlease enter your choice: ");
					exist7=obj.sc.nextInt();
				}
				
				break;
			}	
			case 8:{
				
				System.out.println("======================================= Thank You For Using , Have A Nice Day=======================================");
				mainexist=1;
				break;
			}	
			default:
				break;
			}
		}

	}//end of main

	
	@Override
	public List<Order> getAllOrdersByCategory(String category) throws InvalidCategryException {
	
		List<Order> orderList=getSample();
		List<Order> newList=new ArrayList<>();
		
			for(Order o:orderList) {
				if(o.getCategory().equalsIgnoreCase(category))
					newList.add(o);
					
			}
			
			if(newList.isEmpty()) {
				throw new InvalidCategryException();
			}
		
		return newList;
	}

	@Override
	public int getTotalOrderCost(String category) throws InvalidCategryException {
	
		int total=0;
		List <Order> getList=getSample();
		
		for(Order order:getList) {
			if(order.getCategory().equalsIgnoreCase(category)&&order.getAction().equals("delivered")) {
				total+=order.getOrderCost();
			}
			
		}
		if(total==0) {
			throw new InvalidCategryException();
		}
		
		return total;
	}

	@Override
	public List<Order> getAllCanceledOrder() {

		List <Order> allOrderList=getSample();
		List <Order> newList=new ArrayList<>();
		
			for(Order o:allOrderList) {
				if(o.getAction().equalsIgnoreCase("Cancelled")) {
					newList.add(o);
				}
			}
		
		
		return newList;
	}

	@Override
	public Map<String, List<Order>> createOrderMapByUser() {
		
		Map<String, List<Order>> orderMapbyUser=new HashMap<>();
		String line="";
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("d-MMM-yy"); 
		BufferedReader bufferedRead;
		List <Order> allOrderList=new ArrayList<>();
		List <String> newList=new ArrayList<>();
		String getUser=new String();
		String getCatogory=new String();
		int getCost=0;
		LocalDate getDate;
		String getAction=new String();
		
		try {
			bufferedRead = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.14.1.RELEASE\\MidTerm\\Order.csv"));
			while((line=bufferedRead.readLine())!=null) {
			
				String data[]=line.split(",");
			
			
					getUser=data[0];
					getCatogory=data[1];
					getCost=Integer.parseInt(data[2]);
					getDate=LocalDate.parse(data[3],formatter);
					getAction=data[4];
					allOrderList.add(new Order(getUser,getCatogory,getCost,getDate,getAction));

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			
			for(Order order:allOrderList) {
				if(!getUser.contains(order.getUsername())) {
					newList.add(order.getUsername());
				}
			}
			for(String userName:newList) {
				List <Order> newAllOrderList=new ArrayList<>();
				for(Order o:allOrderList) {
					if(o.getUsername().equals(userName)) {
						newAllOrderList.add(o);
					}
				}
				orderMapbyUser.put(userName, newAllOrderList);
			}
			
		}
		
		
		return orderMapbyUser;
	}

	@Override
	public List<Order> filterOrders(String action) {
		
		List <Order> newAllOrderList=getSample();
		List <Order> filterList=new ArrayList<>();
	
			for(Order o:newAllOrderList) {
				if(o.getAction().equalsIgnoreCase(action)) {
					filterList.add(o);
				}
			}
	
		
		return filterList;
	}

	@Override
	public List<Order> getOrdersBasedOnOrderValue() {
		List<Order> sortOrderList=getSample();
		sortOrder sortO=new sortOrder();
		Collections.sort(sortOrderList,sortO);
		System.out.println("\n===================== Sort By Price =====================\n");
		
		
		return sortOrderList;
	}

	@Override
	public boolean generatePDFReports() {
		
		boolean readStatus=false;
		List<Order> pdfUsed=getSample();
		int countDelivered=0,countCancel=0;
		String msg1=new String();
		String msg2=new String();

		String fileName="C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.14.1.RELEASE\\MidTerm\\Order.pdf";
		
		
		for(Order o:pdfUsed) {
			
			if(o.getAction().equalsIgnoreCase("Delivered")) {
				++countDelivered;
			}else
				++countCancel;
			
		}
	
		msg1="Total delivered orders: "+countDelivered;
		msg2="Total cancelled orders: "+countCancel;
		
		 PDDocument doc=new PDDocument();
		   
		try {
			
			PDPage page=new PDPage();
			doc.addPage(page);
			
			PDPageContentStream cs = new PDPageContentStream(doc, page);
			cs.beginText();
			cs.setFont(PDType1Font.HELVETICA, 14);
			cs.setLeading(17f);
			cs.newLineAtOffset(25, 725);
		    cs. showText(msg1);
		    cs.newLine();
		    cs. showText(msg2);
		    cs.endText();
		    cs.close();
		     doc.save(fileName);
		     doc.close();
		     readStatus=true;
		}catch(IOException e) {
			e.printStackTrace();
			readStatus=false;
		}
		
		
		return readStatus;
	}

}//end of class

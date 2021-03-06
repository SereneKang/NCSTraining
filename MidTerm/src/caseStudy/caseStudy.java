package caseStudy;

public class caseStudy {

	/*
	 Case Study 
=========================

This is the case study where Order.csv file & pdfbox.jar is given


Create a menu driven application to implement the use cases available in IOrderService interface

and create pdf file using file handling PDFBox API.

Step1 : to create appropriate Order bean class based on csv file columns.

following is the requirement specifications
-----------------------------------------

A) public List<Order> getAllOrdersByCategory(String category)throws InvalidCategryException;

   method should return the list of orders based on category (Order.csv)

B)	public int getTotalOrderCost(String category)throws InvalidCategryException;
  Method should return the total value of the order based on category and action should be only delivered
  
c)	public List<Order> getAllCanceledOrder();
 method returns all the cancel orders.
 
d) 	public Map<String, List<Order>> createOrderMapByUser(); 
   
   Business stake holders are interested to view orders based on category , so store order in the form of Map , where key is username , value is List of orders

e)	public List<Order> filterOrders(String action); 
    Filter order based on action.

f) public List<Order> getOrdersBasedOnOrderValue(); 
  sort the orders based on order cost 
	
 g) public boolean generatePDFReports(); 
 method will count the number of orders based on cash payment , online payment and unpaid orders , delivered or cancelled
    
    
*/
	
}

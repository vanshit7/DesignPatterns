package DesignPattern;

import java.util.Scanner;

public class StrategyDesignPattern {

	static interface Payment {
		
		public void collectPaymentDetails();
		public void MakePayment();
		public String getPayString();
	}
	
	static class creditCard implements Payment {

		String payString = "Credit Card";
		@Override
		public void collectPaymentDetails() {
			System.out.println("Enter Credit Card Details!!!");
			
		}

		@Override
		public void MakePayment() {
			System.out.println("Payment Done using  Credit Card!!!");
			
		}
		
		public String getPayString()
		{
			return payString;
		}
		
	}
	
	static class googlePay implements Payment {

		private String payString= "Google Pay";
		@Override
		public void collectPaymentDetails() {
			System.out.println("Enter Google Pay Details!!!");
			
		}

		@Override
		public void MakePayment() {
			System.out.println("Payment Done using Google Pay!!!");
			
		}
		
		public String getPayString()
		{
			return payString;
		}
		
	}
	
	static class Order {
		int order_id;
		int amount;
		int items;
		Payment pay_method;
		
		Order(int order_id, int amount,int items,Payment pay_method){
			this.order_id = order_id;
			this.amount = amount;
			this.items = items;
			this.pay_method = pay_method;
		}
		
		public void placeOrder() {
			pay_method.collectPaymentDetails();
			pay_method.MakePayment();
		}
		
	}
	
	public static void main(String[] args) {
		
		Payment cc = new creditCard();
		Payment gpay = new googlePay();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the order amount: ");
		int amount = sc.nextInt();
		System.out.println("Enter the number of items in the order: ");
		int items = sc.nextInt();
		System.out.println("Select  the payment Method:\n 1. Credit Card\n 2. Google Pay");
		int pay = sc.nextInt();
		Payment method;
		if(pay==1) method=cc;
		else method=gpay;
		
		System.out.println("Placing order using " + method.getPayString());
		sc.close();
		Order order = new Order((int)Math.random()*(100)+1, amount, items, method);
		order.placeOrder();
		
		

	}

}

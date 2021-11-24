package DesignPattern.ObserverDemo;

public class User implements Observer{
	
	private String userName;
	User(String userName){
		this.userName=userName;
	}
	
	@Override
	public void update(String msg, String Channel) {
		System.out.println("Hi "+ userName + ". A new video : " + msg + 
				" has been uploaded on the channel : " + Channel);
	}
}

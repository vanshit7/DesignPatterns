
package DesignPattern;

class UpgradedRed extends Box{
	String color="RED";
	int point=40;
	
	@Override
	public String getColor() {
		System.out.println("color is : " + color);
		return color;
	}
	
	@Override
	public int getPoints() {
		System.out.println("points are : " + point);
		return point;
	}
	
}

class UpgradedGreen extends Box{
	String color="GREEN";
	int point=20;
	
	@Override
	public String getColor() {
		System.out.println("color is : " + color);
		return color;
	}
	
	@Override
	public int getPoints() {
		System.out.println("points are : " + point);
		return point;
	}
	
}

abstract class abstractDriver {
	abstract Box createBoxObject(String color);
}
//the driver class which will create the objects at runtime,
//note that we are not exposing the object creation logic to the user in our main function.
class GameDriver1 extends abstractDriver{
	
	@Override
	public Box createBoxObject(String color) {
		switch(color) {
		case "RED" : return new Red();
		case "GREEN" : return new Green();
		}
		return null;
	}
}

class UpgradedGameDriver extends abstractDriver{
	@Override
	public Box createBoxObject(String color) {
		switch(color) {
		case "RED" : return new UpgradedRed();
		case "GREEN" : return new UpgradedGreen();
		}
		return null;
	}
}

class abstractDriverProducer {
	
	public static abstractDriver getDriver(Boolean upgraded) {
		if(upgraded)
		{
			return new UpgradedGameDriver();
		}
		else
			return new GameDriver1();
	}
	
}


//here we do not even expose the factory classes to the client, so consider this as an additional
//wrapper on the factory class so that we hide the factory classes from the client
//this is usually helpful when you have multiple factory classes.
//notice that we defined a abstractFactory class which will be the factory class for our already defined
//factory classes such as GameDriver and UogradedGameDriver.
//Additionally we created a AbstractDriverProducer to be able to get the abstractDriver class object.
public class AbstractFactoryMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		abstractDriver adp = new abstractDriverProducer().getDriver(true);
		int total = 0;
		for(int i=0;i<100;i++)
		{
			if(i%2==0)
			{
				adp.createBoxObject("RED").getShape();
				total += adp.createBoxObject("RED").getPoints();
			}
			else
			{
				adp.createBoxObject("GREEN").getShape();
				total += adp.createBoxObject("GREEN").getPoints();
			}
				
		}
		System.out.println("The total score is : " + total);
	}

}

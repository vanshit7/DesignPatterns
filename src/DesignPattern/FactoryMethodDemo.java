
package DesignPattern;

//the interface contains the common properties of the different object classes.
//if we have some functions that can be implemented right away in this common class like if the shape
//of all the boxes is sqaure, then we can also use a class instead of an interface and create a function
//to return shape. 
//interface Box {
//	public String getColor();
//	public int getPoints();
//}

abstract class Box {
	String shape = "SQUARE";
	public void getShape() {
		System.out.println("shape is : " + shape);
		//return shape;
	}
	public abstract String getColor();
	public abstract int getPoints();
}
class Green extends Box{
	String color="GREEN";
	int point=2;
	
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

class Red extends Box{
	String color="RED";
	int point=4;
	
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

//the driver class which will create the objects at runtime,
//note that we are not exposing the object creation logic to the user in our main function.
class GameDriver {
	public Box createBoxObject(String color) {
		switch(color) {
		case "RED" : return new Red();
		case "GREEN" : return new Green();
		}
		return null;
	}
}

public class FactoryMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameDriver gd = new GameDriver();
		int total = 0;
		for(int i=0;i<100;i++)
		{
			if(i%2==0)
			{
				gd.createBoxObject("RED").getShape();
				total += gd.createBoxObject("RED").getPoints();
			}
			else
			{
				gd.createBoxObject("GREEN").getShape();
				total += gd.createBoxObject("GREEN").getPoints();
			}
				
		}
		System.out.println("The total score is : " + total);
	}

}

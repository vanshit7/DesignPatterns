package DesignPattern;

class Singleton {
	private static Singleton instance;  //declared it private and static-> private because we do not want 
	//any outside class to be able to access this instance directly.
	//static because we need only one copy of this instance.
	private Singleton() {
		
	}
	
	//we need to make this function public because we will expose this function to outside classes so that
	//they can get the instance.
	//we need to make this static because we cannot create the object from outside classes, so if we 
	//want outside classes to access this function, then it should be accessible from the class name itself
	//hence static.
	public synchronized static Singleton getInstance() {
		if(instance==null) {  //if the object is not yet created, create it
			System.out.println("new object of singleton created");
			instance  = new Singleton();
		}	
		return instance; 
	}
	
	public void stream(String user) {
		System.out.println(user + " is watching right now..." + instance + " is the object");
	}
}
public class SingletonMethodDemo {

	public static void main(String[] args) {

		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Singleton user1 = Singleton.getInstance();
				user1.stream("JOHN");
			}
			
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Singleton user2 = Singleton.getInstance();
				user2.stream("SACHIN");
			}
			
		});
		t2.start();
	}

}


//notice that the same instance is being used even though we are calling the getInstance method for 2 different
//users
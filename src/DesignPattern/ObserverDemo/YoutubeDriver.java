package DesignPattern.ObserverDemo;

public class YoutubeDriver {

	public static void main(String[] args) {
		
		Channel ch = new Channel("Placement Prep");
		
		User u1 = new User("Vanshit");
		User u2 = new User("Nikhil");
		User u3  = new User("Krishan");
		
		ch.subscribe(u3);
		ch.videoUpload("Factory Design Pattern");
		
		ch.subscribe(u1);
		ch.subscribe(u2);
		ch.videoUpload("Observer Design Pattern");
	}

}

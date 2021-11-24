package DesignPattern.ObserverDemo;

public interface Subject {

	public void subscribe(Observer obs);
	public void unsubscribe(Observer obs);
	public void NotifyAll(String msg);
}

package DesignPattern.ObserverDemo;

import java.util.ArrayList;

public class Channel implements Subject{

	private String ChannelName;
	private ArrayList<Observer> list = new ArrayList<Observer>();
	Channel(String ChannelName){
		this.ChannelName = ChannelName;
	}
	
	@Override
	public void subscribe(Observer obs)
	{
		list.add(obs);
	}
	
	@Override
	public void unsubscribe(Observer obs) {
		list.remove(obs);
	}
	
	@Override
	public void NotifyAll(String msg) {
		for(Observer obs : list)
		{
			obs.update(msg,ChannelName);
		}
	}
	
	public void videoUpload(String msg) {
		NotifyAll(msg);
	}
}

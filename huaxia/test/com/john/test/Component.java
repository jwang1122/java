package com.john.test;

public class Component {
	
	public Component(){
		System.out.println("constructor()...");
		getDerivedStateFromProps();
		if(!shouldComponentUpdate()) {
			return;
		};
		render();
		componentDidMount();
	}
	
	void getDerivedStateFromProps() {};
	void render() {};
	void componentDidMount() {};
	boolean shouldComponentUpdate(){return false;};
}

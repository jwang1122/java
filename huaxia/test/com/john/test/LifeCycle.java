package com.john.test;

public class LifeCycle extends Component {

	@Override
	void componentDidMount() {
		System.out.println("componentDidMount()...");
	}

	
	@Override
	boolean shouldComponentUpdate() {
		return true;
	}


	@Override
	void render() {
		System.out.println("render()...");
	}


	public static void main(String[] args) {
		new LifeCycle();	
	}

}

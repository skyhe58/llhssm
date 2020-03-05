package com.soecode.lyf.Listener;

/**
 * @author llh @date 2020/3/5
 */
/**
 * 2.事件对象
 */
public class Even {

	private Robot robot;

	public Even(){
		super();
	}
	public Even(Robot robot){
		super();
		this.robot = robot;
	}


	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}
}
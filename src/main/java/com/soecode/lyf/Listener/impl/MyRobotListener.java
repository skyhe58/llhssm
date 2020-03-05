package com.soecode.lyf.Listener.impl;

import com.soecode.lyf.Listener.Even;
import com.soecode.lyf.Listener.Robot;
import com.soecode.lyf.Listener.RobotListener;

/**
 * @author llh @date 2020/3/5
 *
 * 4.实现事件监听器MyRobotListener：
 */
public class MyRobotListener implements RobotListener {
	@Override
	public void working(Even even) {
		Robot robot = even.getRobot();
		System.out.println("机器人工作提示：请看管好的你机器人，防止它偷懒！");
	}

	@Override
	public void dancing(Even even) {
		Robot robot = even.getRobot();
		System.out.println("机器人跳舞提示：机器人跳舞动作优美，请不要走神哦！");
	}
}
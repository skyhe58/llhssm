package com.soecode.lyf.Listener;

import com.soecode.lyf.Listener.impl.MyRobotListener;

/**
 * @author llh @date 2020/3/5
 *
 * 执行顺序如下：
 *
 * 1、给事件源注册监听器。
 * 2、组件接受外部作用，也就是事件被触发。
 * 3、组件产生一个相应的事件对象，并把此对象传递给与之关联的事件处理器。
 * 4、事件处理器启动，并执行相关的代码来处理该事件。
 *
 * 监听器模式：事件源注册监听器之后，当事件源触发事件，监听器就可以回调事件对象的方法；更形象地说，监听者模式是基于：注册-回调的事件/消息通知处理模式，就是被监控者将消息通知给所有监控者。
 *
 * 1、注册监听器：事件源.setListener。
 * 2、回调：事件源实现onListener。
 *
 *
 * 测试 java监听器实现与原理
 * 下面是一个模仿监听器的demo，需求：实现机器人工作和跳舞，在机器人开始工作和跳舞之前输出相关提示。
 */
public class TestListener {
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.registerListener(new MyRobotListener());
		robot.working();
		robot.dancing();
	}
}

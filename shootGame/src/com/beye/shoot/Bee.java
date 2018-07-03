package com.beye.shoot;

import java.util.Random;

/**
 * 蜜蜂类：是飞行物，也是奖励
 * @author Beye
 *
 */

public class Bee extends FlyingObject implements Award{
	private int xSpeed =1; //x坐标走步
	private int ySpeed =2; //y坐标走步
	private int awardType; //奖励类型
	
	/**
	 * 初始化实例变量
	 */
	public Bee() {
		image = ShootGame.bee;
		width = image.getWidth();
		height = image.getHeight();
		y = -height;
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH-width);
		awardType = rand.nextInt(2);
	}
	
	/**
	 * 重写走步
	 */
	public void step() {
		x += xSpeed;
		y += ySpeed;
		if(x<0) {
			xSpeed =1; //+1往右
		}
		if(x>ShootGame.WIDTH-width) {
			xSpeed = -1; //+(-1)往左
		}
	}
	
	/**
	 * 获取奖励
	 */
	public int getType() {
		return 0; //?awardType
	}

}

package com.beye.shoot;

/**
 * 子弹类：是飞行物
 * @author Beye
 *
 */

public class Bullet extends FlyingObject{
	private int speed =3; //移动走步
	
	/*
	 * 初始化实例变量
	 */
	public Bullet(int x, int y) {
		image = ShootGame.bullet;
		width = image.getWidth();
		height = image.getHeight();
		this.x = x;
		this.y = y;
	}
	
	/*重写走步*/
	public void step() {
		y-=speed;
	}

}

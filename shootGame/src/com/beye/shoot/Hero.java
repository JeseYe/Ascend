package com.beye.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	
	private BufferedImage[] images = {}; //两张图片
	private int index; //图片交换计数
	private int doubleFire; //双倍火力
	private int life; //命
	
	/**
	 * 初始化实例变量
	 */
	public Hero() {
		image = ShootGame.hero0;
		width = image.getWidth();
		height = image.getHeight();
		x = 150;
		y = 400;
		doubleFire = 0; //单倍火力值
		life = 3;
		images = new BufferedImage[] {ShootGame.hero0, ShootGame.hero1};
		
	}
	
	/*重写走步*/
	public void step() {//切换图片
		//step()方法被调用10次， 换一次图片
		int num = index++/10%images.length;
		image = images[num];
	}

}

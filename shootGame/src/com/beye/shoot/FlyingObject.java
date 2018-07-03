package com.beye.shoot;

import java.awt.image.BufferedImage;

/**
 * 飞行物类
 * @author Beye
 *
 */

public abstract class FlyingObject {
	protected int width; //宽
	protected int height; //高
	protected int x; //x坐标
	protected int y; //y坐标
	protected BufferedImage image; //图片
	
	/**
	 * 走步
	 */
	public abstract void step();

}

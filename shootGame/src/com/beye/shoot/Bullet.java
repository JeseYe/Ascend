package com.beye.shoot;

/**
 * �ӵ��ࣺ�Ƿ�����
 * @author Beye
 *
 */

public class Bullet extends FlyingObject{
	private int speed =3; //�ƶ��߲�
	
	/*
	 * ��ʼ��ʵ������
	 */
	public Bullet(int x, int y) {
		image = ShootGame.bullet;
		width = image.getWidth();
		height = image.getHeight();
		this.x = x;
		this.y = y;
	}
	
	/*��д�߲�*/
	public void step() {
		y-=speed;
	}

}

package com.beye.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	
	private BufferedImage[] images = {}; //����ͼƬ
	private int index; //ͼƬ��������
	private int doubleFire; //˫������
	private int life; //��
	
	/**
	 * ��ʼ��ʵ������
	 */
	public Hero() {
		image = ShootGame.hero0;
		width = image.getWidth();
		height = image.getHeight();
		x = 150;
		y = 400;
		doubleFire = 0; //��������ֵ
		life = 3;
		images = new BufferedImage[] {ShootGame.hero0, ShootGame.hero1};
		
	}
	
	/*��д�߲�*/
	public void step() {//�л�ͼƬ
		//step()����������10�Σ� ��һ��ͼƬ
		int num = index++/10%images.length;
		image = images[num];
	}

}

package com.beye.shoot;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.imageio.ImageIO;
/**
 * ��Ϸ������
 * @author Beye
 *
 */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400; //��
	public static final int HEIGHT = 654; //��
	
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage gameover;
	public static BufferedImage pause;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	public Hero hero = new Hero();
	public Bullet[] bullets = {};
	public FlyingObject[] flyings = {};
	
	static { //����ͼƬ��Դ
		try {
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��д���Ʒ���
	 */
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); //��ͼƬ
		paintHero(g);
		paintBullets(g);
		paintFlyingObjects(g);
		
	}
	/*
	 * ��Ӣ�ۻ�
	 */
	public void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	/**
	 * ���ӵ�
	 */
	public void paintBullets(Graphics g) {
		for(int i=0; i<bullets.length;i++) {
			Bullet b = bullets[i]; //ÿһ������
			g.drawImage(b.image, b.x, b.y,null);
		}
	}
	/**
	 * ������
	 */
	public void paintFlyingObjects(Graphics g) {
		for(int i=0; i<flyings.length;i++) {
			FlyingObject f = flyings[i];
			g.drawImage(f.image, f.x, f.y, null);
		}
	}
	
	private Timer timer; //��ʱ��
	private int interval = 10; //ʱ���������룩
    /**
     * ����ִ�ж�������
     */
	public void action() {
		timer = new Timer();
		//���´��룬 ÿ���10����ִ��һ��run()����
		timer.schedule(new TimerTask() {//��ʱ����
			//��дrun����
			public void run() {//��ʱִ�еķ���
				enterAction();
				stepAction();
				repaint();
			}
			
		}, interval, interval);
	}
	
	int flyEnteredIndex = 0; //�������볡����
	/**�������볡
	 */
	//���´��룬 ÿ��400��������һ���л���С�۷�
	//��װ��������
	public void enterAction() {
		flyEnteredIndex++;//��һ��index��1
		if(flyEnteredIndex%40==0) {
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length +1);//����
			flyings[flyings.length-1]=obj;//������װ���������һλ
		}	
	}
	
	/**
	 * ������ɵ���
	 */
	//��������:���ɶ��� һ��Ϊstatic��
	public static FlyingObject nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		if(type == 0) {
			return new Bee();
		}else {
			return new Airplane();
		}
	}
	
	/**
	 * �������߲�
	 */
	public void stepAction() {
		//�����߲�
		for(int i = 0; i<flyings.length; i++) {
			flyings[i].step();
		}
		//�ӵ��߲�
		for(int i=0; i<bullets.length; i++) {
			bullets[i].step();
		}
		hero.step();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly");
		ShootGame game = new ShootGame();
		frame.add(game);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.action();
	}
}

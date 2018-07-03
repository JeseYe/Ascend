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
 * 游戏主界面
 * @author Beye
 *
 */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400; //宽
	public static final int HEIGHT = 654; //高
	
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
	
	static { //加载图片资源
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
	 * 重写绘制方法
	 */
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); //画图片
		paintHero(g);
		paintBullets(g);
		paintFlyingObjects(g);
		
	}
	/*
	 * 画英雄机
	 */
	public void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	/**
	 * 画子弹
	 */
	public void paintBullets(Graphics g) {
		for(int i=0; i<bullets.length;i++) {
			Bullet b = bullets[i]; //每一个敌人
			g.drawImage(b.image, b.x, b.y,null);
		}
	}
	/**
	 * 画敌人
	 */
	public void paintFlyingObjects(Graphics g) {
		for(int i=0; i<flyings.length;i++) {
			FlyingObject f = flyings[i];
			g.drawImage(f.image, f.x, f.y, null);
		}
	}
	
	private Timer timer; //定时器
	private int interval = 10; //时间间隔（毫秒）
    /**
     * 启动执行动作操作
     */
	public void action() {
		timer = new Timer();
		//如下代码， 每间隔10毫秒执行一次run()方法
		timer.schedule(new TimerTask() {//定时触发
			//重写run方法
			public void run() {//定时执行的方法
				enterAction();
				stepAction();
				repaint();
			}
			
		}, interval, interval);
	}
	
	int flyEnteredIndex = 0; //飞行物入场计数
	/**飞行物入场
	 */
	//如下代码， 每隔400毫秒生成一个敌机或小蜜蜂
	//并装到数组中
	public void enterAction() {
		flyEnteredIndex++;//走一步index增1
		if(flyEnteredIndex%40==0) {
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length +1);//扩容
			flyings[flyings.length-1]=obj;//将敌人装进数组最后一位
		}	
	}
	
	/**
	 * 随机生成敌人
	 */
	//工厂方法:生成对象， 一般为static的
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
	 * 飞行物走步
	 */
	public void stepAction() {
		//敌人走步
		for(int i = 0; i<flyings.length; i++) {
			flyings[i].step();
		}
		//子弹走步
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

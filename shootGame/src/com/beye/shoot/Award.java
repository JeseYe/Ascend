package com.beye.shoot;
/**
 * 奖励
 * @author Beye
 *
 */
public interface Award {
	int DOUBLE_FIRE = 0; //双倍火力
	int LIFE =1; //1条命
	int getType(); //获取奖励类型

}

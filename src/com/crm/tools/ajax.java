package com.crm.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.prism.Image;

public class ajax {
	public static String code;
	
	public static final String RANDOMCODEKEY= "RANDOMVALIDATECODEKEY";//放到session中的key
	private Random random=new Random();
	private String randString ="23456789abcdefjhijklmnopqrstuvwsvzABCDEFGHIJKLMNOPQRSTUVWXYZ";//随机产生的字符串
	private int width=185;
	private int height=35;
	private int lineSize=200;
	private int stringNum=9;
	
	/**
	 * 获取字体
	 */
	
	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 21);
	}
	
	
	/**
	 * 获取颜色
	 */
	
	private Color getRandColor(int fc,int bc) {
		//创建具有指定红色、绿色、蓝色和 alpha 值的 sRGB 颜色，这些值都在 (0 - 255) 的范围内
		if(fc>255)
			fc=255;
		if(bc>255)
			bc=255;
	     bc = 255;
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
		return new Color(r, g, b);
	}
	
	/**
	 * 获取随机字符
	 */
	
	public String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));
	}
	
	/**
	 * 绘制干扰线
	 */
	private void drowline(Graphics g) {
		int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);//宽的密度
        int yl = random.nextInt(15);//高的密度
        g.drawLine(x, y, x+xl, y+yl);
	}
	
	/**
	 * 绘制字符串
	 */
	
	public String drowString(Graphics g,String randomString,int i) {
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));//random.nextInt(62)随机生成一个整数，这个整数的范围就是[0,62）
		String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));
        randomString +=rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13*i, 16);
		return randomString;
	}
	
	 /**
     * 生成随机图片
     */
	public String getRandcode(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		BufferedImage image =new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g =image.getGraphics();//产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
		g.setColor(getRandColor(110, 133));
		//绘制干扰线
		for (int i=0;i<=lineSize;i++) {
			drowline(g);
		}
		String randomString ="";
	    for(int i=1;i<=stringNum;i++){
            randomString=drowString(g,randomString,i);
        }
	    session.removeAttribute(RANDOMCODEKEY);
	    session.setAttribute(RANDOMCODEKEY, randomString);
        g.dispose();
        try {
			ImageIO.write(image, "JPEG", response.getOutputStream());//将内存中的图片通过流动形式输出到客户端
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomString;
	}
}

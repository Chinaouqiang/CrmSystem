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
	
	public static final String RANDOMCODEKEY= "RANDOMVALIDATECODEKEY";//�ŵ�session�е�key
	private Random random=new Random();
	private String randString ="23456789abcdefjhijklmnopqrstuvwsvzABCDEFGHIJKLMNOPQRSTUVWXYZ";//����������ַ���
	private int width=185;
	private int height=35;
	private int lineSize=200;
	private int stringNum=9;
	
	/**
	 * ��ȡ����
	 */
	
	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 21);
	}
	
	
	/**
	 * ��ȡ��ɫ
	 */
	
	private Color getRandColor(int fc,int bc) {
		//��������ָ����ɫ����ɫ����ɫ�� alpha ֵ�� sRGB ��ɫ����Щֵ���� (0 - 255) �ķ�Χ��
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
	 * ��ȡ����ַ�
	 */
	
	public String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));
	}
	
	/**
	 * ���Ƹ�����
	 */
	private void drowline(Graphics g) {
		int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);//����ܶ�
        int yl = random.nextInt(15);//�ߵ��ܶ�
        g.drawLine(x, y, x+xl, y+yl);
	}
	
	/**
	 * �����ַ���
	 */
	
	public String drowString(Graphics g,String randomString,int i) {
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));//random.nextInt(62)�������һ����������������ķ�Χ����[0,62��
		String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));
        randomString +=rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13*i, 16);
		return randomString;
	}
	
	 /**
     * �������ͼƬ
     */
	public String getRandcode(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		BufferedImage image =new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g =image.getGraphics();//����Image�����Graphics����,�Ķ��������ͼ���Ͻ��и��ֻ��Ʋ���
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
		g.setColor(getRandColor(110, 133));
		//���Ƹ�����
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
			ImageIO.write(image, "JPEG", response.getOutputStream());//���ڴ��е�ͼƬͨ��������ʽ������ͻ���
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomString;
	}
}

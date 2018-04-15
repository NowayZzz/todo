package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println(
				"CheckcodeServlet的service方法");
			/*
			 * 第一大步:绘图
			 */
			//step1.创建内存映象对象(画布)
			BufferedImage image = 
					new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
			//step2.获得画笔
			Graphics g = 
					image.getGraphics();
			//step3.给笔设置颜色
			g.setColor(new Color(255,255,255));
			//step4.给画布设置背景颜色
			g.fillRect(0, 0, 80, 30);
			//step5.给笔重新设置颜色
			Random r = new Random();
			g.setColor(new Color(
					r.nextInt(255),
					r.nextInt(255),
					r.nextInt(255)));
			
			// Font(字体名称,风格,大小)
			g.setFont(
					new Font(null,Font.BOLD,24));
			
			//step6.生成一个随机数
			
			String number = getNumber(5);
			
			/*
			 * 将number(验证码)绑订到
			 * session对象上。
			 */
			HttpSession session =
					request.getSession();
			session.setAttribute("number",
					number);
			
			//step7.将随机数添加到图片上
			g.drawString(number, 2, 25);
			
			//step8.加一些干扰线
			for(int i = 0; i < 8; i ++){
				g.setColor(new Color(
						r.nextInt(255),
						r.nextInt(255),
						r.nextInt(255)));
				g.drawLine(r.nextInt(80),
						r.nextInt(30), 
						r.nextInt(80),
						r.nextInt(30));
				
			}
			
			/*
			 * 第二大步：将图片压缩，然后发送
			 * 给浏览器。
			 */
			//step1.告诉浏览器，服务器返回的是一张
			//jpg格式的图片。
			//注: jpeg是压缩算法。
			response.setContentType("image/jpeg");
			//step2.获得一个字节输出流
			OutputStream os = 
					response.getOutputStream();
			//step3.将图片压缩，并输出。
			/*
			 * write方法会将原始图片(image)按照
			 * 指定的压缩算法(jpeg)进行压缩，然后
			 * 将压缩之后得到的字节通过os进行输出。
			 */
			javax.imageio.ImageIO.write(
					image, "jpeg", os);
			
	
	}


	/*
	 * 返回长度为size,并且随机从
	 * A~Z,0~9中选取的字符组成的字符串。
	 */
	private String getNumber(int size) {
		String number = "";
		String chars = "ABCDEFGHIJKLMNOPQRS"
				+ "TUVWXYZ0123456789";
		Random r = new Random();
		for(int i = 0; i < size; i ++){
			number += chars.charAt(
					r.nextInt(chars.length()));
		}
		return number;
	}
	
	
	
	

}

package com.els.jewellery.manage.modular.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.els.jewellery.manage.modular.geminfo.vo.GemPrintVo;

public class ImageHandleHelper {
	
	public BufferedImage creatImg(GemPrintVo data) throws IOException{
//		ClassLoader classLoader = ImageHandleHelper.class.getClassLoader();  
//        URL resource = classLoader.getResource("c2.jpg");  
//        String path = resource.getPath();  
//		BufferedImage bg = new BufferedImage(3367, 2410, BufferedImage.TYPE_INT_RGB);
//		BufferedImage bg = ImageIO.read(new File(path));//读取本地图片
		BufferedImage bg = ImageIO.read(new URL("http://39.108.169.195:10000/jeimg/c2.jpg"));//读取本地图片
//	"C:\\Users\\Administrator\\Desktop\\c2.jpg")
		Graphics2D g = bg.createGraphics();//开启画图
		System.out.println(bg.getHeight());
		System.out.println(bg.getWidth());
//		bg = g.getDeviceConfiguration().createCompatibleImage(3367, 2410, Transparency.TRANSLUCENT);
//		g.dispose();
//		g = bg.createGraphics();
//		
		g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("微软雅黑", Font.PLAIN, 35));
        Image image1 = ImageIO.read(new URL (data.getGemColourImg().split("%&")[0]));
        Image image2 = ImageIO.read(new URL (data.getGemHcImg().split("%&")[0]));
//        Image image3 = ImageIO.read(new File (data.getGemImg().split("%&")[0]));
        Image image4 = ImageIO.read(new URL (data.getGemQRImg().split("%&")[0]));
        g.drawString(data.getReportCode().split("%&")[0], Integer.parseInt(data.getReportCode().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getReportCode().split("%&")[1].split(",")[1])*3+40);//报告编号
        g.drawString(data.getGemNameAndWeight().split("%&")[0], Integer.parseInt(data.getGemNameAndWeight().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemNameAndWeight().split("%&")[1].split(",")[1])*3+40);//标的物及重量
        g.drawString(data.getGemColourAndVibrance().split("%&")[0], Integer.parseInt(data.getGemColourAndVibrance().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemColourAndVibrance().split("%&")[1].split(",")[1])*3+40);//颜色及鲜艳度
        g.drawString(data.getGemQuality().split("%&")[0], Integer.parseInt(data.getGemQuality().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemQuality().split("%&")[1].split(",")[1])*3+40);//质量
        g.drawString(data.getGemStampAndNameAndWeight().split("%&")[0], Integer.parseInt(data.getGemStampAndNameAndWeight().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemStampAndNameAndWeight().split("%&")[1].split(",")[1])*3+30);//质量评估标的
        g.drawString(data.getGemAssessmentTime().split("%&")[0], Integer.parseInt(data.getGemAssessmentTime().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemAssessmentTime().split("%&")[1].split(",")[1])*3+30);//评定日期
        g.drawString(data.getGemAccBodyAndCode().split("%&")[0], Integer.parseInt(data.getGemAccBodyAndCode().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemAccBodyAndCode().split("%&")[1].split(",")[1])*3+30);//鉴定机构及证书编号
        g.drawString(data.getGemRemark().split("%&")[0], Integer.parseInt(data.getGemRemark().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemRemark().split("%&")[1].split(",")[1])*3+30);//备注
        g.drawString(data.getColourAndLevel().split("%&")[0], Integer.parseInt(data.getColourAndLevel().split("%&")[1].split(",")[0])*3-100, Integer.parseInt(data.getColourAndLevel().split("%&")[1].split(",")[1])*3+50);//颜色等级及归类命名
        g.drawString(data.getGemVibrance().split("%&")[0], Integer.parseInt(data.getGemVibrance().split("%&")[1].split(",")[0])*3-190, Integer.parseInt(data.getGemVibrance().split("%&")[1].split(",")[1])*3+55);//鲜艳度
        g.drawString(data.getGemParamHue().split("%&")[0], Integer.parseInt(data.getGemParamHue().split("%&")[1].split(",")[0])*3-100, Integer.parseInt(data.getGemParamHue().split("%&")[1].split(",")[1])*3+50);//色调
        g.drawString(data.getGemParamConcent().split("%&")[0], Integer.parseInt(data.getGemParamConcent().split("%&")[1].split(",")[0])*3-100, Integer.parseInt(data.getGemParamConcent().split("%&")[1].split(",")[1])*3+45);//浓度
        g.drawString(data.getGemParamFinish().split("%&")[0], Integer.parseInt(data.getGemParamFinish().split("%&")[1].split(",")[0])*3-100, Integer.parseInt(data.getGemParamFinish().split("%&")[1].split(",")[1])*3+45);//相对彩度
        g.drawString(data.getGemParamRemark().split("%&")[0], Integer.parseInt(data.getGemParamRemark().split("%&")[1].split(",")[0])*3-100, Integer.parseInt(data.getGemParamRemark().split("%&")[1].split(",")[1])*3+45);//彩度备注
        g.drawImage(image1, Integer.parseInt(data.getGemColourImg().split("%&")[1].split(",")[0])*3-160, Integer.parseInt(data.getGemColourImg().split("%&")[1].split(",")[1])*3+30,861,659,null);
        g.drawImage(image2, Integer.parseInt(data.getGemHcImg().split("%&")[1].split(",")[0])*3-160, Integer.parseInt(data.getGemHcImg().split("%&")[1].split(",")[1])*3+30,861,198,null);
//        g.drawImage(image3,Integer.parseInt(data.getGemImg().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemImg().split("%&")[1].split(",")[1])*3,400,400,null);
        g.drawImage(image4,Integer.parseInt(data.getGemQRImg().split("%&")[1].split(",")[0])*3-140, Integer.parseInt(data.getGemQRImg().split("%&")[1].split(",")[1])*3-100,350,350,null);
        g.dispose();
//        ImageIO.write(bg, "jpg", new File("C:\\Users\\Administrator\\Desktop\\c9.jpg"));
        return bg;
       
	}
	
	public BufferedImage creatImgTest(GemPrintVo data) throws IOException{
		ClassLoader classLoader = ImageHandleHelper.class.getClassLoader();  
        URL resource = classLoader.getResource("c2.jpg");  
        String path = resource.getPath();  
//		BufferedImage bg = new BufferedImage(3367, 2410, BufferedImage.TYPE_INT_RGB);
//		BufferedImage bg = ImageIO.read(new File(path));//读取本地图片
		BufferedImage bg = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\c6.jpg"));//读取本地图片
//	"C:\\Users\\Administrator\\Desktop\\c2.jpg")
		Graphics2D g = bg.createGraphics();//开启画图
		System.out.println(bg.getHeight());
		System.out.println(bg.getWidth());
//		bg = g.getDeviceConfiguration().createCompatibleImage(3367, 2410, Transparency.TRANSLUCENT);
//		g.dispose();
//		g = bg.createGraphics();
//		
		g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("微软雅黑", Font.PLAIN, 35));
        Image image1 = ImageIO.read(new URL (data.getGemColourImg().split("%&")[0]));
        Image image2 = ImageIO.read(new URL (data.getGemHcImg().split("%&")[0]));
//        Image image3 = ImageIO.read(new File (data.getGemImg().split("%&")[0]));
        Image image4 = ImageIO.read(new File (data.getGemQRImg().split("%&")[0]));
        g.drawString(data.getReportCode().split("%&")[0], Integer.parseInt(data.getReportCode().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getReportCode().split("%&")[1].split(",")[1])*3);//报告编号
        g.drawString(data.getGemNameAndWeight().split("%&")[0], Integer.parseInt(data.getGemNameAndWeight().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemNameAndWeight().split("%&")[1].split(",")[1])*3);//标的物及重量
        g.drawString(data.getGemColourAndVibrance().split("%&")[0], Integer.parseInt(data.getGemColourAndVibrance().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemColourAndVibrance().split("%&")[1].split(",")[1])*3);//颜色及鲜艳度
        g.drawString(data.getGemQuality().split("%&")[0], Integer.parseInt(data.getGemQuality().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemQuality().split("%&")[1].split(",")[1])*3);//质量
        g.drawString(data.getGemStampAndNameAndWeight().split("%&")[0], Integer.parseInt(data.getGemStampAndNameAndWeight().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemStampAndNameAndWeight().split("%&")[1].split(",")[1])*3);//质量评估标的
        g.drawString(data.getGemAssessmentTime().split("%&")[0], Integer.parseInt(data.getGemAssessmentTime().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemAssessmentTime().split("%&")[1].split(",")[1])*3);//评定日期
        g.drawString(data.getGemAccBodyAndCode().split("%&")[0], Integer.parseInt(data.getGemAccBodyAndCode().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemAccBodyAndCode().split("%&")[1].split(",")[1])*3);//鉴定机构及证书编号
        g.drawString(data.getGemRemark().split("%&")[0], Integer.parseInt(data.getGemRemark().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemRemark().split("%&")[1].split(",")[1])*3);//备注
        g.drawString(data.getColourAndLevel().split("%&")[0], Integer.parseInt(data.getColourAndLevel().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getColourAndLevel().split("%&")[1].split(",")[1])*3);//颜色等级及归类命名
        g.drawString(data.getGemVibrance().split("%&")[0], Integer.parseInt(data.getGemVibrance().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemVibrance().split("%&")[1].split(",")[1])*3);//鲜艳度
        g.drawString(data.getGemParamHue().split("%&")[0], Integer.parseInt(data.getGemParamHue().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemParamHue().split("%&")[1].split(",")[1])*3);//色调
        g.drawString(data.getGemParamConcent().split("%&")[0], Integer.parseInt(data.getGemParamConcent().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemParamConcent().split("%&")[1].split(",")[1])*3);//浓度
        g.drawString(data.getGemParamFinish().split("%&")[0], Integer.parseInt(data.getGemParamFinish().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemParamFinish().split("%&")[1].split(",")[1])*3);//相对彩度
        g.drawString(data.getGemParamRemark().split("%&")[0], Integer.parseInt(data.getGemParamRemark().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemParamRemark().split("%&")[1].split(",")[1])*3);//彩度备注
        g.drawImage(image1, Integer.parseInt(data.getGemColourImg().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemColourImg().split("%&")[1].split(",")[1])*3,861,659,null);
        g.drawImage(image2, Integer.parseInt(data.getGemHcImg().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemHcImg().split("%&")[1].split(",")[1])*3,861,198,null);
//        g.drawImage(image3,Integer.parseInt(data.getGemImg().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemImg().split("%&")[1].split(",")[1])*3,400,400,null);
        g.drawImage(image4,Integer.parseInt(data.getGemQRImg().split("%&")[1].split(",")[0])*3, Integer.parseInt(data.getGemQRImg().split("%&")[1].split(",")[1])*3,350,350,null);
        g.dispose();
        ImageIO.write(bg, "jpg", new File("C:\\Users\\Administrator\\Desktop\\c9.jpg"));
        return bg;
       
	}
	
	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = ImageHandleHelper.class.getClassLoader();  
        URL resource = classLoader.getResource(""); 
        
        ImageHandleHelper a = new ImageHandleHelper();
        a.creatImg(null);
        System.out.println(resource.getPath());
	}

}

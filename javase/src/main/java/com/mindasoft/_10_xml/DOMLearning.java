package com.mindasoft._10_xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by huangmin on 2017/12/25 22:15.
 */
public class DOMLearning {

	public static void main(String arge[]){
		long lasting =System.currentTimeMillis();
		try{
			File f=new File("data_10k.xml");
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("VALUE");

			for (int i=0;i<nl.getLength();i++){
				System.out.print("车牌号码:" + doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue());
				System.out.println(" 车主地址:" + doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("运行时间："+(System.currentTimeMillis() - lasting)+" 毫秒");
	}
}

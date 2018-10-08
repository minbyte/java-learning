package com.mindasoft._10_xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * Created by huangmin on 2017/12/25 22:22.
 */
public class DOM4JLearning {

	public static void main(String arge[]) {
		long lasting = System.currentTimeMillis();
		try {
			File f = new File("data_10k.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			Element foo;

			for (Iterator i = root.elementIterator("VALUE"); i.hasNext();) {
				foo = (Element) i.next();
				System.out.print("车牌号码:" + foo.elementText("NO"));
				System.out.println(" 车主地址:" + foo.elementText("ADDR"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("运行时间：" + (System.currentTimeMillis() - lasting) + " 毫秒");
	}
}

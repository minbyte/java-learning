package com.mindasoft._10_xml;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.util.List;

/**
 * Created by huangmin on 2017/12/25 22:19.
 */
public class JDOMLearning {

	public static void main(String arge[]) {
		long lasting = System.currentTimeMillis();
		try {
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(new File("data_10k.xml"));
			Element foo = doc.getRootElement();
			List allChildren = foo.getChildren();
			for(int i=0;i<allChildren.size();i++) {
				System.out.print("车牌号码:" + ((Element)allChildren.get(i)).getChild("NO").getText());
				System.out.println(" 车主地址:" + ((Element)allChildren.get(i)).getChild("ADDR").getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("运行时间：" + (System.currentTimeMillis() - lasting) + " 毫秒");
	}
}

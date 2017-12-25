/**
 * XML现在已经成为一种通用的数据交换格式,平台的无关性使得很多场合都需要用到XML。
 * 本文将详细介绍用Java解析XML的四种方法。
 * XML现在已经成为一种通用的数据交换格式,它的平台无关性,语言无关性,系统无关性,给数据集成与交互带来了极大的方便。
 * 对于XML本身的语法知识与技术细节,需要阅读相关的技术文献,这里面包括的内容有
 *  DOM(Document Object Model),DTD(Document Type Definition),SAX(Simple API for XML),
 *  XSD(Xml Schema Definition),XSLT(Extensible Stylesheet Language Transformations),
 *  具体可参阅w3c官方网站文档http://www.w3.org获取更多信息。
 *
 * XML在不同的语言里解析方式都是一样的,只不过实现的语法不同而已。
 * 基本的解析方式有两种,一种叫SAX，另一种叫DOM。SAX是基于事件流的解析,DOM是基于XML文档树结构的解析。
 * Java解析XML主要有四种方法。DOM、SAX、JDOM、DOM4J。
 * Created by huangmin on 2017/12/25 22:13.
 */
package com.mindasoft._10_xml;
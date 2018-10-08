package com.mindasoft._03_collection.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 *
 *  CopyOnWriteArrayList实现了Serializable接口，因此它支持序列化，能够通过序列化传输，
 *  实现了RandomAccess接口，支持快速随机访问，实际上就是通过下标序号进行快速访问，
 *  实现了Cloneable接口，能被克隆。
 *
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/7 9:26
 */
public class CopyOnWriteArrayListLearning {

	public void test(){
		CopyOnWriteArrayList list = new CopyOnWriteArrayList();
	}


}

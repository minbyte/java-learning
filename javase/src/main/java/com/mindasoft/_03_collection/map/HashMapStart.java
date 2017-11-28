package com.mindasoft._03_collection.map;

import java.util.HashMap;

/**
 * Created by huangmin on 2017/11/2 14:26.
 */
public class HashMapStart {

	public static void main(String[] args) {
		// 一、 初始化操作
		HashMap<Integer,String> map = new HashMap();
		/**
		 * 1、执行new操作的似乎会去初始化，默认的容量是16个键值对，默认的加载因子是0.75
		 *
		 * static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
		 * static final float DEFAULT_LOAD_FACTOR = 0.75f;
		 *
		 * Constructs an empty <tt>HashMap</tt> with the default initial capacity
		 * (16) and the default load factor (0.75).
		 *  public HashMap() {
		 *		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
		 *	}
		 */

		/**
		 * 2、调用默认的
		 * static final int MAXIMUM_CAPACITY = 1 << 30;
		 *
		 * Constructs an empty <tt>HashMap</tt> with the specified initial
		 * capacity and load factor.
		 *
			public HashMap(int initialCapacity, float loadFactor) {
		 		// 最小容量不能小于0
				if (initialCapacity < 0)
					throw new IllegalArgumentException("Illegal initial capacity: " +
							initialCapacity);
		 		// 不能大于最大容量
				if (initialCapacity > MAXIMUM_CAPACITY)
					initialCapacity = MAXIMUM_CAPACITY;
		 		// 加载因子合法性判断
				if (loadFactor <= 0 || Float.isNaN(loadFactor))
					throw new IllegalArgumentException("Illegal load factor: " +
							loadFactor);
		 		// 设置加载因子；以及当前初始化的容量为该HashMap的阈值threshold
		 		// 当put时，容量大于这个阈值会发什么时候操作？下面会介绍
				this.loadFactor = loadFactor;
				threshold = initialCapacity;
		 		// 空方法，留给子类实现
				init();
			}
		 */
		/**
		 * 3、HashMap还有两个构造方法：
		 * HashMap(int initialCapacity, float loadFactor)   指定初始化容量和加载因子
		 * HashMap(int initialCapacity) 指定初始化容量
		 */

		// put操作
		map.put(1,"11");

		/**
		 * 4、Entry是HashMap的内部类，一共四个属性 final K key;V value;int hash; 以及Entry<K,V> next;
		 * 键、值、哈希以及自身引用。这样Entry就构成了链表形式的数据结构。
		 *
		 * static final Entry<?,?>[] EMPTY_TABLE = {};
		 *
		 * 存储数据的Entry数组，长度是2的幂。HashMap采用链表法解决冲突，每一个Entry本质上是一个单向链表
		 * transient Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;
		 *
			public V put(K key, V value) {
		 		// 如果table是空的，那么初始化
				if (table == EMPTY_TABLE) {
					inflateTable(threshold);   --> 见下面
				}

		 		// 若“key为null”，则将该键值对添加到table[0]中。
				if (key == null)
					return putForNullKey(value);

		 		// 若“key不为null”，则计算该key的哈希值，然后将其添加到该哈希值对应的链表
				int hash = hash(key);
				int i = indexFor(hash, table.length);
				for (Entry<K,V> e = table[i]; e != null; e = e.next) {
					Object k;
		 			// 若“该key”对应的键值对已经存在，则用新的value取代旧的value。然后退
					if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
						V oldValue = e.value;
						e.value = value;
						e.recordAccess(this);
						return oldValue;
					}
				}

		 		// 若“该key”对应的键值对不存在，则将“key-value”添加到table中
				modCount++;
				addEntry(hash, key, value, i);
				return null;
			}

			 private void inflateTable(int toSize) {
				 // Find a power of 2 >= toSize
				 int capacity = roundUpToPowerOf2(toSize);

				 threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
				 table = new HashMap.Entry[capacity];
				 initHashSeedAsNeeded(capacity);
			 }

			 private static int roundUpToPowerOf2(int number) {
				 // assert number >= 0 : "number must be non-negative";
				 return number >= MAXIMUM_CAPACITY
						 ? MAXIMUM_CAPACITY
						 : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
			 }

		 	void addEntry(int hash, K key, V value, int bucketIndex) {
		 		//  若HashMap的实际大小 大于等于 “阈值”，则调整HashMap的大小
				 if ((size >= threshold) && (null != table[bucketIndex])) {
					 resize(2 * table.length);
					 hash = (null != key) ? hash(key) : 0;
					 bucketIndex = indexFor(hash, table.length);
				 }

				 createEntry(hash, key, value, bucketIndex);
			 }
		 */
	}
}

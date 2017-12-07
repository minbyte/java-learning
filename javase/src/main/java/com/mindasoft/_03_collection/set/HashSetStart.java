package com.mindasoft._03_collection.set;

import java.util.*;

/**
 * 对于 HashSet 而言，它是基于 HashMap 实现的，底层采用 HashMap 来保存元素，
 * 所以如果对 HashMap 比较熟悉了，那么学习 HashSet 也是很轻松的。
 *
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/7 10:12
 */
public class HashSetStart {

    public void start(){
        HashSet set = new HashSet();

    }

    /**
     * 源码分析
    public class HashSet<E>
            extends AbstractSet<E>
            implements Set<E>, Cloneable, java.io.Serializable
    {
        static final long serialVersionUID = -5024744406713321676L;

        // 实际底层用的HashMap
        private transient HashMap<E,Object> map;

        // 与后台映射中的对象关联的虚拟值。
        private static final Object PRESENT = new Object();

        // 默认的无参构造器，构造一个空的HashSet。
        // 实际底层会初始化一个空的HashMap，并使用默认初始容量为16和加载因子0.75。
        public HashSet() {
            map = new HashMap<>();
        }

        // 构造一个包含指定collection中的元素的新set。
        // 实际底层使用默认的加载因子0.75和足以包含指定collection中所有元素的初始容量来创建一个HashMap。
        public HashSet(Collection<? extends E> c) {
            map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
            addAll(c);
        }

        // 以指定的initialCapacity和loadFactor构造一个空的HashSet。
        // 实际底层以相应的参数构造一个空的HashMap。
        public HashSet(int initialCapacity, float loadFactor) {
            map = new HashMap<>(initialCapacity, loadFactor);
        }

        // 以指定的initialCapacity构造一个空的HashSet。
        // 实际底层以相应的参数及加载因子loadFactor为0.75构造一个空的HashMap。
        public HashSet(int initialCapacity) {
            map = new HashMap<>(initialCapacity);
        }

        // 以指定的initialCapacity和loadFactor构造一个新的空链接哈希集合。此构造函数为包访问权限，不对外公开，
        // 实际只是是对LinkedHashSet的支持。
        // 实际底层会以指定的参数构造一个空LinkedHashMap实例来实现。
        HashSet(int initialCapacity, float loadFactor, boolean dummy) {
            map = new LinkedHashMap<>(initialCapacity, loadFactor);
        }

        // 迭代器其实是用用的Map的key
        public Iterator<E> iterator() {
            return map.keySet().iterator();
        }

        public int size() {
            return map.size();
        }

        public boolean isEmpty() {
            return map.isEmpty();
        }

        public boolean contains(Object o) {
            return map.containsKey(o);
        }

        // 添加元素，添加到map的Key，value是Object对象
        public boolean add(E e) {
            return map.put(e, PRESENT)==null;
        }

        //
        public boolean remove(Object o) {
            return map.remove(o)==PRESENT;
        }

        public void clear() {
            map.clear();
        }

        @SuppressWarnings("unchecked")
        public Object clone() {
            try {
                HashSet<E> newSet = (HashSet<E>) super.clone();
                newSet.map = (HashMap<E, Object>) map.clone();
                return newSet;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e);
            }
        }

        private void writeObject(java.io.ObjectOutputStream s)
                throws java.io.IOException {
            // Write out any hidden serialization magic
            s.defaultWriteObject();

            // Write out HashMap capacity and load factor
            s.writeInt(map.capacity());
            s.writeFloat(map.loadFactor());

            // Write out size
            s.writeInt(map.size());

            // Write out all elements in the proper order.
            for (E e : map.keySet())
                s.writeObject(e);
        }
    }


    */
}

package com.mindasoft._03_collection.map;

import java.util.TreeMap;

/**
 *
 *  TreeMap是基于红黑树实现的，这里只对红黑树做个简单的介绍，红黑树是一种特殊的二叉排序树，关于二叉排序树，参见：http://blog.csdn.net/ns_code/article/details/19823463，红黑树通过一些限制，使其不会出现二叉树排序树中极端的一边倒的情况，相对二叉排序树而言，这自然提高了查询的效率。
     二叉排序树的基本性质如下：
     1、每个节点都只能是红色或者黑色
     2、根节点是黑色
     3、每个叶节点（NIL节点，空节点）是黑色的。
     4、如果一个结点是红的，则它两个子节点都是黑的。也就是说在一条路径上不能出现相邻的两个红色结点。
     5、从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
     正是这些性质的限制，使得红黑树中任一节点到其子孙叶子节点的最长路径不会长于最短路径的2倍，因此它是一种接近平衡的二叉树。
     说到红黑树，自然不免要和AVL树对比一番。相比较而言，AVL树是严格的平衡二叉树，而红黑树不算严格意义上的平衡二叉树，只是接近平衡，不会让树的高度如BST极端情况那样等于节点的个数。其实能用到红黑树的地方，也都可以用AVL树来实现，但红黑树的应用却非常广泛，而AVL树则很少被使用。在执行插入、删除操作时，AVL树需要调整的次数一般要比红黑树多（红黑树的旋转调整最多只需三次），效率相对较低，且红黑树的统计性能较AVL树要好，当然AVL树在查询效率上可能更胜一筹，但实际上也高不了多少。
     红黑树的插入删除操作很简单，就是单纯的二叉排序树的插入删除操作。红黑树被认为比较变态的地方自然在于插入删除后对红黑树的调整操作（旋转和着色），主要是情况分的很多，限于篇幅及博主的熟悉程度优先，这里不打算详细介绍插入删除后调整红黑树的各种情况及其实现，我们有个宏观上的了解即可，如须详细了解，参见算法导论或一些相关的资料。


     本文对TreeMap的分析较前几篇文章有些浅尝辄止，TreeMap用的没有HashMap那么多，我们有个宏观上的把我和比较即可。
     1、TreeMap是根据key进行排序的，它的排序和定位需要依赖比较器或覆写Comparable接口，
        也因此不需要key覆写hashCode方法和equals方法，就可以排除掉重复的key，
        而HashMap的key则需要通过覆写hashCode方法和equals方法来确保没有重复的key。
     2、TreeMap的查询、插入、删除效率均没有HashMap高，一般只有要对key排序时才使用TreeMap。
     3、TreeMap的key不能为null，而HashMap的key可以为null。

     注：对TreeSet和HashSet的源码不再进行剖析，二者分别是基于TreeMap和HashMap实现的，只是对应的节点中只有key，而没有value，因此对TreeMap和HashMap比较了解的话，对TreeSet和HashSet的理解就会非常容易。
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/7 9:56
 */
public class TreeMapLearning {

    public static void main(String[] args) {

        TreeMap map= new TreeMap();

    }


    /**
     * 源码分析
    存储结构

    TreeMap的排序是基于对key的排序实现的，它的每一个Entry代表红黑树的一个节点，Entry的数据结构如下：
    static final class Entry<K,V> implements Map.Entry<K,V> {
        // 键
        K key;
        // 值
        V value;
        // 左孩子
        Entry<K,V> left = null;
        // 右孩子
        Entry<K,V> right = null;
        // 父节点
        Entry<K,V> parent;
        // 当前节点颜色
        boolean color = BLACK;

        // 构造函数
        Entry(K key, V value, Entry<K,V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

。。。。。
    }
    构造方法

    先来看下TreeMap的构造方法。TreeMap一共有4个构造方法。
            1、无参构造方法
    public TreeMap() {
        comparator = null;
    }
    采用无参构造方法，不指定比较器，这时候，排序的实现要依赖key.compareTo()方法，因此key必须实现Comparable接口，并覆写其中的compareTo方法。
            2、带有比较器的构造方法

    public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }
    采用带比较器的构造方法，这时候，排序依赖该比较器，key可以不用实现Comparable接口。
            3、带Map的构造方法

    public TreeMap(Map<? extends K, ? extends V> m) {
        comparator = null;
        putAll(m);
    }
    该构造方法同样不指定比较器，调用putAll方法将Map中的所有元素加入到TreeMap中。putAll的源码如下：
            
    // 将map中的全部节点添加到TreeMap中
    public void putAll(Map<? extends K, ? extends V> map) {
        // 获取map的大小
        int mapSize = map.size();
        // 如果TreeMap的大小是0,且map的大小不是0,且map是已排序的“key-value对”
        if (size==0 && mapSize!=0 && map instanceof SortedMap) {
            Comparator c = ((SortedMap)map).comparator();
            // 如果TreeMap和map的比较器相等；
            // 则将map的元素全部拷贝到TreeMap中，然后返回！
            if (c == comparator || (c != null && c.equals(comparator))) {
                ++modCount;
                try {
                    buildFromSorted(mapSize, map.entrySet().iterator(),
                            null, null);
                } catch (java._01_io.IOException cannotHappen) {
                } catch (ClassNotFoundException cannotHappen) {
                }
                return;
            }
        }
        // 调用AbstractMap中的putAll();
        // AbstractMap中的putAll()又会调用到TreeMap的put()
        super.putAll(map);
    }
    显然，如果Map里的元素是排好序的，就调用buildFromSorted方法来拷贝Map中的元素，这在下一个构造方法中会重点提及，而如果Map中的元素不是排好序的，就调用AbstractMap的putAll(map)方法，该方法源码如下：
            
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            put(e.getKey(), e.getValue());
    }
    很明显它是将Map中的元素一个个put（插入）到TreeMap中的，主要因为Map中的元素是无序存放的，因此要一个个插入到红黑树中，使其有序存放，并满足红黑树的性质。
            4、带有SortedMap的构造方法

    public TreeMap(SortedMap<K, ? extends V> m) {
        comparator = m.comparator();
        try {
            buildFromSorted(m.size(), m.entrySet().iterator(), null, null);
        } catch (java._01_io.IOException cannotHappen) {
        } catch (ClassNotFoundException cannotHappen) {
        }
    }
    首先将比较器指定为m的比较器，这取决于生成m时调用构造方法是否传入了指定的构造器，而后调用buildFromSorted方法，将SortedMap中的元素插入到TreeMap中，由于SortedMap中的元素师有序的，实际上它是根据SortedMap创建的TreeMap，将SortedMap中对应的元素添加到TreeMap中。
    插入删除

    插入操作即对应TreeMap的put方法，put操作实际上只需按照二叉排序树的插入步骤来操作即可，插入到指定位置后，再做调整，使其保持红黑树的特性。put源码的实现：
            
    public V put(K key, V value) {
        Entry<K,V> t = root;
        // 若红黑树为空，则插入根节点
        if (t == null) {
            // TBD:
            // 5045147: (coll) Adding null to an empty TreeSet should
            // throw NullPointerException
            //
            // compare(key, key); // type check
            root = new Entry<K,V>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        int cmp;
        Entry<K,V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;
        // 找出(key, value)在二叉排序树中的插入位置。
        // 红黑树是以key来进行排序的，所以这里以key来进行查找。
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        else {
            if (key == null)
                throw new NullPointerException();
            Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        // 为（key-value）新建节点
        Entry<K,V> e = new Entry<K,V>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        // 插入新的节点后，调用fixAfterInsertion调整红黑树。
        fixAfterInsertion(e);
        size++;
        modCount++;
        return null;
    }
    这里的fixAfterInsertion便是节点插入后对树进行调整的方法，这里不做介绍。
    删除操作及对应TreeMap的deleteEntry方法，deleteEntry方法同样也只需按照二叉排序树的操作步骤实现即可，删除指定节点后，再对树进行调整即可。deleteEntry方法的实现源码如下：
            
    // 删除“红黑树的节点p”
    private void deleteEntry(Entry<K,V> p) {
        modCount++;
        size--;

        if (p.left != null && p.right != null) {
            Entry<K,V> s = successor (p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        }

        Entry<K,V> replacement = (p.left != null ? p.left : p.right);

        if (replacement != null) {
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left  = replacement;
            else
                p.parent.right = replacement;

            p.left = p.right = p.parent = null;

            if (p.color == BLACK)
                fixAfterDeletion(replacement);
        } else if (p.parent == null) {
            root = null;
        } else {
            if (p.color == BLACK)
                fixAfterDeletion(p);

            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }
    后面的fixAfterDeletion方法便是节点删除后对树进行调整的方法，这里不做介绍。
    其他很多方法这里不再一一介绍。

     */
}

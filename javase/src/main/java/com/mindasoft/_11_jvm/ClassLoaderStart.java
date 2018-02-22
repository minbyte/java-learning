package com.mindasoft._11_jvm;

/**
 * ClassLoader翻译过来就是类加载器，普通的java开发者其实用到的不多，但对于某些框架开发者来说却非常常见。
 * 理解ClassLoader的加载机制，也有利于我们编写出更高效的代码。ClassLoader的具体作用就是将class文件加载到jvm虚拟机中去，程序就可以正确运行了。
 * 但是，jvm启动的时候，并不会一次性加载所有的class文件，而是根据需要去动态加载。想想也是的，一次性加载那么多jar包那么多class，那内存不崩溃。
 *
 * Java语言系统自带有三个类加载器:
 *   - Bootstrap ClassLoader 最顶层的加载类，主要加载核心类库，%JRE_HOME%\lib下的rt.jar、resources.jar、charsets.jar和class等。
 *          另外需要注意的是可以通过启动jvm时指定-Xbootclasspath和路径来改变Bootstrap ClassLoader的加载目录。
 *          比如java -Xbootclasspath/a:path被指定的文件追加到默认的bootstrap路径中。我们可以打开我的电脑，在上面的目录下查看，
 *          看看这些jar包是不是存在于这个目录。
 *   - Extention ClassLoader 扩展的类加载器，加载目录%JRE_HOME%\lib\ext目录下的jar包和class文件。还可以加载-D java.ext.dirs选项指定的目录。
 *   - Appclass Loader也称为SystemAppClass 加载当前应用的classpath的所有类。
 *   加载顺序：1. Bootstrap CLassloder 2. Extention ClassLoader 3. AppClassLoader
 *
 * Company：MGTV
 * User: huangmin
 * DateTime: 2018/2/22 15:20
 */
public class ClassLoaderStart {
}

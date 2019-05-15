# interview
2019年5月9日开始记录面试题，把每次的面试题和程序记录下来，反复总结。

##1.塔木科技0509
在线三个算法题：第一个二分查找，第二个放到hashmap中，第三题逻辑判断，没做出来。

- 服务端测试：目前你正在领导团队开发一款新软件。你在检查项目的时候发现最后一个版本的测试没有通过，并且你知道只要上一个版本有错误，此版本的每一个下面版本都会是错误的。 假设你有S个版本数组【1,2,3,4...,S】，你想找出最早发生错误的版本。假设查找版本的API是 IsBug(Sn) 传入版本号就会返回该版本是否有错误。 请使用API写一个函数用尽量少的步骤找出这第一个出错的版本号。（JS或其他语言）
- 字符串中找出重复数字打印出来值和个数
- 服务端测试：有一个字符串A，有一个字符串B，想要从A转换到B，只能一次一次转换，每次转换要把字符串A中的一个字符全部转换成另外一个字符。求字符串A能不能转换成字符串B。 例如： “abc” -> "bbc" -> "ddc" （判断转换是否成立）

##2.中科软0510
一个算法题：
写一个完整的java代码，实现输入n，计算n的阶乘，注意：
1. 用递归实现
2. 程序要可编译可执行
3. 要有健壮性（怎么测试都合理/正确输出）。

##3.小水滴0510
笔试是一页选择题，考察java基础知识。
1. 线程的方法
2. set、map父类抽象方法
3. 构造函数

面试考察java基础和框架

1. wait()、sleep()区别
2. 死锁及解决办法
3. hashmap的实现，为什么用红黑树，红黑树的复杂度，hashmap的线程安全实现，currenthashmap是怎么实现的线程安全的
4. 统计乱序数组中的第二大数字
5. 快速排序的复杂度
7. spring的bean生命周期，ApplicationContext和BeanFactory的关系
8. IOC的实现，两种动态代理的区别，为什么cglib动态代理时不用实现接口
9. 公平锁与非公平锁


##4.字节跳动0514

今天收到电话，16号下午视频面试。准备一下面经：

1. 虚拟内存是干什么用的？
    首先就是计算机执行指令，cpu执行的速度太快了，磁盘的读写速度远远跟不上，
    就引入了内存，类似于内存条作为cpu和磁盘的中间层。内存的速度也跟不上cpu
    又引入了高速缓存，如计算机的一级二级三级缓存。cpu只需要到缓存中取指令就ok，
    速度比内存快很多。
    一级缓存是静态ram（SRAM），二级缓存是动态的ram（DRAM）。
    （静态比动态速度快很多，但是相同的数据比动态的体积大6倍，价格高）。
    
    cpu找数据或者指令的顺序是：
        一级缓存 -》 二级缓存 -》 内存  
        
    虚拟缓存就是把内存的信息分一部分在磁盘上。目的是为了使更多的程序能够在有限的内存中运行。
    
2. HTTP协议包括哪几种请求，如何保证幂等性？
    HTTP协议本身是一种面向资源的应用层协议，无连接，无状态。
    八种方法：post、put、delete、connect、head、trace、get、options。
    幂等性指的是一次请求和多次请求某一资源具有同样的副作用。
   
    - GET 请求银行账户的余额，虽然结果不一定相同，可是并无副作用，因此是幂等的。
    - 采用 POST 请求提交扣款，多次提交产生不同的副作用，因此不满足幂等性。
    - delete请求用于删除资源，有副作用，但是副作用相同，满足幂等性。
    - put用于创建或者更新，有副作用，同delete，满足幂等性。

    post和get区别？
    相同：都是基于TCP/IP协议的，两者数据传输都是基于TCP连接。
    不同： get 浏览器回退无害，post会再次提交请求。
           get产生的url可以被收藏和浏览器缓存，post不能收藏也不能缓存
           get通过url传递参数，长度有限制。post放在request body并且长度没有限制。因此post不暴露参数更安全一些。
           get产生一个TCP数据包，而post产生两个TCP数据包。（有个有可能，有的不会。主要是tcp协议栈的问题）
                具体是get把head和data一起发送，服务器响应200。而post会先发送head，服务器响应100，再发送data，服务器响应200。
           
3. 输入一个网址到浏览器渲染出页面的过程中有哪些报文，分别涉及哪些协议，协议的主要内容是啥，分别用来做什么的。      
    
    1. 要将网址解析成ip地址，域名解析用到DNS协议。DNS服务器是基于UDP的，因此用到UDP协议。
    2. 得到ip地址后，浏览器与服务器简历http连接，用到HTTP协议。
    3. HTTP的数据包会发送给IP层，用到IP协议。
    
   - DNS协议：由解析器以及域名服务器组成的。域名服务器保存该网络中所有主机的域名和对应IP地址，主要功能将域名转换为IP地址。
   - UDP协议：
   - HTTP协议：包含报文类型，报文类型语法，字段的含义
   
   TCP与UDP的区别：
   TCP：1. 是面向连接的，通讯时必须要先建立连接，然后再通过TCP发送数据。
        2. 保证消息的可靠性，如果消息在传输过程中丢失，那么将重发。
        3. 消息的有序性。
        4. TCP不保存数据的边界，在传输层数据以字节流的形式发送。
        5. 速度慢，需要建立连接
        6. 开销大，被认为是重量级协议。
        7. 头大，一个TCP数据包报头大小20字节
        8.流量控制
        
   UDP：1.无连接的协议，直接点对点连接就可以发送消息。
        2.不保证消息的可靠性，报文可能在运输的途中丢失。
        3.消息无序，
        4.数据包单独发送，只有到达的时候才会再次集成，所有有明确的界限。
        5.速度快
        6.开销小，轻量级协议。
        7.头小，一个UDP数据报报头是8个字节。
        8.没有流量控制
        
   
4. 如果让你设计一个下载器中的断点续传功能，你打算怎么设计，会有哪些问题。
   两个方面思考：
    
    1. 续传的时候需要在想要的位置进行读写操作；
    2. 得记录这个断点的位置信息，持久化到数据库中；  

5. Volatile关键字干什么用的和底层原理
    
    Java的多线程通讯采用的是共享内存模型，内存模型中是每个线程与内存中间有一个线程独有的线程缓存内存，
    线程缓存内存是一个抽象的概念，实际上不存在，实现上类似于计算机的高速缓存。
    当多个线程对一个共享的变量进行操作时，就会先从内存加载到线程缓存内存中，然后进行操作，最后再刷会内存到磁盘持久化。
    这时候已经出了多线程数据问题。
    Volatile关键字是为了解决这一问题：
    1. 使变量在多个线程中间可见
    2. 从公共堆栈取变量的值，而不是线程私有的数据栈
    3. 禁止指令重新排序的优化
    所以说volatile是一种轻量级，性能好，不阻塞的解决方案，可以保证可见性。但是不能保证原子性，基于并发下不是安全的，
    多线程访问统一实例变量还是要加同步锁。

6. CAS干什么用的以及原理。
    Java程序为了实现资源的争用就引入了锁，锁的性能又不好，所以提出一种CAS无锁的方式。Compare And Swap
    CAS是一种原子操作，虽然是对比和交换两个步骤，但是通过cpu的指令集的优化就可以把CAS作为原子操作。
    
    原理是：
        Jvm中的CAS操作是基于处理器的CMPXCHG指令实现的，原理是比较从内存中取出的值和旧的期望值，
        如果相等就进行操作将内存值修改为要修改的值，并且返回true，如果不相等就直接返回false。
        
    应用：
    1. 原子类 AtomicInteger  AtomicLong  AtomicReference  AtomicBoolean
        基于Unsafe实现的，Unsafe通过单例模式提供实例对象，方法大多为native方法。
    2. 
    
    缺点：
    1. ABA问题
    2. 循环时间长开销大
    3. 只能保证一个共享变量的院子操作
        
7. currentHashMap分析
    1.7之前分段锁的思想，对于不同的数据段使用不同的锁，支持多线程同时访问不同的数据段，这样线程就不存在锁竞争，从而提高并发效率。
    1.8之后采用Node数组+链表+红黑树的数据结构来实现的。
    并发采用CAS操作保证数据的获取以及使用synchronized关键字对相应的数据段加锁实现了主要功能。
    采用Node类为一个基本的存储单元，每个键值对都存储在一个Node中。子类TreeNode、TreeBin。  
    
8. LinkedHashMap
   双向链表和HashMap实现LinkedHashMap
   
9. 把反射和动态代理梳理一下，肯定会问spring
   只需要关注 InvocationHandler 与 Proxy 对象。   
   
       /**
        目的： 该方法负责集中处理动态代理类上的所有方法调用。
        第一个参数既是代理类实例，
        第二个参数是被调用的方法对象
        第三个方法是调用参数。
        调用处理器根据这三个参数进行预处理或分派到委托类实例上发射执行
       */
        public Object invoke(Object proxy, Method method, Object[] args)
        
        
       /**
        目的： 创建动态代理对象
        *  loader 类加载器，将字节码加载到JVM并为其定义类对象，然后该类才能使用
        *  Proxy类与普通类的唯一区别就是其字节码是由JVM在运行时动态生成的而非预存在任意一个.class文件中。
        */
        public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
        
        
        流程机制：
        1. 通过实现 InvocationHandler 接口创建自己的调用处理器；
        2. 通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
        3. 通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
        4. 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
        5. 通过代理对象调用目标方法

        动态代理的类已经 extends Proxy，所以只能实现接口。
        因此才有cglib的需要。
   
         
    
    












package com.zzc.threadpool.zzc_alibaba;

import java.util.*;
import java.util.concurrent.*;

public class Sale {
	private static final Integer USER_COUNT = 999999; //用户数
	private static final Integer PRODUCT_COUNT = 99999; //商品数
	private static final Integer RAND_NUM = 9999999; //获取1 ~ 9999999之间的随机数

	private static String s = "";// 用于锁的对象
	private static ConcurrentHashMap userIdMap = new ConcurrentHashMap(PRODUCT_COUNT);//存放已秒杀过的用户ID
//	private static List<Product> sold = new LinkedList<Product>();// 存放已销售的商品（此时商品里包含商品id跟用户id）
//	private static List<Product> sold = new ArrayList<Product>(PRODUCT_COUNT);// 存放已销售的商品（此时商品里包含商品id跟用户id）
//	private static List<Product> sold =Collections.synchronizedList(new ArrayList<Product>(PRODUCT_COUNT)); ;// 存放已销售的商品（此时商品里包含商品id跟用户id）
	static ArrayBlockingQueue sold = new ArrayBlockingQueue(PRODUCT_COUNT);

	static ArrayBlockingQueue product = new ArrayBlockingQueue(PRODUCT_COUNT);// 将产品全部放入此队列中
	static ArrayBlockingQueue users = new ArrayBlockingQueue(USER_COUNT);// 模拟用户



	public static void  main(String[] args) throws ExecutionException, InterruptedException {
		//准备用户和产品
		initParam(product,users);

		long start = System.currentTimeMillis();
		newCachedThreadPool();
		long end = System.currentTimeMillis();
		System.out.println("整个秒杀活动总耗时：" + (end - start) + " ms");


		//秒杀结束后打印信息
		for (int i = 0; i < sold.size(); i++) {
//			 System.out.println(sold.get(i).toString());
		}
	}


	/**
	 * 多线程任务
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	private static void newCachedThreadPool() throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);// 此处使用固定长度的线程池，由于测试电脑是4核，所以用4个线程
		try {
			for (int ii = 0; ii < USER_COUNT; ii++) {// 模拟999999个用户参与秒杀
				executorService.execute(new Runnable() {
					public void run(){
						Product p = null;
						User user = null;
						try {
							if (product.isEmpty()) {
								// System.out.println("很抱歉，商品已售罄！！！");
								return;
							}
							p = (Product) product.take();// 从队列中取出一件商品
							user = (User) users.take();// 一个用户秒杀产品
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						int userBuyId = user.getBuyerId();
						//
						if (userIdMap.get(userBuyId) == null) {// 判断此用户是否已经秒杀成功商品了
							p.setBuyerId(userBuyId);
							userIdMap.put(userBuyId, "1");
//							synchronized (s) {// 锁住静态对象，保证所有线程互斥
								sold.add(p);
//							}
						} else {
							// System.out.println("很抱歉，您已经秒杀过了！！！");
						}
					}
				});
			}

		} finally {
			executorService.shutdown();// 任务全部执行完毕后关闭线程池
			while(true){
				if(executorService.isTerminated()){//判断所有线程是否执行完毕
					break;
				}
			}
		}
	}


	/**
	 * 准备用户跟产品
	 * @param product
	 * @param users
	 * @throws InterruptedException
	 */
	private static void initParam(ArrayBlockingQueue product, ArrayBlockingQueue users) throws InterruptedException {
		for (int i = 0; i <PRODUCT_COUNT ; i++) {
			product.put(new Product(i));// 99999件商品
		}
		for (int i = 0; i <USER_COUNT ; i++) {
			Random random = new Random();
			users.put(new User(random.nextInt(RAND_NUM)));// 999999个用户
		}
	}
}

package com.itheima.task.schedule;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ziyin
 @create 2019-03-2019/3/24-9:45
 */
public class TaskThreadFactory implements ThreadFactory {

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setDaemon(true);
		thread.setName("Task-" + atomicInteger.incrementAndGet());
		return thread;
	}
}

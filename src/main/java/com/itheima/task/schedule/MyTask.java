package com.itheima.task.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ziyin
 @create 2019-03-2019/3/24-10:00
 */
@Service
public class MyTask extends AbstractScheduledTask {
	private Logger logger = LoggerFactory.getLogger(MyTask.class);

	@Override
	protected long getInitialDely() {
		return 5;
	}

	@Override
	protected long getDely() {
		return 5;
	}

	@Override
	protected TimeUnit getUnit() {
		return TimeUnit.SECONDS;
	}

	@Override
	protected void selfJob() {
		//job 的业务逻辑
		logger.info("task running");
	}
}

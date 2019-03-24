package com.itheima.task.schedule;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ziyin
 @create 2019-03-2019/3/24-9:44
 */
@Service
public abstract class AbstractScheduledTask {
	private Logger logger = LoggerFactory.getLogger(AbstractScheduledTask.class);
	private ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(
			Runtime.getRuntime().availableProcessors(),new TaskThreadFactory());
	@Resource
	private TaskConfig taskConfig;

	protected abstract long getInitialDely();

	protected abstract long getDely();

	protected abstract TimeUnit getUnit();

	protected abstract void selfJob();

	@PostConstruct
	public void jobEntrance() {
		String ip = null;
		try {
			ip = IPUtils.getLocalIp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		String taskIp = taskConfig.getTaskIp();
		if(StringUtils.isNotBlank(taskIp) && StringUtils.isNotBlank(ip) && taskIp.equals(ip)) {
			scheduledExecutorService.scheduleWithFixedDelay(() -> {
				try {
					selfJob();
				}catch (Exception e) {
					e.printStackTrace();
				}
			},getInitialDely(),getDely(),getUnit());
			logger.info("Schedule task start success");
		} else {
			logger.error("Schedule task start fail, because local ip is " + ip + "and task ip is " + taskIp);
		}

	}
}

package com.itheima.task.schedule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author ziyin
 @create 2019-03-2019/3/24-9:58
 */
@Service
public class TaskConfig {

	@Value("${task.ip}")
	private String taskIp;

	public String getTaskIp() {
		return taskIp;
	}

	public void setTaskIp(String taskIp) {
		this.taskIp = taskIp;
	}
}

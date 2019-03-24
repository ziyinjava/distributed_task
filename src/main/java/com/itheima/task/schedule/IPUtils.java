package com.itheima.task.schedule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author ziyin
 @create 2019-03-2019/3/24-9:48
 */
public class IPUtils {

	private static Logger logger = LoggerFactory.getLogger(IPUtils.class);

	public static String getLocalIp() throws SocketException {
		Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

		while (networkInterfaces.hasMoreElements()){
			NetworkInterface networkInterface = networkInterfaces.nextElement();
			Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
			while (inetAddresses.hasMoreElements()) {
				InetAddress ip = inetAddresses.nextElement();
				if(ip != null && ip instanceof Inet4Address){
					logger.info("Local ip is " + ip);
					return ip.getHostAddress();
				}
			}
		}
		return null;
	}

}

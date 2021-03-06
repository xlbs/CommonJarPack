package com.jedis.entityobj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author xielbs
 * @create 2018-04-18 9:37
 * @desc 集群配置参数
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "redisClusters")
public class RedisCluster {
	
	private String clusterName;
	
	private List<IP> ipports;

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public List<IP> getIpports() {
		return ipports;
	}

	public void setIpports(List<IP> ipports) {
		this.ipports = ipports;
	}
	
}

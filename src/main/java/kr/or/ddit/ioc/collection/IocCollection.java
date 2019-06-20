package kr.or.ddit.ioc.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class IocCollection {
	private List<String> list;
	private Map<String, String> map;
	private Set<String> set;
	private Properties properties;
	
	public IocCollection() {
		// TODO Auto-generated constructor stub
	}
	
	public IocCollection(List<String> list, Map<String, String> map, Set<String> set, Properties properties) {
		super();
		this.list = list;
		this.map = map;
		this.set = set;
		this.properties = properties;
	}

	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
}

package hello.core.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

	private String url;

	public NetworkClient() {
		System.out.println("생성사 호출, url : " + url);
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void connect() {
		System.out.println("connect : " + url);
	}

	public void call(String msg) {
		System.out.println("call : " + url + " / " + "message : " + msg);
	}

	public void disconnect() {
		System.out.println("disconnect : " + url);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		connect();
		call("초기화");
	}

	@Override
	public void destroy() throws Exception {
		disconnect();
	}
}
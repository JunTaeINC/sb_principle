package hello.core.lifeCycle;

public class NetworkClient {

	private String url;

	public NetworkClient() {
		System.out.println("생성사 호출, url : " + url);
		connect();
		call("초기화 연결 메세지");
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
}
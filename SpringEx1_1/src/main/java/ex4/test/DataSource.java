package ex4.test;

public class DataSource {
	private ServerSetting server;

//	public DataSource(ServerSetting server) {
//		this.server = server;
//	}

	public ServerSetting getServer() {
		return server;
	}

	public void setServer(ServerSetting server) {
		this.server = server;
	}

	public void serverInfo() {
		System.out.println("** server Info **");
		System.out.println("driver class : " + server.getDriverClass());
		System.out.println("URL : " + server.getUrl());
		System.out.println("ID : " + server.getUserName());
		System.out.println("password : " + server.getPassWord());
	}
}

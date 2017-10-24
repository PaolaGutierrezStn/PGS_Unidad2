package model;

public class StoreProcess {
	private String pid;
	private String state;
	private String type;
	private int version;
	private String du;
	
	
	public StoreProcess(String pid, String state, String type, int version, String du) {
		super();
		this.pid = pid;
		this.state = state;
		this.type = type;
		this.version = version;
		this.du = du;
	}
	
	public StoreProcess() {
		this("", "", "", 0, "");
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getDu() {
		return du;
	}

	public void setDu(String du) {
		this.du = du;
	}

	
	
	

}

package Logic;

public class ErrorManager {
	
	public ErrorManager(String titlle,String descp)
	{
		this.setDescp(descp);
		this.setTitlle(titlle);
	}
	
	public ErrorManager() {
		// TODO Auto-generated constructor stub
	}

	private String titlle;
	private String descp;
	private String page;
	
	
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	public String getTitlle() {
		return titlle;
	}
	public void setTitlle(String titlle) {
		this.titlle = titlle;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
}

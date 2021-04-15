package resources;

public enum APIResources {
	
	CreteBinAPI("https://api.jsonbin.io/v3/b"),
	ReadBinAPI("https://api.jsonbin.io/v3/b/{BIN_ID}"),
	UpdateBinAPI("https://api.jsonbin.io/v3/b/{BIN_ID}"),
	DeleteBinAPI("https://api.jsonbin.io/v3/b/{BIN_ID}");

	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}

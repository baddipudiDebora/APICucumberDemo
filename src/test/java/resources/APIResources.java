package resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	ViewMovie("http://www.omdbapi.com/");
	
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

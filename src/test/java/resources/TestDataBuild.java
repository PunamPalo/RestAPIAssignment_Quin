package resources;



import pojo.AddBIN;

public class TestDataBuild {

	/** This method is used to set the data load */
	
	public AddBIN addBinPayLoad(String name,String address)
	{
		AddBIN p =new AddBIN();
		
		p.setName(name);
		p.setAddress(address);
		return p;
	}
	
	
}

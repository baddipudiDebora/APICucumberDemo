package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.GetMovie;
import pojo.Location;

public class TestDataBuild {

	public Object viewMoviePayLoad(String name, String language, String address, String type)
	{
		GetMovie m =new GetMovie();
		m.setapikey("?9c7073c4");
		m.setT("%E2%80%9CA+star+is+born");
		m.setY("2018");
		m.setType("movie");
		return m;
	}


	
}

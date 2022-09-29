import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Crawler{
	
	
	protected ArraySet<String> foundPages;
	protected ArraySet<String> skippedPages;
	
	public Crawler()
	{
		 foundPages= new ArraySet<>();
		 skippedPages= new ArraySet<>();
		
	}
	
	public abstract void crawl(String pageFileName) ;
	
	public List<String> foundPagesList()
	{
		return this.foundPages.asList();
		
	}
	public List<String> skippedPagesList()
	{
		
		return this.skippedPages.asList();
	}
	
	public String foundPagesString()
	{
		String temp ="";
		for(String i:this.foundPagesList())
		{
			temp+=i+"\n";
		}
		return temp;
		
	}
	
	public String skippedPagesString()
	{
		String temp ="";
		for(String i: this.skippedPagesList())
		{
			temp+=i+"\n";
		}
		return temp;
	}
	
	public static boolean validPageLink(String pageFileName)
	{
		if(pageFileName.startsWith("http://")||pageFileName.startsWith("https://")||pageFileName.startsWith("file://")||pageFileName.startsWith("javascript:" )||pageFileName.endsWith("http://")||pageFileName.endsWith("https://")||pageFileName.endsWith("file://"))
		{
			return false;
		}
		 if(pageFileName.endsWith(".HTML")||pageFileName.endsWith(".html"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	
	
}

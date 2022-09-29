import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class IterativeCrawler extends Crawler {
	
	protected ArraySet<String> pendingPages;
	
	public IterativeCrawler()
	{
		this.foundPages= new ArraySet<>();
		this.skippedPages= new ArraySet<>();
		
	}

	@Override
	public void crawl(String pageFileName) 
	{
		
			//File input = new File(pageFileName);
			foundPages.add(pageFileName);
			Document doc = Jsoup.parse(pageFileName, "UTF-8");
			ArrayList<Element> links = doc.select("a[href]");
			for(Element i:links)
			{ 
				String linkedPage = i.attr("href");
			    if(validPageLink(linkedPage)==false)
			    {
			    	skippedPages.add(linkedPage);
			    	continue;
			    }
			    String linkFile = Util.relativeFileName(pageFileName,linkedPage );
			    if(foundPages.contains(linkFile)||skippedPages.contains(linkFile))
			    {
			    	continue;
			    }
			    if (new File(linkFile).exists()==false)
			    {
			    	skippedPages.add(linkedPage);
			    	continue;
			    	
			    }
			    
			    this.pendingPages.add(linkFile);
			    crawlRemaining();
			    
			}
			
		} 

		
		
	

	public void crawlRemaining()
	{
		for(String i :this.pendingPages.asList())
		{
			this.pendingPages.add(i);
		}
				
	}
	public void addPendingPage(String pageFileName)
	{
		this.pendingPages.add(pageFileName);
	}
	public int pendingPagesSize()
	{
		return this.pendingPages.size();
	}
	public String pendingPagesString()
	{
		String temp ="";
		for(String i: this.pendingPages.asList())
		{
			temp+=i+"\n";
		}
		return temp;
	}
	public void crawlNextPage()
	{
		
	}
}

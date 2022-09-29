import java.io.*;
import java.util.*;
import org.jsoup.nodes.*;
import org.jsoup.*;
import org.jsoup.select.*;
public class RecursiveCrawler extends Crawler {

	
	public RecursiveCrawler() {
		
		foundPages= new ArraySet<>();
		skippedPages= new ArraySet<>();
	}
	
	
	
	public void crawl(String pageFileName) {
		
		try {
			foundPages.add(pageFileName);
			File input = new File(pageFileName);
			Document doc = Jsoup.parse(input, "UTF-8");
			ArrayList<Element> links = doc.select("a[href]");
			
			for(Element i:links)
			{ 
				String linkedPage = i.attr("href");
			    if(validPageLink(linkedPage)==false)
			    {
			    	skippedPages.add(linkedPage);
			    	continue;
			    }
			    //Util.relativeFileName(pageFileName,linkedPage );
			    if(foundPages.contains(Util.relativeFileName(pageFileName,linkedPage) )||skippedPages.contains(Util.relativeFileName(pageFileName,linkedPage)))
			    {
			    	continue;
			    }
			    if (new File(Util.relativeFileName(pageFileName,linkedPage)).exists()==false)
			    {
			    	skippedPages.add(linkedPage);
			    	continue;
			    	
			    }
			    
			    crawl(Util.relativeFileName(pageFileName,linkedPage));
			    
			}
			
		} catch (IOException e) {

		}

		
	}
	
	

}

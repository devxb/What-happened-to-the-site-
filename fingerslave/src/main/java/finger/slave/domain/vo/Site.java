package finger.slave.domain.vo;

import java.time.LocalDate;
import java.util.List;

public interface Site{
	
	public String getUrl();
	public LocalDate getUpdatedDate();
	public List<Site> getRelationSites();
	public Site getRelaitonSite(String url);
	public List<Keyword> getKeywords();
	public Keyword getKeyword(String keyword);
	
}
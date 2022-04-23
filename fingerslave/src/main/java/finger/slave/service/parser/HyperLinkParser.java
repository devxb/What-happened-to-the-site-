package finger.slave.service.parser;

import org.springframework.stereotype.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.util.*;

import finger.slave.service.util.*;

@Service
public class HyperLinkParser implements FingerParser{
	
	@Override
	public Map<String, ParameterWrapper> parse(String content, String... uris){
		String uri = uris[0];
		Document document = Jsoup.parse(content);
		Map<String, ParameterWrapper> hyperLinkMap = new HashMap<String, ParameterWrapper>();
		this.parseHead(uri, document, hyperLinkMap);
		this.parseBody(uri, document, hyperLinkMap);
		return hyperLinkMap;
	}
	
	private void parseHead(String uri, Document document, Map<String, ParameterWrapper> hyperLinkMap){
		Element head = document.head();
		this.parseElement(uri, head, hyperLinkMap);
	}
	
	private void parseBody(String uri, Document document, Map<String, ParameterWrapper> hyperLinkMap){
		Element body = document.body();
		this.parseElement(uri, body, hyperLinkMap);
	}
	
	private void parseElement(String uri, Element element, Map<String, ParameterWrapper> hyperLinkMap){
		Elements links = element.getElementsByTag("a");
		this.setLinkOnMap(uri, links, hyperLinkMap);
	}
	
	private void setLinkOnMap(String uri, Elements links, Map<String, ParameterWrapper> hyperLinkMap){
		List<String> hrefs = links.eachAttr("href");
		for(String href : hrefs) {
			if(URIExtractor.isRelativePath(href)) 
				hyperLinkMap.put(href, ParameterWrapper.wrap(URIExtractor.getProtocol(uri) + URIExtractor.getHost(uri) + href));
			else hyperLinkMap.put(href, ParameterWrapper.wrap(href));
		}
	}
	
}
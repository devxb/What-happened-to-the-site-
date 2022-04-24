package finger.slave.service.builder;

import org.springframework.beans.factory.annotation.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.time.*;

import finger.slave.domain.vo.*;
import finger.slave.service.util.*;

public class SiteReflectiveBuilderTest{
	
	private SiteReflectiveBuilder siteBuilder = new SiteReflectiveBuilder();
	
	private final String testurl = "https://test url";
	private final LocalDate testDate = LocalDate.now();
	private final List<Site> testSites = new ArrayList<Site>();
	private final List<Keyword> testKeywords = new ArrayList<Keyword>();
	
	@Test
	public void Site_Object_Make_Test(){
		// given
		Map<String, ParameterWrapper> parameterMap = this.getParameterMap();
		
		// when
		Site site = this.siteBuilder.build(parameterMap);
		
		// then
		assertTrue(site.getUrl().equals(this.testurl));
		assertTrue(site.getUpdatedDate().toString().equals(this.testDate.toString()));
		assertTrue(site.getRelationSites().isEmpty());
		assertTrue(site.getKeywords().isEmpty());
	}
	
	@Test
	public void Site_Object_Make_Test_With_AlreadyMadeSite(){
		// given
		Site alreadyMadeSite = new SiteImpl();
		Map<String, ParameterWrapper> parameterMap = this.getParameterMap();
		
		// when
		this.siteBuilder.build(alreadyMadeSite, parameterMap);
		
		// then
		assertTrue(alreadyMadeSite.getUrl().equals(this.testurl));
		assertTrue(alreadyMadeSite.getUpdatedDate().toString().equals(this.testDate.toString()));
		assertTrue(alreadyMadeSite.getRelationSites().isEmpty());
		assertTrue(alreadyMadeSite.getKeywords().isEmpty());
	}
	
	private Map<String, ParameterWrapper> getParameterMap(){
		Map<String, ParameterWrapper> parameterMap = new HashMap<String, ParameterWrapper>();
		parameterMap.put("url", ParameterWrapper.wrap(this.testurl));
		parameterMap.put("updatedDate", ParameterWrapper.wrap(this.testDate));
		parameterMap.put("relationSites", ParameterWrapper.wrap(this.testSites));
		parameterMap.put("keywords", ParameterWrapper.wrap(this.testKeywords));
		return parameterMap;
	}	

}
package com.linkedin.bobo.facets.range;

import com.linkedin.bobo.api.BoboIndexReader;
import com.linkedin.bobo.facets.data.FacetDataCache;
import com.linkedin.bobo.facets.filter.AdaptiveFacetFilter.FacetDataCacheBuilder;

public class SimpleDataCacheBuilder implements FacetDataCacheBuilder{
  private String name;
  public SimpleDataCacheBuilder( String name) {      
    this.name = name;
    
  }
  public FacetDataCache build(BoboIndexReader reader) {
    return (FacetDataCache) reader.getFacetData(name);
  }
  public String getName() {
    return name;
  }   
}

package com.linkedin.bobo.facets.data;

import com.linkedin.bobo.api.BoboIndexReader;

public interface FacetDataFetcher
{
  public Object fetch(BoboIndexReader reader, int doc);

  public void cleanup(BoboIndexReader reader);
}

package com.linkedin.bobo.facets;

import com.linkedin.bobo.api.BoboIndexReader;

public abstract class FacetCountCollectorSource {
	public abstract FacetCountCollector getFacetCountCollector(BoboIndexReader reader,int docBase);
}

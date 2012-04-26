package com.linkedin.bobo.facets.range;

import org.apache.lucene.util.OpenBitSet;

import com.linkedin.bobo.facets.data.FacetDataCache;

public interface BitSetBuilder {
  OpenBitSet bitSet(FacetDataCache dataCache);
}

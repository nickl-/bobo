package com.linkedin.bobo.facets.impl;

import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.floats.FloatList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Explanation;

import com.linkedin.bobo.api.BoboIndexReader;
import com.linkedin.bobo.api.BoboIndexReader.WorkArea;
import com.linkedin.bobo.api.BrowseSelection;
import com.linkedin.bobo.api.FacetSpec;
import com.linkedin.bobo.facets.FacetCountCollector;
import com.linkedin.bobo.facets.FacetCountCollectorSource;
import com.linkedin.bobo.facets.FacetHandler;
import com.linkedin.bobo.facets.data.MultiValueWithWeightFacetDataCache;
import com.linkedin.bobo.facets.data.TermListFactory;
import com.linkedin.bobo.facets.filter.AdaptiveFacetFilter;
import com.linkedin.bobo.facets.filter.EmptyFilter;
import com.linkedin.bobo.facets.filter.MultiValueFacetFilter;
import com.linkedin.bobo.facets.filter.MultiValueORFacetFilter;
import com.linkedin.bobo.facets.filter.RandomAccessAndFilter;
import com.linkedin.bobo.facets.filter.RandomAccessFilter;
import com.linkedin.bobo.facets.filter.RandomAccessNotFilter;
import com.linkedin.bobo.facets.range.MultiDataCacheBuilder;
import com.linkedin.bobo.facets.range.SimpleDataCacheBuilder;
import com.linkedin.bobo.query.scoring.BoboDocScorer;
import com.linkedin.bobo.query.scoring.FacetScoreable;
import com.linkedin.bobo.query.scoring.FacetTermScoringFunctionFactory;
import com.linkedin.bobo.sort.DocComparatorSource;
import com.linkedin.bobo.util.BigNestedIntArray;

public class MultiValueWithWeightFacetHandler extends MultiValueFacetHandler
{
  public MultiValueWithWeightFacetHandler(String name, String indexFieldName, TermListFactory termListFactory) 
  {
    super(name, indexFieldName, termListFactory, null, null);
  }

  public MultiValueWithWeightFacetHandler(String name, String indexFieldName) 
  {
    super(name, indexFieldName, null, null, null);
  }

  public MultiValueWithWeightFacetHandler(String name) 
  {
    super(name, name, null, null, null);
  }

  @Override
  public RandomAccessFilter buildRandomAccessFilter(String value, Properties prop) throws IOException
  {
    MultiValueFacetFilter f= new MultiValueFacetFilter(new MultiDataCacheBuilder(getName()), value);
    return f;
  }
  @Override
  public MultiValueWithWeightFacetDataCache load(BoboIndexReader reader, WorkArea workArea) throws IOException
  {
    MultiValueWithWeightFacetDataCache dataCache = new MultiValueWithWeightFacetDataCache();
      
    dataCache.setMaxItems(_maxItems);

    if(_sizePayloadTerm == null)
    {
      dataCache.load(_indexFieldName, reader, _termListFactory, workArea);
    }
    else
    {
      dataCache.load(_indexFieldName, reader, _termListFactory, _sizePayloadTerm);
    }
    return dataCache;
  }
}

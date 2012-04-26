package com.linkedin.bobo.facets.impl;

import com.linkedin.bobo.api.BrowseSelection;
import com.linkedin.bobo.api.FacetSpec;
import com.linkedin.bobo.facets.data.FacetDataCache;

public abstract class GroupByFacetCountCollector extends DefaultFacetCountCollector
{
  private int _totalGroups;

  public GroupByFacetCountCollector(String name,
                                    FacetDataCache dataCache,
                                    int docBase,
                                    BrowseSelection sel,
                                    FacetSpec ospec)
  {
    super(name, dataCache, docBase, sel, ospec);
  }

  abstract public int getTotalGroups();
}


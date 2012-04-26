package com.linkedin.bobo.facets.filter;

import java.io.IOException;

import com.linkedin.bobo.api.BoboIndexReader;
import com.linkedin.bobo.docidset.EmptyDocIdSet;
import com.linkedin.bobo.docidset.RandomAccessDocIdSet;

public class EmptyFilter extends RandomAccessFilter 
{
	private static final long serialVersionUID = 1L;

	private static EmptyFilter instance = new EmptyFilter();
	
	private EmptyFilter()
	{
		
	}

	 public double getFacetSelectivity(BoboIndexReader reader)
	  {
	   return 0.0;
	  }
	 
	@Override
	public RandomAccessDocIdSet getRandomAccessDocIdSet(BoboIndexReader reader) throws IOException 
	{
		return EmptyDocIdSet.getInstance();
	}
	
	public static EmptyFilter getInstance()
	{
		return instance;
	}
	
}

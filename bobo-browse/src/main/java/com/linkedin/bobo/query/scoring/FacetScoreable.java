package com.linkedin.bobo.query.scoring;

import java.util.Map;

import com.linkedin.bobo.api.BoboIndexReader;

public interface FacetScoreable {
	 BoboDocScorer getDocScorer(BoboIndexReader reader,
			 					FacetTermScoringFunctionFactory scoringFunctionFactory,
			 					Map<String,Float> boostMap);
}

package com.linkedin.bobo.geosearch.merge;

import java.io.IOException;


import com.linkedin.bobo.geosearch.bo.GeoSearchConfig;

public interface IGeoMerger {
    void merge(IGeoMergeInfo geoMergeInfo, GeoSearchConfig config) throws IOException;
}

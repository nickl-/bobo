package com.linkedin.bobo.geosearch;
import java.util.Iterator;
import java.util.TreeSet;

import com.linkedin.bobo.geosearch.bo.GeoRecord;
import com.linkedin.bobo.geosearch.bo.LatitudeLongitudeDocId;

public interface IGeoUtil {
    Iterator<GeoRecord> getGeoRecordIterator(Iterator<LatitudeLongitudeDocId> lldidIter);
    TreeSet<GeoRecord> getBinaryTreeOrderedByBitMag(Iterator<GeoRecord> grIter);
    TreeSet<GeoRecord> getBinaryTreeOrderedByBitMag();
    TreeSet<GeoRecord> getBinaryTreeOrderedByDocId(Iterator<GeoRecord> grIter);
    Iterator<GeoRecord> getGeoRecordRangeIterator(TreeSet<GeoRecord> tree, GeoRecord minRange, GeoRecord maxRange);
}


package com.linkedin.bobo.geosearch.impl;

import java.io.IOException;

import org.apache.lucene.store.IndexInput;
import org.apache.lucene.store.IndexOutput;

import com.linkedin.bobo.geosearch.IGeoRecordSerializer;
import com.linkedin.bobo.geosearch.bo.GeoRecord;

public class GeoRecordSerializer implements IGeoRecordSerializer<GeoRecord> {

    @Override
    public void writeGeoRecord(IndexOutput indexOutput, GeoRecord geoRecord, int recordByteCount) 
            throws IOException {
        indexOutput.writeLong(geoRecord.highOrder);
        indexOutput.writeInt(geoRecord.lowOrder);
        indexOutput.writeByte(geoRecord.filterByte);
    }

    @Override
    public GeoRecord readGeoRecord(IndexInput indexInput, int recordByteCount) throws IOException {
        return new GeoRecord(indexInput.readLong(),
                indexInput.readInt(),
                indexInput.readByte());
    }
    
}

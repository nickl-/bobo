/**
 * 
 */
package com.linkedin.bobo.geosearch.impl;

import org.apache.lucene.index.IndexReader;

import com.linkedin.bobo.geosearch.IDeletedDocs;

/**
 * @author Ken McCracken
 *
 */
public class IndexReaderDeletedDocs implements IDeletedDocs {

    private IndexReader indexReader;
    
    public IndexReaderDeletedDocs(IndexReader indexReader) {
        this. indexReader =  indexReader;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDeleted(int docid) {
        return indexReader.isDeleted(docid);
    }
    
}

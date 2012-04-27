package com.linkedin.bobo.util;

public interface MemoryManagerAdminMBean {
  long getNumCacheHits();
  long getNumCacheMisses();
  double getHitRate();
}

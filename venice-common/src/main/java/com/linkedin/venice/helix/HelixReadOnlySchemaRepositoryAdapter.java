package com.linkedin.venice.helix;

import com.linkedin.venice.common.VeniceSystemStoreType;
import com.linkedin.venice.meta.ReadOnlySchemaRepository;
import com.linkedin.venice.schema.rmd.ReplicationMetadataSchemaEntry;
import com.linkedin.venice.schema.writecompute.DerivedSchemaEntry;
import com.linkedin.venice.schema.rmd.ReplicationMetadataVersionId;
import com.linkedin.venice.schema.SchemaEntry;
import com.linkedin.venice.utils.Pair;
import java.util.Collection;


/**
 * This repository provides the read-only access to both system stores and regular stores.
 */
public class HelixReadOnlySchemaRepositoryAdapter implements ReadOnlySchemaRepository {
  private final HelixReadOnlyZKSharedSchemaRepository systemStoreSchemaRepository;
  private final ReadOnlySchemaRepository regularStoreSchemaRepository;

  public HelixReadOnlySchemaRepositoryAdapter(HelixReadOnlyZKSharedSchemaRepository systemStoreSchemaRepository,
      ReadOnlySchemaRepository regularStoreSchemaRepository) {
    this.systemStoreSchemaRepository = systemStoreSchemaRepository;
    this.regularStoreSchemaRepository = regularStoreSchemaRepository;
  }


  @Override
  public SchemaEntry getKeySchema(String storeName) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getKeySchema(storeName);
    }
    return systemStoreSchemaRepository.getKeySchema(systemStoreType.getZkSharedStoreName());
  }

  @Override
  public SchemaEntry getValueSchema(String storeName, int id) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getValueSchema(storeName, id);
    }
    return systemStoreSchemaRepository.getValueSchema(systemStoreType.getZkSharedStoreName(), id);
  }

  @Override
  public boolean hasValueSchema(String storeName, int id) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.hasValueSchema(storeName, id);
    }
    return systemStoreSchemaRepository.hasValueSchema(systemStoreType.getZkSharedStoreName(), id);
  }

  @Override
  public int getValueSchemaId(String storeName, String valueSchemaStr) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getValueSchemaId(storeName, valueSchemaStr);
    }
    return systemStoreSchemaRepository.getValueSchemaId(systemStoreType.getZkSharedStoreName(), valueSchemaStr);
  }

  @Override
  public Collection<SchemaEntry> getValueSchemas(String storeName) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getValueSchemas(storeName);
    }
    return systemStoreSchemaRepository.getValueSchemas(systemStoreType.getZkSharedStoreName());
  }

  @Override
  public SchemaEntry getLatestValueSchema(String storeName) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getLatestValueSchema(storeName);
    }
    return systemStoreSchemaRepository.getLatestValueSchema(systemStoreType.getZkSharedStoreName());
  }

  @Override
  public Pair<Integer, Integer> getDerivedSchemaId(String storeName, String derivedSchemaStr) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getDerivedSchemaId(storeName, derivedSchemaStr);
    }
    return systemStoreSchemaRepository.getDerivedSchemaId(systemStoreType.getZkSharedStoreName(), derivedSchemaStr);
  }

  @Override
  public DerivedSchemaEntry getDerivedSchema(String storeName, int valueSchemaId, int derivedSchemaId) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getDerivedSchema(storeName, valueSchemaId, derivedSchemaId);
    }
    return systemStoreSchemaRepository.getDerivedSchema(systemStoreType.getZkSharedStoreName(), valueSchemaId, derivedSchemaId);
  }

  @Override
  public Collection<DerivedSchemaEntry> getDerivedSchemas(String storeName) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getDerivedSchemas(storeName);
    }
    return systemStoreSchemaRepository.getDerivedSchemas(systemStoreType.getZkSharedStoreName());
  }

  @Override
  public DerivedSchemaEntry getLatestDerivedSchema(String storeName, int valueSchemaId) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getLatestDerivedSchema(storeName, valueSchemaId);
    }
    return systemStoreSchemaRepository.getLatestDerivedSchema(systemStoreType.getZkSharedStoreName(), valueSchemaId);
  }


  @Override
  public ReplicationMetadataVersionId getReplicationMetadataVersionId(String storeName, String replicationMetadataSchemaStr) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getReplicationMetadataVersionId(storeName, replicationMetadataSchemaStr);
    }
    return systemStoreSchemaRepository.getReplicationMetadataVersionId(systemStoreType.getZkSharedStoreName(),
        replicationMetadataSchemaStr);
  }

  @Override
  public ReplicationMetadataSchemaEntry getReplicationMetadataSchema(String storeName, int valueSchemaId, int replicationMetadataVersionId) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getReplicationMetadataSchema(storeName, valueSchemaId,
          replicationMetadataVersionId);
    }
    return systemStoreSchemaRepository.getReplicationMetadataSchema(systemStoreType.getZkSharedStoreName(), valueSchemaId,
        replicationMetadataVersionId);
  }

  @Override
  public Collection<ReplicationMetadataSchemaEntry> getReplicationMetadataSchemas(String storeName) {
    VeniceSystemStoreType systemStoreType = VeniceSystemStoreType.getSystemStoreType(storeName);
    if (HelixReadOnlyStoreRepositoryAdapter.forwardToRegularRepository(systemStoreType)) {
      return regularStoreSchemaRepository.getReplicationMetadataSchemas(storeName);
    }
    return systemStoreSchemaRepository.getReplicationMetadataSchemas(systemStoreType.getZkSharedStoreName());
  }

  @Override
  public void refresh() {
    systemStoreSchemaRepository.refresh();
    regularStoreSchemaRepository.refresh();
  }

  @Override
  public void clear() {
    systemStoreSchemaRepository.clear();
    regularStoreSchemaRepository.clear();
  }
}

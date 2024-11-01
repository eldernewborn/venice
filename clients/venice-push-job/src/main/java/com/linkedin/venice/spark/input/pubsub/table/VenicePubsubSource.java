package com.linkedin.venice.spark.input.pubsub.table;

import static com.linkedin.venice.spark.SparkConstants.*;

import com.linkedin.venice.utils.VeniceProperties;
import java.util.Map;
import java.util.Properties;
import org.apache.spark.sql.connector.catalog.Table;
import org.apache.spark.sql.connector.catalog.TableProvider;
import org.apache.spark.sql.connector.expressions.Transform;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.sql.util.CaseInsensitiveStringMap;


public class VenicePubsubSource implements TableProvider {
  public StructType inferSchema(CaseInsensitiveStringMap options) {
    // there is no inference, the table is always created with the same schema
    return KAFKA_INPUT_TABLE_SCHEMA;
  }

  @Override
  public Transform[] inferPartitioning(CaseInsensitiveStringMap options) {
    // we don't support partitioning, it comes from the kafka topic.
    return TableProvider.super.inferPartitioning(options);
  }

  @Override
  public Table getTable(StructType schema, Transform[] partitioning, Map<String, String> configs) {
    Properties properties = new Properties();
    properties.putAll(configs);
    // the properties here is the entry point for all the configurations
    // we receive from the outer layer.
    // schem and partitioning are useless and should be discarded?
    //

    // VeniceProperties consumerProperties = KafkaInputUtils.getConsumerProperties(properties);

    // if we want to break the bag-chain , this is the place !
    return new VenicePubsubInputTable(new VeniceProperties(properties));
  }

  @Override
  public boolean supportsExternalMetadata() {
    return false;
  }
}

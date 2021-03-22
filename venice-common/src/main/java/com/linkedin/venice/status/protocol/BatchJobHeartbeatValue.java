/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.venice.status.protocol;

@SuppressWarnings("all")
/** Value part of the heartbeat sent by a push job */
public class BatchJobHeartbeatValue extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"BatchJobHeartbeatValue\",\"namespace\":\"com.linkedin.venice.status.protocol\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\",\"doc\":\"Epoch time of when a heartbeat is generated.\"}]}");
  /** Epoch time of when a heartbeat is generated. */
  public long timestamp;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public Object get(int field$) {
    switch (field$) {
    case 0: return timestamp;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: timestamp = (Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
package com.mongodb.mongosh.service

import org.graalvm.polyglot.Value

interface ServiceProviderCursor {
  fun addOption(option: Int): ServiceProviderCursor
  fun allowPartialResults(): ServiceProviderCursor
  fun batchSize(v: Int): ServiceProviderCursor
  fun close(options: Value)
  fun clone(): ServiceProviderCursor
  fun isClosed(): Boolean
  fun collation(v: Value): ServiceProviderCursor
  fun comment(v: String): ServiceProviderCursor
  fun count(): Int
  fun forEach(func: Value)
  fun hasNext(): Boolean
  fun hint(v: Value): ServiceProviderCursor
  fun isExhausted(): Boolean
  fun itcount(): Int
  fun limit(v: Int): ServiceProviderCursor
  fun map(func: Value): ServiceProviderCursor
  fun max(v: Value): ServiceProviderCursor
  fun maxTimeMS(v: Long): ServiceProviderCursor
  fun min(v: Value): ServiceProviderCursor
  fun next(): Any?
  fun noCursorTimeout(): ServiceProviderCursor
  fun oplogReplay(): ServiceProviderCursor
  fun projection(v: Value): ServiceProviderCursor
  fun readPref(v: Value): ServiceProviderCursor
  fun returnKey(v: Value): ServiceProviderCursor
  fun size(): Value
  fun skip(v: Int): ServiceProviderCursor
  fun sort(spec: Value): ServiceProviderCursor
  fun tailable(): ServiceProviderCursor
  fun toArray(): Any?
  fun explain(verbosity: String?): Any?
}

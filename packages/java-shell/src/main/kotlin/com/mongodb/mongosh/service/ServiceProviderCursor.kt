package com.mongodb.mongosh.service

import org.graalvm.polyglot.Value

interface ServiceProviderCursor {
  fun addOption(option: Int): ServiceProviderCursor
  fun allowPartialResults(): ServiceProviderCursor
  fun batchSize(v: Int): ServiceProviderCursor
  fun close(options: Value)
  fun clone(): ServiceProviderCursor
  fun isClosed(): Boolean
  fun collation(spec: Value): ServiceProviderCursor
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
  fun maxTimeMS(value: Int): ServiceProviderCursor
  fun min(indexBounds: Value): ServiceProviderCursor
  fun next(): Any?
  fun noServiceProviderCursorTimeout(): ServiceProviderCursor
  fun oplogReplay(): ServiceProviderCursor
  fun projection(v: Value): ServiceProviderCursor
  fun readPref(v: Value): ServiceProviderCursor
  fun returnKey(v: Boolean): ServiceProviderCursor
  fun size(): Value
  fun skip(v: Int): ServiceProviderCursor
  fun sort(spec: Value): ServiceProviderCursor
  fun tailable(): ServiceProviderCursor
  fun toArray(): Value
  fun explain(verbosity: String)
}

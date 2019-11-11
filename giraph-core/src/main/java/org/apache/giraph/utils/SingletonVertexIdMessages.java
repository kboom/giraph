/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.giraph.utils;

import org.apache.giraph.conf.ImmutableClassesGiraphConfiguration;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SingletonVertexIdMessages<I extends WritableComparable, M extends Writable>
    implements VertexIdMessages<I, M>, VertexIdMessageIterator<I, M> {

  private I destination;
  private M message;

  private boolean isFirst = true;

  public SingletonVertexIdMessages<I, M> with(I destination, M message) {
    isFirst = true;
    this.destination = destination;
    this.message = message;
    return this;
  }

  @Override
  public VertexIdMessageBytesIterator<I, M> getVertexIdMessageBytesIterator() {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public VertexIdMessageIterator<I, M> getVertexIdMessageIterator() {
    return this;
  }

  @Override
  public M createData() {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void writeData(ExtendedDataOutput out, M data) throws IOException {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void readData(ExtendedDataInput in, M data) throws IOException {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void initialize() {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void initialize(int expectedSize) {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void add(I vertexId, M data) {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void add(byte[] serializedId, int idPos, M data) {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public int getSize() {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public int getSerializedSize() {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public boolean isEmpty() {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void clear() {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public VertexIdDataIterator<I, M> getVertexIdDataIterator() {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public ImmutableClassesGiraphConfiguration getConf() {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void setConf(ImmutableClassesGiraphConfiguration configuration) {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void write(DataOutput dataOutput) throws IOException {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public void readFields(DataInput dataInput) throws IOException {
    throw new IllegalStateException("Should never call this");
  }

  @Override
  public M getCurrentMessage() {
    return message;
  }

  @Override
  public int getCurrentMessageSize() {
    return 0;
  }

  @Override
  public boolean isNewMessage() {
    return false;
  }

  @Override
  public M getCurrentData() {
    return message;
  }

  @Override
  public int getCurrentDataSize() {
    return 0;
  }

  @Override
  public M releaseCurrentData() {
    return message;
  }

  @Override
  public boolean hasNext() {
    return isFirst;
  }

  @Override
  public void next() {
    isFirst = false;
  }

  @Override
  public I getCurrentVertexId() {
    return destination;
  }

  @Override
  public I releaseCurrentVertexId() {
    return destination;
  }
}

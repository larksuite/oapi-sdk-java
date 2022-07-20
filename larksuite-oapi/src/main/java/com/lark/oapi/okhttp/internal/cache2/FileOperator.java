/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.lark.oapi.okhttp.internal.cache2;

import com.lark.oapi.okio.Buffer;
import com.lark.oapi.okio.Okio;
import java.io.EOFException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Read and write a target file. Unlike Okio's built-in {@linkplain Okio#source(java.io.File) file
 * source} and {@linkplain Okio#sink(java.io.File) file sink} this class offers:
 *
 * <ul>
 *   <li><strong>Read/write:</strong> read and write using the same operator.
 *   <li><strong>Random access:</strong> access any position within the file.
 *   <li><strong>Shared channels:</strong> read and write a file channel that's shared between
 *       multiple operators. Note that although the underlying {@code FileChannel} may be shared,
 *       each {@code FileOperator} should not be.
 * </ul>
 */
final class FileOperator {

  private final FileChannel fileChannel;

  FileOperator(FileChannel fileChannel) {
    this.fileChannel = fileChannel;
  }

  /**
   * Write {@code byteCount} bytes from {@code source} to the file at {@code pos}.
   */
  public void write(long pos, Buffer source, long byteCount) throws IOException {
    if (byteCount < 0 || byteCount > source.size()) {
      throw new IndexOutOfBoundsException();
    }

    while (byteCount > 0L) {
      long bytesWritten = fileChannel.transferFrom(source, pos, byteCount);
      pos += bytesWritten;
      byteCount -= bytesWritten;
    }
  }

  /**
   * Copy {@code byteCount} bytes from the file at {@code pos} into to {@code source}. It is the
   * caller's responsibility to make sure there are sufficient bytes to read: if there aren't this
   * method throws an {@link EOFException}.
   */
  public void read(long pos, Buffer sink, long byteCount) throws IOException {
    if (byteCount < 0) {
      throw new IndexOutOfBoundsException();
    }

    while (byteCount > 0L) {
      long bytesRead = fileChannel.transferTo(pos, byteCount, sink);
      pos += bytesRead;
      byteCount -= bytesRead;
    }
  }
}

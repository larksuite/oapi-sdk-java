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
package com.lark.oapi.okhttp.internal.cache;

import com.lark.oapi.okhttp.Cache;
import com.lark.oapi.okhttp.Request;
import com.lark.oapi.okhttp.Response;
import java.io.IOException;
import javax.annotation.Nullable;

/**
 * OkHttp's internal cache interface. Applications shouldn't implement this: instead use {@link
 * Cache}.
 */
public interface InternalCache {

  @Nullable
  Response get(Request request) throws IOException;

  @Nullable
  CacheRequest put(Response response) throws IOException;

  /**
   * Remove any cache entries for the supplied {@code request}. This is invoked when the client
   * invalidates the cache, such as when making POST requests.
   */
  void remove(Request request) throws IOException;

  /**
   * Handles a conditional request hit by updating the stored cache response with the headers from
   * {@code network}. The cached response body is not updated. If the stored response has changed
   * since {@code cached} was returned, this does nothing.
   */
  void update(Response cached, Response network);

  /**
   * Track an conditional GET that was satisfied by this cache.
   */
  void trackConditionalCacheHit();

  /**
   * Track an HTTP response being satisfied with {@code cacheStrategy}.
   */
  void trackResponse(CacheStrategy cacheStrategy);
}

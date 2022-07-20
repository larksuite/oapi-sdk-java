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
package com.lark.oapi.okhttp.internal.connection;

import com.lark.oapi.okhttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A blacklist of failed routes to avoid when creating a new connection to a target address. This is
 * used so that OkHttp can learn from its mistakes: if there was a failure attempting to connect to
 * a specific IP address or proxy server, that failure is remembered and alternate routes are
 * preferred.
 */
final class RouteDatabase {

  private final Set<Route> failedRoutes = new LinkedHashSet<>();

  /**
   * Records a failure connecting to {@code failedRoute}.
   */
  public synchronized void failed(Route failedRoute) {
    failedRoutes.add(failedRoute);
  }

  /**
   * Records success connecting to {@code route}.
   */
  public synchronized void connected(Route route) {
    failedRoutes.remove(route);
  }

  /**
   * Returns true if {@code route} has failed recently and should be avoided.
   */
  public synchronized boolean shouldPostpone(Route route) {
    return failedRoutes.contains(route);
  }
}

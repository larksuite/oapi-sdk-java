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
package com.lark.oapi.okhttp.internal.http;

public final class HttpMethod {

  private HttpMethod() {
  }

  public static boolean invalidatesCache(String method) {
    return method.equals("POST")
        || method.equals("PATCH")
        || method.equals("PUT")
        || method.equals("DELETE")
        || method.equals("MOVE");     // WebDAV
  }

  public static boolean requiresRequestBody(String method) {
    return method.equals("POST")
        || method.equals("PUT")
        || method.equals("PATCH")
        || method.equals("PROPPATCH") // WebDAV
        || method.equals("REPORT");   // CalDAV/CardDAV (defined in WebDAV Versioning)
  }

  public static boolean permitsRequestBody(String method) {
    return !(method.equals("GET") || method.equals("HEAD"));
  }

  public static boolean redirectsWithBody(String method) {
    return method.equals("PROPFIND"); // (WebDAV) redirects should also maintain the request body
  }

  public static boolean redirectsToGet(String method) {
    // All requests but PROPFIND should redirect to a GET request.
    return !method.equals("PROPFIND");
  }
}

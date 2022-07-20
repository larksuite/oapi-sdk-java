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

package com.lark.oapi.okio;

import java.util.concurrent.TimeUnit;

/**
 * A timeout that can apply its own state to another timeout for the duration of a call. Use this
 * when forwarding one stream to another while retaining both timeouts.
 */
final class PushableTimeout extends Timeout {

  private Timeout pushed;
  private boolean originalHasDeadline;
  private long originalDeadlineNanoTime;
  private long originalTimeoutNanos;

  void push(Timeout pushed) {
    this.pushed = pushed;
    this.originalHasDeadline = pushed.hasDeadline();
    this.originalDeadlineNanoTime = originalHasDeadline ? pushed.deadlineNanoTime() : -1L;
    this.originalTimeoutNanos = pushed.timeoutNanos();

    pushed.timeout(minTimeout(originalTimeoutNanos, timeoutNanos()), TimeUnit.NANOSECONDS);

    if (originalHasDeadline && hasDeadline()) {
      pushed.deadlineNanoTime(Math.min(deadlineNanoTime(), originalDeadlineNanoTime));
    } else if (hasDeadline()) {
      pushed.deadlineNanoTime(deadlineNanoTime());
    }
  }

  void pop() {
    pushed.timeout(originalTimeoutNanos, TimeUnit.NANOSECONDS);

    if (originalHasDeadline) {
      pushed.deadlineNanoTime(originalDeadlineNanoTime);
    } else {
      pushed.clearDeadline();
    }
  }
}

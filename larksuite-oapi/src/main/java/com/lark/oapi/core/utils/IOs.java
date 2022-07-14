package com.lark.oapi.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOs {

  public static void copy(InputStream input, OutputStream output) throws IOException {
    byte[] bs = new byte[4096];
    while (true) {
      int c = input.read(bs);
      if (c == -1) {
        break;
      }
      output.write(bs, 0, c);
    }
  }

  public static byte[] readAll(InputStream input) throws IOException {
    try (ByteArrayOutputStream bos = new ByteArrayOutputStream();) {
      copy(input, bos);
      return bos.toByteArray();
    }
  }
}

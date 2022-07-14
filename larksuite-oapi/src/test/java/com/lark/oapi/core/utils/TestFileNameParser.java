package com.lark.oapi.core.utils;

import org.junit.Test;

public class TestFileNameParser {

  @Test
  public void testParser() {
    String fileName = FileNameParser.parseFileName(
        "Content-Disposition:attachment;filename=FileName.pdf");
    assert fileName.equals("FileName.pdf");

    fileName = FileNameParser.parseFileName(
        "Content-Disposition: attachment; filename*=UTF-8''java%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E4%B9%8B%E7%BE%8E.pdf");
    assert fileName.equals("java并发编程之美.pdf");
  }
}

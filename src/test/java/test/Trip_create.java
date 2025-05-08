package test;

import java.io.IOException;

import org.testng.annotations.Test;

public class Trip_create extends File_uploadtest {
  @Test
  public void trip() throws IOException, InterruptedException {
    File_uploadtest.testFileUploadProcess();
  }
}

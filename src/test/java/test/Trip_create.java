package test;

import java.io.IOException;

import org.testng.annotations.Test;

import web.File_upload;

public class Trip_create {
  @Test
  public void trip() throws IOException, InterruptedException {
	  System.out.println("Started");
	  File_upload.web();
  }
}

package pages;

import com.aventstack.extentreports.Status;

import wrappers.Helper;

public class HelloWorldPage extends Helper{

	public HelloWorldPage helloWorldPass()
	{
	//	log(Status.PASS, "Hello World PASS method in hello world page");
		return this;
	}
	
	public HelloWorldPage helloWorldFail()
	{
	//	log(Status.FAIL, "Hello World FAIL method in hello world page");
		return this;
	}
	
	public HelloWorldPage helloWorldInfo()
	{
	//	log(Status.INFO, "Hello World INFO method in hello world page");
		return this;
	}


}

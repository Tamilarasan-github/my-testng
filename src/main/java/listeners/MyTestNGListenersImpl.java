package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IHookCallBack;
import org.testng.IInvokedMethod;
import org.testng.IMethodInstance;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import utils.Reporter;

public class MyTestNGListenersImpl implements MyTestNGListeners
{
	private static Logger log=LogManager.getLogger(Reporter.class.getName());
	@Override
	public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstrutor,
			Method testMethod)
	{
//	if (testMethod.getName().equals("ChangeInvocationCountOfMethod")) {
//	log.info("TestNG Listener Changing invocation for the following method: " + testMethod.getName());
//	testAnnotation.setInvocationCount(2);
		log.info("TestNG Listener transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstrutor, Method testMethod)");
		if(!(testAnnotation==null))
		{
			log.info("TestNG Listener getTestName():"+testAnnotation.getTestName());
		}
		if(!(testClass==null))
		{
			log.info("TestNG Listener Class Name:"+testClass.getName());
		}
		if(!(testConstrutor==null))
		{
			log.info("TestNG Listener Constructor Name:"+testConstrutor.getName());
		}
		if(!(testMethod==null))
		{
			log.info("TestNG Listener Test Method Name:"+testMethod.getName());
		}
	}

	@Override
	public void onExecutionFinish()
	{
		long endTime = System.currentTimeMillis();
		log.info("TestNG Listener onExecutionFinish():"+endTime);
	}

	@Override
	public void onExecutionStart()
	{
		long startTime = System.currentTimeMillis();
		log.info("TestNG Listener onExecutionStart():"+startTime);
	}

	@Override
	public void run(IHookCallBack callBack, ITestResult testResult)
	{

//		Object[] parameterValues = callBack.getParameters();
//		if (parameterValues[0].equals("parameter 3"))
//		{
//			log.info("TestNG Listener Skip the required parameter");
//		} else
//		{
//			callBack.runTestMethod(testResult);
//		}
		log.info("TestNG Listener run(IHookCallBack callBack, ITestResult testResult)");
		callBack.runTestMethod(testResult);

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result)
	{
		log.info("TestNG Listener afterInvocation(IInvokedMethod method, ITestResult result): " + method.getTestMethod().getMethodName());
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult result)
	{
		log.info("TestNG Listener beforeInvocation(IInvokedMethod method, ITestResult result): " + method.getTestMethod().getMethodName());
	}

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methodsInstance, ITestContext testContext)
	{
		log.info("TestNG Listener intercept(List<IMethodInstance> methodsInstance, ITestContext testContext)");
		return methodsInstance;
//		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
//		for (IMethodInstance method : methodsInstance)
//		{
//			Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
//			if (testMethod.priority() == 1)
//			{
//				result.add(method);
//			}
//		}
//		return result;
	}

	@Override
	public void onFinish(ISuite suite1)
	{
		log.info("TestNG Listener onFinish(ISuite suite1)");
	}

	@Override
	public void onStart(ISuite suite2)
	{
		log.info("TestNG Listener onStart(ISuite suite2)");
	}

	@Override
	public void onFinish(ITestContext contextFinish)
	{
		log.info("TestNG Listener onFinish(ITestContext contextFinish): onFinish method finished");

	}

	@Override
	public void onStart(ITestContext contextStart)
	{
		log.info("TestNG Listener onStart(ITestContext contextStart): started");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		log.info("TestNG Listener onTestFailedButWithinSuccessPercentage(ITestResult result): Method failed with certain success percentage" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		log.info("TestNG Listener onTestFailure(ITestResult result): Method Failed-" + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		log.info("TestNG Listener onTestSkipped(ITestResult result): Method skipped-" + result.getName());

	}

	@Override
	public void onTestStart(ITestResult result)
	{
		log.info("TestNG Listener onTestStart(ITestResult result): Method started-" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		log.info("TestNG Listener onTestSuccess(ITestResult result): Method Passed-" + result.getName());
	}

}

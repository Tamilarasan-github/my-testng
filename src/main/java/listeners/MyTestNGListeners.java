package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.IExecutionListener;
import org.testng.IHookable;
import org.testng.IInvokedMethodListener;
import org.testng.IMethodInterceptor;
import org.testng.IReporter;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

public interface MyTestNGListeners extends IAnnotationTransformer, 
											IHookable, 
											IExecutionListener, 
											IInvokedMethodListener,
											IMethodInterceptor,
											IReporter,
											ISuiteListener,
											ITestListener

{

}

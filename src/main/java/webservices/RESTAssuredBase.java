package webservices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import com.aventstack.extentreports.Status;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import utils.Reporter;

public class RESTAssuredBase extends Reporter
{
	private static Logger logger=LogManager.getLogger(Reporter.class.getName());
	
	public RequestSpecification request(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			String requestBody, boolean logs)
	{
		RestAssured.baseURI = url;
		RequestSpecification requestSpecification = RestAssured.given();
		if (logs)
		{
			requestSpecification.log().all();
		}
		if (requestQueryParams.size() > 0)
		{
			requestSpecification.queryParams(requestQueryParams);
		}
		if (requestHeaders.size() > 0)
		{
			requestSpecification.headers(requestHeaders);
		}

		if (requestBody != null && !requestBody.isEmpty())
		{
			requestSpecification.body(requestBody);
		}

		return requestSpecification;
	}

	public RequestSpecification request(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			File requestBody, boolean logs)
	{
		RestAssured.baseURI = url;
		RequestSpecification requestSpecification = RestAssured.given();
		if (logs)
		{
			requestSpecification.log().all();
		}
		if (requestQueryParams.size() > 0)
		{
			requestSpecification.queryParams(requestQueryParams);
		}
		if (requestHeaders.size() > 0)
		{
			requestSpecification.headers(requestHeaders);
		}

		if (requestBody != null)
		{
			requestSpecification.body(requestBody);
		}

		return requestSpecification;
	}

	public RequestSpecification request(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			JsonObject requestBodyAsJsonObject, boolean logs)
	{
		RestAssured.baseURI = url;
		RequestSpecification requestSpecification = RestAssured.given();
		if (logs)
		{
			requestSpecification.log().all();
		}
		if (requestQueryParams.size() > 0)
		{
			requestSpecification.queryParams(requestQueryParams);
		}
		if (requestHeaders.size() > 0)
		{
			requestSpecification.headers(requestHeaders);
		}

		if (requestBodyAsJsonObject != null)
		{
			requestSpecification.body(requestBodyAsJsonObject);
		}

		return requestSpecification;
	}

	public RequestSpecification request(String url, Map<String, ?> requestHeaders, String requestBody, boolean logs)
	{
		return request(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, String requestBody, boolean logs)
	{
		return request(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, Map<String, ?> requestHeaders, File requestBody, boolean logs)
	{
		return request(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, Map<String, ?> requestHeaders, JsonObject requestBody, boolean logs)
	{
		return request(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, File requestBody, boolean logs)
	{
		return request(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, JsonObject requestBody, boolean logs)
	{
		return request(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, boolean logs)
	{
		return request(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
	}

	public RequestSpecification request(String url, Map<String, ?> requestHeaders, String requestBody)
	{
		boolean logs = true;
		return request(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, Map<String, ?> requestHeaders, File requestBody)
	{
		boolean logs = true;
		return request(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, Map<String, ?> requestHeaders, JsonObject requestBody)
	{
		boolean logs = true;
		return request(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, String requestBody)
	{
		boolean logs = true;
		return request(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, File requestBody)
	{
		boolean logs = true;
		return request(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url, JsonObject requestBody)
	{
		boolean logs = true;
		return request(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
	}

	public RequestSpecification request(String url)
	{
		boolean logs = true;
		return request(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
	}

	public Response get(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			String requestBody, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams, requestBody, logs);
		Response response = requestSpecification.when().get();
		return response;
	}

	public Response get(String url, Map<String, ?> requestHeaders, String requestBody, boolean logs)
	{
		Response response = get(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response get(String url, String requestBody, boolean logs)
	{

		Response response = get(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response get(String url, boolean logs)
	{
		Response response = get(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
		return response;
	}

	public Response get(String url, Map<String, ?> requestHeaders, String requestBody)
	{
		boolean logs = true;
		Response response = get(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response get(String url, String requestBody)
	{
		boolean logs = true;
		Response response = get(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response get(String url)
	{
		boolean logs = true;
		Response response = get(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
		return response;
	}

	public Response get(RequestSpecification requestSpecification)
	{
		Response response = requestSpecification.when().get();
		return response;
	}

	public Response get(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			File requestBodyAsFile, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams, requestBodyAsFile,
				logs);
		Response response = requestSpecification.when().get();
		return response;
	}

	public Response get(String url, Map<String, ?> requestHeaders, File requestBodyAsFile, boolean logs)
	{
		Response response = get(url, requestHeaders, new HashMap<String, String>(), requestBodyAsFile, logs);
		return response;
	}

	public Response get(String url, File requestBodyAsFile, boolean logs)
	{

		Response response = get(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBodyAsFile,
				logs);
		return response;
	}

	public Response get(String url, Map<String, ?> requestHeaders, File requestBodyAsFile)
	{
		boolean logs = true;
		Response response = get(url, requestHeaders, new HashMap<String, String>(), requestBodyAsFile, logs);
		return response;
	}

	public Response get(String url, File requestBodyAsFile)
	{
		boolean logs = true;
		Response response = get(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBodyAsFile,
				logs);
		return response;
	}

	public Response get(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			JsonObject requestBodyAsJsonObject, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams,
				requestBodyAsJsonObject, logs);
		Response response = requestSpecification.when().get();
		return response;
	}

	public Response get(String url, Map<String, ?> requestHeaders, JsonObject requestBodyAsJsonObject, boolean logs)
	{
		Response response = get(url, requestHeaders, new HashMap<String, String>(), requestBodyAsJsonObject, logs);
		return response;
	}

	public Response get(String url, JsonObject requestBodyAsJsonObject, boolean logs)
	{

		Response response = get(url, new HashMap<String, String>(), new HashMap<String, String>(),
				requestBodyAsJsonObject, logs);
		return response;
	}

	public Response get(String url, Map<String, ?> requestHeaders, JsonObject requestBodyAsJsonObject)
	{
		boolean logs = true;
		Response response = get(url, requestHeaders, new HashMap<String, String>(), requestBodyAsJsonObject, logs);
		return response;
	}

	public Response get(String url, JsonObject requestBodyAsJsonObject)
	{
		boolean logs = true;
		Response response = get(url, new HashMap<String, String>(), new HashMap<String, String>(),
				requestBodyAsJsonObject, logs);
		return response;
	}

	public Response post(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			String requestBody, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams, requestBody, logs);
		Response response = requestSpecification.when().post();
		return response;
	}

	public Response post(String url, Map<String, ?> requestHeaders, String requestBody, boolean logs)
	{
		Response response = post(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response post(String url, String requestBody, boolean logs)
	{

		Response response = post(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response post(String url, boolean logs)
	{
		Response response = post(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
		return response;
	}

	public Response post(String url, Map<String, ?> requestHeaders, String requestBody)
	{
		boolean logs = true;
		Response response = post(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response post(String url, String requestBody)
	{
		boolean logs = true;
		Response response = post(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response post(String url)
	{
		boolean logs = true;
		Response response = post(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
		return response;
	}

	public Response post(RequestSpecification requestSpecification)
	{
		Response response = requestSpecification.when().post();
		return response;
	}

	public Response post(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			File requestBodyAsFile, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams, requestBodyAsFile,
				logs);
		Response response = requestSpecification.when().post();
		return response;
	}

	public Response post(String url, Map<String, ?> requestHeaders, File requestBodyAsFile, boolean logs)
	{
		Response response = post(url, requestHeaders, new HashMap<String, String>(), requestBodyAsFile, logs);
		return response;
	}

	public Response post(String url, File requestBodyAsFile, boolean logs)
	{

		Response response = post(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBodyAsFile,
				logs);
		return response;
	}

	public Response post(String url, Map<String, ?> requestHeaders, File requestBodyAsFile)
	{
		boolean logs = true;
		Response response = post(url, requestHeaders, new HashMap<String, String>(), requestBodyAsFile, logs);
		return response;
	}

	public Response post(String url, File requestBodyAsFile)
	{
		boolean logs = true;
		Response response = post(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBodyAsFile,
				logs);
		return response;
	}

	public Response post(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			JsonObject requestBodyAsJsonObject, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams,
				requestBodyAsJsonObject, logs);
		Response response = requestSpecification.when().post();
		return response;
	}

	public Response post(String url, Map<String, ?> requestHeaders, JsonObject requestBodyAsJsonObject, boolean logs)
	{
		Response response = post(url, requestHeaders, new HashMap<String, String>(), requestBodyAsJsonObject, logs);
		return response;
	}

	public Response post(String url, JsonObject requestBodyAsJsonObject, boolean logs)
	{

		Response response = post(url, new HashMap<String, String>(), new HashMap<String, String>(),
				requestBodyAsJsonObject, logs);
		return response;
	}

	public Response post(String url, Map<String, ?> requestHeaders, JsonObject requestBodyAsJsonObject)
	{
		boolean logs = true;
		Response response = post(url, requestHeaders, new HashMap<String, String>(), requestBodyAsJsonObject, logs);
		return response;
	}

	public Response post(String url, JsonObject requestBodyAsJsonObject)
	{
		boolean logs = true;
		Response response = post(url, new HashMap<String, String>(), new HashMap<String, String>(),
				requestBodyAsJsonObject, logs);
		return response;
	}

	public Response put(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			String requestBody, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams, requestBody, logs);
		Response response = requestSpecification.when().put();
		return response;
	}

	public Response put(String url, Map<String, ?> requestHeaders, String requestBody, boolean logs)
	{
		Response response = put(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response put(String url, String requestBody, boolean logs)
	{

		Response response = put(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response put(String url, boolean logs)
	{
		Response response = put(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
		return response;
	}

	public Response put(String url, Map<String, ?> requestHeaders, String requestBody)
	{
		boolean logs = true;
		Response response = put(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response put(String url, String requestBody)
	{
		boolean logs = true;
		Response response = put(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response put(String url)
	{
		boolean logs = true;
		Response response = put(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
		return response;
	}

	public Response put(RequestSpecification requestSpecification)
	{
		Response response = requestSpecification.when().put();
		return response;
	}

	public Response put(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			File requestBodyAsFile, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams, requestBodyAsFile,
				logs);
		Response response = requestSpecification.when().put();
		return response;
	}

	public Response put(String url, Map<String, ?> requestHeaders, File requestBodyAsFile, boolean logs)
	{
		Response response = put(url, requestHeaders, new HashMap<String, String>(), requestBodyAsFile, logs);
		return response;
	}

	public Response put(String url, File requestBodyAsFile, boolean logs)
	{

		Response response = put(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBodyAsFile,
				logs);
		return response;
	}

	public Response put(String url, Map<String, ?> requestHeaders, File requestBodyAsFile)
	{
		boolean logs = true;
		Response response = put(url, requestHeaders, new HashMap<String, String>(), requestBodyAsFile, logs);
		return response;
	}

	public Response put(String url, File requestBodyAsFile)
	{
		boolean logs = true;
		Response response = put(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBodyAsFile,
				logs);
		return response;
	}

	public Response put(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			JsonObject requestBodyAsJsonObject, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams,
				requestBodyAsJsonObject, logs);
		Response response = requestSpecification.when().put();
		return response;
	}

	public Response put(String url, Map<String, ?> requestHeaders, JsonObject requestBodyAsJsonObject, boolean logs)
	{
		Response response = put(url, requestHeaders, new HashMap<String, String>(), requestBodyAsJsonObject, logs);
		return response;
	}

	public Response put(String url, JsonObject requestBodyAsJsonObject, boolean logs)
	{

		Response response = put(url, new HashMap<String, String>(), new HashMap<String, String>(),
				requestBodyAsJsonObject, logs);
		return response;
	}

	public Response put(String url, Map<String, ?> requestHeaders, JsonObject requestBodyAsJsonObject)
	{
		boolean logs = true;
		Response response = put(url, requestHeaders, new HashMap<String, String>(), requestBodyAsJsonObject, logs);
		return response;
	}

	public Response put(String url, JsonObject requestBodyAsJsonObject)
	{
		boolean logs = true;
		Response response = put(url, new HashMap<String, String>(), new HashMap<String, String>(),
				requestBodyAsJsonObject, logs);
		return response;
	}

	public Response delete(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			String requestBody, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams, requestBody, logs);
		Response response = requestSpecification.when().delete();
		return response;
	}

	public Response delete(String url, Map<String, ?> requestHeaders, String requestBody, boolean logs)
	{
		Response response = delete(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response delete(String url, String requestBody, boolean logs)
	{

		Response response = delete(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody,
				logs);
		return response;
	}

	public Response delete(String url, boolean logs)
	{
		Response response = delete(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
		return response;
	}

	public Response delete(String url, Map<String, ?> requestHeaders, String requestBody)
	{
		boolean logs = true;
		Response response = delete(url, requestHeaders, new HashMap<String, String>(), requestBody, logs);
		return response;
	}

	public Response delete(String url, String requestBody)
	{
		boolean logs = true;
		Response response = delete(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBody,
				logs);
		return response;
	}

	public Response delete(String url)
	{
		boolean logs = true;
		Response response = delete(url, new HashMap<String, String>(), new HashMap<String, String>(), "", logs);
		return response;
	}

	public Response delete(RequestSpecification requestSpecification)
	{
		Response response = requestSpecification.when().delete();
		return response;
	}

	public Response delete(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			File requestBodyAsFile, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams, requestBodyAsFile,
				logs);
		Response response = requestSpecification.when().delete();
		return response;
	}

	public Response delete(String url, Map<String, ?> requestHeaders, File requestBodyAsFile, boolean logs)
	{
		Response response = delete(url, requestHeaders, new HashMap<String, String>(), requestBodyAsFile, logs);
		return response;
	}

	public Response delete(String url, File requestBodyAsFile, boolean logs)
	{

		Response response = delete(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBodyAsFile,
				logs);
		return response;
	}

	public Response delete(String url, Map<String, ?> requestHeaders, File requestBodyAsFile)
	{
		boolean logs = true;
		Response response = delete(url, requestHeaders, new HashMap<String, String>(), requestBodyAsFile, logs);
		return response;
	}

	public Response delete(String url, File requestBodyAsFile)
	{
		boolean logs = true;
		Response response = delete(url, new HashMap<String, String>(), new HashMap<String, String>(), requestBodyAsFile,
				logs);
		return response;
	}

	public Response delete(String url, Map<String, ?> requestHeaders, Map<String, ?> requestQueryParams,
			JsonObject requestBodyAsJsonObject, boolean logs)
	{
		RequestSpecification requestSpecification = request(url, requestHeaders, requestQueryParams,
				requestBodyAsJsonObject, logs);
		Response response = requestSpecification.when().delete();
		return response;
	}

	public Response delete(String url, Map<String, ?> requestHeaders, JsonObject requestBodyAsJsonObject, boolean logs)
	{
		Response response = delete(url, requestHeaders, new HashMap<String, String>(), requestBodyAsJsonObject, logs);
		return response;
	}

	public Response delete(String url, JsonObject requestBodyAsJsonObject, boolean logs)
	{

		Response response = delete(url, new HashMap<String, String>(), new HashMap<String, String>(),
				requestBodyAsJsonObject, logs);
		return response;
	}

	public Response delete(String url, Map<String, ?> requestHeaders, JsonObject requestBodyAsJsonObject)
	{
		boolean logs = true;
		Response response = delete(url, requestHeaders, new HashMap<String, String>(), requestBodyAsJsonObject, logs);
		return response;
	}

	public Response delete(String url, JsonObject requestBodyAsJsonObject)
	{
		boolean logs = true;
		Response response = delete(url, new HashMap<String, String>(), new HashMap<String, String>(),
				requestBodyAsJsonObject, logs);
		return response;
	}

	public String extractResponseBodyAsString(Response response)
	{
		return response.then().extract().asPrettyString();
	}
	
	
	public ValidatableResponse fetchResponseLogs(Response response)
	{
		return response.then().log().all();
	}

	public void verifyResponseContentType(Response response, String type)
	{
		if (response.getContentType().toLowerCase().contains(type.toLowerCase()))
		{
			log(Status.PASS, "The Content type " + type + " matches the expected content type");
		} else
		{
			log(Status.FAIL, "The Content type " + type + " does not match the expected content type "
					+ response.getContentType());
		}
	}

	public void verifyResponseStatusCode(Response response, int statusCode)
	{
		if (response.statusCode() == statusCode)
		{
			log(Status.PASS, "The status code " + statusCode + " matches the expected code");
		} else
		{
			log(Status.FAIL,
					"The status code " + statusCode + " does not match the expected code" + response.statusCode());
		}
	}

	public void verifyResponseTime(Response response, long timeLimitInMillis)
	{
		if (response.time() <= timeLimitInMillis)
		{
			log(Status.PASS, "The time taken " + response.time() + " with in the expected time");
		} else
		{
			log(Status.FAIL,
					"The time taken " + response.time() + " is greater than expected SLA time " + timeLimitInMillis);
		}
	}

	public void verifyJsonResponseContentWithKey(Response response, String key, String expectedValue)
	{
		if (response.getContentType().contains("json"))
		{
			JsonPath jsonPath = response.jsonPath();
			String actValue = jsonPath.get(key);
			if (actValue.equalsIgnoreCase(expectedValue))
			{
				log(Status.PASS, "The JSON response has value " + expectedValue + " as expected. ");
			} else
			{
				log(Status.FAIL, "The JSON response :" + actValue + " does not have the value " + expectedValue
						+ " as expected.");
			}
		}
	}

	public void verifyJsonResponseContentsWithKey(Response response, String key, String expectedValue)
	{
		if (response.getContentType().contains("json"))
		{
			JsonPath jsonPath = response.jsonPath();
			List<String> actualValuesList = jsonPath.getList(key);
			boolean state = false;
			for (String value : actualValuesList)
			{
				if (value.equalsIgnoreCase(expectedValue))
				{
					state = true;
					log(Status.PASS, "The JSON response has value " + expectedValue + " as expected. ");
				}
			}

			if (!state)
			{
				log(Status.FAIL, "The JSON response :" + actualValuesList + " does not have the value " + expectedValue
						+ " as expected.");
			}
		}
	}

	public List<String> fetchJsonResponseContentsWithKey(Response response, String key)
	{
		if (response.getContentType().contains("json"))
		{
			JsonPath jsonPath = response.jsonPath();
			return jsonPath.getList(key);
		} else
		{
			return null;
		}
	}

	public String fetchJsonResponseContentWithKey(Response response, String key)
	{
		if (response.getContentType().contains("json"))
		{
			JsonPath jsonPath = response.jsonPath();
			return (String) jsonPath.get(key);
		} else
		{
			return null;
		}
	}

	@Override
	public String takeScreenshot()
	{
		// TODO Auto-generated method stub
		return null;
	}

}

package com.mulesoft.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;

public class MuleComponent {

	
	
	public Map<String, String> processMap(Map<String, String> input) {
		// processMap implementation
		System.out.println("processMap");
		Map<String, String> output = new HashMap<String, String>();
		output.put("processed by", "processMap");
		if (input != null && input.size() > 0) {
			output.put("message", input.entrySet().iterator().next().getValue());
		} else {
			output.put("message", "no entries in map");
		}
		return output;
	}

	public Map<String, String> processArray(List<String> input) {
		// processArray implementation
		System.out.println("processList");
		Map<String, String> output = new HashMap<String, String>();
		output.put("processed by", "processList");
		output.put("message", input.get(0));
		return output;
	}

	public Map<String, String> processString(String input) {
		// processString implementation
		System.out.println("processString");
		Map<String, String> output = new HashMap<String, String>();
		output.put("processed by", "processString");
		output.put("message", input);
		return output;
	}

	public Map<String, String> processAll(
			@Payload Object input, 
			@InboundHeaders("http.method") String method ) {
		// processString implementation
		System.out.println("processAll");
		Map<String, String> output = new HashMap<String, String>();
		output.put("processed by", "processAll");
		output.put("message", input.toString());
		output.put("http.method",  method);
		return output;
	}
}

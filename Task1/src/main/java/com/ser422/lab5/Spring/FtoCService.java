package com.ser422.lab5.Spring;

/**
 * @author Crunchify, LLC
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

import org.json.JSONException;
import org.json.JSONObject;
// import javax.ws.rs.GET;
// import javax.ws.rs.Path;
// import javax.ws.rs.PathParam;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.Response;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@RequestMapping("/ftocservice")
public class FtoCService {

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public String convertFtoC() throws JSONException {

		JSONObject jsonObject = new JSONObject();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32) * 5 / 9;
		jsonObject.put("F Value", fahrenheit);
		jsonObject.put("C Value", celsius);

		String result = jsonObject.toString();
		return result;
	}

	@RequestMapping(value = "/{f}", method = RequestMethod.GET, produces = "application/json")
	public String convertFtoCfromInput(@PathVariable("f") float f,
			@RequestParam(value = "precision", required = false, defaultValue = "ignore") String maxDecimal)
			throws JSONException {

		// Used for the decimal places specified by the user
		DecimalFormat df = new DecimalFormat();
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius = (f - 32) * 5 / 9;

		if (maxDecimal.equals("ignore")) {
			jsonObject.put("F Value", f);
			jsonObject.put("C Value", celsius);
		} else {
			df.setMaximumFractionDigits(Integer.parseInt(maxDecimal));
			Float decimalPlaces = Float.parseFloat(df.format(celsius));
			jsonObject.put("F Value", f);
			jsonObject.put("C Value", decimalPlaces);
		}

		String result = jsonObject.toString();
		return result;
	}
}
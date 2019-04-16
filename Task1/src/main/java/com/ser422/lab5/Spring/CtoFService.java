package com.ser422.lab5.Spring;

import java.text.DecimalFormat;

/**
 * @author Crunchify.com
 *  * Description: This program converts unit from Centigrade to Fahrenheit.
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
// import javax.ws.rs.GET;
// import javax.ws.rs.Path;
// import javax.ws.rs.PathParam;
// import javax.ws.rs.Produces;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@RequestMapping("/ctofservice")
public class CtoFService {

	@RequestMapping(method = RequestMethod.GET, produces = "application/xml")
	public String convertCtoF() {

		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius * 9) / 5) + 32;
		Double result = fahrenheit;

		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>"
				+ "</ctofservice>";
	}

	@RequestMapping(value = "/{c}", method = RequestMethod.GET, produces = "application/xml")
	public String convertCtoFfromInput(@PathVariable("c") Double c,
			@RequestParam(value = "precision", required = false, defaultValue = "ignore") String maxDecimal) {

		// Used for the decimal places specified by the user
		DecimalFormat df = new DecimalFormat();
		Double fahrenheit;
		Double celsius = c;
		Double result = null;
		fahrenheit = ((celsius * 9) / 5) + 32;

		if (maxDecimal.equals("ignore")) {
			result = fahrenheit;
		} else {
			df.setMaximumFractionDigits(Integer.parseInt(maxDecimal));
			Double decimalPlaces = Double.parseDouble(df.format(fahrenheit));
			result = decimalPlaces;
		}

		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>"
				+ "</ctofservice>";
	}
}
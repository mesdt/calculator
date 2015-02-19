package mesdt.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@Autowired
	private CalculatorService calculator;

	@RequestMapping(method = RequestMethod.GET, value = "/hi")
	public Object hi() {
		return "Hi there,";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/null")
	public Object nul() {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/", params = { "!x" })
	public Object index() {
		return calculator.getCache();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public EvalResponse eval(@RequestParam String x, @RequestParam(required = false) String save) {
		return calculator.eval(x, save != null);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/**")
	public Object set(@RequestParam String answer) {
		return "answer=" + answer;
	}

}

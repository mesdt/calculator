package mesdt.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	@RequestMapping(method = RequestMethod.GET, value = "/", params = { "!x" })
	public Object index() {
		return calculatorService.getCache();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public EvalResponse eval(@RequestParam String x, @RequestParam(required = false) String save) {
		return calculatorService.eval(x, save != null);
	}

}
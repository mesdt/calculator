package mesdt.calculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	private final Map<String, Object> cache = Collections.synchronizedMap(new HashMap<>());

	private final ExpressionParser expressionParser = new SpelExpressionParser();

	public Object getCache() {
		return Collections.unmodifiableMap(cache);
	}

	public EvalResponse eval(String x, boolean save) {
		if (cache.containsKey(x)) {
			return new EvalResponse(cache.get(x), true);
		} else {
			Object answer = expressionParser.parseExpression(x).getValue();
			if (save) {
				cache.put(x, answer);
			}
			return new EvalResponse(answer, false);
		}
	}

}

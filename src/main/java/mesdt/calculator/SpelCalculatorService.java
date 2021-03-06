package mesdt.calculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class SpelCalculatorService implements CalculatorService {

	private final Map<String, Object> cache = new HashMap<>();

	private final Map<String, Object> immutableCacheView = Collections.unmodifiableMap(cache);

	private final ExpressionParser expressionParser = new SpelExpressionParser();

	@Override
	public Object getCache() {
		return immutableCacheView;
	}

	@Override
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

	@Override
	public void set(String x, Object answer) {
		cache.put(x, answer);
	}

	@Override
	public void clearCache() {
		cache.clear();
	}

}

package mesdt.calculator;

public interface CalculatorService {

	Object getCache();

	EvalResponse eval(String x, boolean save);

	void set(String x, Object answer);

	void clearCache();

}

package mesdt.calculator;

public interface Svc {

	Object getCache();

	EvalResponse eval(String x, boolean save);

	void set(String x, Object answer);

}
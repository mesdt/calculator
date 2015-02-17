package mesdt.calculator;

public class EvalResponse {

	public final Object answer;

	public final boolean fromCache;

	public EvalResponse(Object answer, boolean fromCache) {
		this.answer = answer;
		this.fromCache = fromCache;
	}

}

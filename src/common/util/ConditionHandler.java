package common.util;

public interface ConditionHandler<T> {
	void conditionHandling(T condition) throws Exception;
}

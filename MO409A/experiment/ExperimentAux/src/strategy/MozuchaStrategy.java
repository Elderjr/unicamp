package strategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import operators.OperatorMetric;
import project.Project;

public class MozuchaStrategy {

	private static final MozuchaStrategy instance = new MozuchaStrategy();
	

	private MozuchaStrategy() {
		
	}

	
	public static MozuchaStrategy getInstance() {
		return instance;
	}
	
	private Map<String,Integer> getOperatorCount(List<Project> projects) {
		Map<String, Integer> operatorCount = new HashMap<>();
		for (Project p : projects) {
			for (OperatorMetric op : p.getMetrics()) {
				if (op.getCoverage() >= p.getCoverage() * 0.91) {
					if (!operatorCount.containsKey(op.getOperator())) {
						operatorCount.put(op.getOperator(), 0);
					}
					int count = operatorCount.get(op.getOperator());
					operatorCount.put(op.getOperator(), count + 1);
				}
			}
		}
		return operatorCount;
	}
	
	public Set<String> getSelectedOperators(List<Project> projects, int threshold) {
		Set<String> operators = new HashSet<>();
		Map<String, Integer> operatorCount = getOperatorCount(projects);
		System.out.println("=== MOZUCHA STRATEGY OPERATORS === ");
		int total = 0;
		for (Entry<String, Integer> entry : operatorCount.entrySet()) {
			if (entry.getValue() >= threshold) {
				System.out.printf("Operator %s NOT SELECTED count: %d >= %d \n", entry.getKey(), entry.getValue(),
						threshold);
				total += 1;
			} else {
				operators.add(entry.getKey());
				System.out.printf("Operator %s SELECTED count: %d < %d \n", entry.getKey(), entry.getValue(),
						threshold);
			}

		}
		System.out.println("Total removed: "+total);
		return operators;
	}

}

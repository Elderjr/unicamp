package project;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import operators.OperatorMetric;

public class Project {

	private final String name;
	private List<OperatorMetric> operatorMetrics;

	public Project(String name) {
		this.name = name;
		this.operatorMetrics = new LinkedList<>();
	}

	public String getName() {
		return this.name;
	}

	public List<OperatorMetric> getMetrics() {
		return this.operatorMetrics;
	}

	public void addOperatorMetric(String operator, int mutantsKilled, int mutantsGenerated) {
		this.operatorMetrics.add(new OperatorMetric(operator, mutantsKilled, mutantsGenerated));
	}

	public int getMutantsGenerated() {
		return this.getMutantsGenerated(null);
	}
	
	public int getMutantsGenerated(Set<String> operators) {
		int mutantsGenerated = 0;
		for (OperatorMetric m : this.operatorMetrics) {
			if (operators == null || operators.contains(m.getOperator())) {
				mutantsGenerated += m.getMutantsGenerated();
			}

		}
		return mutantsGenerated;
	}

	public int getMutantsKilled() {
		return this.getMutantsKilled(null);
	}
	
	public int getMutantsKilled(Set<String> operators) {
		int mutantsKilled = 0;
		for (OperatorMetric m : this.operatorMetrics) {
			if (operators == null || operators.contains(m.getOperator())) {
				mutantsKilled += m.getMutantsKilled();
			}
		}
		return mutantsKilled;

	}

	public double getCoverage() {
		return this.getCoverage(null);
	}
	
	public double getCoverage(Set<String> notToInclude) {
		return ((double) this.getMutantsKilled(notToInclude)) / ((double) this.getMutantsGenerated(notToInclude));
	}

}

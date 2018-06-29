package operators;


public class OperatorMetric {
	
	private String operator;
	private int mutantsKilled;
	private int mutantsGenerated;
	
	public OperatorMetric(String operator, int mutantsKilled, int mutantsGenerated){
		this.operator = operator;
		this.mutantsKilled = mutantsKilled;
		this.mutantsGenerated = mutantsGenerated;
	}
	
	public String getOperator() {
		return this.operator;
	}
	
	public int getMutantsKilled() {
		return this.mutantsKilled;
	}
	
	public int getMutantsGenerated() {
		return this.mutantsGenerated;
	}
	
	public double getCoverage() {
		return ((double) this.mutantsKilled) / ((double) this.mutantsGenerated);
	}
}

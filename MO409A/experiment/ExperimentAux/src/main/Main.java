package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import inputReader.BadFormatException;
import inputReader.InputReader;

import java.util.Set;

import operators.OperatorMetric;
import project.Project;
import strategy.MozuchaStrategy;

public class Main {

	public static void printGeneralResults(List<Project> projects) {
		Map<String, Integer> mutantsKilledPerOperator = new HashMap<>();
		Map<String, Integer> mutantsGeneratedPerOperator = new HashMap<>();
		for (Project p : projects) {
			for (OperatorMetric m : p.getMetrics()) {
				if (!mutantsKilledPerOperator.containsKey(m.getOperator())) {
					mutantsKilledPerOperator.put(m.getOperator(), 0);
					mutantsGeneratedPerOperator.put(m.getOperator(), 0);
				}
				int mutantsKilled = mutantsKilledPerOperator.get(m.getOperator()) + m.getMutantsKilled();
				int mutantsGenerated = mutantsGeneratedPerOperator.get(m.getOperator())
						+ m.getMutantsGenerated();
				mutantsKilledPerOperator.put(m.getOperator().toString(), mutantsKilled);
				mutantsGeneratedPerOperator.put(m.getOperator().toString(), mutantsGenerated);
			}
		}
		System.out.println("=== General Results ===");
		System.out.println("Projects:");
		for(Project p : projects) {
			int mutantsKilled = p.getMutantsKilled();
			int mutantsGenerated = p.getMutantsGenerated();
			double coverage = ((double) mutantsKilled) / ((double) mutantsGenerated);
			System.out.printf("%s (%d/%d = %.2f) \n", p.getName(), mutantsKilled, mutantsGenerated, coverage);
		}
		System.out.println();
		System.out.println("Operators:");
		for (Entry<String, Integer> entry : mutantsKilledPerOperator.entrySet()) {
			String operatorName = entry.getKey();
			int mutantsKilled = entry.getValue();
			int mutantsGenerated = mutantsGeneratedPerOperator.get(operatorName);
			double coverage = ((double) mutantsKilled) / ((double) mutantsGenerated);
			System.out.printf("%s (%d/%d = %.2f) \n", operatorName, mutantsKilled, mutantsGenerated, coverage);
		}
	}
	
	public static void printResultsWithSelectiveOperators(List<Project> projects, Set<String> operators) {
		System.out.println("=== RESULTS WITH STRATEGY ===");
		for (Project p : projects) {
			int mutantsKilled = p.getMutantsKilled(operators);
			int mutantsGenerated = p.getMutantsGenerated(operators);
			double coverage = ((double) mutantsKilled) / ((double) mutantsGenerated);
			System.out.printf("%s (%d/%d = %f) \n", p.getName(), mutantsKilled, mutantsGenerated, coverage);

		}
	}

	public static void main(String[] args) {
		if(args.length == 2) {
			String filePath = args[0];
			try {
				int threshold = Integer.parseInt(args[1]);
				List<Project> projects = InputReader.getInstance().readFile(filePath);
				printGeneralResults(projects);
				Set<String> operators = MozuchaStrategy.getInstance().getSelectedOperators(projects, threshold);
				printResultsWithSelectiveOperators(projects, operators);
			} catch(NumberFormatException e) {
				System.out.println("O Threshold (segundo parâmetro) deve ser um número inteiro");
			} catch (BadFormatException | IOException e) {
				System.out.println("Houve um erro na leitura do arquivo, causa: "+e.getMessage());
			}	
		}else {
			System.out.println("Ajuda: <Arquivo de resultados gerais do teste de mutação> <Threshold>");
		}
	}
}

package inputReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import project.Project;

public class InputReader {

	private static final InputReader instance = new InputReader();
	

	private InputReader() {
		
	}

	
	public static InputReader getInstance() {
		return instance;
	}
	
	public List<Project> readFile(String path) throws FileNotFoundException, BadFormatException, IOException {
		
		List<Project> projects = new LinkedList<>();
		File file = new File(path);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int lineCount = 1;
		Project currentProject = null;
		do {
			if (!(line.charAt(0) == '#' || line.charAt(0) == '@' || line.charAt(0) == '-')) {
				br.close();
				fr.close();
				throw new BadFormatException("Linha " + lineCount
						+ " mal formatada: toda linha deve começar com #, @ ou -. Encontrado: " + line.charAt(0));
			} else if (line.charAt(0) == '-' && currentProject == null) {
				br.close();
				fr.close();
				throw new BadFormatException(
						"Nenhum projeto foi inicializado para adicionar um resultado de um operador (linha " + lineCount
								+ ")");
			} else if (line.charAt(0) == '@') {
				if (currentProject != null) {
					projects.add(currentProject);
				}
				currentProject = new Project(line.substring(1, line.length()));
			} else if (line.charAt(0) == '-') {
				String values[] = line.substring(1, line.length()).split(" ");
				if (values.length == 3) {
					String operator = values[0];
					int mutantsKilled ;
					int mutantsGenerated;
					try {
						mutantsKilled = Integer.parseInt(values[1]);
					}catch(NumberFormatException ex) {
						br.close();
						fr.close();
						throw new BadFormatException("Linha " + lineCount
								+ " mal formatada: "+values[1]+" não é um número inteiro");
					}
					try {
						mutantsGenerated = Integer.parseInt(values[2]);
					}catch(NumberFormatException ex) {
						br.close();
						fr.close();
						throw new BadFormatException("Linha " + lineCount
								+ " mal formatada: "+values[2]+" não é um número inteiro");
					}
					if(mutantsKilled > mutantsGenerated) {
						br.close();
						fr.close();
						throw new BadFormatException("Linha " + lineCount
								+ " mal formatada: o número de mutantes mortos não pode ser maior que o "
								+ " número de mutantes gerados (encontrado: "+mutantsKilled+" > "+mutantsGenerated+")");
					}
					currentProject.addOperatorMetric(operator, mutantsKilled, mutantsGenerated);
				}else {
					br.close();
					fr.close();
					throw new BadFormatException("Linha " + lineCount
							+ " mal formatada: todo resultado de operador deve ser feito no formato "
							+ "<operador><espaço><mutantes mortos><mutantes gerados>"
							+ "(Encontrado: "+line+")");
				}
			}
			line = br.readLine();
		} while (br.ready());
		br.close();
		fr.close();
		if (currentProject != null) {
			projects.add(currentProject);
		}
		return projects;
	}
}

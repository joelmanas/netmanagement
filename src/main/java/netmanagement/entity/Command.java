package netmanagement.entity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Logger;

public class Command {
	private static Logger LOG = Logger.getLogger(Command.class.getName());
	
	private String[] command;

	public Command(String[] command) {
		super();
		this.command = command;
	}
	
	public String executeCommand() {
		LOG.info("Ejecutando comando:\t"+Arrays.asList(this.command));
		
		String s, response = "";
		try {
			ProcessBuilder builder = new ProcessBuilder(this.command);
			builder.redirectErrorStream(true);
			
			Process process = builder.start();
			InputStream stdout = process.getInputStream();
	
			BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
			
			while ((s = reader.readLine()) != null)
            	response += s+"\n";
            
            process.waitFor();
            process.destroy();
		} catch(Exception e) {
			LOG.warning("ERROR:\t" + e.getMessage() + "\t" + e.getCause());
		}
        LOG.info("Comando ejecutado correctamente:\n-----\n"+response+"\n-----");
        return response;
	}
}

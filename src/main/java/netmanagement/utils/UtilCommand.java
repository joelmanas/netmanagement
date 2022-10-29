package netmanagement.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Logger;

public class UtilCommand {
	private static Logger LOG = Logger.getLogger(UtilCommand.class.getName());
	
	private String[] command;

	public UtilCommand(String[] command) {
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
				response += "\n"+s;
			
            process.waitFor();
            process.destroy();
		} catch(Exception e) {
			LOG.warning("ERROR:\t" + e.getMessage() + "\t" + e.getCause());
		}
        LOG.info("Comando ejecutado correctamente:\n-----"+response+"\n-----");
        return response;
	}
}

package netmanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import netmanagement.database.vo.Device;
import netmanagement.utils.UtilCommand;
import netmanagement.utils.UtilDevice;

/**
 * Para ejecutar este programa debes tener instalada la utilidad Nmap en tu máquina Linux
 * @author Joel Manas
 * @version 0.1
 *
 */
public class Main {
	protected static Properties properties = new Properties();

	private static Logger LOG = Logger.getLogger(Main.class.getName());
	
	private static String network;

	public static void main(String[] args) {
		LOG.info("Iniciando ejecución");

		try {
			properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));

			if(getNetwork()) {
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						inventoryDevices();
					}
				};

				if(properties.getProperty("SCHEDULED").equalsIgnoreCase("true")) {
					int interval = Integer.parseInt(properties.getProperty("SCHEDULED_INTERVAL"));
					LOG.info("Ejecucion por intervalos ("+interval+"min)");
					
					ScheduledExecutorService execService = Executors.newScheduledThreadPool(1);
					execService.scheduleAtFixedRate(runnable, 0, interval, TimeUnit.MINUTES);					
				} else runnable.run();
			}
		} catch (IOException e) {
			LOG.warning("Ha ocurrido un error cargando el fichero de propiedades:\t"+e.getMessage()+"\t"+e.getCause());
		}
		
		LOG.info("Fin de la ejecución");
	}
	
	private static boolean getNetwork() {
		LOG.info("Obteniendo red del servidor...");
		UtilCommand command = new UtilCommand(new String[] {"/bin/bash", "-c", "ip addr"});
		String response = command.executeCommand();
        Pattern pattern = Pattern.compile("enp\\d+s\\d+\\:(?s).*inet\\s(\\d+\\.\\d+\\.\\d+\\.\\d+\\/\\d+)");
        Matcher matcher = pattern.matcher(response);
        
        if(matcher.find())
        	network = matcher.group(1).replaceAll("(\\d+)\\/", "0/");
        else {
        	LOG.info("No se ha podido extraer la red del servidor");
        	return false;
        }
        
        LOG.info("Red obtenida correctamente:\t"+network);
        return true;
	}

	private static void inventoryDevices() {
		LOG.info("Descubriendo nuevos dispositivos en la red...");
		try {
			UtilDevice utilDevice = new UtilDevice();
			String rootPwd = properties.getProperty("ROOT_PWD");
			
			if(rootPwd != null && !rootPwd.isEmpty()) {
				UtilCommand command = new UtilCommand(new String[] {"/bin/sh", "-c", "echo "+rootPwd+"| sudo -S nmap -sn "+network});
				String response = command.executeCommand();
				LOG.info("Tratando respuesta...");
				
				Pattern rootPwdPattern = Pattern.compile("(incorrect password)");
				Matcher rootPwdMatcher = rootPwdPattern.matcher(response);
				if(!rootPwdMatcher.find()) {
					String[] lines = response.split("\\r?\\n");
					
					ArrayList<Device> devices = new ArrayList<>();
					String macAddress = null, ipAddress = null, label = null;
					
					for(String line : lines) {
						Pattern ipPattern = Pattern.compile("((\\d+\\.){3}\\d+)");
						Matcher ipMatcher = ipPattern.matcher(line);
						
						Pattern macPattern = Pattern.compile("((([A-Z]|[0-9]){2}\\:){5}([A-Z]|[0-9]){2})");
						Matcher macMatcher = macPattern.matcher(line);
						
						Pattern labelPattern = Pattern.compile("MAC[A-Za-z0-9\\s\\:]+\\(((?s).*)\\)$");
						Matcher labelMatcher = labelPattern.matcher(line);
						
						if(macMatcher.find())
							macAddress = macMatcher.group(1);
						if(ipMatcher.find())
							ipAddress = ipMatcher.group(1);
						if(labelMatcher.find())
							label = labelMatcher.group(1);
						if(label != null && ipAddress != null && macAddress != null) {
							Device device = new Device();
							device.setIpaddress(ipAddress);
							device.setPhysicaladdress(macAddress);
							device.setLabel(label);
							
							devices.add(device);
							
							macAddress = null;
							ipAddress = null;
							label = null;
						}
					}
					utilDevice.inventoryAll(devices);
				} else LOG.warning("La contraseña de administrador especificada no es válida");
			} else LOG.warning("Se debe especificar una contraseña de administrador en src/main/resources/application.properties (ROOT_PWD)");
		} catch (IOException e) {
			LOG.warning("Ha ocurrido un error leyendo el archivo de configuracion 'mybatis-config.xml':\t"+e.getMessage()+"\t"+e.getCause());
			LOG.warning("No se puede continuar sin conexión con la base de datos");
		} catch (Exception e) {
			LOG.warning("Ha ocurrido un error:\t"+e.getMessage()+"\t"+e.getCause());
		}
	}
}

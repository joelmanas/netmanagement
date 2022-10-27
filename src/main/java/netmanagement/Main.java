package netmanagement;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import netmanagement.entity.Command;
import netmanagement.entity.Device;

public class Main {
	private static Logger LOG = Logger.getLogger(Main.class.getName());
	private static String network;

	public static void main(String[] args) {
		LOG.info("Iniciando ejecución");
		if(getNetwork()) {
			//ScheduledExecutorService execService = Executors.newScheduledThreadPool(1);

			//execService.scheduleAtFixedRate(new Runnable() {
				//public void run() {
				    inventoryDevices();
				//}
			//}, 0, 5, TimeUnit.MINUTES);
		}
		LOG.info("Fin de la ejecución");
	}
	
	private static boolean getNetwork() {
		LOG.info("Obteniendo red del servidor...");
		Command command = new Command(new String[] {"/bin/bash", "-c", "ip addr"});
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
		Command command = new Command(new String[] {"/bin/sh", "-c", "echo 1234| sudo -S nmap -sn "+network});
		String response = command.executeCommand();
		LOG.info("Tratando respuesta...");
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
				Device device = new Device(macAddress, ipAddress, label);
				devices.add(device);
				macAddress = null;
				ipAddress = null;
				label = null;
			}
		}
		
		Device.inventoryAll(devices);
	}
}

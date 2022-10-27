package netmanagement.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Logger;

import netmanagement.database.Driver;

public class Device {
	private static Logger LOG = Logger.getLogger(Device.class.getName());
	
	private int id;
	private String physicalAddress;
	private String ipAddress;
	private String label;
	private boolean trust;
	private boolean remove;
	private Timestamp updatedAt;
	
	/**
	 * 
	 * @param physicalAddress Direccion MAC
	 * @param ipAddress Direccion IP
	 * @param label Nombre
	 */
	public Device(String physicalAddress, String ipAddress, String label) {
		super();
		this.physicalAddress = physicalAddress;
		this.ipAddress = ipAddress;
		this.label = label;
	}
	
	private Device() {
		super();
	}
	
	/**
	 * Searches for a device with a specific <b>id</b> 
	 * @param id
	 * @return Device if exists, otherwise null
	 */
	public static Device getDevice(int id) {
		Device device = null;
		String query = "SELECT * FROM devices WHERE id = '"+id+"'";
		try {
			Driver driver = new Driver();
			ResultSet result = driver.select(query);
			
			while(result.next()) {
				device = new Device();
				device.id = result.getInt(1);
				device.physicalAddress = result.getString(2);
				device.ipAddress = result.getString(3);
				device.label = result.getString(4);
				device.trust = result.getBoolean(5);
				device.remove = result.getBoolean(6);
				device.updatedAt = result.getTimestamp(7);
			}
			
			driver.close();
		} catch (SQLException e) {
			LOG.warning("Ha ocurrido un error:\t"+e.getMessage()+"\t"+e.getCause());
		}
		return device;
	}
	
	/**
	 * Searches for a device with a specific <b>physicalAddress</b> 
	 * @param physicalAddress
	 * @return Device if exists, otherwise null
	 */
	public static Device getDevice(String physicalAddress) {
		Device device = null;
		String query = "SELECT * FROM devices WHERE physicalAddress = '"+physicalAddress+"'";
		try {
			Driver driver = new Driver();
			ResultSet result = driver.select(query);
			
			while(result.next()) {
				device = new Device();
				device.id = result.getInt(1);
				device.physicalAddress = result.getString(2);
				device.ipAddress = result.getString(3);
				device.label = result.getString(4);
				device.trust = result.getBoolean(5);
				device.remove = result.getBoolean(6);
				device.updatedAt = result.getTimestamp(7);
			}
			
			driver.close();
		} catch (SQLException e) {
			LOG.warning("Ha ocurrido un error:\t"+e.getMessage()+"\t"+e.getCause());
		}
		return device;
	}
	
	public static void inventoryAll(ArrayList<Device> devices) {
		for(Device device : devices) {
			device.inventory();
		}
	}
	
	public void inventory() {
		try {
			Driver driver = new Driver();
			ResultSet result = driver.select("SELECT * FROM devices WHERE physicalAddress = '"+this.getPhysicalAddress()+"'");
			
			boolean inventoried = false;
			this.updatedAt = new Timestamp(System.currentTimeMillis());
			
			while(result.next()) {
				inventoried = true;
				if(result.getBoolean(6))
					this.remove();
				else if(!this.ipAddress.equals(result.getString(3))) {
					this.label = result.getString(4);
					this.trust = result.getBoolean(5);
					this.remove = result.getBoolean(6);
					this.update();
				}
			} if(!inventoried)
				this.insert();
			
			driver.close();
		} catch (SQLException e) {
			LOG.warning("Ha ocurrido un error:\t"+e.getMessage()+"\t"+e.getCause());
		}
		
	}
	
	private void update() {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE devices SET ")
						.append("ipAddress = '"+this.ipAddress+"',")
						.append("label = '"+this.label+"',")
						.append("trust = "+this.trust+",")
						.append("remove = "+this.remove+",")
						.append("updatedAt = '"+this.updatedAt+"'")
				.append(" WHERE physicalAddress = '"+this.getPhysicalAddress()+"'");
		try {
			Driver driver = new Driver();
			int rows = driver.manipulate(query.toString());
			
			LOG.info("Actualizando "+rows+" registros");
			
			driver.close();
		} catch (SQLException e) {
			LOG.warning("Ha ocurrido un error:\t"+e.getMessage()+"\t"+e.getCause());
		}
	}
	
	private void insert() {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO devices ")
				.append("(physicalAddress, ipAddress, label, trust, remove, updatedAt) ")
				.append("VALUES ('"+this.physicalAddress+"','"+this.ipAddress+"','"+this.label+"',false,false,'"+this.updatedAt+"')");
		try {
			Driver driver = new Driver();
			int rows = driver.manipulate(query.toString());
			
			LOG.info("Insertando "+rows+" nuevos registros");
			
			driver.close();
		} catch (SQLException e) {
			LOG.warning("Ha ocurrido un error:\t"+e.getMessage()+"\t"+e.getCause());
		}
	}
	
	private void remove() {
		
	}
	
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public boolean isTrust() {
		return trust;
	}

	public void setTrust(boolean trust) {
		this.trust = trust;
	}

	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Timestamp currentTimestamp) {
		this.updatedAt = currentTimestamp;
	}
	
	public int getId() {
		return id;
	}
}

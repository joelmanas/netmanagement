package netmanagement.utils;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import netmanagement.database.DbSession;
import netmanagement.database.dao.DeviceMapper;
import netmanagement.database.vo.Device;
import netmanagement.database.vo.DeviceExample;

public class UtilDevice {
	private Logger LOG = Logger.getLogger(UtilDevice.class.getName());
	
	private SqlSession dbSession;
	/**
	 * 
	 * @param physicalAddress Direccion MAC
	 * @param ipAddress Direccion IP
	 * @param label Nombre
	 * @throws IOException 
	 */
	public UtilDevice() throws IOException, Exception {
		super();
		this.dbSession = new DbSession().getDbSession();
	}
	
	/**
	 * Searches for a device with a specific <b>id</b> 
	 * @param id
	 * @return UtilDevice if exists, otherwise null
	 * @throws IOException
	 */
	public List<Device> getDevice(int id) {
		LOG.info("Consultando dispositivo con id "+id+" en la base de datos");
		DeviceMapper mapperDeviceMapper = dbSession.getMapper(DeviceMapper.class);
		
		DeviceExample consulta = new DeviceExample();
		consulta.createCriteria().andIdEqualTo(id);
		
		List<Device> Device = mapperDeviceMapper.selectByExample(consulta);

		LOG.info("Fin de consulta del dispositivo con id "+id+" en la base de datos");
		dbSession.close();
			
		return Device;
	}
	
	/**
	 * Searches for a device with a specific <b>physicalAddress</b> 
	 * @param physicalAddress
	 * @return UtilDevice if exists, otherwise null
	 * @throws IOException
	 */
	public List<Device> getDevice(String physicalAddress) {
		LOG.info("Consultando dispositivo con direccion MAC "+physicalAddress+" en la base de datos");
		DeviceMapper mapperDeviceMapper = dbSession.getMapper(DeviceMapper.class);
		
		DeviceExample consulta = new DeviceExample();
		consulta.createCriteria().andPhysicaladdressEqualTo(physicalAddress);
		
		List<Device> Device = mapperDeviceMapper.selectByExample(consulta);

		LOG.info("Fin de consulta del dispositivo con direccion MAC "+physicalAddress+" en la base de datos");
		dbSession.close();
		
		return Device;
	}
	
	public void inventoryAll(ArrayList<Device> devices) {
		LOG.info("Se han descubierto "+devices.size()+" dispositivos");
		for(Device device : devices) {
			LOG.info(device.toString());
			inventory(device);
		}
		this.dbSession.close();
	}
	
	private void inventory(Device device) {
		List<Device> devices = getDevice(device.getPhysicaladdress());
		
		if(devices.size() > 0) {
			LOG.info("El equipo ya existe en base de datos ("+devices.get(0).getLabel()+")");
			if(devices.get(0).getRemove()) {
				LOG.info("El dispositivo se ha marcado como no deseado");
				remove(device);
			} else if(!device.getIpaddress().equals(devices.get(0).getIpaddress())) {
				LOG.info("La direccion IP ha cambiado");
				update(device);
			}
		} else {
			LOG.info("El equipo no existe en base de datos");
			insert(device);
		}
	}
	
	private void update(Device device) {
		LOG.info("Actualizando dispositivo en la base de datos...");
		
		DeviceMapper mapperDeviceMapper = dbSession.getMapper(DeviceMapper.class);
		
		device.setUpdatedat(new Timestamp(System.currentTimeMillis()));
		mapperDeviceMapper.updateByPrimaryKey(device);
		
		LOG.info("Se ha actualizado el dispositivo con direccion MAC "+device.getPhysicaladdress()+" en la base de datos");
		dbSession.close();
	}
	
	private void insert(Device device) {
		LOG.info("Insertando dispositivo en la base de datos...");
		
		DeviceMapper mapperDeviceMapper = dbSession.getMapper(DeviceMapper.class);
		
		device.setTrust(false);
		device.setRemove(false);
		device.setUpdatedat(new Timestamp(System.currentTimeMillis()));
		mapperDeviceMapper.insert(device);
		
		LOG.info("Se ha actualizado el dispositivo con direccion MAC "+device.getPhysicaladdress()+" en la base de datos");
		dbSession.close();
	}
	
	private void remove(Device device) {
		
	}
}

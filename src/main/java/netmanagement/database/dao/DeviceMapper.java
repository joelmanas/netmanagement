package netmanagement.database.dao;

import java.util.List;
import netmanagement.database.vo.Device;
import netmanagement.database.vo.DeviceExample;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("physicaladdress") String physicaladdress);

    int insert(Device row);

    int insertSelective(Device row);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(@Param("id") Integer id, @Param("physicaladdress") String physicaladdress);

    int updateByExampleSelective(@Param("row") Device row, @Param("example") DeviceExample example);

    int updateByExample(@Param("row") Device row, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device row);

    int updateByPrimaryKey(Device row);
}
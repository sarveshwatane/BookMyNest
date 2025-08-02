package com.cdac.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.MultipartFile;

import com.cdac.model.Room;

public interface IRoomService {

	Room addNewRoon(MultipartFile file, String roomType, BigDecimal roomPrice) throws SerialException, SQLException, IOException;

	List<String> getAllRoomTypes();

	List<Room> getAllRoom();

	byte[] getRoomPhotoByRoomId(Long roomId) throws SQLException;

}

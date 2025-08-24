package com.example.BookMyNest.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.BookMyNest.dtos.Response;
import com.example.BookMyNest.dtos.RoomDTO;
import com.example.BookMyNest.enums.RoomType;
import com.example.BookMyNest.services.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {
	private final RoomService roomService;

	@PostMapping("/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Response> addRoom(@RequestParam Integer roomNumber, @RequestParam RoomType type,
			@RequestParam BigDecimal pricePerNight, @RequestParam Integer capacity, @RequestParam String description,
			@RequestParam MultipartFile imageFile) {
		RoomDTO roomDTO = RoomDTO.builder().roomNumber(roomNumber).type(type).pricePerNight(pricePerNight)
				.capacity(capacity).description(description).build();

		return ResponseEntity.ok(roomService.addRoom(roomDTO, imageFile));

	}

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Response> updateRoom(@RequestParam(value = "roomNumber", required = false) Integer roomNumber,
			@RequestParam(value = "type", required = false) RoomType type,
			@RequestParam(value = "pricePerNight", required = false) BigDecimal pricePerNight,
			@RequestParam(value = "capacity", required = false) Integer capacity,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
			@RequestParam(value = "id", required = true) Long id) {
		RoomDTO roomDTO = RoomDTO.builder().id(id).roomNumber(roomNumber).type(type).pricePerNight(pricePerNight)
				.capacity(capacity).description(description).build();

		return ResponseEntity.ok(roomService.updateRoom(roomDTO, imageFile));

	}

	@GetMapping("/all")
	public ResponseEntity<Response> getAllRooms() {
		return ResponseEntity.ok(roomService.getAllRooms());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getRoomById(@PathVariable Long id) {
		return ResponseEntity.ok(roomService.getRoomById(id));
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Response> deleteRoom(@PathVariable Long id) {
		return ResponseEntity.ok(roomService.deleteRoom(id));
	}

	@GetMapping("/available")
	public ResponseEntity<Response> getAvailableRooms(

			@RequestParam LocalDate checkInDate, @RequestParam LocalDate checkOutDate,
			@RequestParam(required = false) RoomType roomType) {

		return ResponseEntity.ok(roomService.getAvailableRooms(checkInDate, checkOutDate, roomType));
	}

	@GetMapping("/types")
	public ResponseEntity<List<RoomType>> getAllRoomTypes() {
		return ResponseEntity.ok(roomService.getAllRoomTypes());
	}

	@GetMapping("/search")
	public ResponseEntity<Response> searchRoom(@RequestParam String input) {
		return ResponseEntity.ok(roomService.searchRoom(input));
	}

}

package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}

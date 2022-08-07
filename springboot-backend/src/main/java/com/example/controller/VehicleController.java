package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Vehicle;
import com.example.repository.VehicleRepository;

@RestController
@RequestMapping("/api/v1/")
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	
   // get all vehicle
	@GetMapping("/vehicle")
	public  List<Vehicle> getAllVehicle(){
		return vehicleRepository.findAll();
	}
	// create vehicle rest api
		@PostMapping("/vehicle")
		public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
			return vehicleRepository.save(vehicle);
		}
		// get vehicle by id rest api
		@GetMapping("/vehicle/{id}")
		public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
			Vehicle vehicle = vehicleRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" + id));
			return ResponseEntity.ok(vehicle);
		}
		
		// update vehicle rest api
		
		@PutMapping("/vehicle/{id}")
		public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails){
			Vehicle vehicle = vehicleRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" + id));
			
			vehicle.setFullName(vehicleDetails.getFullName());
			vehicle.setNoplate(vehicleDetails.getNoplate());
			vehicle.setType(vehicleDetails.getType());
			
			Vehicle updatedVehicle = vehicleRepository.save(vehicle);
			return ResponseEntity.ok(updatedVehicle);
		}
		
		// delete vehicle rest api
		@DeleteMapping("/vehicle/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteVehicle(@PathVariable Long id){
			Vehicle vehicle = vehicleRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicle not exist with id :" + id));
			
			vehicleRepository.delete(vehicle);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
}

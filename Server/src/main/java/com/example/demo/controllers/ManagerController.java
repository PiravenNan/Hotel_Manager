package com.example.demo.controllers;

import com.example.demo.DTOs.AddBuildingDTO;
import com.example.demo.DTOs.AddManagerDTO;
import com.example.demo.models.Building;
import com.example.demo.models.Manager;
import com.example.demo.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @PostMapping(value = "/addManager")
    public ResponseEntity<Manager> addNewManager(@RequestBody AddManagerDTO addManagerDTO){
        try{
            return new ResponseEntity<>(managerService.addNewManager(addManagerDTO), HttpStatus.CREATED);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "addNewBuilding/{managerId}")
    public ResponseEntity<Building> addNewBuilding(@PathVariable Long managerId, @RequestBody AddBuildingDTO addBuildingDTO){
        try {
            return new ResponseEntity<>(managerService.addNewBuilding(managerId, addBuildingDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/{managerId}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long managerId){
        try{
            return new ResponseEntity<>(managerService.getManagerById(managerId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/allBuildings/{managerId}")
    public ResponseEntity<List<Building>> getAllBuildingsByManagerId(@PathVariable Long managerId){
        try{
            return new ResponseEntity<>(managerService.getAllBuildingsByManagerId(managerId),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "updateManager/{managerId}")
    public ResponseEntity<Manager> updateManger(@PathVariable Long managerId, @RequestBody AddManagerDTO addManagerDTO){
        try{
            return new ResponseEntity<>(managerService.updateManager(managerId,addManagerDTO),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

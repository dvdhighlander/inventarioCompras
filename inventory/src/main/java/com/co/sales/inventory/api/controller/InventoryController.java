package com.co.sales.inventory.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.sales.inventory.api.model.CompraDTO;
import com.co.sales.inventory.api.model.CompraResponse;
import com.co.sales.inventory.api.model.Inventory;
import com.co.sales.inventory.api.model.InventoryDTO;
import com.co.sales.inventory.api.model.InventoryResponse;
import com.co.sales.inventory.api.service.InventoryServiceImpl;
import com.co.sales.inventory.api.validation.RequestValidations;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Inventario")
public class InventoryController {

	@Autowired
	private InventoryServiceImpl inventoryService;
	
	@GetMapping
	@ResponseBody
	public List<InventoryDTO> getAllinventoryData(@RequestParam(required = true)  int page, @RequestParam(required = true)  int pageSize){
		return inventoryService.getAllInventory(page, pageSize);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<InventoryDTO> getInventoryById(@PathVariable(required = true) int id){
		InventoryDTO product= inventoryService.getInventoryById(id);
		return  new ResponseEntity<InventoryDTO>(product, HttpStatus.OK);
	}
	
	@PostMapping
	public InventoryResponse createInventory(@RequestBody(required = true)  Inventory newInv) {
		return inventoryService.createInventory(newInv);
	}
	
	@PutMapping("/RegistrarCompra")
	public CompraResponse buyProduct(@RequestBody(required = true) @Valid @RequestValidations() CompraDTO compras) {
		return inventoryService.buyProduct(compras);
	}
	
	@PutMapping
	public InventoryResponse updateInventory(@RequestBody(required = true) Inventory newInv) {
		return inventoryService.updateInventory(newInv);
	}
	
	  @DeleteMapping("/{id}")
	  public InventoryResponse deleteInventory(@PathVariable(required = true) int id) {
		  return inventoryService.deleteInventory(id);
	  }
}

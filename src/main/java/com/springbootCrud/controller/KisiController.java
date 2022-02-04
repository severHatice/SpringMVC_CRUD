package com.springbootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootCrud.model.Kisi;
import com.springbootCrud.service.KisiService;

@RestController//bir cok metod yapacagimiz icin tum controller icin restcontroller mapping
public class KisiController {

	public KisiService kisiService;
	
	@Autowired
	public KisiController(KisiService kisiService) {
		this.kisiService=kisiService;
	}
	@GetMapping(path="/kisiler")//kisiservice class ina git ve databaseden veriler donsun
	public List<Kisi> fetchPerson(){
		return kisiService.tumKisileriGetir();
	}
	@PostMapping(path="/kisiler/ekle")
	public Kisi addPerson(@RequestBody Kisi kisi) {//toplu veri geliyor
		return kisiService.kisiEkle(kisi);
	}
	@DeleteMapping(path="/kisiler/sil/{id}")
	public String deletePersonWithId(@PathVariable Integer id) {
		return  kisiService.idIleKisiSil(id);
	}
	@PutMapping(path="/kisiler/guncelle")
	public Kisi updatePerson(@RequestBody Kisi yeniKisi) {
		return kisiService.kisiGuncelle(yeniKisi);
		
	}
	@PatchMapping(path="/kisiler/yenile/{id}")
	public Kisi yamaYapmaFetch(@PathVariable Integer id,@RequestBody Kisi updateKisi) {
		return kisiService.idIleKisiGuncelle(id,updateKisi);
	}
}

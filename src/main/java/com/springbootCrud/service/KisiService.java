package com.springbootCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.springbootCrud.model.Kisi;
import com.springbootCrud.repository.KisiRepository;



@Service
public class KisiService {

	public static KisiRepository kisiRepository;

	@Autowired//
	public KisiService(KisiRepository kisirepo) {
		kisiRepository=kisirepo;

	}

	public Kisi kisiEkle(Kisi kisi) {
		return kisiRepository.save(kisi);
	}
	
	public List<Kisi> tumKisileriGetir(){
		
		return kisiRepository.findAll();
		}
	
	public String idIleKisiSil(Integer id) {
		
		if(kisiRepository.findById(id)==null) {
			throw new EmptyResultDataAccessException(id);
		}
		kisiRepository.deleteById(id);
		return id+"id ile silindi";
		
	}

	public String idIleKisiSil1(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Kisi kisiGuncelle(Kisi guncelKisi) {
		return kisiRepository.save(guncelKisi);
	}

	public Kisi idIleKisiGuncelle(Integer id, Kisi updateKisi) {
		
		Kisi oldKisi=kisiRepository.findById(id).orElseThrow(()->new IllegalStateException(id+" li kisi bulunamadi"));
		
		if(updateKisi.getAd()!=null) {
			oldKisi.setAd(updateKisi.getAd());
		}
		
		if(updateKisi.getSoyad()!=null) {
			oldKisi.setSoyad(updateKisi.getSoyad());
		}
		
		if(updateKisi.getYas()!=0) {
			oldKisi.setYas(updateKisi.getYas());
		}
		return kisiRepository.save(oldKisi);
	}
	
	
	
	
	}

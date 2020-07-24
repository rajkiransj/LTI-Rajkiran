package com.lti.multiplexmgm.api.multiplex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.multiplexmgm.api.multiplex.document.MultiplexDocument;
import com.lti.multiplexmgm.api.multiplex.repository.MultiplexRepository;

@Service
public class MultiplexServiceImpl implements MultiplexService {

	@Autowired
	private MultiplexRepository multiRepository;

	// Register Multiplex
	@Override
	public MultiplexDocument registerMultiplex(MultiplexDocument multidoDocument) {
		// TODO Auto-generated method stub
		multidoDocument.getName();
		// multidoDocument.getScreens();
		multidoDocument.getNumberOfScreens();
		multidoDocument.getLocation();
		return multiRepository.save(multidoDocument);
	}

	// Get Multiplex Details Using multiplexId
	@Override
	public Optional<MultiplexDocument> getMultiplexDetail(String multiplexId) {

		return multiRepository.findById(multiplexId);
	}

	// find All Multiplex
	@Override
	public List<MultiplexDocument> findAll() {
		List<MultiplexDocument> mylist = multiRepository.findAll();
		return mylist;
	}

	// delete multiplex by using multiplexId

	@Override
	public boolean deleteMujltiplexById(String multiplexId) {
		if (multiRepository.existsById(multiplexId)) {
			multiRepository.deleteById(multiplexId);
			return true;
		} else {
			return false;
		}
	}

	// delete All Multiplex
	@Override
	public void deleteAll() {
		multiRepository.deleteAll();
	}

	// Update multiplex by using multiplexId
	@Override
	public MultiplexDocument updateMultiplexDetail(String multiplexId, MultiplexDocument multiplexDocument) {
		// TODO Auto-generated method stub
		multiplexDocument.setMultiplexId(multiplexId);
		return multiRepository.save(multiplexDocument);
	}
}

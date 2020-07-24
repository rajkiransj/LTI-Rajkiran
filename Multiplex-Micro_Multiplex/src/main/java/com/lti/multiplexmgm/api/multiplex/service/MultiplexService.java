package com.lti.multiplexmgm.api.multiplex.service;

import java.util.List;
import java.util.Optional;

import com.lti.multiplexmgm.api.multiplex.document.MultiplexDocument;

public interface MultiplexService {

	public MultiplexDocument registerMultiplex(MultiplexDocument multidoDocument);

	public Optional<MultiplexDocument> getMultiplexDetail(String multiplexId);

	public List<MultiplexDocument> findAll();

	public boolean deleteMujltiplexById(String userId);

	public void deleteAll();

	public MultiplexDocument updateMultiplexDetail(String multiplexId, MultiplexDocument multiplexDocument);

}

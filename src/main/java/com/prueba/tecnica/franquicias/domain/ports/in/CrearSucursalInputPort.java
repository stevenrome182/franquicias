package com.prueba.tecnica.franquicias.domain.ports.in;

import com.prueba.tecnica.franquicias.domain.model.Sucursal;

public interface CrearSucursalInputPort {
	
	Sucursal guardar(Sucursal sucursal);

}

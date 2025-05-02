package com.prueba.tecnica.franquicias.application.usecase;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.prueba.tecnica.franquicias.domain.exception.ProductoNoEncontradoException;
import com.prueba.tecnica.franquicias.domain.exception.StockNegativoException;
import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;

@ExtendWith(MockitoExtension.class)
class TestActualizarStockUseCase {

	@Mock
	private ProductoRepositoryPort productoRepository;

	@InjectMocks
	private ActualizarStockUseCase actualizarStockUseCase;

	@Test
	void actualizarStock() {
		final var productoResponse = new Producto();
		productoResponse.setId(1L);
		productoResponse.setNombre("Producto Test");
		productoResponse.setStock(5);
		Mockito.when(productoRepository.buscarPorId(ArgumentMatchers.anyLong()))
				.thenReturn(Optional.of(productoResponse));
		actualizarStockUseCase.actualizarStock(1L, 9);
		Mockito.verify(productoRepository, Mockito.times(1)).guardar(ArgumentMatchers.any());
	}

	@Test
	void actualizarStockProductoNoEncontradoException() {
		Mockito.when(productoRepository.buscarPorId(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());
		Assertions.assertThrows(ProductoNoEncontradoException.class, () -> {
			actualizarStockUseCase.actualizarStock(1L, 9);
		});
	}

	@Test
	void actualizarStockNegativoException() {
		final var productoResponse = new Producto();
		productoResponse.setId(1L);
		productoResponse.setNombre("Producto Test");
		productoResponse.setStock(5);
		Mockito.when(productoRepository.buscarPorId(ArgumentMatchers.anyLong()))
				.thenReturn(Optional.of(productoResponse));
		Assertions.assertThrows(StockNegativoException.class, () -> {
			actualizarStockUseCase.actualizarStock(1L, -8);
		});
	}

}

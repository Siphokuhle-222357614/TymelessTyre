package za.co.tt.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import za.co.tt.domain.Rim;
import za.co.tt.repository.RimRepository;
import za.co.tt.service.impl.RimServiceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RimServiceTest {

    private RimRepository rimRepository;
    private RimServiceImpl rimService;

    @BeforeEach
    void setUp() {
        rimRepository = mock(RimRepository.class);
        rimService = new RimServiceImpl(rimRepository);
    }

    @Test
    void getAllRims_shouldReturnListOfRims() {
        Rim rim1 = new Rim();
        Rim rim2 = new Rim();
        when(rimRepository.findAll()).thenReturn(Arrays.asList(rim1, rim2));
        assertEquals(2, rimService.getAllRims().size());
    }

    @Test
    void getRimById_shouldReturnRim() {
        Rim rim = new Rim();
        rim.setId(1L);
        when(rimRepository.findById(1L)).thenReturn(Optional.of(rim));
        assertEquals(1L, rimService.getRimById(1L).getId());
    }

    @Test
    void createRim_shouldSaveAndReturnRim() {
        Rim rim = new Rim();
        rim.setBrandName("OZ Racing");
        when(rimRepository.save(rim)).thenReturn(rim);
        assertEquals("OZ Racing", rimService.createRim(rim).getBrandName());
    }

    @Test
    void deleteRim_shouldCallRepositoryDelete() {
        rimService.deleteRim(1L);
        verify(rimRepository, times(1)).deleteById(1L);
    }
}
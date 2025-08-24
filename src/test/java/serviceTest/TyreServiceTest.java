package serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.tt.domain.Tyre;
import za.co.tt.repository.ITyreRepository;
import za.co.tt.service.impl.TyreServiceImpl;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TyreServiceTest {

    private ITyreRepository tyreRepository;
    private TyreServiceImpl tyreService;

    @BeforeEach
    void setUp() {
        tyreRepository = mock(ITyreRepository.class);
        tyreService = new TyreServiceImpl(tyreRepository);
    }

    @Test
    void getAllTyres_shouldReturnListOfTyres() {
        Tyre tyre1 = new Tyre();
        Tyre tyre2 = new Tyre();
        when(tyreRepository.findAll()).thenReturn(Arrays.asList(tyre1, tyre2));
        assertEquals(2, tyreService.getAllTyres().size());
    }

    @Test
    void getTyreById_shouldReturnTyre() {
        Tyre tyre = new Tyre();
        tyre.setId(1L);
        when(tyreRepository.findById(1L)).thenReturn(Optional.of(tyre));
        assertEquals(1L, tyreService.getTyreById(1L).getId());
    }

    @Test
    void createTyre_shouldSaveAndReturnTyre() {
        Tyre tyre = new Tyre();
        tyre.setBrandName("Continental");
        when(tyreRepository.save(tyre)).thenReturn(tyre);
        assertEquals("Continental", tyreService.createTyre(tyre).getBrandName());
    }

    @Test
    void deleteTyre_shouldCallRepositoryDelete() {
        tyreService.deleteTyre(1L);
        verify(tyreRepository, times(1)).deleteById(1L);
    }
}
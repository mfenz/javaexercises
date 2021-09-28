package at.cb.testingcms.service;

import at.cb.testingcms.model.Category;
import at.cb.testingcms.model.User;
import at.cb.testingcms.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CategoryServiceTest {

    private CategoryService categoryService;

    private CategoryRepository categoryRepository; // = Mockito.mock(CategoryRepository.class);

    @BeforeEach
    public void initBeforeEach(){
        categoryRepository = Mockito.mock(CategoryRepository.class);
        Mockito
                .when(categoryRepository.save(Mockito.any(Category.class)))
                .then(AdditionalAnswers.returnsFirstArg());
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void wennKeinKategorieNameDannServiceException(){
        ServiceException serviceException = catchThrowableOfType(
                () -> categoryService.createCategory(""),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Kategorie-Name eingeben");
    }

    @Test
    public void wennKategorieNameMehrAls50ZeichenServiceException(){
        ServiceException serviceException = catchThrowableOfType(
                () -> categoryService.createCategory("asdlfkjwoierjslkfdj sldkfmwoiejfslkslkdfjwoiejrslkdfslkdfjoeijfsdflkwpoerjslfmsdf"),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Der Name muss zwischen 1 und 50 Zeichen sein");
    }

    @Test
    public void wennKategorieMitDemNamenBereitsExistiertDannServiceException(){
        Mockito.doReturn(Optional.of(new Category()))
                .when(categoryRepository).findByName("Java");

        ServiceException serviceException = catchThrowableOfType(
                () -> categoryService.createCategory("Java"),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Diese Kategorie existiert bereits");
    }

    @Test
    public void pruefeObKategorieMitRichtigenNamenGespeichertWurde(){
        Category category = categoryService.createCategory("Java");
        assertEquals("Java", category.getName());
    }

    //@Test


}
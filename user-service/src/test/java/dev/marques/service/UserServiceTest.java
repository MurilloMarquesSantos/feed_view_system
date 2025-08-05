package dev.marques.service;

import dev.marques.dto.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserService userService;

    @Test
    void listProducts_ReturnsListOfProduct_WhenSuccessful(){

        BDDMockito.when(userService.listProducts()).thenReturn("products");

        String products = userService.listProducts();

        assertThat(products).isNotBlank();

    }
}
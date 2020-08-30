package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product first = new Product(1, "name1", 10);
    private Product second = new Product(2, "name2", 20);
    private Product third = new Product(3, "name3", 30);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

  @Test
  public void shouldThrowCheckedException() {
    int idToRemove = 4;
    assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));

  }


    @Test
    public void shouldNotThrowCheckedException() {
        int idToRemove = 1;
        repository.removeById(idToRemove);
        Product[] expected = new Product[]{second, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}
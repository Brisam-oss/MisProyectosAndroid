package com.example.pedidos.domain.usecase
import com.example.pedidos.domain.model.Product
import com.example.pedidos.domain.repository.ProductRepository
import javax.inject.Inject

class CreateProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(product: Product) {

        val existing = repository.findProductByCode(product.code)

        require(existing == null) {
            "Product with code ${product.code} already exists"
        }

        repository.saveProduct(product)
    }
}
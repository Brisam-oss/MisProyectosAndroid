package com.example.pedidos.domain.validation

import com.example.pedidos.domain.model.Product
class ProductValidation {
    operator fun invoke(product: Product): ValidationResult =
        listOfNotNull(
            "Code required".takeIf { product.code.isBlank() },
            "Description required".takeIf { product.description.isBlank() },
            "Category required".takeIf { product.category.isBlank() },
            "Invalid price".takeIf { product.price < 0 },
            "Invalid Stock".takeIf { product.stock <= 0 }
        ).firstOrNull()
            ?.let { ValidationResult.Error(it) }
            ?: ValidationResult.Success
}
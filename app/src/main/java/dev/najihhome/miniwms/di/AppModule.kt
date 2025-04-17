package dev.najihhome.miniwms.presentation.di

import dev.najihhome.miniwms.data.repository.ProductRepositoryImpl
import dev.najihhome.miniwms.domain.repository.ProductRepository
import dev.najihhome.miniwms.domain.usecase.GetProductDetailUseCase
import dev.najihhome.miniwms.domain.usecase.GetProductsUseCase
import dev.najihhome.miniwms.presentation.productselection.ProductSelectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Repositories
    single<ProductRepository> { ProductRepositoryImpl() }

    // Use cases
    factory { GetProductsUseCase(repository = get()) }
    factory { GetProductDetailUseCase(repository = get()) }

    // ViewModels
    viewModel {
        ProductSelectionViewModel(
            getProductsUseCase = get(),
            getProductDetailUseCase = get()
        )
    }
}
package di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import presentation.myTrips.MyTripsScreenModel

val screenModelsModule = module {
    factoryOf(::MyTripsScreenModel)
}

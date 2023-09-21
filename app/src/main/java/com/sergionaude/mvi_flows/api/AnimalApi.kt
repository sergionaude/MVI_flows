package com.sergionaude.mvi_flows.api

import com.sergionaude.mvi_flows.model.Animal
import retrofit2.http.GET

interface AnimalApi {

    @GET("animals.json")
    suspend fun getAnimals(): List<Animal>

}
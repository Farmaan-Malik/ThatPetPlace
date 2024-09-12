package com.petplace.thatpetplace.homeScreen.profile.data.remote

import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetPayload
import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ProfileApi {

    @POST("addPet")
    suspend fun AddPet(
        @Body payload: AddPetPayload
    ) : AddPetResponse

}
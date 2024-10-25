package com.petplace.thatpetplace.homeScreen.profile.data.remote

import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetPayload
import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetResponse
import com.petplace.thatpetplace.homeScreen.profile.data.model.PetDeleteResponse
import com.petplace.thatpetplace.homeScreen.profile.data.model.PetListResponse
import com.petplace.thatpetplace.homeScreen.profile.data.model.UploadPetResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ProfileApi {

    @POST("pet/addPet")
    suspend fun AddPet(
        @Body payload: AddPetPayload
    ) : AddPetResponse


    @GET("pet/getAllPets")
    suspend fun getPetList (
        @Query("userID") userID:String
    ) : PetListResponse

    @Multipart
    @POST("pet/uploadPetProfile")
    suspend fun uploadPetProfile (
        @Query("petID") petID:String,
        @Part photo: MultipartBody.Part
    ) : UploadPetResponse
    @DELETE("pet/Delete")
    suspend fun deletePet (
        @Query("petID") petID:String
    ) : PetDeleteResponse

}
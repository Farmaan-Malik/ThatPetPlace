package com.petplace.thatpetplace.homeScreen.profile.domain

import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetPayload
import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetResponse
import com.petplace.thatpetplace.homeScreen.profile.data.model.PetListResponse
import com.petplace.thatpetplace.homeScreen.profile.data.model.UploadPetResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody


interface ProfileRepository {

    fun addPet(addPetPayload: AddPetPayload): Flow<Resource<AddPetResponse>>

    fun getPetList(userId: String): Flow<Resource<PetListResponse>>

    fun uploadPetProfile(petID: String, photo: MultipartBody.Part): Flow<Resource<UploadPetResponse>>

}
package com.petplace.thatpetplace.homeScreen.profile.domain

import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetPayload
import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetResponse
import kotlinx.coroutines.flow.Flow


interface ProfileRepository {

    fun addPet(addPetPayload: AddPetPayload): Flow<Resource<AddPetResponse>>

}
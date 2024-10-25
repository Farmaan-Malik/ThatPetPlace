package com.petplace.thatpetplace.homeScreen.profile.data.remote

import android.util.Log
import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetPayload
import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetResponse
import com.petplace.thatpetplace.homeScreen.profile.data.model.PetDeleteResponse
import com.petplace.thatpetplace.homeScreen.profile.data.model.PetListResponse
import com.petplace.thatpetplace.homeScreen.profile.data.model.UploadPetResponse
import com.petplace.thatpetplace.homeScreen.profile.domain.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody

class ProfileRepositoryImpl(private val profileApi: ProfileApi): ProfileRepository {
    override fun addPet(addPetPayload: AddPetPayload): Flow<Resource<AddPetResponse>> {
       Log.e("payLoad", addPetPayload.toString())
        return flow {
            emit(Resource.Loading())
            val result = profileApi.AddPet(addPetPayload)
            emit(Resource.Success(result))
        }.catch {
           emit(Resource.Error(it.localizedMessage))
        }
    }

    override fun getPetList(userId: String): Flow<Resource<PetListResponse>> {
        return flow {
            emit(Resource.Loading())
            val result = profileApi.getPetList(userId)
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.localizedMessage))
        }
    }

    override fun uploadPetProfile(petID: String, photo: MultipartBody.Part): Flow<Resource<UploadPetResponse>> {
        return flow {
            emit(Resource.Loading())
            val result = profileApi.uploadPetProfile(petID, photo)
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.localizedMessage))
        }
    }

    override fun deletePet(petID: String): Flow<Resource<PetDeleteResponse>> {
        return flow {
            emit(Resource.Loading())
            val result = profileApi.deletePet(petID)
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.localizedMessage))
        }
    }


}
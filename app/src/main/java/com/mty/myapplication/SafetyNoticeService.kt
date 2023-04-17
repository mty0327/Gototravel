package com.mty.myapplication

import retrofit2.http.GET

interface SafetyNoticeService {
    @GET("api/safetyNotice")
    suspend fun getSafetyNotices(): SafetyNoticeResponse
}
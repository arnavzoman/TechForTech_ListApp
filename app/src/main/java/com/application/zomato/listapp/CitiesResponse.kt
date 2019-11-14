package com.application.zomato.listapp


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CitiesResponse(
    @SerializedName("has_more")
    val hasMore: Int,
    @SerializedName("has_total")
    val hasTotal: Int,
    @SerializedName("location_suggestions")
    val locationSuggestions: List<LocationSuggestion>,
    @SerializedName("status")
    val status: String
) {
    @Keep
    data class LocationSuggestion(
        @SerializedName("country_flag_url")
        val countryFlagUrl: String,
        @SerializedName("country_id")
        val countryId: Int,
        @SerializedName("country_name")
        val countryName: String,
        @SerializedName("discovery_enabled")
        val discoveryEnabled: Int,
        @SerializedName("has_go_out_tab")
        val hasGoOutTab: Int,
        @SerializedName("has_new_ad_format")
        val hasNewAdFormat: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_state")
        val isState: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("should_experiment_with")
        val shouldExperimentWith: Int,
        @SerializedName("state_code")
        val stateCode: String,
        @SerializedName("state_id")
        val stateId: Int,
        @SerializedName("state_name")
        val stateName: String
    )
}
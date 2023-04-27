package com.example.a0303_application

data class UVData(
    val __extras: Extras,
    val _links: Links,
    val fields: List<Field>,
    val include_total: Boolean,
    val limit: String,
    val offset: String,
    val records: List<Records>,
    val resource_format: String,
    val resource_id: String,
    val total: String
){
    data class Records(
        val county: String,
        val publishagency: String,
        val publishtime: String,
        val sitename: String,
        val uvi: String,
        val wgs84lat: String,
        val wgs84lon: String
    )
    data class Extras(
        val api_key: String
    )
    data class Info(
        val label: String
    )

    data class Links(
        val next: String,
        val start: String
    )
    data class Field(
        val id: String,
        val info: Info,
        val type: String
    )
}


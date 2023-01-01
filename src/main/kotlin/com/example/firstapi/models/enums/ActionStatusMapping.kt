package com.example.firstapi.models.enums

enum class ActionStatusMapping(
    val excludedStatuses: List<Status>? = null
) {
    EXPIRED(listOf(Status.EXPIRED, Status.DRAFT)),
}
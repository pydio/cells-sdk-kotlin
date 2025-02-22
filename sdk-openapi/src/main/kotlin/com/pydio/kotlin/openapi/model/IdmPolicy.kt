/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param ormActions
 * @param ormResources
 * @param ormSubjects
 * @param actions
 * @param conditions
 * @param description
 * @param effect
 * @param id
 * @param resources
 * @param subjects
 */
data class IdmPolicy(
    @Json(name = "OrmActions") val ormActions: kotlin.collections.List<IdmPolicyAction>? = null,
    @Json(name = "OrmResources")
    val ormResources: kotlin.collections.List<IdmPolicyResource>? = null,
    @Json(name = "OrmSubjects") val ormSubjects: kotlin.collections.List<IdmPolicySubject>? = null,
    @Json(name = "actions") val actions: kotlin.collections.List<kotlin.String>? = null,
    @Json(name = "conditions")
    val conditions: kotlin.collections.Map<kotlin.String, IdmPolicyCondition>? = null,
    @Json(name = "description") val description: kotlin.String? = null,
    @Json(name = "effect") val effect: IdmPolicyEffect? = IdmPolicyEffect.unknown,
    @Json(name = "id") val id: kotlin.String? = null,
    @Json(name = "resources") val resources: kotlin.collections.List<kotlin.String>? = null,
    @Json(name = "subjects") val subjects: kotlin.collections.List<kotlin.String>? = null
) {}

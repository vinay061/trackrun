package com.project.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}
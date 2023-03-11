package com.example.todoappkotlin.utils

import java.text.SimpleDateFormat
import java.util.*

fun getFormatedDateTime(Millies: Long, Format: String)=
    SimpleDateFormat(Format, Locale.getDefault()).format(Date(Millies))


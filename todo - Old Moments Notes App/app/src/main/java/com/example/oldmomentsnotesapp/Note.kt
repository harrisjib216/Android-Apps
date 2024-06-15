package com.example.oldmomentsnotesapp

import java.time.LocalTime

data class Note(
    var title: String,
    var createdAt: LocalTime,
    var lastUpdated: LocalTime,
    var content: List<Body>
)

data class Body(
    var text: String,
    var imagePath: String,
    var audioPath: String,
)

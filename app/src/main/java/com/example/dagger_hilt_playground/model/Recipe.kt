package com.example.dagger_hilt_playground.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity( tableName = "recipes")
data class Recipe(

    @PrimaryKey(autoGenerate = false)
    @SerializedName("_id")
    val id: String = "",

    @ColumnInfo(name = "image_url")
    val image_url: String = "",
    @ColumnInfo(name = "publisher")
    val publisher: String = "",
    @ColumnInfo(name = "publisher_url")
    val publisher_url: String = "",
    @ColumnInfo(name = "recipe_id")
    val recipe_id: String ="",
    @ColumnInfo(name = "social_rank")
    val social_rank: Double = 0.0,
    @ColumnInfo(name = "source_url")
    val source_url: String ="" ,
    @ColumnInfo(name = "title")
    val title: String =""
)
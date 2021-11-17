package com.example.kadai01

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Kadai : RealmObject(){


    @PrimaryKey
    var id: String = ""
    var title: String = ""
    var pass: String = ""
}
package com.example.mybottomnavigation

import android.app.Application

class MyApplication(): Application() {
    var component = DaggerMyComponent.create()
}
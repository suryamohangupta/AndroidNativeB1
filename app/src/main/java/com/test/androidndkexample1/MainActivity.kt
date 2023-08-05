package com.test.androidndkexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.test.androidndkexample1.databinding.ActivityMainBinding

//Project Link: https://blog.mindorks.com/getting-started-with-android-ndk-android-tutorial/
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
        val x: Int = add(3,4)
        println(add(5,6))
        println(sub(90,80))
        println(multiply(5, 9))
        println(divide(90,5))

    }

    /**
     * A native method that is implemented by the 'androidndkexample1' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun add(x: Int, y: Int): Int
    external fun sub(x: Int, y: Int): Int
    external fun multiply(x: Int, y: Int): Int
    external fun divide(x: Int, y: Int): Int

    companion object {
        // Used to load the 'androidndkexample1' library on application startup.
        init {
            System.loadLibrary("androidndkexample1")
        }
    }
}
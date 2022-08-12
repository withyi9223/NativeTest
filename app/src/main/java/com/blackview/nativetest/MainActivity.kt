package com.blackview.nativetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blackview.nativetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = "stringFromJNI()"
        val arr = byteArrayOf()
        val arr2 = byteArrayOf()
        YuvUtil.yuvRotateI420(arr, 100, 100, arr2, 90)
    }

    /**
     * A native method that is implemented by the 'nativetest' native library,
     * which is packaged with this application.
     */


    companion object {
        // Used to load the 'nativetest' library on application startup.
        init {
            System.loadLibrary("yuv")
        }
    }
}
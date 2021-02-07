package com.ctyeung.modalex

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission()
        val btn_service = findViewById(R.id.btn_service) as MaterialButton
        btn_service.setOnClickListener{onClickService()}

        val btn_alertDialog = findViewById(R.id.btn_alert) as MaterialButton
        btn_service.setOnClickListener{onClickAlert()}
    }

    fun onClickAlert() {

    }

    fun onClickService() {
        /*
         * https://stackoverflow.com/questions/19846541/what-is-windowmanager-in-android
         */
        val p = WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY else WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT)


        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

        val layoutInflater = baseContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = layoutInflater.inflate(R.layout.alert_layout, null)
        windowManager.addView(popupView, p)

        Handler().postDelayed(Runnable { windowManager.removeView(popupView) }, 3000)
    }

    fun requestPermission(): Boolean {
        val ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE= 2323;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:$packageName"))
                startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE)
                return true
            }
        }
        return false
    }
}
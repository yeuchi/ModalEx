package com.ctyeung.modalex

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var txt_hello:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission()
        (findViewById(R.id.btn_service) as MaterialButton).setOnClickListener{onClickService()}
        (findViewById(R.id.btn_alert) as MaterialButton).setOnClickListener{onClickAlert()}
        (findViewById(R.id.btn_fragment) as MaterialButton).setOnClickListener{onClickFragment()}
        (findViewById(R.id.btn_toast) as MaterialButton).setOnClickListener{onClickToast()}
        (findViewById(R.id.btn_snackbar) as MaterialButton).setOnClickListener{onClickSnackBar()}

        txt_hello = findViewById(R.id.txt_hello) as TextView
    }

    fun onClickSnackBar() {
        txt_hello.announceForAccessibility("displaying SnackBar")

        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        lp.setMargins(50, 0, 0, 0)
        val root = findViewById(R.id.root) as View
        val snackbar = Snackbar.make(root, "hello world", Snackbar.LENGTH_LONG)
        snackbar.view.layoutParams = lp
        snackbar.show()
    }

    fun onClickToast() {
        txt_hello.announceForAccessibility("displaying Toast")

        val toast = Toast.makeText(this,"hello wolrd", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 10, 200)
        toast.show()
    }

    fun onClickFragment() {
        txt_hello.announceForAccessibility("displaying Dialog fragment")

        ModalFragment().show(this.supportFragmentManager, "hello")
    }

    fun onClickAlert() {

        txt_hello.announceForAccessibility("displaying Alert Dialog")

        /*
         * Try custom view !
         */
       val builder = AlertDialog.Builder(this)
            .setMessage("messge to the world")
            .setCancelable(false)
            .setTitle("title")
            .setPositiveButton("Alert" ) {dialogInterface, i ->
            }

        builder.create().show()
    }

    fun onClickService() {

        txt_hello.announceForAccessibility("displaying custom view through window manager")

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
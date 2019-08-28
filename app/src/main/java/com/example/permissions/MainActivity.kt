package com.example.permissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

private const val TARGET_PERMISSION = Manifest.permission.CAMERA
private const val PERMISSION_REQUEST_CODE = 11

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello_world.setOnClickListener {
            usePermission(TARGET_PERMISSION) { toast(R.string.using_permission) }
        }
    }

    private fun usePermission(permission: String, block: () -> Unit) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                // provide an explanation for using permission
                showPermissionRationale(permission)
            } else {
                // no explanation is required, request the permission
                requestPermission(permission)
            }
        } else {
            // permission has already been granted
            block()
        }
    }

    private fun showPermissionRationale(permission: String) {
        AlertDialog.Builder(this)
            .setTitle(R.string.permission_title)
            .setMessage(R.string.permission_description)
            .setPositiveButton(android.R.string.ok) { dialog, _ ->
                requestPermission(permission)
                dialog.dismiss()
            }
            .setNegativeButton(android.R.string.cancel) { dialog, _ -> dialog.dismiss() }
            .setCancelable(true)
            .setIcon(R.drawable.ic_danger)
            .show()
    }

    private fun requestPermission(permission: String) {
        ActivityCompat.requestPermissions(this, arrayOf(permission), PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED) {
                    // permission has been granted
                    toast(R.string.now_granted)
                } else {
                    // permission has been denied
                    toast(R.string.not_granted)
                }
            }
        }
    }

    private fun toast(text: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, text, length).show()
    }

    private fun toast(@StringRes textResId: Int, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, textResId, length).show()
    }
}

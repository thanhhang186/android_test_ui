package com.styl.testautomationdemo.main

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.styl.testautomationdemo.BuildConfig
import com.styl.testautomationdemo.R
import com.styl.testautomationdemo.second.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_navigation.setOnClickListener(this)
//        val url = Environment.getExternalStorageDirectory().path + "/firmware/unzipFolder/"
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(
//                arrayOf(
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE
//                ), 11)
//        }
//        Log.d("test", "result = " + isNeedUpdateApk(this, url))
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_navigation -> {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun isOldApkFile(downloadVersionName: String, downloadVersionCode: Int): Boolean {
        var result: Boolean? = null
        val currentVersion = BuildConfig.VERSION_NAME
        val arrCurrent = currentVersion.split(".")
        val arrDownload = downloadVersionName.split(".")
        val length = Math.max(arrCurrent.size, arrDownload.size)
        for (i in 0 until length) {
            var currentNum = 0
            if (i < arrCurrent.size) {
                try {
                    currentNum = Integer.parseInt(arrCurrent[i])
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    continue
                }

            }

            var downloadNum = 0
            if (i < arrDownload.size) {
                try {
                    downloadNum = Integer.parseInt(arrDownload[i])
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    continue
                }
            }
            if (currentNum < downloadNum) {
                Log.d("test", "currentNum = $currentNum, downloadNum = $downloadNum")
                return false
            } else if (currentNum > downloadNum){
                return true
            }
        }

        if (result == null) {
            Log.d("test", "VERSION_CODE")
            result = BuildConfig.VERSION_CODE >= downloadVersionCode
        }
        return result
    }

    fun isNeedUpdateApk(context: Context, path: String): Boolean {
        val fileApk = getFileUpdate(path)
        if (fileApk?.exists() == true) {
            val packageInfo =
                context.packageManager?.getPackageArchiveInfo(fileApk.absolutePath, PackageManager.GET_ACTIVITIES)
            if (packageInfo != null) {
                Log.d("test", "packageInfo = ${packageInfo}")
                Log.d("test", "current package id = ${BuildConfig.APPLICATION_ID}")
                Log.d("test", "apk package id = ${packageInfo?.packageName}")
                Log.d("test", "current versionCode = ${BuildConfig.VERSION_CODE}, apk versionCode = ${packageInfo?.versionCode}")
                Log.d("test", "current versionName = ${BuildConfig.VERSION_NAME}, apk versionName = ${packageInfo?.versionName}")
                return !isOldApkFile(packageInfo?.versionName ?: "", packageInfo.versionCode)
            }
        }
        return false
    }

    fun getFileUpdate(folder: String): File? {
        val file = File(folder)
        if (file.isDirectory && file.listFiles() != null) {
            for (child in file.listFiles()) {
                if (child.name.endsWith(".apk")) {
                    return child
                }
            }
        }
        return null
    }

}

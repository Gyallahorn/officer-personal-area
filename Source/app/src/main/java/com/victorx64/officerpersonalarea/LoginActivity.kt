package com.victorx64.officerpersonalarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.login_web_view.*

// @todo #13 make login activity, get visual part from figma, add phone firebase authentication
class LoginActivity : AppCompatActivity() {
var myWebView : WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCenter.start(
            application, "ff1e2117-dff5-4134-9e9b-460e2f86b717",
            Analytics::class.java, Crashes::class.java
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_web_view)
        myWebView = findViewById(R.id.WebView)
        WebView.settings.javaScriptEnabled = true
        WebView.loadUrl("https://officer-persomal-area.web.app/")
        WebView.getSettings().setLoadWithOverviewMode(true);
        WebView.getSettings().setUseWideViewPort(true);
        WebView.addJavascriptInterface(WebAppInterface(this), "Android")
        val intent = Intent(this, MainActivity::class.java)
                           startActivity(intent)


//        login_button.setOnClickListener{
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }


    }


}

package br.com.wdnjunior.mobile_tcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.app.Activity;
import android.webkit.WebViewClient;
import android.net.Uri;
import android.content.Intent;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://tcc.wilsondonizetti.eti.br");
        myWebView.setWebViewClient(new MyWebViewClient());

        WebSettings webSettings = myWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);





    }
    // Use When the user clicks a link from a web page in your WebView
    private class MyWebViewClient extends WebViewClient {

        @Override

        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (Uri.parse(url).getHost().equals("wilsondonizetti.eti.br")) {

                return false;

            }

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            startActivity(intent);

            return true;
        }
    }
}

